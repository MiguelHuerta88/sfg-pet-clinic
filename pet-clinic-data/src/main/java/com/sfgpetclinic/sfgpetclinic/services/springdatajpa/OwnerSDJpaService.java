package com.sfgpetclinic.sfgpetclinic.services.springdatajpa;

import com.sfgpetclinic.sfgpetclinic.model.Owner;
import com.sfgpetclinic.sfgpetclinic.repositories.OwnerRepository;
import com.sfgpetclinic.sfgpetclinic.repositories.PetRepository;
import com.sfgpetclinic.sfgpetclinic.repositories.PetTypeRepository;
import com.sfgpetclinic.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository,
                             PetTypeRepository petTypeRepository,
                             PetRepository petRepository
    ) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findBylastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
