package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class TinmanCalculateTest extends BaseTest {

    @Test(description = "Calculation Tinman method pace")
    public void сalculateTinmanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        tinmanCalculatorTab.calculateTinmanRunning();

    }

    @Test(description = "Calculation Tinman method pace with invalid data")
    public void invalidCalculateTinmanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        tinmanCalculatorTab.calculateTinmanRunning();
        //add checking
    }

}
