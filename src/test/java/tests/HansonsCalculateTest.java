package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class HansonsCalculateTest extends BaseTest {

    @Test(description = "Calculation Hansons method pace")
    public void сalculateHansonsMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        hansonsCalculatorTab.calculateHansonsMarathonPace();
        hansonsCalculatorTab.checkingOpenRaceInfoHeader().shouldBe(visible);

    }

    @Test(description = "Calculation Hansons method pace")
    public void invalidCalculateHansonsMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        hansonsCalculatorTab.calculateHansonsMarathonPaceWithInvalidData();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Please fix the following errors:"));

    }

}
