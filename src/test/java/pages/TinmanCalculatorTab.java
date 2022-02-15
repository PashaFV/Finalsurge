package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class TinmanCalculatorTab {

    public static final By TINMAN_TITLE_BUTTON = By.xpath("//a[text()='Tinman']");
    public static final By MALE_RADIO_BUTTON = By.xpath("//input[@id='Male']");
    public static final By FEMALE_RADIO_BUTTON = By.xpath("//input[@id='Female']");
    public static final By RACE_DIST_DROPDOWN = By.xpath("//select[@name='distance']");
    public static final By HOURS_INPUT = By.xpath("//input[@id='TimeHH']");
    public static final By MINUTES_INPUT = By.xpath("//input[@id='TimeMM']");
    public static final By SECONDS_INPUT = By.xpath("//input[@id='TimeSS']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By RACE_INFORMATION_HEADER = By.xpath("//h4[text()='Race Information']");
    public static final By RECENT_RACE_INFORMATION_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td");


    @Step("Tinman running Calculation")
    public void calculateTinmanRunning() {

        $(TINMAN_TITLE_BUTTON).click();
        $(RACE_DIST_DROPDOWN).selectOptionByValue("10");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("12");
        $(SECONDS_INPUT).sendKeys("00");
        $(MALE_RADIO_BUTTON).click();
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Tinman running Calculation with invalid data")
    public void InvalidCalculateTinmanRunning() {

        $(TINMAN_TITLE_BUTTON).click();
        $(RACE_DIST_DROPDOWN).selectOptionByValue("10");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("00");
        $(SECONDS_INPUT).sendKeys("00");
        $(MALE_RADIO_BUTTON).click();
        $(CALCULATE_PACES_BUTTON).click();

    }

//shouldHave(text("10 km"));


    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenRaceInformationHeader() {
        return $(RACE_INFORMATION_HEADER);
    }

}
