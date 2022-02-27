package tests.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {

        System.out.printf("Test started:  %s \n", result.getName());
    }

    public void onTestSuccess(ITestResult result) {

        System.out.printf("Test success:  %s \n", result.getName());

    }

    public void onTestFailure(ITestResult result) {

        System.out.printf("Test failed: %s \n", result.getName());
        log.info("Take screenshot");

    }

}
