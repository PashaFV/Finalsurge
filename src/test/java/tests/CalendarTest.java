package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import models.Workout;
import models.WorkoutFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CalendarPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CalendarTest extends BaseTest {

    @Test(description = "Login with valid data to finalsurge.com")
    public void quickAddWorkoutTest() {

        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.openQuickAddWorkoutForm();
        calendarPage.workoutAddHeader().shouldBe(visible);

        Workout workout = WorkoutFactory.get();
        calendarPage.createQuickAddWorkout(workout);

        calendarPage.createdWorkout(workout.getWorkoutName()).shouldHave(attribute("data-title", workout.getWorkoutName()));
    }

    @Test(description = "Check if a quick added workout is saved to the workout library")
    public void quickAddedWorkoutShouldHaveSavedToLibrary() {

        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.openQuickAddWorkoutForm();
        calendarPage.workoutAddHeader().shouldBe(visible);

        Workout workout = WorkoutFactory.get();
        workout.setSaveToLibrary(true);
        calendarPage.createQuickAddWorkout(workout);

        calendarPage.successQuickAddWorkoutToLibraryText().shouldHave(text("*The workout was successfully saved to your Workout Library"));

        workoutLibraryPage.openPage();

        workoutLibraryPage.createdWorkoutLibraryName(workout).shouldHave(text(workout.getWorkoutName()));
        workoutLibraryPage.createdWorkoutLibraryDesc(workout).shouldHave(text(workout.getWorkoutDescription()));
    }

    @Test(description = "Check if a month is changed in the calendar")
    public void monthShouldBeChangedInCalendar(){
        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        String originalHeaderDateName = calendarPage.chosenMonth().getText();
        calendarPage.goToPrevMonth();
        calendarPage.chosenMonth().shouldNotHave(text(originalHeaderDateName));
    }
}
