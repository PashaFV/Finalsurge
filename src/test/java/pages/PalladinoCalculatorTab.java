package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PalladinoCalculatorTab extends WorkoutCalculatorPopUp{

    public static final By PALLADINO_TITLE_BUTTON = By.xpath("//a[text()='Palladino']");
    public static final By CRITICAL_POWER_INPUT = By.xpath("//input[@id='CP']");
    public static final By RESERVE_WORK_CAPACITY_INPUT = By.xpath("//input[@id='RWC']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");

    public static final By MINUTES_INPUT = By.xpath("//input[@id='TimeMM']");
    public static final By SECONDS_INPUT = By.xpath("//input[@id='TimeSS']");
    public static final By SHORT_TEST_AVG_POWER_INPUT = By.xpath("//input[@id='AVPWS']");
    public static final By LONG_TEST_AVG_POWER_INPUT = By.xpath("//input[@id='AVPWL']");
    public static final By LONG_MINUTES_INPUT = By.xpath("//input[@id='TimeMML']");
    public static final By LONG_SECONDS_INPUT = By.xpath("//input[@id='TimeSSL']");
    public static final By ESTIMATE_RESULTS_BUTTON = By.xpath("//input[@id='saveButtonSettings2']");

    public static final By RACE_TIME_HOURS_INPUT = By.xpath("//input[@id='TimeHHR']");
    public static final By RACE_TIME_MINUTES_INPUT = By.xpath("//input[@id='TimeMMR']");
    public static final By RACE_TIME_SECONDS_INPUT = By.xpath("//input[@id='TimeSSR']");
    public static final By RACE_AVG_POWER_INPUT = By.xpath("//input[@id='RAP']");
    public static final By ESTIMATE_RESULTS_BUTTON_SECOND = By.xpath("//input[@id='saveButtonSettings3']");

    public static final By RRACE_TIME_MINUTES_INPUT = By.xpath("//input[@id='TimeMMRR']");
    public static final By RRACE_TIME_SECONDS_INPUT = By.xpath("//input[@id='TimeSSRR']");
    public static final By RRACE_AVG_POWER_INPUT = By.xpath("//input[@id='RAPR']");
    public static final By ESTIMATE_RESULTS_BUTTON_THIRD = By.xpath("//input[@id='saveButtonSettings4']");


    public static final By YOUR_WORKOUT_PACES_TABLE = By.xpath("//table[@class='table table-condensed table-hover']/tbody/tr/td");
    public static final By INTERVAL_POWER_TARGETS_HEADER = By.xpath("//h4[text()='Interval Power Targets']");


//PALLADINO POWER PROJECT - INTERVAL POWER TARGET CALCULATOR
    @Step("Calculation interval power target by Palladino power project")
    public void calculatePalladinoPower() {

        $(PALLADINO_TITLE_BUTTON).click();
        $(CRITICAL_POWER_INPUT).setValue("100");
        $(RESERVE_WORK_CAPACITY_INPUT).setValue("10");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Calculation interval power target with invalid data")
    public void invalidCalculatePalladinoPower() {

        $(PALLADINO_TITLE_BUTTON).click();
        $(CRITICAL_POWER_INPUT).setValue("10");
        $(RESERVE_WORK_CAPACITY_INPUT).setValue("10");
        $(CALCULATE_PACES_BUTTON).click();

    }

//PALLADINO POWER PROJECT - CP AND RWC FROM A CP TEST
    @Step("Calculation estimate from the duration and power data of two test components")
    public void calcululatePalladinoEstimate() {

        $(MINUTES_INPUT).setValue("10");
        $(SECONDS_INPUT).setValue("00");
        $(SHORT_TEST_AVG_POWER_INPUT).setValue("100");
        $(LONG_MINUTES_INPUT).setValue("12");
        $(LONG_SECONDS_INPUT).setValue("00");
        $(LONG_TEST_AVG_POWER_INPUT).setValue("100");
        $(ESTIMATE_RESULTS_BUTTON).click();

    }

//PALLADINO POWER PROJECT - CP FROM RACE OR TT >= 40 MINUTES
    @Step("Calculation estimate range for CP/FTP from race/TT duration and power from 40 minutes")
    public void calcululateEstimateFromRaceFromFourtyMinutes() {

        $(RACE_TIME_HOURS_INPUT).setValue("1");
        $(RACE_TIME_MINUTES_INPUT).setValue("10");
        $(RACE_TIME_SECONDS_INPUT).setValue("00");
        $(RACE_AVG_POWER_INPUT).setValue("100");
        $(ESTIMATE_RESULTS_BUTTON_SECOND).click();

    }

//PALLADINO POWER PROJECT - CP FROM RACE OR TT <= 40 MINUTES
    @Step("Calculation estimate range for CP/FTP from race/TT duration and power up to 40 minutes")
    public void calcululateEstimateFromRaceUpToFourtyMinutes() {

        $(RRACE_TIME_MINUTES_INPUT).setValue("10");
        $(RRACE_TIME_SECONDS_INPUT).setValue("00");
        $(RRACE_AVG_POWER_INPUT).setValue("100");
        $(ESTIMATE_RESULTS_BUTTON_THIRD).click();

    }


    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenPowerTargetHeader() {
        return $(INTERVAL_POWER_TARGETS_HEADER);
    }

    //TODO checking shouldHave(text("30:00"));
    @Step("Checking that the calculations for Interval Power Targets are correct")
    public SelenideElement сheckingCalculations() {
        return $(YOUR_WORKOUT_PACES_TABLE);
    }

}
