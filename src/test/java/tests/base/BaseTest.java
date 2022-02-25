package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;



import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    public LoginPage loginPage;
    public CalendarPage calendarPage;
    public WorkoutLibraryPage workoutLibraryPage;
    public WorkoutCalculatorPopUp workoutCalculatorPopUp;
    public IntensityCalculatorTab intensityCalculatorTab;
    public HansonsCalculatorTab hansonsCalculatorTab;
    public McMillanCalculatorTab mcMillanCalculatorTab;
    public PalladinoCalculatorTab palladinoCalculatorTab;
    public TinmanCalculatorTab tinmanCalculatorTab;
    public OtherCalculatorPopUp otherCalculatorPopUp;
    public PaceCalculatorTab paceCalculatorTab;
    public CaloricNeedsCalculatorTab caloricNeedsCalculatorTab;
    public WorkoutUpdatePage workoutUpdatePage;
    public WorkoutDetailsPage workoutDetailsPage;
    public DefaultPage defaultPage;
    public WorkoutCommentsPopUp workoutCommentsPopUp;
    public WorkoutUploadDataPopUp workoutUploadDataPopUp;
    public WorkoutInjuryReportPopUp workoutInjuryReportPopUp;
    public WorkoutReportPage workoutReportPage;
    public VitalsPage vitalsPage;

    @BeforeClass
    public void setUp() {
        log.info("Setup options and configurations.");

        Configuration.baseUrl = System.getenv().getOrDefault("FINALSURGE_URL", PropertyReader.getProperty("finalsurge.url"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.savePageSource = false;
        Configuration.browserSize = "1440x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        loginPage = new LoginPage();
        calendarPage = new CalendarPage();
        workoutLibraryPage = new WorkoutLibraryPage();
        workoutCalculatorPopUp = new WorkoutCalculatorPopUp();
        intensityCalculatorTab = new IntensityCalculatorTab();
        hansonsCalculatorTab = new HansonsCalculatorTab();
        mcMillanCalculatorTab = new McMillanCalculatorTab();
        palladinoCalculatorTab = new PalladinoCalculatorTab();
        tinmanCalculatorTab = new TinmanCalculatorTab();
        otherCalculatorPopUp = new OtherCalculatorPopUp();
        paceCalculatorTab = new PaceCalculatorTab();
        caloricNeedsCalculatorTab = new CaloricNeedsCalculatorTab();
        workoutUpdatePage = new WorkoutUpdatePage();
        workoutDetailsPage = new WorkoutDetailsPage();
        defaultPage = new DefaultPage();
        workoutCommentsPopUp = new WorkoutCommentsPopUp();
        workoutUploadDataPopUp = new WorkoutUploadDataPopUp();
        workoutInjuryReportPopUp = new WorkoutInjuryReportPopUp();
        workoutReportPage = new WorkoutReportPage();
        vitalsPage = new VitalsPage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        log.info("Browser close.");
        getWebDriver().quit();
    }

    @Attachment(type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
