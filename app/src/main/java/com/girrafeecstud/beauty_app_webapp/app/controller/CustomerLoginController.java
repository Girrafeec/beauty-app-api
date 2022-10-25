package com.girrafeecstud.beauty_app_webapp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/customer")
public class CustomerLoginController {

    @GetMapping("/login")
    public String getCustomersLoginPage() {
        System.out.println("login controller request");
        return  "customer_login_page";
    }

}
