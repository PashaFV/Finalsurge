package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class OtherCalculatorPopUp extends BasePage{

    //public static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']/strong");
    public static final By OTHER_CALCULATOR_BUTTON = By.xpath("//a[@data-reveal-id='OtherCalc']");
    public static final By CLOSE_CALCULATOR_BUTTON = By.xpath("//div[@id='OtherCalc']/a[@class='close-reveal-modal']");
    public static final By PACE_TITLE_BUTTON = By.xpath("//a[text()='Pace Calculator']");


    @Step("Open Pop-Up other calculator")
    public void openCalculatorPopUp(){
        $(OTHER_CALCULATOR_BUTTON).click();
        switchTo().frame($("[id='OtherCalciFrame']"));
    }

    @Step("Close Pop-Up workout calculator")
    public void closeCalculatorPopUp(){
        switchTo().defaultContent();
        $(CLOSE_CALCULATOR_BUTTON).click();

    }

    public SelenideElement popUpTitleButton() {return $(PACE_TITLE_BUTTON); }


}