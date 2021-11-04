package com.epam.tc.hw4.service;

import com.epam.tc.hw4.model.User;

public class UserCreator {

    public static final String USER_LOGIN = LoginDataProvider.getLoginData("testUser.login");
    public static final String USER_PASSWORD = LoginDataProvider.getLoginData("testUser.password");
    public static final String USER_NAME = LoginDataProvider.getLoginData("testUser.name");


    public static User withCredentialsFromProperty() {
        return new User(USER_LOGIN, USER_PASSWORD, USER_NAME);
    }

    public static User withEmptyLogin() {
        return new User("", USER_PASSWORD, USER_NAME);
    }

    public static User withEmptyPassword() {
        return new User(USER_LOGIN, "", USER_NAME);
    }

    public static User withEmptyName() {
        return new User(USER_LOGIN, USER_PASSWORD, "");
    }
}
