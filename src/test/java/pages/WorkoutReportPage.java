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


    public static final By TABLE_REPORT_TITLE = By.xpath("//div[@class='w-box w-box-blue']/div[@class='w-box-header']/h4");
    public static final By REPORT_FILTERS_TITLE = By.xpath("//div[@class='w-box-header']/h4[text()='Report Filters']");
    public static final By ADD_COMMENTS_BUTTON = By.xpath("//i[@class='icsw16-create-write ptip_s'][1]");
    public static final By TEXT_VALUE_IN_COMMENTS = By.xpath("//div[@class='ch-content']");
    public static final By VIEW_REPORT_BUTTON = By.xpath("//input[@id='saveButton']");

    public static final By WORKOUT_COMMENTS_TEXTAREA = By.xpath("//textarea[@id='CommentDesc']");
    public static final By ADD_COMMENT_BUTTON = By.xpath("//input[@id='saveButtonComment']");
    public static final By EMPTY_REPORT_TITLE = By.xpath("//div[@class='w-box-content']/p");


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
        $(VIEW_REPORT_BUTTON).click();

    }

    @Step("View empty report with activity type - Hills")
    public void viewEmptyReport() {
        log.info("View report with activity type - Hills");
        new Input("#WorkoutDate").write("1/01/2022");
        new Input("#WorkoutDateEnd").write("1/07/2022");
        new Dropdown("#ActivityType").selectOption("Hills");
        new RadioButton("#groupBy1").click();
        $(VIEW_REPORT_BUTTON).click();

    }

    @Step("Add comments to workout from report")
    public void addCommentsToWorkout() {
        log.info("Add comments to workout from report");
        new Input("#WorkoutDate").write("2/10/2022");
        new Input("#WorkoutDateEnd").write("2/24/2022");
        new Dropdown("#ActivityType").selectOption("Hills");
        new RadioButton("#groupBy1").click();
        $(VIEW_REPORT_BUTTON).click();
        $(ADD_COMMENTS_BUTTON).click();
        switchTo().frame($("[id='WorkoutCommentsiFrame']"));
        $(WORKOUT_COMMENTS_TEXTAREA).setValue("test comment");
        $(ADD_COMMENT_BUTTON).click();

    }


    public SelenideElement reportFiltersTitle() {
        return $(REPORT_FILTERS_TITLE);
    }

    public SelenideElement reportTableTitle() {return $(TABLE_REPORT_TITLE);}

    public SelenideElement emptyReportTitle() {return $(EMPTY_REPORT_TITLE);}

    public SelenideElement textValueInComments() {return $(TEXT_VALUE_IN_COMMENTS);}

}


