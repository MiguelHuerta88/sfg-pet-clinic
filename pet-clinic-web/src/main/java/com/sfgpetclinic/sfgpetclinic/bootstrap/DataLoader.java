package com.sfgpetclinic.sfgpetclinic.bootstrap;

import com.sfgpetclinic.sfgpetclinic.model.Owner;
import com.sfgpetclinic.sfgpetclinic.model.Vet;
import com.sfgpetclinic.sfgpetclinic.services.OwnerService;
import com.sfgpetclinic.sfgpetclinic.services.PetService;
import com.sfgpetclinic.sfgpetclinic.services.VetService;
import com.sfgpetclinic.sfgpetclinic.services.map.OwnerServiceMap;
import com.sfgpetclinic.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Miguel");
        owner1.setLastName("Huerta");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Susan");
        owner1.setLastName("Espino");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner1.setId(3L);
        owner1.setFirstName("Erik");
        owner1.setLastName("Huerta");
        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner1.setId(4L);
        owner1.setFirstName("Sam");
        owner1.setLastName("Huerta");
        ownerService.save(owner4);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Jorge");
        vet1.setLastName("Camacho");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Macho Man");
        vet1.setLastName("Randy Savage");
        vetService.save(vet2);

        System.out.println("Loaded vets.....");
    }
}
