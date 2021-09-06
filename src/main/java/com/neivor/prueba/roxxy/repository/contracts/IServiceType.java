package com.neivor.prueba.roxxy.repository.contracts;

import com.neivor.prueba.roxxy.repository.entities.ServiceTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceType extends CrudRepository<ServiceTypeEntity, Integer> {
}
