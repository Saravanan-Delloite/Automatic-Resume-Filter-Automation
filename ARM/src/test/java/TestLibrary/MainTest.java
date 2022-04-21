package TestLibrary;

import PageLibrary.DriverPage;
import PageLibrary.SignupPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest extends DriverPage {
    DriverPage dr = new DriverPage();
    SignupPage signup =new SignupPage(driver);
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

    boolean userName = signup.emailTextFieldEnable();
    Assert.assertEquals(userName,true);

    boolean password = signup.emailTextFieldEnable();
    Assert.assertEquals(password,true);

    boolean confirmPassword = signup.emailTextFieldEnable();
    Assert.assertEquals(confirmPassword,true);

    boolean role = signup.roleTextFieldEnable();
    Assert.assertEquals(role,true);

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
