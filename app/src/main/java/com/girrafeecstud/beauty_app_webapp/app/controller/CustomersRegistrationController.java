package com.girrafeecstud.beauty_app_webapp.app.controller;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.dao.CustomerRegistrationDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.usecase.CustomerRegistrationUseCase;

@Controller
@RequestMapping("/user/customer")
public class CustomersRegistrationController {

    @Autowired
    private CustomerRegistrationUseCase customerRegistrationUseCase;

    @GetMapping("/registration")
    public String customersRegistrationPage() {
        return  "customer_registration_page";
    }

}
