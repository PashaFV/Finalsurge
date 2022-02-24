package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class WorkoutReportPage extends BasePage{

    public static final By ACTIVITY_TYPE_DROPDOWN = By.xpath("//select[@id='ActivityType']");
    public static final By REPORT_VIEW_RADIO_BUTTONS = By.xpath("//label[@class='radio inline']");
    //select radio $(By.name("user.gender")).selectRadio("male");
    public static final By START_DATE_INPUT = By.xpath("//input[@id='WorkoutDate']");
    public static final By END_DATE_INPUT = By.xpath("//input[@id='WorkoutDateEnd']");
    public static final By VIEW_REPORT_BUTTON = By.xpath("//input[@id='saveButton']");
    public static final By TABLE_REPORT_TITLE = By.xpath("//div[@class='w-box w-box-blue']/div[@class='w-box-header']/h4");
    public static final By REPORT_FILTERS_TITLE = By.xpath("//div[@class='w-box-header']/h4[text()='Report Filters']");
    public static final By ADD_COMMENTS_BUTTON = By.xpath("//i[@class='icsw16-create-write ptip_s'][1]");

    public static final By WORKOUT_COMMENTS_TEXTAREA = By.xpath("//textarea[@id='CommentDesc']");
    public static final By ADD_COMMENT_BUTTON = By.xpath("//input[@id='saveButtonComment']");


    @Step("Open page ")
    public void openPage() {
        log.info("Go to workout report page");
        open("/WorkoutReport");

    }

    @Step("View report with activity type - Hills")
    public void viewReport() {
        log.info("View report with activity type - Hills");
        new Input("#WorkoutDate").write("2/10/2022");
        new Input("#WorkoutDateEnd").write("2/24/2022");
        new Dropdown("#ActivityType").selectOption("Hills");
        new RadioButton("#groupBy1").click();

    }
    @Step("Add comments to workout from report")
    public void addCommentsToWorkout() {
        log.info("Add comments to workout from report");
        new Input("#WorkoutDate").write("2/10/2022");
        new Input("#WorkoutDateEnd").write("2/24/2022");
        new Dropdown("#ActivityType").selectOption("Hills");
        new RadioButton("#groupBy1").click();
        $(ADD_COMMENTS_BUTTON).click();
        switchTo().frame($("[id='WorkoutCommentsiFrame']"));
        $(WORKOUT_COMMENTS_TEXTAREA).setValue("test comment");
        $(ADD_COMMENT_BUTTON).click();

    }


    public SelenideElement reportFiltersTitle() {
        return $(REPORT_FILTERS_TITLE);
    }

    public SelenideElement reportTableTitle() {return $(TABLE_REPORT_TITLE);}
}


