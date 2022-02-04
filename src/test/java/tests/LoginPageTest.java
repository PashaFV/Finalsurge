package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageTest extends BaseTest {

    @Test(description = "Login with valid data to finalsurge.com")
    public void LoginTest() {
        loginPage.openPage();
        loginPage.login();
        $(By.xpath("//div[@class='user-info']")).shouldBe(visible);

    }

    @Test(description = "Login with invalid data to finalsurge.com")
    public void InvalidLoginTest() {
        loginPage.openPage();
        loginPage.loginWithInvalidData();
        $(By.xpath("//strong[text()='Invalid login credentials. Please try again.']")).shouldBe(visible);

    }

}
