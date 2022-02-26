package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class TinmanCalculatorTab extends WorkoutCalculatorPopUp{

    public static final By TINMAN_TITLE_BUTTON = By.xpath("//a[text()='Tinman']");
    public static final By RACE_DIST_DROPDOWN = By.xpath("//select[@name='distance']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By RACE_INFORMATION_HEADER = By.xpath("//h4[text()='Race Information']");
    public static final By RATING_VALUE_IN_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td[4]");


    @Step("Open Tinman calculator tab")
    public void openTinmanTab() {
        log.info("Open Tinman calculator tab in workout calculator");
        $(TINMAN_TITLE_BUTTON).click();
    }

    @Step("Tinman running calculation")
    public void calculateTinmanRunning() {

        log.info("Tinman running calculation");
        $(RACE_DIST_DROPDOWN).selectOptionByValue("10");
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("45");
        new Input("#TimeSS").write("00");
        new RadioButton("#Male").click();
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Tinman running Calculation with invalid data")
    public void invalidCalculateTinmanRunning() {

        log.info("Tinman running calculation with invalid data");
        $(RACE_DIST_DROPDOWN).selectOptionByValue("10");
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("00");
        new Input("#TimeSS").write("10");
        new RadioButton("#Male").click();
        $(CALCULATE_PACES_BUTTON).click();

    }



    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenRaceInformationHeader() {
        return $(RACE_INFORMATION_HEADER);
    }

    @Step("Checking that the rating value in table was right")
    public SelenideElement ratingValueInTable() {
        return $(RATING_VALUE_IN_TABLE);
    }

}
