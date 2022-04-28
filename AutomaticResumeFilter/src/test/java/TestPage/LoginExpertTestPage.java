package TestPage;

import Page.LoginPage;
import Utilities.Environment;
import Utilities.ExcelDataConfig;
import Utilities.ListenerForExtentReport;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Utilities.SetupDriver.getDriver;
@Listeners(ListenerForExtentReport.class)


public class LoginExpertTestPage {
    Logger logger = Logger.getLogger(LoginExpertTestPage.class);

    LoginPage login;
    ExcelDataConfig excel = new ExcelDataConfig(Environment.path);

    @BeforeClass
    public void setup() {
        login = new LoginPage(getDriver());
    }

    @Test(priority = 1)
    public void ClickProfile()
    {
        login.clickProfile();
    }

    @Test(priority = 2)
    public void ClickSignOut()
    {
        login.ClickSignOut();
        logger.info("************** Logged In ******************");
    }
    @Test(priority = 3)
    public void EnterUsername()
    {
        login.EnterUsername(excel.getData(1,1,0));
    }

    @Test(priority = 4)
    public void EnterPassword()
    {
        login.EnterPassword(excel.getData(1,1,1));
    }

    @Test(priority = 5)
    public void ClickLogin()
    {
        login.ClickLogin();
        logger.info("****************** Logged In By Expert ********************");
    }
}
