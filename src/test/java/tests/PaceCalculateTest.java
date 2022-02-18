package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class PaceCalculateTest extends BaseTest {

    @Test(description = "Calculation pace")
    public void сalculatePaceTest() {

        loginPage.openPage();
        loginPage.login();
        otherCalculatorPopUp.openCalculatorPopUp();
        otherCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        paceCalculatorTab.calculatePace();
        paceCalculatorTab.checkingOpenPaceChartTable().shouldBe(visible);

    }

    @Test(description = "Calculation pace with invalid data")
    public void invalidCalculatePaceTest() {

        loginPage.openPage();
        loginPage.login();
        otherCalculatorPopUp.openCalculatorPopUp();
        otherCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        paceCalculatorTab.invalidCalculatePace();
        otherCalculatorPopUp.ErrorMessage().shouldHave(text("Please enter a time greater than 0 seconds."));

    }
}
