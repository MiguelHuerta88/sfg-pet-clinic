package com.sfgpetclinic.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetsController {

    @GetMapping({"/vets", "vets/index", "/vets/index.html"})
    public String index() {
        return "vets/index";
    }
}
