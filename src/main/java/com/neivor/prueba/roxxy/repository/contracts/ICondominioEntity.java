package com.neivor.prueba.roxxy.repository.contracts;

import com.neivor.prueba.roxxy.repository.entities.CondominioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICondominioEntity extends CrudRepository<CondominioEntity, Integer> {

}
