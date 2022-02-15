package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class WorkoutDetailsPage extends BasePage {

    public static final By WORKOUT_DETAILS_HEADER = By.xpath("//h4[text()='Workout Details']");

    public SelenideElement workoutDetailsHeader(){
        return $(WORKOUT_DETAILS_HEADER);
    }
}
