package tests.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.CalendarPage;
import pages.LoginPage;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    public LoginPage loginPage;
    public CalendarPage calendarPage;

    @BeforeClass
    public void setUp() {

        Configuration.baseUrl = System.getenv().getOrDefault("FINALSURGE_URL", PropertyReader.getProperty("finalsurge.url"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.timeout = 100000;
        Configuration.savePageSource = false;

        loginPage = new LoginPage();
        calendarPage = new CalendarPage();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        getWebDriver().quit();
    }

}
