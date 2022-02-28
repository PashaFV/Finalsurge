package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class PalladinoCalculatorTab extends WorkoutCalculatorPopUp{

    public static final By PALLADINO_TITLE_BUTTON = By.xpath("//a[text()='Palladino']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By POWER_TARGET_VALUE_IN_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td[3]");

    public static final By ESTIMATE_RESULTS_BUTTON = By.xpath("//input[@id='saveButtonSettings2']");
    public static final By ESTIMATE_CP_VALUE_IN_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td[1]");

    public static final By ESTIMATE_RESULTS_BUTTON_SECOND = By.xpath("//input[@id='saveButtonSettings3']");
    public static final By ESTIMATE_CP_OR_FTP_VALUE_IN_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td[2]");
    public static final By ESTIMATE_CP_OR_FTP_RANGE_VALUE_IN_TABLE = By.xpath("//table[@class='table table-condensed table-hover table-striped']/tbody/tr/td[2]");

    public static final By ESTIMATE_RESULTS_BUTTON_THIRD = By.xpath("//input[@id='saveButtonSettings4']");
    public static final By INTERVAL_POWER_TARGETS_HEADER = By.xpath("//h4[text()='Interval Power Targets']");

    @Step("Open Palladino calculator tab")
    public void openPalladinoTab() {
        log.info("Open Palladino calculator tab in workout calculator");
        $(PALLADINO_TITLE_BUTTON).click();
    }


    //PALLADINO POWER PROJECT - INTERVAL POWER TARGET CALCULATOR
    @Step("Calculation interval power target by Palladino power project")
    public void calculatePalladinoIntervalPower() {

        log.info("Calculation interval power target by Palladino power project");
        new Input("#CP").write("100");
        new Input("#RWC").write("10");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Calculation interval power target with invalid data")
    public void invalidCalculatePalladinoPower() {

        log.info("Calculation interval power target with invalid data");
        new Input("#CP").write("10");
        new Input("#RWC").write("10");
        $(CALCULATE_PACES_BUTTON).click();

    }

    //PALLADINO POWER PROJECT - CP AND RWC FROM A CP TEST
    @Step("Estimate result from the duration and power data of two test components")
    public void cpAndRwcPalladinoEstimate() {

        log.info("Estimate result from the duration and power data of two test components");
        new Input("#TimeMM").write("10");
        new Input("#TimeSS").write("00");
        new Input("#AVPWS").write("100");
        new Input("#TimeMML").write("12");
        new Input("#TimeSSL").write("00");
        new Input("#AVPWL").write("100");
        $(ESTIMATE_RESULTS_BUTTON).click();

    }

    @Step("Estimate result from the duration and power with invalid data")
    public void invalidCpAndRwcPalladinoEstimate() {

        log.info("Estimate result from the duration and power with invalid dat");
        new Input("#TimeMM").write("10");
        new Input("#TimeSS").write("00");
        new Input("#AVPWS").write("100");
        new Input("#TimeMML").write("12");
        new Input("#TimeSSL").write("00");
        new Input("#AVPWL").write("10");
        $(ESTIMATE_RESULTS_BUTTON).click();

    }

    //PALLADINO POWER PROJECT - CP FROM RACE OR TT >= 40 MINUTES
    @Step("Calculation estimate range for CP/FTP from race/TT duration and power from 40 minutes")
    public void estimateFromRaceFromFourtyMinutes() {

        log.info("Calculation estimate range for CP/FTP from race/TT duration and power from 40 minutes");
        new Input("#TimeHHR").write("1");
        new Input("#TimeMMR").write("10");
        new Input("#TimeSSR").write("00");
        new Input("#RAP").write("100");
        $(ESTIMATE_RESULTS_BUTTON_SECOND).click();

    }

    //PALLADINO POWER PROJECT - CP FROM RACE OR TT <= 40 MINUTES
    @Step("Calculation estimate range for CP/FTP from race/TT duration and power up to 40 minutes")
    public void estimateFromRaceUpToFourtyMinutes() {

        log.info("Calculation estimate range for CP/FTP from race/TT duration and power up to 40 minutes");
        new Input("#TimeMMRR").write("10");
        new Input("#TimeSSRR").write("00");
        new Input("#RAPR").write("100");
        $(ESTIMATE_RESULTS_BUTTON_THIRD).click();

    }


    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenPowerTargetHeader() {
        return $(INTERVAL_POWER_TARGETS_HEADER);
    }

    @Step("Checking that the Power Target (W) value was right")
    public SelenideElement powerTargetValue() {
        return $(POWER_TARGET_VALUE_IN_TABLE);
    }

    @Step("Checking that the CP (W) value was right")
    public SelenideElement estimateCPValue() {
        return $(ESTIMATE_CP_VALUE_IN_TABLE);
    }

    @Step("Checking that the CP/FTP Estimate (W) value was right")
    public SelenideElement estimateCpOrFtpValue() {
        return $(ESTIMATE_CP_OR_FTP_VALUE_IN_TABLE);
    }

    @Step("Checking that the CP/FTP range (W) value was right")
    public SelenideElement estimateCpOrFtpRangeValue() {
        return $(ESTIMATE_CP_OR_FTP_RANGE_VALUE_IN_TABLE);
    }



}
