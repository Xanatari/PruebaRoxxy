package com.neivor.prueba.roxxy.repository.contracts;

import com.neivor.prueba.roxxy.repository.entities.FacturaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaEntity extends CrudRepository<FacturaEntity, Integer> {
}
