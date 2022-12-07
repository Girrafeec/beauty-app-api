package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.dao;

import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.model.MastersServiceRegistrationsDatabaseModel;

import java.sql.SQLException;
import java.util.List;

public interface MastersServiceRegistrationsDao {

    List<MastersServiceRegistrationsDatabaseModel> getMastersServiceRegistrations() throws SQLException;

}
