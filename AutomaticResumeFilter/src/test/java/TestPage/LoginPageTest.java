package TestPage;

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
    public List<List<String>> testData = new ArrayList<>();
    String userid="";
    String password="";

    LoginPage login;

    @BeforeMethod
    public void setup()
    {
        setDriver();
        getDriver().get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
        getDriver().manage().window().maximize();

        login = new LoginPage(getDriver());
    }

    @BeforeClas
    public void ReadData()
    {
        testData = FetchData.getTestData();
        userid = testData.get(0).get(0);
        password = testData.get(0).get(1);
    }

    @Test
    public void EnterUsername()
    {
        login.EnterUsername(userid);
    }
}
