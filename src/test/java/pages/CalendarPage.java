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
    public static final By WORKOUT_MOVE_DATEPICKER_LAST_ELEMENT = By.xpath("//div[contains(@class, 'datepicker dropdown-menu') and contains(@style, 'block')]//td[contains(@class, 'day  active')]/../../tr[6]//td[7]");
    String chosenWorkout = "//div[@data-title='%s']";
    String workoutContextMenuItem = "//div[@data-title='%s']/../../ul//a[text()='%s']";
    String workoutDate = "//div[@data-title='%s']/../../../..";

    @Step("Open calendar page ")
    public void openPage() {
        log.info("Open /Calendar page");
        open("/Calendar");

    }
    @Step("Open QUICK ADD WORKOUT form")
    public void openQuickAddWorkoutForm() {
        log.info("Open QUICK ADD WORKOUT form");
        Actions action = new Actions(getWebDriver());
        action.moveToElement($(ADD_BUTTON)).click().build().perform();
        $(QUICK_ADD_LOCATOR).click();
    }

    @Step("Return user_info element")
    public SelenideElement userInfo(){
       return  $(USER_INFO);
    }

    @Step("Return workout add header")
    public SelenideElement workoutAddHeader(){
        return $(WORKOUT_ADD_HEADER);
    }

    @Step("Fill in Quick Add Workout Form")
    public void fillInQuickAddWorkoutForm(Workout workout){
        log.info("Fill in Quick Add Workout Form");
        new Input("#WorkoutDate").write(workout.getDate());
        new Input("#WorkoutTime").write(workout.getTimeOfDay());
        new Input("#Name").write(workout.getWorkoutName());
        new Input("#Distance").write(workout.getDistance());
        new Input("#Duration").write(workout.getDuration());
        new Input("#Desc").write(workout.getWorkoutDescription());
        new Input("#PostDesc").write(workout.getDuration());
        new Dropdown("#ActivityType").selectOption(workout.getActivityType());
        new Dropdown("#DistType").selectOption(workout.getDistanceMeasure());
        new Dropdown("#PaceType").selectOption(workout.getPaceMeasure());
        new Dropdown("#HowFeel").selectOption(workout.getHowIFelt());
        new Dropdown("#PerEffort").selectOption(workout.getPerceivedEffort());

        $("#PlannedWorkout").setSelected(workout.isShowPlannedDistance());
        $("#SaveLibrary").setSelected(workout.isSaveToLibrary());
        $("#IsRace").setSelected(workout.isMarkAsRace());
    }

    @Step("Clicking on Save workout button")
    public void clickSaveQuickAddWorkout(){
        log.info("Clicking on Save button");
        $("#saveButton").click();
        log.info("Save button was clicked");
    }

    @Step("Logout")
    public void logout() {
        log.info("Clicking on logout link");
        $(LOGOUT_LINK).click();
    }

    @Step("Create Quick Add Workout")
    public void createQuickAddWorkout(Workout workout) {
        fillInQuickAddWorkoutForm(workout);
        clickSaveQuickAddWorkout();
    }

    @Step("Return success Quick Add Workout To Library Text")
    public SelenideElement successQuickAddWorkoutToLibraryText() {
        return $(SUCCESS_QUICK_ADD_WORKOUT_TEXT);
    }

    @Step("Go to prev month in calendar")
    public void goToPrevMonth() {
        log.info("Clicking on previous month button");
        $(PREV_MONTH_BUTTON).click();
    }

    public SelenideElement chosenMonth() {
        return $(HEADER_MONTH_LINK);
    }

    @Step("Go to Update Form Of Created Workout")
    public void goToUpdateFormOfCreatedWorkout(String workoutName) {
        log.info("Call context menu of chosen workout");
        $(By.xpath(String.format(chosenWorkout, workoutName))).click();
        deleteCookiesForExpandCollapseTables();
        $(By.xpath(String.format(workoutContextMenuItem, workoutName, "Update Workout"))).click();
    }

    public SelenideElement createdWorkout(String workoutName){
        return $(By.xpath(String.format(chosenWorkout, workoutName)));
    }

    @Step("Go to Workout Comments PopUp")
    public void goToWorkoutCommentsPopUp(String workoutName){
        log.info("Call context menu of chosen workout");
        $(By.xpath(String.format(chosenWorkout, workoutName))).click();
        log.info("Click on Comments in context menu");
        $(By.xpath(String.format(workoutContextMenuItem, workoutName, "Comments"))).click();
        switchTo().frame($("#WorkoutCommentsiFrame"));
    }

    @Step("Go to Workout Upload Data PopUp")
    public void goToWorkoutUploadDataPopUp(String workoutName) {
        log.info("Call context menu of chosen workout");
        $(By.xpath(String.format(chosenWorkout, workoutName))).click();
        log.info("Click on Upload Data in context menu");
        $(By.xpath(String.format(workoutContextMenuItem, workoutName, "Upload Data"))).click();
        switchTo().frame($("#WorkoutUploadiFrame"));
    }

    @Step("Go to Workout Pain Injury Report PopUp")
    public void goToWorkoutPainInjuryReportPopUp(String workoutName) {
        log.info("Call context menu of chosen workout");
        $(By.xpath(String.format(chosenWorkout, workoutName))).click();
        log.info("Click on Pain & Injury in context menu");
        $(By.xpath(String.format(workoutContextMenuItem, workoutName, "Pain & Injury"))).click();
        switchTo().frame($("#PainInjuryFrame"));
    }

    @Step("Move Workout Element To The Other Date")
    public String moveWorkoutElementToTheOtherDate(String workoutName){
        log.info("Call context menu of chosen workout");
        $(By.xpath(String.format(chosenWorkout, workoutName))).click();
        log.info("Click on Move in context menu");
        $(By.xpath(String.format(workoutContextMenuItem, workoutName, "Move"))).click();
        String movingDate = $(WORKOUT_MOVE_DATEPICKER_LAST_ELEMENT).getText();
        $(WORKOUT_MOVE_DATEPICKER_LAST_ELEMENT).click();
        return movingDate;
    }

    public SelenideElement workoutDate(String workoutName){
        return $(By.xpath(String.format(workoutDate, workoutName)));
    }
}