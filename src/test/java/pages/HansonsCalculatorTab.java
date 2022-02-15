package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class HansonsCalculatorTab extends WorkoutCalculatorPopUp{

    public static final By HANSONS_TITLE_BUTTON = By.xpath("//a[text()='Hansons']");
    public static final By RACE_DIST_DROPDOWN = By.xpath("//select[@name='distance']");
    public static final By TEMPERATURE_INPUT = By.xpath("//input[@id='Temp']");
    public static final By WIND_SPEED_INPUT = By.xpath("//input[@id='Wind']");
    public static final By HOURS_INPUT = By.xpath("//input[@id='TimeHH']");
    public static final By MINUTES_INPUT = By.xpath("//input[@id='TimeMM']");
    public static final By SECONDS_INPUT = By.xpath("//input[@id='TimeSS']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By RACE_INFORMATION_HEADER = By.xpath("//h4[text()='Race Information']");
    public static final By RECENT_RACE_INFORMATION_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']/strong");


    @Step("Hansons marathon Calculation")
    public void calculateHansonsMarathonPace() {

        $(HANSONS_TITLE_BUTTON).click();
        $(RACE_DIST_DROPDOWN).selectOptionByValue("Marathon");
        $(HOURS_INPUT).setValue("01");
        $(MINUTES_INPUT).sendKeys("30");
        $(SECONDS_INPUT).sendKeys("00");
        $(TEMPERATURE_INPUT).sendKeys("24");
        $(WIND_SPEED_INPUT).sendKeys("10");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Hansons marathon Calculation")
    public void calculateHansonsMarathonPaceWithInvalidData() {

        $(HANSONS_TITLE_BUTTON).click();
        $(HOURS_INPUT).setValue("01");
        $(MINUTES_INPUT).sendKeys("30");
        $(SECONDS_INPUT).sendKeys("00");
        $(TEMPERATURE_INPUT).sendKeys("24");
        $(WIND_SPEED_INPUT).sendKeys("10");
        $(CALCULATE_PACES_BUTTON).click();

    }

//.shouldHave(text("Marathon"));


    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenRaceInfoHeader() {
        return $(RACE_INFORMATION_HEADER);
    }


}
