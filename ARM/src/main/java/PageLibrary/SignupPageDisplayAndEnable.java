package PageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPageDisplayAndEnable extends DriverPage {
    boolean name,email,userName,password,confirmPassword,role;
    public SignupPageDisplayAndEnable(WebDriver driver)
    {
        this.driver = driver;
    }

    By signup_Title = By.xpath("//div[@class='signup']");
    By nameTextField = By.xpath("//*[text()='Name']/following-sibling::input");
    By emailTextField = By.xpath("//*[text()='Email']/following-sibling::input");
    By userNameTextField = By.xpath("//*[text()='User Name']/following-sibling::input");
    By passwordTextField = By.xpath("//*[text()='Password']/following-sibling::input");
    By confirmPasswordTextField = By.xpath("//*[text()='Confirm Password']/following-sibling::input");
    By roleTextField = By.xpath("//select[@formcontrolname='role']");

    public String gettext()
    {
        String text = driver.findElement(signup_Title).getText();
        System.out.println(text);
        return text;
    }

    public boolean nameTextFieldDisplay()
    {
        name = driver.findElement(nameTextField).isDisplayed();
        return name;
    }

    public boolean emailTextFieldDisplay()
    {
        email =driver.findElement(emailTextField).isDisplayed();
        return email;
    }
    public boolean userNameTextFieldDisplay()
    {
        userName =driver.findElement(userNameTextField).isDisplayed();
        return userName;
    }
    public boolean passwordTextFieldDisplay()
    {
        password =driver.findElement(passwordTextField).isDisplayed();
        return password;
    }
    public boolean confirmPasswordTextFieldDisplay()
    {
        email =driver.findElement(confirmPasswordTextField).isDisplayed();
        return email;
    }
    public boolean roleTextFieldDisplay()
    {
        role =driver.findElement(roleTextField).isDisplayed();
        return role;
    }




    public boolean nameTextFieldEnable()
    {
        name = driver.findElement(nameTextField).isEnabled();
        return name;
    }
    public boolean emailTextFieldEnable()
    {
        email = driver.findElement(nameTextField).isEnabled();
        return email;
    }
    public boolean userNameTextFieldEnable()
    {
        userName = driver.findElement(nameTextField).isEnabled();
        return userName;
    }
    public boolean passwordTextFieldEnable()
    {
        password = driver.findElement(nameTextField).isEnabled();
        return password;
    }
    public boolean confirmPasswordTextFieldEnable()
    {
        confirmPassword = driver.findElement(nameTextField).isEnabled();
        return confirmPassword;
    }
    public boolean roleTextFieldEnable()
    {
        role = driver.findElement(nameTextField).isEnabled();
        return role;
    }

}
