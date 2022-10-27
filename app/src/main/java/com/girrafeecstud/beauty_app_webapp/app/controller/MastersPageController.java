package com.girrafeecstud.beauty_app_webapp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/master")
public class MastersPageController {

    @GetMapping("/{id}")
    public String openMasterPage(@PathVariable String id) {
        System.out.println("opened master page with " + id + " id");

        return "master_entry_page";
    }

}
