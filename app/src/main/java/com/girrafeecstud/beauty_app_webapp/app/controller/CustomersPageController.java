package com.girrafeecstud.beauty_app_webapp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/customer")
public class CustomersPageController {

    @GetMapping("/{id}")
    public String openCustomerPage(@PathVariable String id) {
        System.out.println("opened customer page with " + id + " id");

        return "customer_entry_page";
    }

}
