package com.epam.tc.hw5.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginDataProvider {

    public static String getLoginData(String needed) {
        String data = null;
        try (InputStream loginData = new FileInputStream("src/test/resources/com.epam.tc.hw5/login.properties")) {
            Properties forLogin = new Properties();
            forLogin.load(loginData);
            data = forLogin.getProperty(needed);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }
}
