package tests.base;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
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

    @BeforeClass
    public void setUp() {
        log.info("Setup options and configurations.");

        Configuration.baseUrl = System.getenv().getOrDefault("FINALSURGE_URL", PropertyReader.getProperty("finalsurge.url"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.savePageSource = false;
        Configuration.browserSize = "1440x1080";

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
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        log.info("Browser close.");
        getWebDriver().quit();
    }

}
