package com.example.lab4_20206442.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class principal {

    @GetMapping(name = "/")
    public String inicio(){
        return "principal";
    }

}
