package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class OtherCalculatorPopUp extends BasePage {

    public static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']");
    public static final By OTHER_CALCULATOR_BUTTON = By.xpath("//a[@data-reveal-id='OtherCalc']");
    public static final By CLOSE_CALCULATOR_BUTTON = By.xpath("//div[@id='OtherCalc']/a[@class='close-reveal-modal']");
    public static final By PACE_TITLE_BUTTON = By.xpath("//a[text()='Pace Calculator']");
    public static final By FINALSURGE_HEADER_LOGO = By.xpath("//img[@alt='Final Surge']");

    @Step("Open Pop-Up other calculator")
    public void openCalculatorPopUp() {
        log.info("Open Pop-Up other calculator");
        WebDriverRunner.driver().getWebDriver().manage().deleteCookieNamed("FSOCalc");
        $(OTHER_CALCULATOR_BUTTON).click();
        switchTo().frame($("[id='OtherCalciFrame']"));
    }

    @Step("Close Pop-Up workout calculator")
    public void closeCalculatorPopUp() {
        log.info("Close Pop-Up other calculator");
        switchTo().defaultContent();
        $(CLOSE_CALCULATOR_BUTTON).click();

    }


    public SelenideElement ErrorMessage() {
        return $(ERROR_MESSAGE);
    }

    public SelenideElement popUpTitleButton() {
        return $(PACE_TITLE_BUTTON);
    }

    public SelenideElement headerLogo() {
        return $(FINALSURGE_HEADER_LOGO);
    }

}
