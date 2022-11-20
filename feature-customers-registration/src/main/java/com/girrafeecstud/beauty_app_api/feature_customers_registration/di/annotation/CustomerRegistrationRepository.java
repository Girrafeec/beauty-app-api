package com.girrafeecstud.beauty_app_api.feature_customers_registration.di.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerRegistrationRepository {
}
