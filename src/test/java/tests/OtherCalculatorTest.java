package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;

public class OtherCalculatorTest extends BaseTest {

    @Test(description = "Open other calculator pop-up")
    public void openWorkoutCalculatorTest() {

        loginPage.openPage();
        loginPage.login();
        otherCalculatorPopUp.openCalculatorPopUp();
        otherCalculatorPopUp.popUpTitleButton().shouldBe(visible);

    }

    @Test(description = "Close other calculator pop-up")
    public void closeWorkoutCalculatorTest() {

        loginPage.openPage();
        loginPage.login();
        otherCalculatorPopUp.openCalculatorPopUp();
        otherCalculatorPopUp.popUpTitleButton().shouldBe(visible);
        otherCalculatorPopUp.closeCalculatorPopUp();
        otherCalculatorPopUp.headerLogo().shouldBe(visible);

    }

}
