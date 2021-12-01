package com.epam.tc.hw7.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginDataProvider {

    public static String getLoginData(String loginProperty) {
        String data = null;
        try (InputStream loginData = new FileInputStream("src/test/resources/com.epam.tc.hw6/login.properties")) {
            Properties forLogin = new Properties();
            forLogin.load(loginData);
            data = forLogin.getProperty(loginProperty);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }
}
