package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class WorkoutCalculatorPopUp extends BasePage {

    public static final By WORKOUT_CALCULATOR_BUTTON = By.xpath("//a[@data-reveal-id='IntensityCalc']");
    public static final By CLOSE_CALCULATOR_BUTTON = By.xpath("//div[@id='IntensityCalc']/a[@class='close-reveal-modal']");
    public static final By INTENSITY_TITLE_BUTTON = By.xpath("//button[text()='Intensity']");
    public static final By FINALSURGE_HEADER_LOGO = By.xpath("//img[@alt='Final Surge']");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']");

    @Step("Open Pop-Up workout calculator")
    public void openCalculatorPopUp(){
        log.info("Open Pop-Up workout calculator");
        $(WORKOUT_CALCULATOR_BUTTON).click();
        switchTo().frame($("[id='IntensityCalciFrame']"));
    }

    @Step("Close Pop-Up workout calculator")
    public void closeCalculatorPopUp(){
        log.info("Close Pop-Up workout calculator");
        switchTo().defaultContent();
        $(CLOSE_CALCULATOR_BUTTON).click();

    }

    public SelenideElement popUpTitleButton() {return $(INTENSITY_TITLE_BUTTON); }

    public SelenideElement headerLogo() {return $(FINALSURGE_HEADER_LOGO); }

    @Step("Get error message")
    public SelenideElement getErrorMessage(){

        return $(ERROR_MESSAGE);
    }




    }



