package com.girrafeecstud.beauty_app_webapp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class CommonLoginController {

    @GetMapping
    public String getMainLoginPage() {
        return "common_login_page";
    }

}
