package com.sfgpetclinic.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    Set<T> findAll();
    T save(T object);
    T findById(ID id);
    void delete(T object);
    void deleteById(ID id);
}
