package TestPage;

import Page.ForgotPasswordPage;
import Page.LoginPage;
import Utilities.Environment;
import Utilities.ExcelDataConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Utilities.SetupDriver.*;

public class LoginPageTest {


    LoginPage login;
    ForgotPasswordPage forgotPassword;
    ExcelDataConfig excel = new ExcelDataConfig(Environment.path);

    @BeforeClass
    public void setup() {
        setDriver();
        getDriver().get(Environment.URL);
        getDriver().manage().window().maximize();

        login = new LoginPage(getDriver());
        forgotPassword = new ForgotPasswordPage(getDriver());
    }

    @Test(priority = 1)
    public void ClickForgotPassword()
    {
        login.ClickForgotPassword();
    }

    @Test(priority = 2)
    public void EnterEmailId()
    {
        forgotPassword.EnterEmailId(excel.getData(0,1,2));
    }

    @Test(priority = 3)
    public void ClickSendOtp()
    {
        forgotPassword.ClickSendOtp();
    }

    @Test(priority = 4)
    public void ClickBackToLogin()
    {
        forgotPassword.clickBackToLogin();
    }

    @Test(priority = 5)
    public void AssertTitle()
    {
        Assert.assertEquals(login.AssertTitle(),Environment.title);
    }

    @Test(priority = 6)
    public void EnterUsername()
    {
        login.EnterUsername(excel.getData(0,1,0));
    }

    @Test(priority = 7)
    public void AssertLoginButton()
    {
        Assert.assertFalse(login.AssertLoginButton());
    }

    @Test(priority = 8)
    public void AssertUsername()
    {
        Assert.assertEquals(login.AssertUsername(),excel.getData(0,1,0));
    }

    @Test(priority = 9)
    public void EnterPassword()
    {
        login.EnterPassword(excel.getData(0,1,1));
    }

    @Test(priority = 10)
    public void AssertPassword()
    {
        Assert.assertEquals(login.AssertPassword(),excel.getData(0,1,1));
    }

    @Test(priority = 11)
    public void Assertions() {
        Assert.assertTrue(login.AssertRememberMe());
        Assert.assertTrue(login.AssertRegister());
        Assert.assertTrue(login.AssertForgotPassword());
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
    }

    @Test(priority = 14)
    public void ClickProfile()
    {
        login.clickProfile();
    }

    @Test(priority = 15)
    public void ClickSignOut()
    {
        login.ClickSignOut();
    }
}
