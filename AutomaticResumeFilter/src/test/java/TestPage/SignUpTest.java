package TestPage;

import Page.*;
//import PageLibrary.SignupOperation;
import Utilities.Environment;
import Utilities.ListenerForExtentReport;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import static Utilities.SetupDriver.*;

import java.util.concurrent.TimeUnit;
@Listeners(ListenerForExtentReport.class)


public class SignUpTest {
    Logger logger = Logger.getLogger(SignUpTest.class);
    SignupPageDisplayAndEnable signup;
    SignupOperation operation;
    @BeforeSuite
    public void setup() {
        setDriver();
        getDriver().get(Environment.URL);
        getDriver().manage().window().maximize();
        logger.info("Opening Browser and Maximizing It");
        signup =new SignupPageDisplayAndEnable(getDriver());
        operation= new SignupOperation(getDriver());
    }




    //@Parameters("browserName")
    @BeforeTest
    @Deprecated
    public void openBrowser()
    {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void signupPage()
    {
        signup.clickRegister();
        logger.info("Clicking the Signup Link");
        String text = signup.gettext();
        Assert.assertEquals(text,"Sign Up");
    }
    @Test(priority = 2)
    public void textFieldDisplay()
    {
        boolean name = signup.nameTextFieldDisplay();
        Assert.assertEquals(name,true);
        logger.info("Checking Name Field is Displayed");

        boolean email = signup.emailTextFieldDisplay();
        Assert.assertEquals(email,true);
        logger.info("Checking email Field is Displayed");

        boolean userName = signup.userNameTextFieldDisplay();
        Assert.assertEquals(userName,true);
        logger.info("Checking userName Field is Displayed");

        boolean password = signup.passwordTextFieldDisplay();
        Assert.assertEquals(password,true);
        logger.info("Checking password Field is Displayed");

        boolean confirmPassword = signup.confirmPasswordTextFieldDisplay();
        Assert.assertEquals(confirmPassword,true);
        logger.info("Checking confirm password Field is Displayed");

        boolean role = signup.roleTextFieldDisplay();
        Assert.assertEquals(role,true);
        logger.info("Checking role Field is Displayed");
    }
    @Test(priority = 3)
    public void textFieldEnable()
    {
        boolean name = signup.nameTextFieldEnable();
        Assert.assertEquals(name,true);
        logger.info("Checking Name Field is Enable");

        boolean email = signup.emailTextFieldEnable();
        Assert.assertEquals(email,true);
        logger.info("Checking email Field is Enable");

        boolean userName = signup.userNameTextFieldEnable();
        Assert.assertEquals(userName,true);
        logger.info("Checking userName Field is Enable");

        boolean password = signup.passwordTextFieldEnable();
        Assert.assertEquals(password,true);
        logger.info("Checking password Field is Enable");

        boolean confirmPassword = signup.confirmPasswordTextFieldEnable();
        Assert.assertEquals(confirmPassword,true);
        logger.info("Checking confirm password Field is Enable");

        boolean role = signup.roleTextFieldEnable();
        Assert.assertEquals(role,true);
        logger.info("Checking role Field is Enable");

    }

    @Test(priority = 4)
    public void SignupHR() throws InterruptedException {
        operation.userSignupHR();
        operation.HR();
        logger.info("User signed in as HR");
        Thread.sleep(3000);
    }
    @Test(priority = 5)
    public void SignupSubExp() throws InterruptedException {
        operation.userSignupSubjectExpert();
        operation.subjectExpert();
        logger.info("User signed in as Subject Expert");
        Thread.sleep(3000);
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
