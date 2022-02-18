package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DefaultPage extends BasePage {

    public static final By DASHBOARD_BREADCRUMBS_BUTTON = By.xpath("//a[text()='Dashboard']");
    public static final By TRAINING_VOLUME_TITLE = By.xpath("//h4[text()='Training Volume']");
    public static final By PAST_DAYS_DROPDOWN = By.xpath("//select[@id='PastDays']");
    public static final By ACTIVITIES_DROPDOWN = By.xpath("//select[@id='ATF']");
    public static final By UPCOMING_WORKOUTS_TITLE = By.xpath("//div/h4[text()='Upcoming Workouts']");
    public static final By RECENT_PAST_WORKOUTS_TITLE = By.xpath("//div/h4[text()='Recent Past Workouts']");
    public static final By FIRST_DATA_IN_RECENT_PAST_WORKOUTS = By.xpath("//div[@data-label='past-workouts']/div/table/tbody/tr/td[@class='dont-break-out']");
    public static final By FIRST_DATA_IN_UPCOMING_WORKOUTS = By.xpath("//div[@data-label='future-workouts']/div/table/tbody/tr/td[@class='dont-break-out']");
    public static final By WORKOUT_REPORTS_BUTTON = By.xpath("//li[text()='Workout Reports']");


    @Step("Open page ")
    public void openPage() {
        open("/Default");

    }

    @Step("Go to workout from upcoming workout menu")
    public void openWorkoutFromUpcomingMenu() {

        $(UPCOMING_WORKOUTS_TITLE).click();
        $(FIRST_DATA_IN_RECENT_PAST_WORKOUTS).click();

    }
    @Step("Go to workout from past workout menu")
    public void openWorkoutFromPastMenu() {

        $(RECENT_PAST_WORKOUTS_TITLE).click();
        $(FIRST_DATA_IN_UPCOMING_WORKOUTS).click();

    }


}

