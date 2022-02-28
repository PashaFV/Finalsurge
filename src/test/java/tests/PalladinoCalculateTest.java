package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class PalladinoCalculateTest extends BaseTest {

    @Test(description = "Calculation Palladino interval power method pace", priority = 1)
    public void сalculatePalladinoIntervalPowerTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        palladinoCalculatorTab.openPalladinoTab();
        palladinoCalculatorTab.calculatePalladinoIntervalPower();
        palladinoCalculatorTab.checkingOpenPowerTargetHeader().shouldBe(visible);
        palladinoCalculatorTab.powerTargetValue().shouldHave(text("95 - 105"));

    }

    @Test(description = "Calculation Palladino interval power method pace with invalid data", priority = 2)
    public void invalidCalculatePalladinoMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        palladinoCalculatorTab.openPalladinoTab();
        palladinoCalculatorTab.invalidCalculatePalladinoPower();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Critical Power cannot be less than 100.00."));

    }

    @Test(description = "Estimate result from the duration and power data", priority = 3)
    public void cpAndRwcPalladinoEstimateTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        palladinoCalculatorTab.openPalladinoTab();
        palladinoCalculatorTab.cpAndRwcPalladinoEstimate();
        palladinoCalculatorTab.estimateCPValue().shouldHave(text("100.0"));

    }

    @Test(description = "Estimate result from the duration and power data with invalid data", priority = 4)
    public void invalidCpAndRwcPalladinoEstimateTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        palladinoCalculatorTab.openPalladinoTab();
        palladinoCalculatorTab.invalidCpAndRwcPalladinoEstimate();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Average Power (Long) cannot be less than 20.00."));

    }

    @Test(description = "Estimate result CP from race or tt >= 40 MINUTES", priority = 5)
    public void cpFromFourtyMinutesEstimateTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        palladinoCalculatorTab.openPalladinoTab();
        palladinoCalculatorTab.estimateFromRaceFromFourtyMinutes();
        palladinoCalculatorTab.estimateCpOrFtpValue().shouldHave(text("101"));

    }

    @Test(description = "Estimate result CP from race or tt >= 40 MINUTES", priority = 6)
    public void cpUpToFourtyMinutesEstimateTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        palladinoCalculatorTab.openPalladinoTab();
        palladinoCalculatorTab.estimateFromRaceUpToFourtyMinutes();
        palladinoCalculatorTab.estimateCpOrFtpRangeValue().shouldHave(text("80 to 87"));

    }

}
