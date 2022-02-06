package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Input;
import io.qameta.allure.Step;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CalendarPage extends BasePage{

    public static final By ADD_BUTTON = By.xpath("//i[@class='icon-plus']");
    public static final By QUICK_ADD_LOCATOR = By.xpath("//a[@class='quick-add']");
    public static final By USER_INFO = By.xpath("//div[@class='user-info']");
    public static final By WORKOUT_ADD_HEADER = By.xpath("//h4[@id='WorkoutAddHeader']");
    public static final By LOGOUT_LINK = By.xpath("//div[@class='user-info']//a[text()='Logout']");


    @Step("Open calendar page ")
    public void openPage() {
        open("/calendar");

    }
    @Step("Add new quick workout")
    public void addNewQuickWorkout() {
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

    public void create(Workout workout){

        new Input("#WorkoutDate").write(workout.getDate());
        new Input("#WorkoutTime").write(workout.getTimeOfDay());
        new Input("#Name").write(workout.getWorkoutName());
        new Input("#Distance").write(workout.getDistance());
        new Input("#Duration").write(workout.getDuration());
        //new Input("#Pace").write(workout.getPace()); TODO добавить pace в WorkoutFactory


    }


    public void logout() {
        $(LOGOUT_LINK).click();
    }
}
