package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CaloricCalculateTest extends BaseTest {

    @Test(description = "Calculation caloric", priority = 1)
    public void сalculateCaloricTest() {

        loginPage.openPage();
        loginPage.login();
        otherCalculatorPopUp.openCalculatorPopUp();
        otherCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        caloricNeedsCalculatorTab.calculateCalorics();
        caloricNeedsCalculatorTab.checkingOpenCaloricNeedsTable().shouldBe(visible);
        caloricNeedsCalculatorTab.metabolicRate().shouldHave(text("1,752 kCal"));

    }

    @Test(description = "Calculation caloric with invalid data", priority = 2)
    public void invalidCalculateCaloricTest() {

        loginPage.openPage();
        loginPage.login();
        otherCalculatorPopUp.openCalculatorPopUp();
        otherCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        caloricNeedsCalculatorTab.invalidCalculateCalorics();
        otherCalculatorPopUp.ErrorMessage().shouldHave(text("Height in Centimeters cannot be less than 60.00."));

    }

}
