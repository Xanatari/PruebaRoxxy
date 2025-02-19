package com.neivor.prueba.roxxy.service.implementations;

import com.neivor.prueba.roxxy.repository.contracts.TransaccionRepository;
import com.neivor.prueba.roxxy.repository.entities.TransaccionEntity;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PessimisticLockException;
import javax.transaction.Transactional;

@Service
public class TransaccionService {

    private final TransaccionRepository repository;

    public TransaccionService(TransaccionRepository repository) {
        this.repository = repository;
    }

    @Retryable(
            value = { OptimisticLockException.class, PessimisticLockException.class, TransientDataAccessException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    @Transactional
    public void procesarTransaccion(Long id) {
        // Recupera la transacción con bloqueo pesimista para evitar concurrencia
        TransaccionEntity transaccion = repository.findByIdForUpdate(id)
                .orElseThrow(() -> new EntityNotFoundException("Transacción no encontrada"));

        // Verifica el estado para evitar reprocesamientos
        if("EN_PROCESO".equals(transaccion.getEstado())) {
            throw new IllegalStateException("La transacción ya está siendo procesada");
        }

        // Actualiza el estado a EN_PROCESO
        transaccion.setEstado("EN_PROCESO");
        repository.save(transaccion);

        try {
            // Lógica del negocio que puede fallar
            // Por ejemplo, llamada a servicios externos, cálculos, etc.
            // Si todo va bien, actualiza el estado a COMPLETADA
            transaccion.setEstado("COMPLETADA");
        } catch (Exception e) {
            // En caso de error, se actualiza el estado a FALLIDA y se lanza la excepción para que Spring Retry la capte
            transaccion.setEstado("FALLIDA");
            throw e;
        }

        repository.save(transaccion);
    }

    // Método opcional para recuperar (fallback) después de agotar los reintentos
    @Recover
    public void recover(Exception e, Long id) {
        // Implementa lógica de recuperación: notificar, guardar log, alertar, etc.
        System.err.println("No se pudo procesar la transacción " + id + " tras varios intentos: " + e.getMessage());
    }
}