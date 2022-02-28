package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.*;

public class McMillanCalculateTest extends BaseTest {

    @Test(description = "Calculation McMillan method pace", priority = 1)
    public void сalculateMcMillanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        mcMillanCalculatorTab.openMcMillanTab();
        mcMillanCalculatorTab.calculateMcMillanRunning();
        mcMillanCalculatorTab.reCalculateButton().shouldBe(visible);
        mcMillanCalculatorTab.recoveryJogsValue().shouldHave(text("3:15 - 3:15"));

    }

    @Test(description = "Calculation McMillan method pace with invalid data", priority = 2)
    public void invalidCalculateMcMillanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        mcMillanCalculatorTab.openMcMillanTab();
        mcMillanCalculatorTab.invalidCalculateMcMillanRunning();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Please select a Recent Race Distance."));

    }

    @Test(description = " Re calculation McMillan method pace after success", priority = 3)
    public void reCalculateMcMillanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        mcMillanCalculatorTab.openMcMillanTab();
        mcMillanCalculatorTab.reCalculateMcMillanRunning();
        mcMillanCalculatorTab.reCalculateDropdownValue().shouldHave(value("10Km"));


    }
}
