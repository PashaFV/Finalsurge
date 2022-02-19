package tests;

import com.codeborne.selenide.Condition;
import models.Workout;
import models.WorkoutFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

        Workout workoutForEditing = WorkoutFactory.get();
        workoutUpdatePage.updateWorkout(workoutForEditing);

        workoutDetailsPage.workoutDetailsHeader().shouldBe(visible);
        assertTrue(workoutDetailsPage.activityTypeField().getText().contains(workoutForEditing.getActivityType()));
        assertTrue(workoutDetailsPage.timeOfDayField().getText().contains(workoutForEditing.getTimeOfDay()));
        workoutDetailsPage.workoutNameField().shouldHave(text(workoutForEditing.getWorkoutName()));
        assertTrue(workoutDetailsPage.workoutDescField().getText().contains(workoutForEditing.getWorkoutDescription()));
        assertTrue(workoutDetailsPage.distanceStatisticsBlock(workoutForEditing).getText().contains(workoutForEditing.getDistance()));
        assertTrue(workoutDetailsPage.distanceStatisticsBlock(workoutForEditing).getText().contains(workoutForEditing.getDistanceMeasure()));
        assertTrue(workoutDetailsPage.distanceStatisticsBlock(workoutForEditing).getText().contains(workoutForEditing.getDuration()));
        assertTrue(workoutDetailsPage.paceStatisticsBlock(workoutForEditing).getText().contains(workoutForEditing.getPaceMeasure()));
        workoutDetailsPage.howIFeltField().shouldHave(text(workoutForEditing.getHowIFelt()));
        workoutDetailsPage.perceivedEffortField().shouldHave(text(workoutForEditing.getPerceivedEffort()));
    }

    @Test(description = "Run type workout should be updated")
    public void checkFieldsValuesOfCreatedWorkoutInUpdateForm(){
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
    }
}
