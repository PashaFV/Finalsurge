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

    @Test(description = "Check if vitals is updated")
    public void updateDailyVitals() {
        loginPage.openPage();
        loginPage.login();
        vitalsPage.openPage();
        Vitals vitals = VitalsFactory.get();
        vitalsPage.createAddVitals(vitals);
        Vitals vitalsForEditing = VitalsFactory.get();
        vitalsPage.editVitals(vitals.getDate(), vitalsForEditing);

        vitalsPage.createdDailyVitals(vitalsForEditing.getSteps()).shouldHave(Condition.text(vitalsForEditing.getSteps()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getWeight()).shouldHave(Condition.text(vitalsForEditing.getWeight()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getBodyFat()).shouldHave(Condition.text(vitalsForEditing.getBodyFat()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getRestingHR()).shouldHave(Condition.text(vitalsForEditing.getRestingHR()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getVariabilityHR()).shouldHave(Condition.text(vitalsForEditing.getVariabilityHR()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getCalories()).shouldHave(Condition.text(vitalsForEditing.getCalories()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getWater()).shouldHave(Condition.text(vitalsForEditing.getWater()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getMuscleMass()).shouldHave(Condition.text(vitalsForEditing.getMuscleMass()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getSleepHours()).shouldHave(Condition.text(vitalsForEditing.getSleepHours()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getTotalTimeAwake()).shouldHave(Condition.text(vitalsForEditing.getTotalTimeAwake()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getSleepAmount()).shouldHave(Condition.text(vitalsForEditing.getSleepAmount()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getSleepQuality()).shouldHave(Condition.text(vitalsForEditing.getSleepQuality()));
        vitalsPage.createdDailyVitals(vitalsForEditing.getStressAmount()).shouldHave(Condition.text(vitalsForEditing.getStressAmount()));
    }

    @Test(description = "Check if vitals is deleted")
    public void deleteDailyVitals(){
        loginPage.openPage();
        loginPage.login();
        vitalsPage.openPage();
        Vitals vitals = VitalsFactory.get();
        vitalsPage.createAddVitals(vitals);
        vitalsPage.deleteVitals(vitals.getDate());

        vitalsPage.stepsFieldOfVitalsRow(vitals.getDate()).shouldNotHave(Condition.text(vitals.getSteps()));
    }




}
