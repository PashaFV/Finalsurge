package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class IntensityCalculateTest extends BaseTest {

    @Test(description = "Calculation your running intensity", priority = 1)
    public void сalculateRunningIntensityTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        intensityCalculatorTab.calculateRunningIntensity();
        intensityCalculatorTab.checkingOpenWorkoutPacesHeader().shouldBe(visible);
        intensityCalculatorTab.marathonPacesInTable().shouldHave(text("10:47 /mi"));

    }

    @Test(description = "Calculation your running intensity with invalid data", priority = 2)
    public void invalidCalculateRunningIntensityTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        intensityCalculatorTab.calculateRunningIntensityWithInvalidData();
        workoutCalculatorPopUp.getErrorMessage().shouldHave(text("Your Marathon time cannot be less than 2:01:10 in order to use this calculator."));

    }

}
