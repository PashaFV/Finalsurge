package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class WorkoutCalculatorPopUp extends BasePage {

    public static final By WORKOUT_CALCULATOR_BUTTON = By.xpath("//a[@data-reveal-id='IntensityCalc']");
    public static final By MILE_RADIO_BUTTON = By.xpath("//input[@id='MILE']");
    public static final By HOURS_INPUT = By.xpath("//input[@id='TimeHH']");
    public static final By MINUTES_INPUT = By.xpath("//input[@id='TimeMM']");
    public static final By SECONDS_INPUT = By.xpath("//input[@id='TimeSS']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By YOUR_WORKOUT_PACES_HEADER = By.xpath("//h4[text()='Your Workout Paces']");

    public static final By HANSONS_TITLE_BUTTON = By.xpath("//a[text()='Hansons']");
    public static final By RACE_DIST_DROPDOWN = By.xpath("//select[@name='distance']");
    public static final By TEMPERATURE_INPUT = By.xpath("//input[@id='Temp']");
    public static final By WIND_SPEED_INPUT = By.xpath("//input[@id='Wind']");

    public static final By MCMILLAN_TITLE_BUTTON = By.xpath("//a[text()='McMillan']");
    public static final By GOAL_DIST_DROPDOWN = By.xpath("//select[@name='goaldistance']");
    public static final By GOAL_HOURS_INPUT = By.xpath("//input[@id='GTimeHH']");
    public static final By GOAL_MINUTES_INPUT = By.xpath("//input[@id='GTimeMM']");
    public static final By GOAL_SECONDS_INPUT = By.xpath("//input[@id='GTimeSS']");
    public static final By RE_CALCULATE_PACES_BUTTON = By.xpath("//a[@name='btnSubmitSettings']");
    public static final By CALCULATE_MY_PACES_BUTTON = By.xpath("//input[@value='Calculate My Paces']");

    public static final By TINMAN_TITLE_BUTTON = By.xpath("//a[text()='Tinman']");
    public static final By MALE_RADIO_BUTTON = By.xpath("//input[@id='Male']");
    public static final By RACE_INFORMATION_HEADER = By.xpath("//h4[text()='Race Information']");

    @Step("Running Intensity Calculation")
    public void calculateRunningIntensity() {

        $(WORKOUT_CALCULATOR_BUTTON).click();
        switchTo().frame($("[id='IntensityCalciFrame']"));
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("12");
        $(SECONDS_INPUT).sendKeys("00");
        $(MILE_RADIO_BUTTON).click();
        $(CALCULATE_PACES_BUTTON).click();

    }
    @Step("Hansons marathon Calculation")
    public void calculateHansonsMarathonPace() {

        $(WORKOUT_CALCULATOR_BUTTON).click();
        switchTo().frame($("[id='IntensityCalciFrame']"));
        $(HANSONS_TITLE_BUTTON).click();
        $(RACE_DIST_DROPDOWN).selectOptionByValue("Marathon");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("12");
        $(SECONDS_INPUT).sendKeys("00");
        $(TEMPERATURE_INPUT).sendKeys("30");
        $(WIND_SPEED_INPUT).sendKeys("10");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("McMillan running Calculation")
    public void calculateMcMillanRunning() {

        $(WORKOUT_CALCULATOR_BUTTON).click();
        switchTo().frame($("[id='IntensityCalciFrame']"));
        $(MCMILLAN_TITLE_BUTTON).click();
        $(RACE_DIST_DROPDOWN).selectOptionByValue("10km");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("12");
        $(SECONDS_INPUT).sendKeys("00");
        $(GOAL_DIST_DROPDOWN).selectOptionByValue("15km");
        $(GOAL_HOURS_INPUT).setValue("00");
        $(GOAL_MINUTES_INPUT).sendKeys("10");
        $(GOAL_SECONDS_INPUT).sendKeys("00");
        $(CALCULATE_MY_PACES_BUTTON).click();

    }

    @Step("Tinman running Calculation")
    public void calculateTinmanRunning() {

        $(WORKOUT_CALCULATOR_BUTTON).click();
        switchTo().frame($("[id='IntensityCalciFrame']"));
        $(TINMAN_TITLE_BUTTON).click();
        $(RACE_DIST_DROPDOWN).selectOptionByValue("10");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("12");
        $(SECONDS_INPUT).sendKeys("00");
        $(MALE_RADIO_BUTTON).click();
        $(CALCULATE_PACES_BUTTON).click();

    }

    public SelenideElement yourWorkoutPacesHeader(){
        return $(YOUR_WORKOUT_PACES_HEADER);
    }

    public SelenideElement reCalculatePacesButton(){
        return $(RE_CALCULATE_PACES_BUTTON);
    }

    public SelenideElement raceInformationHeader(){
        return $(RACE_INFORMATION_HEADER);
    }

}
