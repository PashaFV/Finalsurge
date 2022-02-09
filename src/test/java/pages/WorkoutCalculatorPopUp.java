package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class WorkoutCalculatorPopUp extends BasePage {

    public static final By WORKOUT_CALCULATOR_BUTTON = By.xpath("//a[@data-reveal-id='IntensityCalc']");
    public static final By MILE_RADIO_BUTTON = By.xpath("//input[@id='MILE']");
    public static final By HOURS_INPUT = By.xpath("//input[@placeholder='hh']");
    public static final By MINUTES_INPUT = By.xpath("//input[@placeholder='mm']");
    public static final By SECONDS_INPUT = By.xpath("//input[@placeholder='ss']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By YOUR_WORKOUT_PACES_HEADER = By.xpath("//h4[text()='Your Workout Paces']");



    @Step("Running Intensity Calculation")
    public void calculateRunningIntensity() {

        $(WORKOUT_CALCULATOR_BUTTON).click();
        switchTo().frame($("[id='IntensityCalciFrame']"));
        $(HOURS_INPUT).setValue("00");
        $(MINUTES_INPUT).sendKeys("12");
        $(SECONDS_INPUT).sendKeys("00");
        $(MILE_RADIO_BUTTON).click();
        $(CALCULATE_PACES_BUTTON).click();

    }

    public SelenideElement yourWorkoutPacesHeader(){
        return $(YOUR_WORKOUT_PACES_HEADER);
    }


}
