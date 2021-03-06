package pages;

import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Injury;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class WorkoutInjuryReportPopUp extends BasePage{

    public static final By PAIN_LEVEL_INPUT = By.xpath("//*[@id='painLevelSlider']//input");
    public static final By PAIN_LEVEL_DD_COUNTER = By.xpath("//div[@id='painLevelSlider']//div[contains(@class, 'min') and @role = 'slider']");
    public static final By PAIN_LEVEL_DESC_ELEMENT = By.xpath("//div[@id='painLevelSlider']//div[contains(@class, 'tooltip-main')]/div[contains(@class, 'tooltip-inner')]");
    public static final By PAIN_TREND_DESC_ELEMENT = By.xpath("//div[@id='painTrendSlider']//div[contains(@class, 'tooltip-main')]/div[contains(@class, 'tooltip-inner')]");
    public static final By PAIN_DURATION_INPUT = By.xpath("//*[@id='painDurationSlider']//input");
    public static final By PAIN_DURATION_DD_MIN_COUNTER = By.xpath("//div[@id='painDurationSlider']//div[contains(@class, 'min') and @role = 'slider']");
    public static final By PAIN_DURATION_DD_MAX_COUNTER = By.xpath("//div[@id='painDurationSlider']//div[contains(@class, 'max') and @role = 'slider']");
    public static final By PAIN_TREND_INPUT = By.xpath("//*[@id='painTrendSlider']//input");
    public static final By PAIN_TREND_DD_COUNTER = By.xpath("//div[@id='painTrendSlider']//div[contains(@class, 'min') and @role = 'slider']");
    String PAIN_NOTES_TEXTAREA = "#painNotes";
    String ADD_INJURY_REPORT_BUTTON = "#painPointSave";
    String bodyDot = "//*[@id='dot-%s']";

    @Step("Add front side injury Report")
    public Injury addFrontReport(Injury injury) {
        log.info("click on body dot");
        $(By.xpath(String.format(bodyDot, injury.getBodyDot()))).click();
        log.info("Configure slider's pain counters");
        actions().dragAndDropBy($(PAIN_LEVEL_DD_COUNTER), injury.getPainLevelXCoordinates(), 0).perform();
        actions().dragAndDropBy($(PAIN_DURATION_DD_MIN_COUNTER), injury.getPainDurationStartXCoordinates(), 0).perform(); //injury.getPainDurationStartXCoordinates()
        actions().dragAndDropBy($(PAIN_DURATION_DD_MAX_COUNTER), injury.getPainDurationEndXCoordinates(), 0).perform();
        actions().dragAndDropBy($(PAIN_TREND_DD_COUNTER), injury.getPainTrendXCoordinates(), 0).perform();
        new Input(PAIN_NOTES_TEXTAREA).write(injury.getPainNotes());
        injury.setWithPainLevelConnectedText($(PAIN_LEVEL_DESC_ELEMENT).getOwnText());
        injury.setWithPainTrendConnectedText($(PAIN_TREND_DESC_ELEMENT).getOwnText());
        injury.setWithPainDurationEndConnectedText($(PAIN_DURATION_DD_MAX_COUNTER).getText());
        injury.setWithPainDurationStartConnectedText($(PAIN_DURATION_DD_MIN_COUNTER).getText());
        log.info("Click on add injury report button");
        $(ADD_INJURY_REPORT_BUTTON).click();
        return injury;
    }

    public SelenideElement painMapDot(String injuryDot) {
        return $(By.xpath(String.format(bodyDot, injuryDot)));
    }
}
