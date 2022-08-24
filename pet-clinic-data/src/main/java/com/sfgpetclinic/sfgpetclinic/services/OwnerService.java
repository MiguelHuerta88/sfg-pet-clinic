package com.sfgpetclinic.sfgpetclinic.services;

import com.sfgpetclinic.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findBylastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
