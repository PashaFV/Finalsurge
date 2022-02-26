package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class McMillanCalculatorTab extends WorkoutCalculatorPopUp {

    public static final By RACE_DIST_DROPDOWN = By.xpath("//select[@name='distance']");
    public static final By MCMILLAN_TITLE_BUTTON = By.xpath("//a[text()='McMillan']");
    public static final By GOAL_DIST_DROPDOWN = By.xpath("//select[@name='goaldistance']");
    public static final By CALCULATE_MY_PACES_BUTTON = By.xpath("//input[@value='Calculate My Paces']");
    public static final By RE_CALCULATE_PACES_BUTTON = By.xpath("//a[@name='btnSubmitSettings']");
    public static final By RECOVERY_JOGS_VALUE = By.xpath("//table[@class='table table-condensed table-hover']/tbody/tr[@class='MIpace']/td[2]");
    public static final By RECENT_INFORMATION_TABLE = By.xpath("//div/strong");

    @Step("Open McMillan calculator tab")
    public void openMcMillanTab() {
        log.info("Open McMillan calculator tab in workout calculator");
        $(MCMILLAN_TITLE_BUTTON).click();
    }

    @Step("McMillan running Calculation")
    public void calculateMcMillanRunning() {

        log.info("McMillan running calculation");
        new Dropdown("#distance").selectOption("10Km");
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("12");
        new Input("#TimeSS").write("00");
        $(GOAL_DIST_DROPDOWN).selectOptionByValue("15km");
        new Input("#GTimeHH").write("00");
        new Input("#GTimeMM").write("10");
        new Input("#GTimeSS").write("00");
        $(CALCULATE_MY_PACES_BUTTON).click();

    }

    @Step("McMillan running Calculation with invalid data")
    public void invalidCalculateMcMillanRunning() {

        log.info("McMillan running calculation with invalid data");
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("12");
        new Input("#TimeSS").write("00");
        $(GOAL_DIST_DROPDOWN).selectOptionByValue("15km");
        new Input("#GTimeHH").write("00");
        new Input("#GTimeMM").write("10");
        new Input("#GTimeSS").write("00");
        $(CALCULATE_MY_PACES_BUTTON).click();

    }

    @Step("Re calculate McMillan running after success")
    public void reCalculateMcMillanRunning() {

        log.info("Re calculate McMillan running after success");
        new Dropdown("#distance").selectOption("10Km");
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("12");
        new Input("#TimeSS").write("00");
        $(GOAL_DIST_DROPDOWN).selectOptionByValue("15km");
        new Input("#GTimeHH").write("00");
        new Input("#GTimeMM").write("10");
        new Input("#GTimeSS").write("00");
        $(CALCULATE_MY_PACES_BUTTON).click();
        $(RE_CALCULATE_PACES_BUTTON).click();

    }

    @Step("Checking that the re-calculate button was visible")
    public SelenideElement reCalculateButton() {
        return $(RE_CALCULATE_PACES_BUTTON);
    }

    @Step("Checking that the recovery jogs value was right")
    public SelenideElement recoveryJogsValue() {
        return $(RECOVERY_JOGS_VALUE);
    }

    @Step("Checking that value in distance dropdown was right")
    public SelenideElement reCalculateDropdownValue() {
        return $(RACE_DIST_DROPDOWN);
    }


}
