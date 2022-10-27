package com.girrafeecstud.beauty_app_webapp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class CommonRegistrationController {

    @GetMapping
    public String getMainRegistrationPage() {
        return "common_registration_page";
    }

}
