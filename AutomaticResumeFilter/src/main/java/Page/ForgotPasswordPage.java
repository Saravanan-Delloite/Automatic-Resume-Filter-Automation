package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Enter email']")
    WebElement email;

    @FindBy(id = "sendotp")
    WebElement otp;

    @FindBy(xpath = "//a[@href='/login']")
    WebElement backtoLogin;

    public ForgotPasswordPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickBackToLogin()
    {
        backtoLogin.click();
    }
    public void EnterEmailId(String mailId)
    {
        email.sendKeys(mailId);
    }
    public void ClickSendOtp()
    {
        otp.click();
    }
}
