package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class TinmanCalculateTest extends BaseTest {

    @Test(description = "Calculation Tinman method pace", priority = 1)
    public void сalculateTinmanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        tinmanCalculatorTab.openTinmanTab();
        tinmanCalculatorTab.calculateTinmanRunning();
        tinmanCalculatorTab.checkingOpenRaceInformationHeader().shouldBe(visible);
        tinmanCalculatorTab.ratingValueInTable().shouldHave(text("57.1%"));

    }

    @Test(description = "Calculation Tinman method pace with invalid data", priority = 2)
    public void invalidCalculateTinmanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        tinmanCalculatorTab.openTinmanTab();
        tinmanCalculatorTab.invalidCalculateTinmanRunning();
        tinmanCalculatorTab.checkingOpenRaceInformationHeader().shouldBe(visible);
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Please select a Race Distance."));
        //Not a bug but a feature
    }

}
