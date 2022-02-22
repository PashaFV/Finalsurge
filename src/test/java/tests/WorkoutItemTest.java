package tests;

import com.codeborne.selenide.Condition;
import models.Injury;
import models.InjuryFactory;
import models.Workout;
import models.WorkoutFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
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
        workoutDetailsPage.activityTypeField().shouldHave(text(workoutForEditing.getActivityType()));
        workoutDetailsPage.timeOfDayField().shouldHave(text(workoutForEditing.getTimeOfDay()));
        workoutDetailsPage.workoutNameField().shouldHave(text(workoutForEditing.getWorkoutName()));
        workoutDetailsPage.workoutDescField().shouldHave(text(workoutForEditing.getWorkoutDescription()));
        workoutDetailsPage.distanceStatisticsBlock(workoutForEditing).shouldHave((text(workoutForEditing.getDistance())));
        workoutDetailsPage.distanceStatisticsBlock(workoutForEditing).shouldHave((text(workoutForEditing.getDistanceMeasure())));
        workoutDetailsPage.distanceStatisticsBlock(workoutForEditing).shouldHave((text(workoutForEditing.getDuration())));
        workoutDetailsPage.paceStatisticsBlock(workoutForEditing).shouldHave(text(workoutForEditing.getPaceMeasure()));
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


    @Test(description = "Check if a comment is added to the workout")
    public void workoutCommentShouldBeAdded(){
        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.openQuickAddWorkoutForm();
        calendarPage.workoutAddHeader().shouldBe(visible);

        Workout workout = WorkoutFactory.get();
        calendarPage.createQuickAddWorkout(workout);
        calendarPage.goToWorkoutCommentsPopUp(workout.getWorkoutName());
        workoutCommentsPopUp.addComment(workout.getWorkoutComment());
        workoutCommentsPopUp.createdComment().shouldHave(text(workout.getWorkoutComment()));
    }

    @Test(description = "Check if a file is uploaded to the workout item")
    public void fileShouldBeUploaded(){
        File file = new File("src/test/resources/example.tcx");
        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.openQuickAddWorkoutForm();
        calendarPage.workoutAddHeader().shouldBe(visible);

        Workout workout = WorkoutFactory.get();
        calendarPage.createQuickAddWorkout(workout);
        calendarPage.goToWorkoutUploadDataPopUp(workout.getWorkoutName());
        workoutUploadDataPopUp.uploadFile(file);
        workoutDetailsPage.downloadFileButton().shouldBe(visible);
    }

    @Test(description = "Check if a workout pain & injury report is added to the workout item")
    public void workoutPainInjuryReportShouldBeAdded(){
        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.openQuickAddWorkoutForm();
        calendarPage.workoutAddHeader().shouldBe(visible);

        Workout workout = WorkoutFactory.get();
        Injury injury = InjuryFactory.get();
        calendarPage.createQuickAddWorkout(workout);
        calendarPage.goToWorkoutPainInjuryReportPopUp(workout.getWorkoutName());
        injury = workoutInjuryReportPopUp.addFrontReport(injury);

        workoutInjuryReportPopUp.painMapDot(injury.getBodyDot()).shouldHave(attributeMatching("data-original-title",".+" + injury.getWithPainLevelConnectedText() + ".+"));
        workoutInjuryReportPopUp.painMapDot(injury.getBodyDot()).shouldHave(attributeMatching("data-original-title",".+" + injury.getWithPainTrendConnectedText()  + ".+"));
        //workoutInjuryReportPopUp.painMapDot(injury.getBodyDot()).shouldHave(attributeMatching("data-original-title",".+" + injury.()  + ".+"));
        //workoutInjuryReportPopUp.painMapDot(injury.getBodyDot()).shouldHave(attributeMatching("data-original-title",".+" + injury.()  + ".+"));
    }

}
