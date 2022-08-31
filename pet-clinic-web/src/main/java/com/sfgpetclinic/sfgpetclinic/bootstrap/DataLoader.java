package com.sfgpetclinic.sfgpetclinic.bootstrap;

import com.sfgpetclinic.sfgpetclinic.model.Owner;
import com.sfgpetclinic.sfgpetclinic.model.PetType;
import com.sfgpetclinic.sfgpetclinic.model.Vet;
import com.sfgpetclinic.sfgpetclinic.services.OwnerService;
import com.sfgpetclinic.sfgpetclinic.services.PetTypeService;
import com.sfgpetclinic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType cat = new PetType();
        cat.setName("Cats");
        PetType savedCat = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dogs");
        PetType savedDog = petTypeService.save(dog);

        System.out.println("Loaded Pet Types");

        Owner owner1 = new Owner();
        owner1.setFirstName("Miguel");
        owner1.setLastName("Huerta");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Susan");
        owner2.setLastName("Espino");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Erik");
        owner3.setLastName("Huerta");
        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Sam");
        owner4.setLastName("Huerta");
        ownerService.save(owner4);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jorge");
        vet1.setLastName("Camacho");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Macho Man");
        vet2.setLastName("Randy Savage");
        vetService.save(vet2);

        System.out.println("Loaded vets.....");
    }
}
