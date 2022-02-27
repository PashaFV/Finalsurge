package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class PaceCalculateTest extends BaseTest {

    @Test(description = "Calculation pace", priority = 1)
    public void сalculatePaceTest() {

        loginPage.openPage();
        loginPage.login();
        otherCalculatorPopUp.openCalculatorPopUp();
        otherCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        paceCalculatorTab.openPaceTab();
        paceCalculatorTab.calculatePace();
        paceCalculatorTab.checkingOpenPaceChartTable().shouldBe(visible);
        paceCalculatorTab.checkingPaceChartTime().shouldHave(text("15:00 min/km"));

    }

    @Test(description = "Calculation pace with invalid data", priority = 2)
    public void invalidCalculatePaceTest() {

        loginPage.openPage();
        loginPage.login();
        otherCalculatorPopUp.openCalculatorPopUp();
        otherCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        paceCalculatorTab.openPaceTab();
        paceCalculatorTab.invalidCalculatePace();
        otherCalculatorPopUp.ErrorMessage().shouldHave(text("Please enter a time greater than 0 seconds."));

    }
}
