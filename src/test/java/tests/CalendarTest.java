package tests;

import models.Workout;
import models.WorkoutFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CalendarPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CalendarTest extends BaseTest {

    @Test(description = "Login with valid data to finalsurge.com")
    public void AddWorkoutTest() {

        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.addNewQuickWorkout();
        calendarPage.workoutAddHeader().shouldBe(visible);
        Workout workout = WorkoutFactory.get();
        calendarPage.create(workout);
    }

}
