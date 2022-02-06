package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

        $(ADD_BUTTON).click();
        $(QUICK_ADD_LOCATOR).click();

    }

    public SelenideElement userInfo(){
       return  $(USER_INFO);
    }

    public SelenideElement workoutAddHeader(){
        return $(WORKOUT_ADD_HEADER);
    }


    public void logout() {
        $(LOGOUT_LINK).click();
    }
}
