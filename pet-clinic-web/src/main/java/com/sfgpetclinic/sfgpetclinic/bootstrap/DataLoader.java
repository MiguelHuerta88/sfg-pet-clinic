package com.sfgpetclinic.sfgpetclinic.bootstrap;

import com.sfgpetclinic.sfgpetclinic.model.*;
import com.sfgpetclinic.sfgpetclinic.services.OwnerService;
import com.sfgpetclinic.sfgpetclinic.services.PetTypeService;
import com.sfgpetclinic.sfgpetclinic.services.SpecialtyService;
import com.sfgpetclinic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    private final SpecialtyService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cats");
        PetType savedCat = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dogs");
        PetType savedDog = petTypeService.save(dog);

        System.out.println("Loaded Pet Types");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        Specialty dermatology = new Specialty();
        dermatology.setDescription("Dermatology");
        Specialty savedDermatology = specialtiesService.save(dermatology);

        System.out.println("Loaded Specialties");

        Owner owner1 = new Owner();
        owner1.setFirstName("Miguel");
        owner1.setLastName("Huerta");
        owner1.setAddress("1140 E Merced Ave");
        owner1.setCity("West Covina");
        owner1.setTelephone("3103676337");

        Pet miguelPet = new Pet();
        miguelPet.setPetType(savedDog);
        miguelPet.setOwner(owner1);
        miguelPet.setBirthDate(LocalDate.now());
        miguelPet.setName("Metz");
        owner1.getPets().add(miguelPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Susan");
        owner2.setLastName("Espino");
        owner2.setAddress("1140 E Merced Ave");
        owner2.setCity("West Covina");
        owner2.setTelephone("3234303644");
        Pet susiePet = new Pet();
        susiePet.setPetType(savedDog);
        susiePet.setOwner(owner2);
        susiePet.setBirthDate(LocalDate.now());
        susiePet.setName("Chip");
        owner2.getPets().add(susiePet);
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Erik");
        owner3.setLastName("Huerta");
        owner3.setAddress("139 E 235th St");
        owner3.setCity("Carson");
        owner3.setTelephone("3108306604");
        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Sam");
        owner4.setLastName("Huerta");
        owner4.setAddress("139 E 235th St");
        owner4.setCity("Carson");
        owner4.setTelephone("3108306604");
        ownerService.save(owner4);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jorge");
        vet1.setLastName("Camacho");
        vet1.getSpecialties().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Macho Man");
        vet2.setLastName("Randy Savage");
        vet2.getSpecialties().add(savedDermatology);
        vetService.save(vet2);

        System.out.println("Loaded vets.....");
    }
}
