package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public static final By USERNAME_INPUT = By.xpath("//input[@id='login_name']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='login_password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open site ")
    public void openPage() {
        driver.get("https://log.finalsurge.com/login");

    }

    @Step("Login as user '{userName}' use password '{password}'")
    public void login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }


}
