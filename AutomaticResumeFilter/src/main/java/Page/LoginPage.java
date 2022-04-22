package Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//title[text()='ResumeFrontEnd']")
    WebElement title;

    @FindBy(id = "emailAddress")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@href='/signup']")
    WebElement signUpButton;

    @FindBy(xpath = "//a[@href='/forgotpassword']")
    WebElement forgotPassword;

    @FindBy(id = "rememberPasswordCheck")
    WebElement rememberPassword;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void EnterUsername(String userid)
    {
        username.sendKeys(userid);
    }
    public void EnterPassword(String pswrd)
    {
        password.sendKeys(pswrd);
    }
    public void ClickLogin()
    {
        loginButton.click();
    }
    public ForgotPasswordPage ClickForgotPassword()
    {
        forgotPassword.click();
        return new ForgotPasswordPage(driver);
    }
    public void ClickRememberMe()
    {
        rememberPassword.click();
    }
}

