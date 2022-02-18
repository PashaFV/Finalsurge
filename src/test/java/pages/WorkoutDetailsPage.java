package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class WorkoutDetailsPage extends BasePage {

    public static final By WORKOUT_DETAILS_HEADER = By.xpath("//h4[text()='Workout Details']");
    ////div/span[text()='Run']
    //div/small[contains(text(),'12:00 PM')]
    ////div[text()='IEM Championship3:36']
    ////p[contains(text(),'Fine')]

     ////div/span[contains(text(),'6.00 km ~ 3:36')] distancse, distance measure, duration

    // paceStatisticsblock  ,contains paceMeasure
    String activityTypeField = "//div/span[text()='%s']";  ////div[@style]/span
    String timeOfDayField = "///div/small[contains(text(),'12:00 PM')]";
    String workoutNameField = "//div[text()='%s']";
    String workoutDescField = "//p[contains(text(),'%s')]";
    String distanceStatisticsBlock = "//div/span[contains(text(),'%s %s ~ %s')]";
    String paceStatisticsBlock = "//div/span[contains(text(),'%s')]";
    String howIFeltField = "//div/span[contains(text(),'%s')]";
    String perceivedEffortField = "//div[contains(text(),'%s')]";


    public SelenideElement workoutDetailsHeader(){
        return $(WORKOUT_DETAILS_HEADER);
    }

    public SelenideElement activityTypeField(){
        return null;

    }
}
