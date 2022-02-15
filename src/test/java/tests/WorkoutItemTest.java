package tests;

import models.Workout;
import models.WorkoutFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class WorkoutItemTest extends BaseTest {

    @Test(description = "Check if a month is changed in the calendar")
    public void updateWorkoutWithChoosingRunType(){
        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.openQuickAddWorkoutForm();
        calendarPage.workoutAddHeader().shouldBe(visible);

        Workout workout = WorkoutFactory.get();
        calendarPage.createQuickAddWorkout(workout);

        calendarPage.goToUpdateFormOfCreatedWorkout(workout.getWorkoutName());

        workoutUpdatePage.workoutUpdateHeader().shouldBe(visible);
        workoutUpdatePage.updateWorkout();
        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);
    }
}
