package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IntensityCalculatorTab extends WorkoutCalculatorPopUp {

    public static final By MILE_RADIO_BUTTON = By.xpath("//input[@id='MILE']");
    public static final By FIVE_KM_RADIO_BUTTON = By.xpath("//input[@id='FIVEK']");
    public static final By TEN_KM_RADIO_BUTTON = By.xpath("//input[@id='TENK']");
    public static final By HALF_MARATHON_RADIO_BUTTON = By.xpath("//input[@id='HALFMAR']");
    public static final By MARATHON_RADIO_BUTTON = By.xpath("//input[@id='MARATHON']");
    public static final By HOURS_INPUT = By.xpath("//input[@id='TimeHH']");
    public static final By MINUTES_INPUT = By.xpath("//input[@id='TimeMM']");
    public static final By SECONDS_INPUT = By.xpath("//input[@id='TimeSS']");
    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By YOUR_WORKOUT_PACES_HEADER = By.xpath("//h4[text()='Your Workout Paces']");
    public static final By YOUR_WORKOUT_PACES_TABLE = By.xpath("//table[@class='table table-condensed table-hover']/tbody/tr/td");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']/strong");



    @Step("Running Intensity Calculation")
    public void calculateRunningIntensity() {

        new RadioButton("#FIVEK").click();
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("30");
        new Input("#TimeSS").write("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Running Intensity Calculation with invalid date")
    public void calculateRunningIntensityWithInvalidData() {


        new RadioButton("#MARATHON").click();
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("10");
        new Input("#TimeSS").write("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    //ERROR


    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenWorkoutPacesHeader() {
        return $(YOUR_WORKOUT_PACES_HEADER);
    }



}
