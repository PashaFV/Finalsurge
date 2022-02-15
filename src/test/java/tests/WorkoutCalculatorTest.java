package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class WorkoutCalculatorTest extends BaseTest {

    @Test(description = "Open workout calculator pop-up")
    public void openWorkoutCalculatorTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);

    }

    @Test(description = "Close workout calculator pop-up")
    public void closeWorkoutCalculatorTest() {

        loginPage.openPage();
        loginPage.login();
        workoutCalculatorPopUp.openCalculatorPopUp();
        workoutCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        workoutCalculatorPopUp.closeCalculatorPopUp();
        workoutCalculatorPopUp.headerLogo().shouldBe(visible);


    }

}
