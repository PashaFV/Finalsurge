package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class McMillanCalculatorTab {

    public static final By HOURS_INPUT = By.xpath("//input[@id='TimeHH']");
    public static final By MINUTES_INPUT = By.xpath("//input[@id='TimeMM']");
    public static final By SECONDS_INPUT = By.xpath("//input[@id='TimeSS']");
    public static final By RACE_DIST_DROPDOWN = By.xpath("//select[@name='distance']");
    public static final By MCMILLAN_TITLE_BUTTON = By.xpath("//a[text()='McMillan']");
    public static final By GOAL_DIST_DROPDOWN = By.xpath("//select[@name='goaldistance']");
    public static final By GOAL_HOURS_INPUT = By.xpath("//input[@id='GTimeHH']");
    public static final By GOAL_MINUTES_INPUT = By.xpath("//input[@id='GTimeMM']");
    public static final By GOAL_SECONDS_INPUT = By.xpath("//input[@id='GTimeSS']");
    public static final By CALCULATE_MY_PACES_BUTTON = By.xpath("//input[@value='Calculate My Paces']");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']/strong");
    public static final By RE_CALCULATE_PACES_BUTTON = By.xpath("//a[@name='btnSubmitSettings']");
    public static final By RECENT_INFORMATION_TABLE = By.xpath("//div/strong");


    @Step("McMillan running Calculation")
    public void calculateMcMillanRunning() {

        $(MCMILLAN_TITLE_BUTTON).click();
        $(RACE_DIST_DROPDOWN).selectOptionByValue("10km");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("12");
        $(SECONDS_INPUT).sendKeys("00");
        $(GOAL_DIST_DROPDOWN).selectOptionByValue("15km");
        $(GOAL_HOURS_INPUT).setValue("00");
        $(GOAL_MINUTES_INPUT).sendKeys("10");
        $(GOAL_SECONDS_INPUT).sendKeys("00");
        $(CALCULATE_MY_PACES_BUTTON).click();

    }

    @Step("McMillan running Calculation with invalid data")
    public void invalidCalculateMcMillanRunning() {

        $(MCMILLAN_TITLE_BUTTON).click();
        //$(RACE_DIST_DROPDOWN).selectOptionByValue("10km");
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("12");
        $(SECONDS_INPUT).sendKeys("00");
        $(GOAL_DIST_DROPDOWN).selectOptionByValue("15km");
        $(GOAL_HOURS_INPUT).setValue("00");
        $(GOAL_MINUTES_INPUT).sendKeys("10");
        $(GOAL_SECONDS_INPUT).sendKeys("00");
        $(CALCULATE_MY_PACES_BUTTON).click();

    }

//shouldHave(text("Recent Race: "));


    @Step("Checking that the re-calculate button was visible")
    public SelenideElement checkingVisibleReCalculateButton() {
        return $(RE_CALCULATE_PACES_BUTTON);
    }


}
