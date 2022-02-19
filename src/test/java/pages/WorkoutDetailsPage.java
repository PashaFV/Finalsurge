package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class WorkoutDetailsPage extends BasePage {

    public static final By WORKOUT_DETAILS_HEADER = By.xpath("//h4[text()='Workout Details']");
    public static final By ACTIVITY_TYPE_FIELD = By.xpath("//div[@style]/span");
    public static final By TIME_OF_DAY_FIELD = By.xpath("//div[@class='formSep']/div[@style]/small");
    public static final By WORKOUT_NAME_FIELD = By.xpath("//div[@class='formSep']/div[contains(@style,'clear')]");
    public static final By WORKOUT_DESC_FIELD = By.xpath("//small[contains(text(), 'Workout Description:')]/../../p");
    public static final By HOW_I_FELT_FIELD = By.xpath("//small[text()='How I Felt:']/../span");
    public static final By PERCEIVED_EFFORT_FIELD = By.xpath("//small[text()='Perceived Effort']/..");

   // String ACTIVITY_TYPE_FIELD = "//div[@style]/span";  //   //div/span[text()='%s']
   // String TIME_OF_DAY_FIELD = "//div[@class='formSep']/div[@style]/small"; //  //div/small[contains(text(),'%s')]
   // String WORKOUT_NAME_FIELD = "//div[@class='formSep']/div[contains(@style,'clear')]"; //  //div[text()='%s']
   // String WORKOUT_DESC_FIELD = "//small[contains(text(), 'Workout Description:')]/../../p"; // //p[contains(text(),'%s')] //small[contains(text(), 'Workout Description:')]/../../p
    String distanceStatisticsBlock = "//div/span[contains(text(),'%s %s ~ %s')]";
    String paceStatisticsBlock = "//div/span[contains(text(),'%s')]";
   // String HOW_I_FELT_FIELD = "//small[text()='How I Felt:']/../span"; // //div/span[contains(text(),'%s')]
   // String PERCEIVED_EFFORT_FIELD = "//small[text()='Perceived Effort']/.."; //  //div[contains(text(),'%s')]

    public SelenideElement workoutDetailsHeader(){
        return $(WORKOUT_DETAILS_HEADER);
    }
    public SelenideElement activityTypeField(){
        return $(ACTIVITY_TYPE_FIELD);
    }

    public SelenideElement timeOfDayField(){
        return $(TIME_OF_DAY_FIELD);
    }

    public SelenideElement workoutNameField(){
        return $(WORKOUT_NAME_FIELD);
    }

    public SelenideElement workoutDescField(){
        return $(WORKOUT_DESC_FIELD);
    }

    public SelenideElement distanceStatisticsBlock(Workout workout){
        return $(By.xpath(String.format(distanceStatisticsBlock, workout.getDistance(), workout.getDistanceMeasure(), workout.getDuration())));
    }

    public SelenideElement paceStatisticsBlock(Workout workout){
        return $(By.xpath(String.format(paceStatisticsBlock, workout.getPaceMeasure())));
    }

    public SelenideElement howIFeltField(){
        return $(HOW_I_FELT_FIELD);
    }

    public SelenideElement perceivedEffortField(){
        return $(PERCEIVED_EFFORT_FIELD);
    }

}
