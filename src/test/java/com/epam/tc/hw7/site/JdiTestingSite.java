package com.epam.tc.hw7.site;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.site.pages.HomePage;
import com.epam.tc.hw7.site.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestingSite {

    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void openJdiSite() {
        homePage.open();
    }

    /*@FindBy(className = "uui-header dark-gray")
    public static Menu headerMenu;
    @FindBy(css = "img#user-icon") public static Link userIcon;
    @FindBy(id = "name") public static TextField name;
    @FindBy(id = "password" public static TextField password;
    @FindBy(id = "login-button") public static Button loginButton;
    @FindBy(id = "user-name") public static Text userName;
    @UI(".btn-login")
    public static Button logout;

    @Css("form") public static Form<User> loginForm;

    @Css(".profile-photo [ui=label]") public static UIElement userName;
    @Css(".logout") public static WebElement logout;
    @Css("img#user-icon") public static UIElement userIcon;
    @UI(".sidebar-menu li") public static Menu leftMenu;
    @UI(".sidebar-menu li") public static JList<MenuItem> menu;
    

    public static void open() {
        homePage.open();
    }

    public static void login(User user) {
        homePage.login(User.DEFAULT_USER);
    }

    public static void shouldBeLoggedOut(AbstractPage page) {
        if (page.isLoggedIn()) {
            page.logout();
        }
    }*/
}
