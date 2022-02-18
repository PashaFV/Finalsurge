package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
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
    public static final By EXPAND_COLLAPSE_TABLE_POST_WORKOUT_NOTES = By.xpath("//h4[text()='Post Workout Notes & Results']");
    public static final By EXPAND_COLLAPSE_TABLE_EQUIPMENT = By.xpath("//h4[text()='Equipment']");
    public static final By EXPAND_COLLAPSE_TABLE_ROUTES = By.xpath("//h4[text()='Routes']");
    public static final By EXPAND_COLLAPSE_TABLE_WARM_UP_COOL_DOWN = By.xpath("//h4[text()='Warm-up & Cool-down']");
    public static final By EXPAND_COLLAPSE_TABLE_WEATHER = By.xpath("//h4[text()='Weather']");
    public static final By EXPAND_COLLAPSE_TABLE_HEART_RATE_ZONES = By.xpath("//h4[text()='Heart Rate Zones']");
    public static final By EXPAND_COLLAPSE_TABLE_PACE_ZONES = By.xpath("//h4[text()='Pace Zones']");
    String activitySubType = "//a[contains(@class, 'acc-in')]/../..//a[contains(text(), '%s')]";
    String howIFeltRadio = "//div[@class='ibutton-group']//span[text()='%s']";
////a[contains(@class, 'acc-in')]/../..//a[contains(text(), 'No Sub-Type')]

    public SelenideElement workoutUpdateHeader(){
        return $(WORKOUT_UPDATE_HEADER);
    }

    public void updateWorkout(Workout workout) {
        fillInUpdateWorkoutForm(workout);
        clickUpdateWorkoutButton();
    }

    private void fillInUpdateWorkoutForm(Workout workout) {
        expandAllTables();
        new Input("#WorkoutDate").write(workout.getDate());
        new Input("#WorkoutTime").write(workout.getTimeOfDay());
        new Input("#Name").write(workout.getWorkoutName());
        new Input("#Distance").write(workout.getDistance());
        new Input("#Duration").write(workout.getDuration());
        new Input("#Desc").write(workout.getWorkoutDescription());
        new Input("#PostDesc").write(workout.getDuration()); // post workout note results
        //new Input("#Pace").write(workout.getPace()); TODO добавить pace в WorkoutFactory
        //new Dropdown("#ActivityType").selectOption(workout.getActivityType());
        $(By.xpath(String.format(activitySubType, workout.getActivitySubType()))).click();
        $(By.xpath(String.format(howIFeltRadio, workout.getHowIFelt()))).click();
        new Dropdown("#DistType").selectOption(workout.getDistanceMeasure());
        new Dropdown("#PaceType").selectOption(workout.getPaceMeasure());
        new Dropdown("#PerEffort").selectOption(workout.getPerceivedEffort());
        $("#PlannedWorkout").setSelected(workout.isShowPlannedDistance());
        $("#SaveLibrary").setSelected(workout.isSaveToLibrary());
        $("#IsRace").setSelected(workout.isMarkAsRace());
    }

    private void expandAllTables() {
        $(EXPAND_COLLAPSE_TABLE_POST_WORKOUT_NOTES).click();
        $(EXPAND_COLLAPSE_TABLE_EQUIPMENT).click();
        $(EXPAND_COLLAPSE_TABLE_ROUTES).click();
        $(EXPAND_COLLAPSE_TABLE_WARM_UP_COOL_DOWN).click();
        $(EXPAND_COLLAPSE_TABLE_WEATHER).click();
        $(EXPAND_COLLAPSE_TABLE_HEART_RATE_ZONES).click();
        $(EXPAND_COLLAPSE_TABLE_PACE_ZONES).click();
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
        workout.setSaveToLibrary($("#SaveLibrary").isSelected());
        workout.setMarkAsRace($("#IsRace").isSelected());
        workout.setShowPlannedDistance($("#PlannedWorkout").isSelected());
        return workout;
    }

}