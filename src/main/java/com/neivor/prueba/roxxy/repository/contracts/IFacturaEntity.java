package com.neivor.prueba.roxxy.repository.contracts;

import com.neivor.prueba.roxxy.repository.entities.FacturaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IFacturaEntity extends CrudRepository<FacturaEntity, Integer> {

    @Transactional(readOnly = true)
    Optional<FacturaEntity> findByDocPagador(String docPagador);
}
