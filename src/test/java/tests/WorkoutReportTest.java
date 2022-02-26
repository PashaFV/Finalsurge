package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class WorkoutReportTest extends BaseTest {

    @Test(description = "View report")
    public void viewReportTest() {

        loginPage.openPage();
        loginPage.login();
        workoutReportPage.openPage();
        workoutReportPage.reportFiltersTitle().shouldBe(visible);
        workoutReportPage.viewReport();
        workoutReportPage.reportTableTitle().shouldHave(text("Athlete Workout Report"));

    }

    @Test(description = "Add comment to workout from report")
    public void addCommentToWorkoutTest() {

        loginPage.openPage();
        loginPage.login();
        workoutReportPage.openPage();
        workoutReportPage.reportFiltersTitle().shouldBe(visible);
        workoutReportPage.addCommentsToWorkout();
        workoutReportPage.textValueInComments().shouldHave(text("test comment"));

    }

}
