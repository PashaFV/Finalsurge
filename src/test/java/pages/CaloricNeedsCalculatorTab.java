package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CaloricNeedsCalculatorTab extends OtherCalculatorPopUp {


    public static final By WEIGHT_LBS_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios3' and @name='WeightType']");
    public static final By WEIGHT_KG_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios4' and @name='WeightType']");
    public static final By HEIGHT_INCHES_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios3' and @name='HeightType']");
    public static final By HEIGHT_CENTIMETERS_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios4' and @name='HeightType']");
    public static final By GENDER_MALE_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios5' and @name='Gender']");
    public static final By GENDER_FEMALE_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios6' and @name='Gender']");
    public static final By DISTANCE_MILES_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios7' and @name='DistType']");
    public static final By DISTANCE_KILOMETERS_RADIO_BUTTON = By.xpath("//input[@id='optionsRadios8' and @name='DistType']");
    public static final By CALCULATE_CALORIC_BUTTON = By.xpath("//input[@value='Calculate Caloric Needs']");

    public static final By CALORIC_NEEDS_TABLE_HEADER = By.xpath("//div[@class='w-box w-box-green']/div[@class='w-box-header']/h4");
    public static final By METABOLIC_RATE = By.xpath("//div[@class='span6']/div/small");


    @Step("Calorics Calculation")
    public void calculateCalorics() {
        log.info("Calorics calculation in other calculator");

        new Input("#Weight").write("70");
        $(WEIGHT_KG_RADIO_BUTTON).setSelected(true);
        new Input("#HeightInchCent").write("185");
        $(HEIGHT_CENTIMETERS_RADIO_BUTTON).setSelected(true);
        new Input("#Age").write("22");
        $(GENDER_MALE_RADIO_BUTTON).setSelected(true);
        new Input("#RunDist").write("2.4");
        $(DISTANCE_KILOMETERS_RADIO_BUTTON).setSelected(true);
        $(CALCULATE_CALORIC_BUTTON).click();

    }

    @Step("Calorics Calculation with invalid data")
    public void invalidCalculateCalorics() {
        log.info("Calorics calculation with invalid data in other calculator");

        new Input("#Weight").write("85");
        $(WEIGHT_KG_RADIO_BUTTON).setSelected(true);
        new Input("#HeightInchCent").write("5");
        $(HEIGHT_CENTIMETERS_RADIO_BUTTON).setSelected(true);
        new Input("#Age").write("24");
        $(GENDER_MALE_RADIO_BUTTON).setSelected(true);
        new Input("#RunDist").write("2.4");
        $(DISTANCE_KILOMETERS_RADIO_BUTTON).setSelected(true);
        $(CALCULATE_CALORIC_BUTTON).click();

    }

    @Step("Checking that the table was opened")
    public SelenideElement checkingOpenCaloricNeedsTable() {
        return $(CALORIC_NEEDS_TABLE_HEADER);
    }

    @Step("Checking Estimated Resting Metabolic Rate")
    public SelenideElement metabolicRate() {
        return $(METABOLIC_RATE);
    }


}
