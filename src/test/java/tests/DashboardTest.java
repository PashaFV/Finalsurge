package tests;

import models.Workout;
import models.WorkoutFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DashboardTest extends BaseTest {

    @Test(description = "Go to workout from upcoming workout menu test")
    public void GoToWorkoutFromUpcomingMenuTest() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.openWorkoutFromUpcomingMenu();
        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);

    }
    @Test(description = "Go to workout from upcoming workout menu test")
    public void GoToWorkoutFromPastMenuTest() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.openWorkoutFromPastMenu();
        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);

    }
}


