package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class WorkoutCalculator extends BaseTest {

    @Test(description = "Calculation your running intensity")
    public void calculation() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.calculateRunningIntensity();
        workoutCalculatorPopUp.yourWorkoutPacesHeader().shouldBe(visible);

    }

}
