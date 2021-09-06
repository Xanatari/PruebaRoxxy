package com.neivor.prueba.roxxy.repository.contracts;

import com.neivor.prueba.roxxy.repository.entities.PagadorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPagadorEntity extends CrudRepository<PagadorEntity, Integer> {
    Optional<PagadorEntity> findByDocumentoPagador(String documentoPagador);
}
