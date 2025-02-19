package com.neivor.prueba.roxxy.repository.contracts;

import com.neivor.prueba.roxxy.repository.entities.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface TransaccionRepository extends JpaRepository<TransaccionEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT t FROM TransaccionEntity t WHERE t.id = :id")
    Optional<TransaccionEntity> findByIdForUpdate(@Param("id") Long id);
}