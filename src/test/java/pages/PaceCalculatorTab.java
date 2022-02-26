package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class PaceCalculatorTab extends OtherCalculatorPopUp{

    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By PACE_CHART_TABLE_HEADER = By.xpath("//h4[text()='Pace Chart']");
    public static final By PACE_CHART_TIME_VALUE = By.xpath("//table[@class='table table-condensed table-hover']/tbody/tr[2]/td[2]");
    public static final By PACE_TITLE_BUTTON = By.xpath("//a[text()='Pace Calculator']");

    @Step("Open pace calculator tab")
    public void openPaceTab() {
        log.info("Open pace calculator tab in other calculator");
        $(PACE_TITLE_BUTTON).click();
    }


    @Step("Pace calculation")
    public void calculatePace() {
        log.info("Pace calculation in other calculator");

        new Input("#RunDist").write("2");
        new Dropdown("#DistType").selectOption("Kilometers");
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("30");
        new Input("#TimeSS").write("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Pace calculation with invalid data")
    public void invalidCalculatePace() {
        log.info("Pace calculation with invalid data in other calculator");

        new Input("#RunDist").write("2");
        new Dropdown("#DistType").selectOption("Kilometers");
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("00");
        new Input("#TimeSS").write("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenPaceChartTable() {
        return $(PACE_CHART_TABLE_HEADER);
    }

    @Step("Checking that the table was opened")
    public SelenideElement checkingPaceChartTime() {
        return $(PACE_CHART_TIME_VALUE);
    }


}
