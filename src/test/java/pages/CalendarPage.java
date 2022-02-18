package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@Log4j2
public class CalendarPage extends BasePage{

    public static final By ADD_BUTTON = By.xpath("//i[@class='icon-plus']");
    public static final By QUICK_ADD_LOCATOR = By.xpath("//a[@class='quick-add']");
    public static final By USER_INFO = By.xpath("//div[@class='user-info']");
    public static final By WORKOUT_ADD_HEADER = By.xpath("//h4[@id='WorkoutAddHeader']");
    public static final By LOGOUT_LINK = By.xpath("//div[@class='user-info']//a[text()='Logout']");
    public static final By SUCCESS_QUICK_ADD_WORKOUT_TEXT = By.xpath("//div[@class='alert alert-success']");
    public static final String HEADER_MONTH_LINK = "#dpMonth";
    public static final By PREV_MONTH_BUTTON = By.xpath("//i[contains(@class,'icon-chevron-left')]");
    public static final By CALENDAR_WORKOUT_CHIP_NAME = By.xpath("//div[@data-title]");
    String chosenWorkout = "//div[@data-title='%s']";
    String workoutContextMenuItem = "//div[@data-title='%s']/../../ul//a[text()='%s']";

    @Step("Open calendar page ")
    public void openPage() {
        open("/Calendar");

    }
    @Step("Add new quick workout")
    public void openQuickAddWorkoutForm() {
        Actions action = new Actions(getWebDriver());
        action.moveToElement($(ADD_BUTTON)).click().build().perform();
//        $(ADD_BUTTON).click();
        $(QUICK_ADD_LOCATOR).click();

    }

    public SelenideElement userInfo(){
       return  $(USER_INFO);
    }

    public SelenideElement workoutAddHeader(){
        return $(WORKOUT_ADD_HEADER);
    }

    public void fillInQuickAddWorkoutForm(Workout workout){

        new Input("#WorkoutDate").write(workout.getDate());
        new Input("#WorkoutTime").write(workout.getTimeOfDay());
        new Input("#Name").write(workout.getWorkoutName());
        new Input("#Distance").write(workout.getDistance());
        new Input("#Duration").write(workout.getDuration());
        new Input("#Desc").write(workout.getWorkoutDescription());
        new Input("#PostDesc").write(workout.getDuration());
        //new Input("#Pace").write(workout.getPace()); TODO добавить pace в WorkoutFactory
        new Dropdown("#ActivityType").selectOption(workout.getActivityType());
        new Dropdown("#DistType").selectOption(workout.getDistanceMeasure());
        new Dropdown("#PaceType").selectOption(workout.getPaceMeasure());
        new Dropdown("#HowFeel").selectOption(workout.getHowIFelt());
        new Dropdown("#PerEffort").selectOption(workout.getPerceivedEffort());

        $("#PlannedWorkout").setSelected(workout.isShowPlannedDistance());
        $("#SaveLibrary").setSelected(workout.isSaveToLibrary());
        $("#IsRace").setSelected(workout.isMarkAsRace());
    }

    public void clickSaveQuickAddWorkout(){
        log.info("Clicking on Save button");
        $("#saveButton").click();
        log.info("Save button was clicked");
    }

    public void logout() {
        $(LOGOUT_LINK).click();
    }

    public void createQuickAddWorkout(Workout workout) {
        fillInQuickAddWorkoutForm(workout);
        clickSaveQuickAddWorkout();
    }

    public SelenideElement successQuickAddWorkoutToLibraryText() {
        return $(SUCCESS_QUICK_ADD_WORKOUT_TEXT);
    }

    public void goToPrevMonth() {
        $(PREV_MONTH_BUTTON).click();
    }

    public SelenideElement chosenMonth() {
        return $(HEADER_MONTH_LINK);
    }

    public void goToUpdateFormOfCreatedWorkout(String workoutName) {
        $(By.xpath(String.format(chosenWorkout, workoutName))).click();
        deleteCookiesForExpandCollapseTables();
        $(By.xpath(String.format(workoutContextMenuItem, workoutName, "Update Workout"))).click();
    }

    public SelenideElement createdWorkout(String workoutName){
        return $(By.xpath(String.format(chosenWorkout, workoutName)));
    }
}