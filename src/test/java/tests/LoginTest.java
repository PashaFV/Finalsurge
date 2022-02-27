package tests;

import lombok.extern.log4j.Log4j2;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Login with valid data to finalsurge.com", priority = 2)
    public void loginTest() {
        log.debug("Login to the site using valid data");
        loginPage.openPage();
        loginPage.login();
        calendarPage.userInfo().shouldBe(visible);
    }

    @Test(description = "Logout after success login to finalsurge.com", priority = 3)
    public void logoutTest(){
        log.debug("Logout after success login from finalsurge.com");
        loginPage.openPage();
        loginPage.login();
        calendarPage.logout();
        loginPage.successLogoutText().shouldHave(text("You have been successfully logged out of the system."));
    }

    @Test(dataProvider = "loginData", description = "Login with invalid data to finalsurge.com", priority = 1)
    public void invalidLoginTest(String userName, String password, String errorMessage) {
        log.debug("Login to finalsurge.com using an invalid data");
        loginPage.openPage();
        loginPage.loginWithInvalidData(userName, password);
        loginPage.invalidCredText().shouldBe(visible);
        loginPage.invalidCredText().shouldHave(text(errorMessage));

    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "test1234", "Please enter your e-mail address."},
                {"test@ya.ru", "", "Please enter a password."},
                {"usertest@ya.ru", "12345678", "Invalid login credentials. Please try again."},
                {"", "", "Please enter your e-mail address."},
        };
    }

    @Test(description = "Sign Up with valid data to finalsurge.com", priority = 4)
    public void registrationTest() {
        log.debug("Sign up to the site using valid data");
        signUpPage.openPage();
        Account account = AccountFactory.get();
        signUpPage.signUp(account);
        calendarPage.userInfo().shouldBe(visible);
    }
}
