package pages;

import org.openqa.selenium.By;

public class WorkoutReportPage extends BasePage{

    public static final By ACTIVITY_TYPE_DROPDOWN = By.xpath("//select[@id='ActivityType']");
    public static final By REPORT_VIEW_RADIO_BUTTONS = By.xpath("//label[@class='radio inline']");
    //select radio $(By.name("user.gender")).selectRadio("male");
    public static final By START_DATE_INPUT = By.xpath("//input[@id='WorkoutDate']");
    public static final By END_DATE_INPUT = By.xpath("//input[@id='WorkoutDateEnd']");
    public static final By VIEW_REPORT_BUTTON = By.xpath("//input[@id='saveButton']");
    public static final By TABLE_REPORT_TITLE = By.xpath("//div[@class='w-box w-box-blue']/div[@class='w-box-header']");
    public static final By REPORT_FILTERS_TITLE = By.xpath("//div[@class='w-box-header']/h4[text()='Report Filters']");

}


