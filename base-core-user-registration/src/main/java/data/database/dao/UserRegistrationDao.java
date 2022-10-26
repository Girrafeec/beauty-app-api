package data.database.dao;

import data.database.model.RegistrationUserDatabaseModel;

import javax.annotation.PreDestroy;

public interface UserRegistrationDao {
    void registration(RegistrationUserDatabaseModel user);

    boolean userExists(RegistrationUserDatabaseModel user);

    void onUserRegistrationDaoDestroy();
}
