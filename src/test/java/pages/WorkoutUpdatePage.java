package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class WorkoutUpdatePage extends BasePage{

    public static final By WORKOUT_UPDATE_HEADER = By.xpath("//h4[text()='Update Workout']");

    public SelenideElement workoutUpdateHeader(){
        return $(WORKOUT_UPDATE_HEADER);
    }

    public void updateWorkout() {
        clickUpdateWorkoutButton();
    }

    public void clickUpdateWorkoutButton(){
        log.info("Clicking on Update Workout button");
        $("#saveButton").click();
        log.info("Update Workout button was clicked");
    }
}