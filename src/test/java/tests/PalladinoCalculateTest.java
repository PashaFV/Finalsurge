package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class PalladinoCalculateTest extends BaseTest {

    @Test(description = "Calculation Palladino method pace")
    public void сalculatePalladinoMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        palladinoCalculatorTab.calculatePalladinoPower();
        palladinoCalculatorTab.checkingOpenPowerTargetHeader().shouldBe(visible);

    }

    @Test(description = "Calculation Palladino method pace with invalid data")
    public void invalidCalculatePalladinoMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        palladinoCalculatorTab.invalidCalculatePalladinoPower();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Please fix the following errors:"));

    }


}
