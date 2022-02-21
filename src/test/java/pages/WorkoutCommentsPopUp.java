package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Input;
import models.Workout;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WorkoutCommentsPopUp extends BasePage {
    String ADD_COMMENT_BUTTON = "#saveButtonComment";
    String COMMENT_TEXT_AREA = "#CommentDesc";
    public static final By LAST_COMMENT_ITEM = By.xpath("//div[contains(@class, 'message-item')][1]");

    public void addComment(String workoutComment){
        new Input(COMMENT_TEXT_AREA).write(workoutComment);
        $(ADD_COMMENT_BUTTON).click();
    }

    public SelenideElement createdComment(){
        return $(LAST_COMMENT_ITEM);
    }

}
