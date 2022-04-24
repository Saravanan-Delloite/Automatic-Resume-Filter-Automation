package TestPage;

import Page.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Utilities.SetupDriver.getDriver;


public class LoginExpertTestPage {
    LoginPage login;

    @BeforeClass
    public void setup()
    {

        login = new LoginPage(getDriver());

    }

    @Test(priority = 1)
    public void EnterUsername()
    {
        login.EnterUsername("name1");
    }

    @Test(priority = 2)
    public void EnterPassword()
    {
        login.EnterPassword("12345678");
    }

    @Test(priority = 3)
    public void ClickLogin()
    {
        login.ClickLogin();
    }
}
