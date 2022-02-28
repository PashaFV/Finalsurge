package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class SignUpPage extends BasePage{
    public static final By CREATE_ACC_BUTTON = By.xpath("//button[@type='submit']");

    @Step("Open sign up page ")
    public void openPage() {
        log.info("Open /register page");
        open("/register");
    }

    @Step("Sign up")
    public void signUp(Account account) {
        log.info("Fill in fields in signUp page");
        new Input("#create_first").write(account.getFirstName());
        new Input("#create_last").write(account.getLastName());
        new Input("#create_email").write(account.getEmail());
        new Input("#password_meter").write(account.getPassword());
        new Input("#create_passwordmatch").write(account.getPassword());
        log.info("Click on Create Account Button");
        $(CREATE_ACC_BUTTON).click();
    }
}
