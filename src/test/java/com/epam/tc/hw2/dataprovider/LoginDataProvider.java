package com.epam.tc.hw2.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.DataProvider;


public class LoginDataProvider {
    @DataProvider
    public static Object[][] sameStepsData() {
        try (InputStream loginData = new FileInputStream("com.epam.tc.hw2/login.properties")) {
            Properties forLogin = new Properties();
            forLogin.load(loginData);
            return new Object[][] {
                    {
                            forLogin.getProperty("url"),
                            forLogin.getProperty("login"),
                            forLogin.getProperty("password"),
                            forLogin.getProperty("name")
                    }
            };
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
