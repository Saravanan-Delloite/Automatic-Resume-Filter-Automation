package Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

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

    @FindBy(xpath = "//div[@id='dropdownMenuButton']")
    WebElement profile;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    WebElement signout;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void EnterUsername(String userid) {
        username.sendKeys(userid);
    }

    public void EnterPassword(String pswrd) {
        password.sendKeys(pswrd);
    }

    public void ClickLogin()
    {
        loginButton.click();
    }

    public ForgotPasswordPage ClickForgotPassword() {
        forgotPassword.click();
        return new ForgotPasswordPage(driver);
    }

    public void ClickRememberMe() {
        rememberPassword.click();
    }

    public String AssertTitle() {
        return driver.getTitle();
    }

    public String AssertUsername() {
        return username.getAttribute("value");
    }

    public String AssertPassword() {
        return password.getAttribute("value");
    }

    public boolean AssertLoginButton() {
        return loginButton.isEnabled();
    }

    public boolean AssertRememberMe() {
        return rememberPassword.isDisplayed();
    }

    public boolean AssertForgotPassword() {
        return forgotPassword.isDisplayed();
    }

    public boolean AssertRegister() {
        return signUpButton.isDisplayed();
    }

    public void clickProfile() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        profile.click();
    }

    public void ClickSignOut() {
        signout.click();
    }

    public void clickRegister()
    {
        signUpButton.click();
    }

}

