package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class HansonsCalculateTest extends BaseTest {

    @Test(description = "Calculation Hansons method pace", priority = 1)
    public void сalculateHansonsMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        hansonsCalculatorTab.openHansonsTab();
        hansonsCalculatorTab.calculateHansonsMarathonPace();
        hansonsCalculatorTab.checkingOpenRaceInfoHeader().shouldBe(visible);
        hansonsCalculatorTab.checkingPaceKmValue().shouldHave(text("0:42"));

    }

    @Test(description = "Calculation Hansons method pace", priority = 2)
    public void invalidCalculateHansonsMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        hansonsCalculatorTab.openHansonsTab();
        hansonsCalculatorTab.calculateHansonsMarathonPaceWithInvalidData();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Please fix the following errors:"));

    }

}
