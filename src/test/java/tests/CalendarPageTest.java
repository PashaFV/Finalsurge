package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CalendarPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CalendarPageTest extends BaseTest {

    @Test(description = "Login with valid data to finalsurge.com")
    public void AddWorkoutTest() {

        loginPage.openPage();
        loginPage.login();
        calendarPage.openPage();
        calendarPage.addNewQuickWorkout();
        $(By.xpath("//h4[@id='WorkoutAddHeader']")).shouldBe(visible);

    }

}
