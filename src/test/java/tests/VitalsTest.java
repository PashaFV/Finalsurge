package tests;

import com.codeborne.selenide.Condition;
import models.Vitals;
import models.VitalsFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class VitalsTest  extends BaseTest {

    @Test(description = "Check if vitals is added")
    public void dailyVitalsShouldBeAdded() {
        loginPage.openPage();
        loginPage.login();
        vitalsPage.openPage();
        Vitals vitals = VitalsFactory.get();
        vitalsPage.createAddVitals(vitals);

        vitalsPage.createdDailyVitals(vitals.getSteps()).shouldHave(Condition.text(vitals.getSteps()));
        vitalsPage.createdDailyVitals(vitals.getWeight()).shouldHave(Condition.text(vitals.getWeight()));
        vitalsPage.createdDailyVitals(vitals.getBodyFat()).shouldHave(Condition.text(vitals.getBodyFat()));
        vitalsPage.createdDailyVitals(vitals.getRestingHR()).shouldHave(Condition.text(vitals.getRestingHR()));
        vitalsPage.createdDailyVitals(vitals.getVariabilityHR()).shouldHave(Condition.text(vitals.getVariabilityHR()));
        vitalsPage.createdDailyVitals(vitals.getCalories()).shouldHave(Condition.text(vitals.getCalories()));
        vitalsPage.createdDailyVitals(vitals.getWater()).shouldHave(Condition.text(vitals.getWater()));
        vitalsPage.createdDailyVitals(vitals.getMuscleMass()).shouldHave(Condition.text(vitals.getMuscleMass()));
        vitalsPage.createdDailyVitals(vitals.getSleepHours()).shouldHave(Condition.text(vitals.getSleepHours()));
        vitalsPage.createdDailyVitals(vitals.getTotalTimeAwake()).shouldHave(Condition.text(vitals.getTotalTimeAwake()));
        vitalsPage.createdDailyVitals(vitals.getSleepAmount()).shouldHave(Condition.text(vitals.getSleepAmount()));
        vitalsPage.createdDailyVitals(vitals.getSleepQuality()).shouldHave(Condition.text(vitals.getSleepQuality()));
        vitalsPage.createdDailyVitals(vitals.getStressAmount()).shouldHave(Condition.text(vitals.getStressAmount()));
        //vitalsPage.createdDailyVitals(vitals.getHealthNotes()).shouldHave(Condition.text(vitals.getHealthNotes())); //TODO update working method for span notes через ИЛИ локатор
    }
}
