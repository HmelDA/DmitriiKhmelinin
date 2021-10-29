package com.epam.tc.hw2.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.DataProvider;


public class LoginDataProvider {
    @DataProvider
    public static Object[][] sameStepsData() {
        try (InputStream loginData = new FileInputStream("src/test/resources/com.epam.tc.hw2/login.properties")) {
            Properties forLogin = new Properties();

            if (loginData == null) {
                System.out.println("Sorry, unable to find login.properties");
                return null;
            }

            forLogin.load(loginData);

            return new Object[][]{
                    {
                            forLogin.getProperty("testSite.url"),
                            forLogin.getProperty("testUser.login"),
                            forLogin.getProperty("testUser.password"),
                            forLogin.getProperty("testUser.name")
                    }
            };
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
