package TestPage;

import Page.DriverPage;
import Page.LoginPage;
import Page.SignupOperation;
import Page.SignupPageDisplayAndEnable;
import static Utilities.SetupDriver.*;

import Utilities.Environment;
import Utilities.SetupDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainTest{
//    WebDriver driver;
    SignupPageDisplayAndEnable signup;
    SignupOperation operation;
    LoginPage login;

    @BeforeSuite
    public void setupDriver(){
        setDriver();
//        driver = getDriver();
        getDriver().get(Environment.URL);
        getDriver().manage().window().maximize();
        signup = new SignupPageDisplayAndEnable(getDriver());
        operation = new SignupOperation(getDriver());
        login = new LoginPage(getDriver());
    }

    //@Parameters("browserName")
    @BeforeTest
    @Deprecated
//    public void openBrowser()
//    {
//        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
    @Test(priority = 1)
    public void ClickRegister() throws InterruptedException {
        login.clickRegister();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void signupPage()
    {
        String text = signup.gettext();
        Assert.assertEquals(text,"Sign Up");
    }
    @Test(priority = 3)
    public void textFieldDisplay()
    {
        boolean name = signup.nameTextFieldDisplay();
        Assert.assertEquals(name,true);

        boolean email = signup.emailTextFieldDisplay();
        Assert.assertEquals(email,true);

        boolean userName = signup.userNameTextFieldDisplay();
        Assert.assertEquals(userName,true);

        boolean password = signup.passwordTextFieldDisplay();
        Assert.assertEquals(password,true);

        boolean cinformPassword = signup.confirmPasswordTextFieldDisplay();
        Assert.assertEquals(cinformPassword,true);

        boolean role = signup.roleTextFieldDisplay();
        Assert.assertEquals(role,true);
    }
    @Test(priority = 4)
    public void textFieldEnable()
    {
        boolean name = signup.nameTextFieldEnable();
        Assert.assertEquals(name,true);

        boolean email = signup.emailTextFieldEnable();
        Assert.assertEquals(email,true);

        boolean userName = signup.userNameTextFieldEnable();
        Assert.assertEquals(userName,true);

        boolean password = signup.passwordTextFieldEnable();
        Assert.assertEquals(password,true);

        boolean confirmPassword = signup.confirmPasswordTextFieldEnable();
        Assert.assertEquals(confirmPassword,true);

        boolean role = signup.roleTextFieldEnable();
        Assert.assertEquals(role,true);

    }

    @Test(priority = 5)
    public void Signup() throws InterruptedException {
        operation.userSignup();
        operation.HR();
//        operation.subjectExpert();
    }

    @Test(priority = 6)
    public void clickProfile()
    {
        login.clickProfile();
    }
    @Test(priority = 7)
    public void clickSignOut()
    {
        login.ClickSignOut();
    }


//    @AfterTest
//    public void closeBrowser()
//    {
//        try {
//            dr.terminate();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Not able to close the browser");
//        }
//    }

}
