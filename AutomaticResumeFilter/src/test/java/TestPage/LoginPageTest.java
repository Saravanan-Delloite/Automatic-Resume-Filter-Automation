package TestPage;

import Page.DriverPage;
import Page.ForgotPasswordPage;
import Page.LoginPage;
import Utilities.Environment;
import Utilities.ExcelDataConfig;
import Utilities.ListenerForExtentReport;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import static Utilities.SetupDriver.*;
@Listeners(ListenerForExtentReport.class)

public class LoginPageTest {

    Logger logger = Logger.getLogger(LoginPageTest.class);

    LoginPage login;
    ForgotPasswordPage forgotPassword;
    ExcelDataConfig excel = new ExcelDataConfig(Environment.path);

    @BeforeClass
    public void setup() {
//        setDriver();
//        getDriver().get(Environment.URL);
//        getDriver().manage().window().maximize();


        login = new LoginPage(getDriver());
        forgotPassword = new ForgotPasswordPage(getDriver());
    }

    @Test(priority = 1)
    public void ClickForgotPassword()
    {
        login.ClickForgotPassword();
        logger.info("Clicking Forgot Password");
    }

    @Test(priority = 2)
    public void EnterEmailId()
    {
        forgotPassword.EnterEmailId(excel.getData(0,1,2));
        logger.info(" Entering Email ID ");

    }

    @Test(priority = 3)
    public void ClickSendOtp()
    {
        forgotPassword.ClickSendOtp();
        logger.info(" Clicking Send OTP ");
    }

    @Test(priority = 4)
    public void ClickBackToLogin()
    {
        forgotPassword.clickBackToLogin();
        logger.info("Clicking Back to Login");

    }

    @Test(priority = 5)
    public void AssertTitle()
    {
        Assert.assertEquals(login.AssertTitle(),Environment.title);
        logger.info("Asserting Title");

    }

    @Test(priority = 6)
    public void EnterUsername()
    {
        login.EnterUsername(excel.getData(0,1,0));
        logger.info(" Entering Username");

    }

    @Test(priority = 7)
    public void AssertLoginButton()
    {
        Assert.assertFalse(login.AssertLoginButton());
        logger.info("Asserting Login Button");

    }

    @Test(priority = 8)
    public void AssertUsername()
    {
        Assert.assertEquals(login.AssertUsername(),excel.getData(0,1,0));
        logger.info(" Asserting Username");

    }

    @Test(priority = 9)
    public void EnterPassword()
    {
        login.EnterPassword(excel.getData(0,1,1));
        logger.info("Entering Password");
    }

    @Test(priority = 10)
    public void AssertPassword()
    {
        Assert.assertEquals(login.AssertPassword(),excel.getData(0,1,1));
        logger.info("Asserting Password");
    }

    @Test(priority = 11)
    public void Assertions() {
        Assert.assertTrue(login.AssertRememberMe());
        Assert.assertTrue(login.AssertRegister());
        Assert.assertTrue(login.AssertForgotPassword());
        logger.info("Assertions");
    }

    @Test(priority = 12)
    public void ClickRememberMe()
    {
        login.ClickRememberMe();
    }

    @Test(priority = 13)
    public void ClickLogin()
    {
        login.ClickLogin();
        logger.info("******************* Logged In ********************");
    }


}
