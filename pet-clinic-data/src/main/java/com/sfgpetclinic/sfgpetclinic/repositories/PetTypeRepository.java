package com.sfgpetclinic.sfgpetclinic.repositories;

import com.sfgpetclinic.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
