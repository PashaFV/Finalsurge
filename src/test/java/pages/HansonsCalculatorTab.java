package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class HansonsCalculatorTab extends WorkoutCalculatorPopUp{

    public static final By HANSONS_TITLE_BUTTON = By.xpath("//a[text()='Hansons']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By RACE_INFORMATION_HEADER = By.xpath("//h4[text()='Recent Race Information']");
    public static final By PACE_KM_VALUE_IN_RECENT_RACE_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td[4]");
    public static final By RECENT_RACE_INFORMATION_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td");


    @Step("Open Hansons calculator tab")
    public void openHansonsTab() {
        log.info("Open Hansons calculator tab in workout calculator");
        $(HANSONS_TITLE_BUTTON).click();
    }

    @Step("Hansons marathon Calculation")
    public void calculateHansonsMarathonPace() {

        log.info("Hansons marathon calculation");
        new Dropdown("#RaceDist").selectOption("Marathon");
        new Input("#TimeHH").write("01");
        new Input("#TimeMM").write("30");
        new Input("#TimeSS").write("00");
        new Input("#Temp").write("24");
        new Input("#Wind").write("10");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Hansons marathon Calculation")
    public void calculateHansonsMarathonPaceWithInvalidData() {

        log.info("Hansons marathon calculation with invalid data");
        new Input("#TimeHH").write("01");
        new Input("#TimeMM").write("30");
        new Input("#TimeSS").write("00");
        new Input("#Temp").write("24");
        new Input("#Wind").write("10");
        $(CALCULATE_PACES_BUTTON).click();

    }


    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenRaceInfoHeader() {
        return $(RACE_INFORMATION_HEADER);
    }

    @Step("Checking that the Pace/km value was right")
    public SelenideElement checkingPaceKmValue() {
        return $(PACE_KM_VALUE_IN_RECENT_RACE_TABLE);
    }


}
