package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class WorkoutReportTest extends BaseTest {

    @Test(description = "View report", priority = 1)
    public void viewReportTest() {

        loginPage.openPage();
        loginPage.login();
        workoutReportPage.openPage();
        workoutReportPage.reportFiltersTitle().shouldBe(visible);
        workoutReportPage.viewReport();
        workoutReportPage.reportTableTitle().shouldHave(text("Athlete Workout Report"));

    }

    @Test(description = "View empty report", priority = 2)
    public void viewEmptyReportTest() {

        loginPage.openPage();
        loginPage.login();
        workoutReportPage.openPage();
        workoutReportPage.reportFiltersTitle().shouldBe(visible);
        workoutReportPage.viewEmptyReport();
        workoutReportPage.emptyReportTitle().shouldHave(text("There are no workout results for the selected filters."));

    }

    @Test(description = "Add comment to workout from report", priority = 3)
    public void addCommentToWorkoutTest() {

        loginPage.openPage();
        loginPage.login();
        workoutReportPage.openPage();
        workoutReportPage.reportFiltersTitle().shouldBe(visible);
        workoutReportPage.addCommentsToWorkout();
        workoutReportPage.textValueInComments().shouldHave(text("test comment"));

    }

}
