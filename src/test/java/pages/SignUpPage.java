package pages;

import elements.Input;
import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpPage extends BasePage{
    public static final By CREATE_ACC_BUTTON = By.xpath("//button[@type='submit']");

    @Step("Open sign up page ")
    public void openPage() {
        open("/register");
    }

    public void signUp(Account account) {
        new Input("#create_first").write(account.getFirstName());
        new Input("#create_last").write(account.getLastName());
        new Input("#create_email").write(account.getEmail());
        new Input("#password_meter").write(account.getPassword());
        new Input("#create_passwordmatch").write(account.getPassword());
        $(CREATE_ACC_BUTTON).click();
    }
}
