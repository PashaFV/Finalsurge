package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class McMillanCalculateTest extends BaseTest {

    @Test(description = "Calculation McMillan method pace")
    public void сalculateMcMillanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        mcMillanCalculatorTab.calculateMcMillanRunning();
        mcMillanCalculatorTab.checkingVisibleReCalculateButton().shouldBe(visible);

    }

    @Test(description = "Calculation McMillan method pace with invalid data")
    public void invalidCalculateMcMillanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        mcMillanCalculatorTab.invalidCalculateMcMillanRunning();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Please fix the following errors:"));

    }

}
