package com.sfgpetclinic.sfgpetclinic.services;

import com.sfgpetclinic.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
