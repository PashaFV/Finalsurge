package tests;

import lombok.extern.log4j.Log4j2;
import models.Workout;
import models.WorkoutFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class DashboardTest extends BaseTest {

    @Test(description = "Go to workout from upcoming workout menu test")
    public void GoToWorkoutFromUpcomingMenuTest() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.trainingVolumeGraphic().shouldBe(visible);
        defaultPage.openWorkoutFromUpcomingMenu();
        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);

    }
    @Test(description = "Go to workout from upcoming workout menu test")
    public void GoToWorkoutFromPastMenuTest() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.trainingVolumeGraphic().shouldBe(visible);
        defaultPage.openWorkoutFromPastMenu();
        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);

    }

    @Test(description = "Go to workout reports from default page test")
    public void GoToWorkoutReportsFromDashboard() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.trainingVolumeGraphic().shouldBe(visible);
        defaultPage.openWorkoutReportsFromDashboard();
        workoutReportPage.reportFiltersTitle().shouldBe(visible);

    }

}


