package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CaloricNeedsCalculatorTab extends OtherCalculatorPopUp{

    public static final By WEIGHT_INPUT = By.xpath("//input[@id='Weight']");
    public static final By HEIGHT_INPUT = By.xpath("//input[@id='HeightInchCent']");
    public static final By AGE_INPUT = By.xpath("//input[@id='Age']");
    public static final By RUN_DISTANCE_INPUT = By.xpath("//input[@id='RunDist']");
    public static final By WEIGHT_LBS_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios3' and @name='WeightType']");
    public static final By WEIGHT_KG_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios4' and @name='WeightType']");
    public static final By HEIGHT_INCHES_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios3' and @name='HeightType']");
    public static final By HEIGHT_CENTIMETERS_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios4' and @name='HeightType']");
    public static final By GENDER_MALE_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios5' and @name='Gender']");
    public static final By GENDER_FEMALE_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios6' and @name='Gender']");
    public static final By DISTANCE_MILES_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios7' and @name='DistType']");
    public static final By DISTANCE_KILOMETERS_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios8' and @name='DistType']");
    public static final By CALCULATE_CALORIC_BUTTON = By.xpath("//input[@value='Calculate Caloric Needs']");

    public static final By CALORIC_NEEDS_TABLE_HEADER = By.xpath("//h4[text()='Today's Caloric Needs']");
    public static final By PACE_TITLE_BUTTON = By.xpath("//a[text()='Pace Calculator']");


    @Step("Calorics Calculation")
    public void calculateCalorics() {

        $(WEIGHT_INPUT).setValue("85");
        $(WEIGHT_KG_RADIO_BUTTON).setSelected(true);
        $(HEIGHT_INPUT).setValue("185");
        $(HEIGHT_CENTIMETERS_RADIO_BUTTON).setSelected(true);
        $(AGE_INPUT).setValue("24");
        $(GENDER_MALE_RADIO_BUTTON).setSelected(true);
        $(RUN_DISTANCE_INPUT).setValue("2.4");
        $(DISTANCE_KILOMETERS_RADIO_BUTTON).setSelected(true);
        $(CALCULATE_CALORIC_BUTTON).click();

    }

    @Step("Calorics Calculation with invalid data")
    public void invalidCalculateCalorics() {

        $(WEIGHT_INPUT).setValue("85");
        $(WEIGHT_KG_RADIO_BUTTON).setSelected(true);
        $(HEIGHT_INPUT).setValue("5");
        $(HEIGHT_CENTIMETERS_RADIO_BUTTON).setSelected(true);
        $(AGE_INPUT).setValue("24");
        $(GENDER_MALE_RADIO_BUTTON).setSelected(true);
        $(RUN_DISTANCE_INPUT).setValue("2.4");
        $(DISTANCE_KILOMETERS_RADIO_BUTTON).setSelected(true);
        $(CALCULATE_CALORIC_BUTTON).click();

    }

    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenCaloricNeedsTable() {
        return $(CALORIC_NEEDS_TABLE_HEADER);
    }

}
