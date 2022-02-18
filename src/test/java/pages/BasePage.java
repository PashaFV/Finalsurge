package pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected void deleteCookiesForExpandCollapseTables() {
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("pacezones-run");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("routes-run");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("hrzones-run");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("notes-run");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("weather-run");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("equipment-run");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("warmcool-run");
    }

}
