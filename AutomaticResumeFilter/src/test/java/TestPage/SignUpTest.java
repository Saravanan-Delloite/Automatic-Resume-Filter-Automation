package TestPage;

import Page.*;
//import PageLibrary.SignupOperation;
import Utilities.Environment;
import Utilities.ListenerForExtentReport;
import org.testng.Assert;
import org.testng.annotations.*;

import static Utilities.SetupDriver.*;

import java.util.concurrent.TimeUnit;
@Listeners(ListenerForExtentReport.class)


public class SignUpTest {

    SignupPageDisplayAndEnable signup;
    SignupOperation operation;
    @BeforeSuite
    public void setup() {
        setDriver();
        getDriver().get(Environment.URL);
        getDriver().manage().window().maximize();

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
        String text = signup.gettext();
        Assert.assertEquals(text,"Sign Up");
    }
    @Test(priority = 2)
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
    @Test(priority = 3)
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

    @Test(priority = 4)
    public void SignupHR() throws InterruptedException {
        operation.userSignupHR();
        operation.HR();
        Thread.sleep(3000);
    }
    @Test(priority = 5)
    public void SignupSubExp() throws InterruptedException {
        operation.userSignupSubjectExpert();
        operation.subjectExpert();
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
