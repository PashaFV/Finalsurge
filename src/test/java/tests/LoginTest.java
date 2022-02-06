package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.LoginPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {

    @Test(description = "Login with valid data to finalsurge.com")
    public void loginTest() {
        loginPage.openPage();
        loginPage.login();
        calendarPage.userInfo().shouldBe(visible);
    }

    @Test(description = "Login with invalid data to finalsurge.com")
    public void invalidLoginTest() {
        loginPage.openPage();
        loginPage.loginWithInvalidData();
        loginPage.invalidCredText().shouldBe(visible);
    }

    @Test
    public void logoutTest(){
        loginPage.openPage();
        loginPage.login();
        calendarPage.logout();
        loginPage.successLogoutText().shouldHave(text("You have been successfully logged out of the system."));
    }


}
