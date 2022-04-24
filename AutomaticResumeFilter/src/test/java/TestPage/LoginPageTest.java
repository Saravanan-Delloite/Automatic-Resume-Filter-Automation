package TestPage;

import Page.ForgotPasswordPage;
import Page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Utilities.SetupDriver.*;

public class LoginPageTest {


    LoginPage login;
    ForgotPasswordPage forgotPassword;

    @BeforeClass
    public void setup() {
        setDriver();
        getDriver().get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
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
        forgotPassword.EnterEmailId("yyashmittal@gmail.com");
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
        Assert.assertEquals(login.AssertTitle(),"ResumeFrontEnd");
    }

    @Test(priority = 6)
    public void EnterUsername()
    {
        login.EnterUsername("admin123");
    }

    @Test(priority = 7)
    public void AssertLoginButton()
    {
        Assert.assertFalse(login.AssertLoginButton());
    }

    @Test(priority = 8)
    public void AssertUsername()
    {
        Assert.assertEquals(login.AssertUsername(),"admin123");
    }

    @Test(priority = 9)
    public void EnterPassword()
    {
        login.EnterPassword("admin123");
    }

    @Test(priority = 10)
    public void AssertPassword()
    {
        Assert.assertEquals(login.AssertPassword(),"admin123");
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
