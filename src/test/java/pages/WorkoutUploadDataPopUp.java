package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WorkoutUploadDataPopUp extends BasePage{

    String UPLOAD_FILE_BUTTON = "#saveButton";
    public static final By SELECT_FILE_BUTTON = By.xpath("//input[@id = 'TCXFile']");

    public void uploadFile(File file) {
        $(SELECT_FILE_BUTTON).uploadFile(file);
        $(UPLOAD_FILE_BUTTON).click();
    }

}
