package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    public static final By EMAIL_INPUT = By.xpath("//input[@id='login_name']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='login_password']");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    public static final By INVALID_CRED_TEXT = By.xpath("//label[@class='error'] | //strong[text()='Invalid login credentials. Please try again.']");
    public static final By SUCCESS_LOGOUT_TEXT = By.xpath("//div//strong[text()='You have been successfully logged out of the system.']");

    public String email, password;

    @Step("Open site ")
    public void openPage() {
        open("/login");

    }

    @Step("Login as user '{userName}' use password '{password}'")
    public void login() {

        email = System.getenv().getOrDefault("FINALSURGE_EMAIL", PropertyReader.getProperty("finalsurge.email"));
        password = System.getenv().getOrDefault("FINALSURGE_PASSWORD", PropertyReader.getProperty("finalsurge.password"));
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    @Step("Login as user '{userName}' use password '{password}'")
    public void loginWithInvalidData(String email, String password) {

        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    public SelenideElement invalidCredText() {
        return $(INVALID_CRED_TEXT);
    }

    public SelenideElement successLogoutText() {
        return $(SUCCESS_LOGOUT_TEXT);
    }


}
