package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface MasterRegistrationDao {
}
