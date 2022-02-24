package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Vitals;
import models.Workout;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class VitalsPage extends BasePage{
    public static final By ADD_VITALS_BUTTON = By.xpath("//button[@title='Add Vitals']");
    String createdDailyVitalsRow = "//table//tr/td[contains(text(), '%s')]";

    @Step("Open Daily Vitals page ")
    public void openPage() {
        open("/DailyVitals");
    }

    public void createAddVitals(Vitals vitals){
        $(ADD_VITALS_BUTTON).click();
        fillInDailyVitalsForm(vitals);
        clickSaveAddVitals();
    }

    private void clickSaveAddVitals() {
        log.info("Clicking on save Add Vitals button");
        $("#saveButton").click();
        log.info("Save Add Vitals button was clicked");
    }

    public void fillInDailyVitalsForm(Vitals vitals){
        new Input("#VitalsDate").write(vitals.getDate());
        new Input("#Steps").write(vitals.getSteps());
        new Input("#Calories").write(vitals.getCalories());
        new Input("#Weight").write(vitals.getWeight());
        new Dropdown("#WeightType").selectOption(vitals.getWeightMeasure());
        new Input("#BodyFat").write(vitals.getBodyFat());
        new Input("#WaterPercent").write(vitals.getWater());
        new Input("#MuscleMass").write(vitals.getMuscleMass());
        new Dropdown("#MuscleMassType").selectOption(vitals.getMuscleMassMeasure());
        new Input("#RestHR").write(vitals.getRestingHR());
        new Input("#HRVar").write(vitals.getVariabilityHR());
        new Input("#SleepHours").write(vitals.getSleepHours());
        new Input("#AwakeTime").write(vitals.getTotalTimeAwake());
        new Dropdown("#SleepAmount").selectOption(vitals.getSleepAmount());
        new Dropdown("#SleepQuality").selectOption(vitals.getSleepQuality());
        new Dropdown("#Stress").selectOption(vitals.getStressAmount());
        new Input("#Systolic").write(vitals.getSystolicBloodPressure());
        new Input("#Diastolic").write(vitals.getDiastolicBloodPressure());
        new Input("#HealthNotes").write(vitals.getHealthNotes());
    }

    public SelenideElement createdDailyVitals(String vitalsTextField){
        return $(By.xpath(String.format(createdDailyVitalsRow, vitalsTextField)));
    }

}
