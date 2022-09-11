package com.sfgpetclinic.sfgpetclinic.repositories;

import com.sfgpetclinic.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
