package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@Log4j2
public class WorkoutUploadDataPopUp extends BasePage{

    String UPLOAD_FILE_BUTTON = "#saveButton";
    public static final By SELECT_FILE_BUTTON = By.xpath("//input[@id = 'TCXFile']");

    @Step("Upload file")
    public void uploadFile(File file) {
        log.info("upload file");
        $(SELECT_FILE_BUTTON).uploadFile(file);
        log.info("Click on save uploaded file button");
        $(UPLOAD_FILE_BUTTON).click();
    }

}
