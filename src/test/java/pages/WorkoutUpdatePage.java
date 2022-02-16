package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class WorkoutUpdatePage extends BasePage{

    public static final By WORKOUT_UPDATE_HEADER = By.xpath("//h4[text()='Update Workout']");
    public static final By SELECTED_ACTIVITY_TYPE_ACCORDION = By.xpath("//a[contains(@class, 'acc-in')]");
    public static final By CHECKED_HOW_I_FELT_RADIO = By.xpath("//div[@class='ibutton-group']//input[@checked]/../span");

    public SelenideElement workoutUpdateHeader(){
        return $(WORKOUT_UPDATE_HEADER);
    }

    public void updateWorkout() {
        fillInUpdateWorkoutForm();
        clickUpdateWorkoutButton();
    }

    private void fillInUpdateWorkoutForm() {

    }

    public void clickUpdateWorkoutButton(){
        log.info("Clicking on Update Workout button");
        $("#saveButton").click();
        log.info("Update Workout button was clicked");
    }

    public Workout readFieldValuesFromUpdateWorkoutForm(){
        Workout workout = Workout.builder().build();
        workout.setDate(new Input("#WorkoutDate").read());
        workout.setTimeOfDay(new Input("#WorkoutTime").read());
        workout.setWorkoutName(new Input("#Name").read());
        workout.setDistance(new Input("#Distance").read());
        workout.setDuration(new Input("#Duration").read());
        workout.setWorkoutDescription(new Input("#Desc").read());
        workout.setActivityType($(SELECTED_ACTIVITY_TYPE_ACCORDION).getText());
        workout.setDistanceMeasure(new Dropdown("#DistType").getOption());
        workout.setPaceMeasure(new Dropdown("#PaceType").getOption());
        workout.setHowIFelt($(CHECKED_HOW_I_FELT_RADIO).getText());
        workout.setPerceivedEffort(new Dropdown("#PerEffort").getOption());
        return workout;
    }

}