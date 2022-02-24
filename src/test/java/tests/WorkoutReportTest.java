package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class WorkoutReportTest extends BaseTest {

    @Test(description = "View")
    public void viewReportTest() {

        loginPage.openPage();
        loginPage.login();
        workoutReportPage.openPage();
        workoutReportPage.viewReport();
        workoutReportPage.reportTableTitle().shouldHave(text("Athlete Workout Report"));

    }

}
