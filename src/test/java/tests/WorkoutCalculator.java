package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class WorkoutCalculator extends BaseTest {

    @Test(description = "Calculation your running intensity")
    public void сalculateRunningIntensityTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.calculateRunningIntensity();
        workoutCalculatorPopUp.yourWorkoutPacesHeader().shouldBe(visible);

    }
    @Test(description = "Calculation Hansons method pace")
    public void сalculateHansonsMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.calculateHansonsMarathonPace();
        workoutCalculatorPopUp.yourWorkoutPacesHeader().shouldBe(visible);

    }

    @Test(description = "Calculation McMillan method pace")
    public void сalculateMcMillanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.calculateMcMillanRunning();
        workoutCalculatorPopUp.reCalculatePacesButton().shouldBe(visible);

    }

    @Test(description = "Calculation Tinman method pace")
    public void сalculateTinmanMethodTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.calculateTinmanRunning();
        workoutCalculatorPopUp.raceInformationHeader().shouldBe(visible);

    }

}
