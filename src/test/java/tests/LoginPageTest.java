package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginPageTest extends BaseTest {

    @Test(description = "Login with valid users data")
    public void LoginTest(String userName, String password) {
        loginPage.openPage();
        loginPage.login(userName, password);

    }

}
