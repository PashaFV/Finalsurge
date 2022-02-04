package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CalendarPage extends BasePage{

    public static final By ADD_BUTTON = By.xpath("//i[@class='icon-plus']");
    public static final By QUICK_ADD_LOCATOR = By.xpath("//a[@class='quick-add']");

    @Step("Open calendar page ")
    public void openPage() {
        open("/calendar");

    }
    @Step("Add new quick workout")
    public void addNewQuickWorkout() {

        $(ADD_BUTTON).click();
        $(QUICK_ADD_LOCATOR).click();

    }

}
