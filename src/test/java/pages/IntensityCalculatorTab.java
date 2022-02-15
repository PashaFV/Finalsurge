package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class IntensityCalculatorTab extends WorkoutCalculatorPopUp {

    public static final By MILE_RADIO_BUTTON = By.xpath("//input[@id='MILE']");
    public static final By FIVE_KM_RADIO_BUTTON = By.xpath("//input[@id='FIVEK']");
    public static final By TEN_KM_RADIO_BUTTON = By.xpath("//input[@id='TENK']");
    public static final By HALF_MARATHON_RADIO_BUTTON = By.xpath("//input[@id='HALFMAR']");
    public static final By MARATHON_RADIO_BUTTON = By.xpath("//input[@id='MARATHON']");
    public static final By HOURS_INPUT = By.xpath("//input[@id='TimeHH']");
    public static final By MINUTES_INPUT = By.xpath("//input[@id='TimeMM']");
    public static final By SECONDS_INPUT = By.xpath("//input[@id='TimeSS']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By YOUR_WORKOUT_PACES_HEADER = By.xpath("//h4[text()='Your Workout Paces']");
    public static final By YOUR_WORKOUT_PACES_TABLE = By.xpath("//table[@class='table table-condensed table-hover']/tbody/tr/td");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']/strong");



    @Step("Running Intensity Calculation")
    public void calculateRunningIntensity() {

        $(FIVE_KM_RADIO_BUTTON).setSelected(true);
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("30");
        $(SECONDS_INPUT).sendKeys("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Running Intensity Calculation with invalid date")
    public void calculateRunningIntensityWithInvalidData() {

        $(MARATHON_RADIO_BUTTON).setSelected(true);
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("10");
        $(SECONDS_INPUT).sendKeys("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

//shouldHave(text("30:00"));


    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenWorkoutPacesHeader() {
        return $(YOUR_WORKOUT_PACES_HEADER);
    }



}
