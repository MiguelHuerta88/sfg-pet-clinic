package com.sfgpetclinic.sfgpetclinic.services;

import com.sfgpetclinic.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findBylastName(String lastName);
}
