package tests;

import models.Workout;
import models.WorkoutFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

public class WorkoutItemTest extends BaseTest {

    @Test(description = "Run type workout should be updated")
    public void updateRunTypeWorkout(){
        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.openQuickAddWorkoutForm();
        calendarPage.workoutAddHeader().shouldBe(visible);

        Workout workout = WorkoutFactory.get();
        calendarPage.createQuickAddWorkout(workout);
        calendarPage.goToUpdateFormOfCreatedWorkout(workout.getWorkoutName());

        workoutUpdatePage.workoutUpdateHeader().shouldBe(visible);
        Workout workoutFromUpdateForm = workoutUpdatePage.readFieldValuesFromUpdateWorkoutForm();

        assertEquals(workoutFromUpdateForm.getWorkoutName(), workout.getWorkoutName());
        assertEquals(workoutFromUpdateForm.getWorkoutDescription(), workout.getWorkoutDescription());
        assertEquals(workoutFromUpdateForm.getDate(), workout.getDate());
        assertEquals(workoutFromUpdateForm.getActivityType(), workout.getActivityType());
        assertEquals(workoutFromUpdateForm.getTimeOfDay(), workout.getTimeOfDay());
        assertEquals(workoutFromUpdateForm.getDistance(), workout.getDistance());
        assertEquals(workoutFromUpdateForm.getDuration(), workout.getDuration());
        assertEquals(workoutFromUpdateForm.getDistanceMeasure(), workout.getDistanceMeasure());
        assertEquals(workoutFromUpdateForm.getPaceMeasure(), workout.getPaceMeasure());
        assertEquals(workoutFromUpdateForm.getHowIFelt(), workout.getHowIFelt());
        assertEquals(workoutFromUpdateForm.getPerceivedEffort(), workout.getPerceivedEffort());

        workoutUpdatePage.updateWorkout();
        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);
    }
}
