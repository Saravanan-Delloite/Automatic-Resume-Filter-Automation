package TestPage;

import Page.ForgotPasswordPage;
import Page.LoginPage;
import Utilities.FetchData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static Utilities.SetupDriver.*;

public class LoginPageTest {
//    public List<List<String>> testData = new ArrayList<>();
//    String userid="";
//    String password="";

    LoginPage login;
    ForgotPasswordPage forgotPassword;
//    @BeforeClass
//    public void ReadData()
//    {
//        testData = FetchData.getTestData();
//        userid = testData.get(0).get(0);
//        password = testData.get(0).get(1);
//    }

    @BeforeClass
    public void setup()
    {
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
    public void EnterUsername()
    {
        login.EnterUsername("admin123");
    }

    @Test(priority = 6)
    public void EnterPassword()
    {
        login.EnterPassword("admin123");
    }

    @Test(priority = 7)
    public void ClickRememberMe()
    {
        login.ClickRememberMe();
    }
    @Test(priority = 8)
    public void ClickLogin()
    {
        login.ClickLogin();
    }
}
