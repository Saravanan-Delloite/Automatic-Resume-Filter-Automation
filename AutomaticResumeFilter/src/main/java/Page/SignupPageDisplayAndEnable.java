package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPageDisplayAndEnable extends DriverPage {
    boolean name,email,userName,password,confirmPassword,role;
    public SignupPageDisplayAndEnable(WebDriver driver)
    {
        this.driver = driver;
    }

    static By register = By.xpath("//a[text()='Register now']");
    static By signup_Title = By.xpath("//div[@class='signup']");
    static By nameTextField = By.xpath("//*[text()='Name']/following-sibling::input");
    static By emailTextField = By.xpath("//*[text()='Email']/following-sibling::input");
    static By userNameTextField = By.xpath("//*[text()='User Name']/following-sibling::input");
    static By passwordTextField = By.xpath("//*[text()='Password']/following-sibling::input");
    static By confirmPasswordTextField = By.xpath("//*[text()='Confirm Password']/following-sibling::input");
    static By roleTextField = By.xpath("//select[@formcontrolname='role']");

    public SignupPageDisplayAndEnable() {
    }

    public void clickRegister()
    {
        driver.findElement(register).click();
    }

    public String gettext()
    {
        String text = driver.findElement(signup_Title).getText();       //Getting the Text of Signup Page
        System.out.println(text);
        return text;
    }
    public boolean nameTextFieldDisplay()
    {
        name = driver.findElement(nameTextField).isDisplayed();         //Checking if the name text field is Displaying
        return name;
    }

    public boolean emailTextFieldDisplay()
    {
        email =driver.findElement(emailTextField).isDisplayed();        //Checking if the email text field is Displaying
        return email;
    }
    public boolean userNameTextFieldDisplay()
    {
        userName =driver.findElement(userNameTextField).isDisplayed();  //Checking if the userName text field is Displaying
        return userName;
    }
    public boolean passwordTextFieldDisplay()
    {
        password =driver.findElement(passwordTextField).isDisplayed();  //Checking if the password text field is Displaying
        return password;
    }
    public boolean confirmPasswordTextFieldDisplay()
    {
        email =driver.findElement(confirmPasswordTextField).isDisplayed();  //Checking if the confirmation password text field is Displaying
        return email;
    }
    public boolean roleTextFieldDisplay()
    {
        role =driver.findElement(roleTextField).isDisplayed();  //Checking if the role text field is Displaying
        return role;
    }




    public boolean nameTextFieldEnable()
    {
        name = driver.findElement(nameTextField).isEnabled();   //Checking if the name text field is Enabled
        return name;
    }
    public boolean emailTextFieldEnable()
    {
        email = driver.findElement(emailTextField).isEnabled(); //Checking if the email text field is Enabled
        return email;
    }
    public boolean userNameTextFieldEnable()
    {
        userName = driver.findElement(userNameTextField).isEnabled();   //Checking if the UserName text field is Enabled
        return userName;
    }
    public boolean passwordTextFieldEnable()
    {
        password = driver.findElement(passwordTextField).isEnabled();   //Checking if the password text field is Enabled
        return password;
    }
    public boolean confirmPasswordTextFieldEnable()
    {
        confirmPassword = driver.findElement(confirmPasswordTextField).isEnabled(); //Checking if the conformation password text field is Enabled
        return confirmPassword;
    }
    public boolean roleTextFieldEnable()
    {
        role = driver.findElement(roleTextField).isEnabled();   //Checking if the role text field is Enabled
        return role;
    }

}
