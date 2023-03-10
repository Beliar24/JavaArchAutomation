package ui.selenium.tests;


import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.selenium.configuration.Base;
import ui.selenium.po.LoginPage;
import ui.selenium.entities.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ui.selenium.service.UserController.getUserCredentials;
import static ui.selenium.utils.Utils.getProperty;

public class WikiLoginTest extends Base {

    @Test
    @Description("Test for successfully auth with user")
    public void wikiLogInTest() {
        User user = getUserCredentials();

        new LoginPage()
                .clickLogin()
                .auth(user);

        assertThat(new LoginPage().getUsername()).isEqualTo(getProperty("username"));
    }
}
