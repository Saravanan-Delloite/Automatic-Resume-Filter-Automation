package TestLibrary;

import PageLibrary.DriverPage;
//import PageLibrary.SignupOperation;
import PageLibrary.SignupOperation;
import PageLibrary.SignupPageDisplayAndEnable;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainTest extends DriverPage {
    DriverPage dr = new DriverPage();
    SignupPageDisplayAndEnable signup =new SignupPageDisplayAndEnable(driver);
    SignupOperation operation= new SignupOperation(driver);



    //@Parameters("browserName")
@BeforeTest
@Deprecated
    public void openBrowser()
{
    dr.setup("chrome");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test(priority = 1)
    public void signupPage()
{
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
public void Signup() throws InterruptedException {
    operation.userSignup();
//    operation.HR();
    operation.subjectExpert();
}


@AfterTest
    public void closeBrowser()
{
    try {
        dr.terminate();
    }
    catch (Exception e)
    {
        System.out.println("Not able to close the browser");
    }
}

}
