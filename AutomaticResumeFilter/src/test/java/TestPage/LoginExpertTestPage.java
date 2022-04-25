package TestPage;

import Page.LoginPage;
import Utilities.Environment;
import Utilities.ExcelDataConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Utilities.SetupDriver.getDriver;


public class LoginExpertTestPage {
    LoginPage login;
    ExcelDataConfig excel = new ExcelDataConfig(Environment.path);

    @BeforeClass
    public void setup() {
        login = new LoginPage(getDriver());
    }

    @Test(priority = 1)
    public void EnterUsername()
    {
        login.EnterUsername(excel.getData(1,1,0));
    }

    @Test(priority = 2)
    public void EnterPassword()
    {
        login.EnterPassword(excel.getData(1,1,1));
    }

    @Test(priority = 3)
    public void ClickLogin()
    {
        login.ClickLogin();
    }
}
