package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.site.pages.forms.LoginForm;


@Url("index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    @Css("#user-icon")
    public static Icon userIcon;
    @Css("form")
    public static LoginForm loginForm;
    @Css("#user-name")
    public static Label userName;
    @UI(".navbar-nav.m-l8 li a")
    public static Menu headerMenu;
    @UI(".fa-sign-out")
    public static Button logout;


    public static void login(User user) {
        userIcon.click();
        loginForm.loginAs(user);
    }

    public static void logout() {
        if (!logout.isVisible()) {
            userIcon.click();
        }
        logout.click();
    }

    public static void selectPage(String page) {
        headerMenu.select(page);
    }

}
