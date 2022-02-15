package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class IntensityCalculateTest extends BaseTest {

    @Test(description = "Calculation your running intensity")
    public void сalculateRunningIntensityTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        intensityCalculatorTab.calculateRunningIntensity();
        intensityCalculatorTab.checkingOpenWorkoutPacesHeader().shouldBe(visible);

    }

    @Test(description = "Calculation your running intensity with invalid data")
    public void invalidCalculateRunningIntensityTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        intensityCalculatorTab.calculateRunningIntensityWithInvalidData();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Please fix the following errors:"));

    }

}
