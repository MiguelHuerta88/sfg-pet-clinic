package com.sfgpetclinic.sfgpetclinic.controller;

import com.sfgpetclinic.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"/vets", "vets/index", "/vets/index.html", "/vets.html"})
    public String index(Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
