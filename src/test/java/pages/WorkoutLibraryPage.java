package pages;

import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class WorkoutLibraryPage extends BasePage {
    String nameCell = "//tr/td[2][text()='%s']";
    String DescriptionCell = "//tr/td[2][text()='%s']/../td[3]";
    public static final By EXPAND_COLLAPSE_TABLE_RUN = By.xpath("//h4[text()='Run']");

    @Step("Open workout library page ")
    public void openPage() {
        log.info("Open workout library page");
        open("/WorkoutLibrary");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("WL-00000001-0001-0001-0001-000000000001");
        $(EXPAND_COLLAPSE_TABLE_RUN).click();
    }

    public SelenideElement createdWorkoutLibraryName(Workout workout) {
        return $(By.xpath(String.format(nameCell, workout.getWorkoutName())));
    }

    public SelenideElement createdWorkoutLibraryDesc(Workout workout) {
        return $(By.xpath(String.format(DescriptionCell, workout.getWorkoutName())));
    }
}
