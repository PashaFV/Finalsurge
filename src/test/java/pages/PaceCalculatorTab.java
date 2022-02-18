package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PaceCalculatorTab extends OtherCalculatorPopUp{

    public static final By DISTANCE_INPUT = By.xpath("//input[@id='RunDist']");
    public static final By DISTANCE_TYPE_DROPDOWN = By.xpath("//select[@id='DistType']");
    public static final By HOURS_INPUT = By.xpath("//input[@id='TimeHH']");
    public static final By MINUTES_INPUT = By.xpath("//input[@id='TimeMM']");
    public static final By SECONDS_INPUT = By.xpath("//input[@id='TimeSS']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By PACE_CHART_TABLE_HEADER = By.xpath("//h4[text()='Pace Chart']");
    public static final By PACE_TITLE_BUTTON = By.xpath("//a[text()='Pace Calculator']");


    @Step("Pace Calculation")
    public void calculatePace() {

        $(PACE_TITLE_BUTTON).click();
        $(DISTANCE_INPUT).setValue("2");
        $(DISTANCE_TYPE_DROPDOWN).selectOptionByValue("km");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("30");
        $(SECONDS_INPUT).sendKeys("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Pace Calculation with invalid data")
    public void invalidCalculatePace() {

        $(PACE_TITLE_BUTTON).click();
        $(DISTANCE_INPUT).setValue("2");
        $(DISTANCE_TYPE_DROPDOWN).selectOptionByValue("km");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("00");
        $(SECONDS_INPUT).sendKeys("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenPaceChartTable() {
        return $(PACE_CHART_TABLE_HEADER);
    }

}
