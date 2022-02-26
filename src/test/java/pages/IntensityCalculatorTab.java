package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class IntensityCalculatorTab extends WorkoutCalculatorPopUp {


    public static final By CALCULATE_PACES_BUTTON = By.xpath("//input[@value='Calculate Paces']");
    public static final By YOUR_WORKOUT_PACES_HEADER = By.xpath("//h4[text()='Your Workout Paces']");
    public static final By MARATHON_PACES_VALUE_IN_TABLE = By.xpath("//table[@class='table table-condensed table-hover']/tbody/tr/td[3]");
    public static final By YOUR_WORKOUT_PACES_TABLE = By.xpath("//table[@class='table table-condensed table-hover']/tbody/tr/td");

    @Step("Running Intensity Calculation")
    public void calculateRunningIntensity() {

        log.info("Running intensity calculation in workout calculator");
        new RadioButton("#FIVEK").click();
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("30");
        new Input("#TimeSS").write("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Running Intensity Calculation with invalid date")
    public void calculateRunningIntensityWithInvalidData() {

        log.info("Running intensity calculation with invalid data in workout calculator");
        new RadioButton("#MARATHON").click();
        new Input("#TimeHH").write("00");
        new Input("#TimeMM").write("10");
        new Input("#TimeSS").write("00");
        $(CALCULATE_PACES_BUTTON).click();

    }

    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenWorkoutPacesHeader() {
        return $(YOUR_WORKOUT_PACES_HEADER);
    }

    @Step("Checking marathon pace value in table")
    public SelenideElement marathonPacesInTable() {
        return $(MARATHON_PACES_VALUE_IN_TABLE);
    }


}
