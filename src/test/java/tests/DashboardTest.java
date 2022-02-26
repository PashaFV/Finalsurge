package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class DashboardTest extends BaseTest {

    @Test(description = "Go to workout from upcoming workout menu")
    public void goToWorkoutFromUpcomingMenuTest() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.trainingVolumeGraphic().shouldBe(visible);
        defaultPage.openWorkoutFromUpcomingMenu();
        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);

    }

    @Test(description = "Go to workout from upcoming workout menu")
    public void goToWorkoutFromPastMenuTest() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.trainingVolumeGraphic().shouldBe(visible);
        defaultPage.openWorkoutFromPastMenu();
        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);

    }

    @Test(description = "Go to workout reports from dashboard")
    public void goToWorkoutReportsFromDashboard() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.trainingVolumeGraphic().shouldBe(visible);
        defaultPage.openWorkoutReportsFromDashboard();
        workoutReportPage.reportFiltersTitle().shouldBe(visible);

    }

    @Test(description = "Go to calendar from dashboard")
    public void goToCalendarFromDashboard() {

        loginPage.openPage();
        loginPage.login();
        defaultPage.openPage();
        defaultPage.trainingVolumeGraphic().shouldBe(visible);
        defaultPage.openCalendarFromDashboard();
        calendarPage.chosenMonth().shouldBe(visible);

    }

}


