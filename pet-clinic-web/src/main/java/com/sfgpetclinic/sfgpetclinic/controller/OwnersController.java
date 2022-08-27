package com.sfgpetclinic.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnersController {

    @GetMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String index() {
        return "owners/index";
    }
}
