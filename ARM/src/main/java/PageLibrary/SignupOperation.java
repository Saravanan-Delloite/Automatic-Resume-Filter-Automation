package PageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class SignupOperation extends SignupPageDisplayAndEnable{
    static ReadingExcel excel = new ReadingExcel();


    static By checkbox = By.xpath("//input[@type='checkbox']");
    static By skill = By.xpath("//input[@placeholder='Enter Categories']");
    static By letsgo = By.xpath("//button[@type='submit']");

    public SignupOperation(WebDriver driver)  {
        this.driver=driver;
        excel.readData();
    }
    public static void userSignup() throws InterruptedException {
        String name = excel.getName();
        driver.findElement(nameTextField).sendKeys(name);
        Thread.sleep(2000);
        String email = excel.getEmail();
        driver.findElement(emailTextField).sendKeys(email);
        Thread.sleep(2000);
        String userName = excel.getUsername();
        driver.findElement(userNameTextField).sendKeys(userName);
        Thread.sleep(2000);
        int password = excel.getPassword();
        String password1 = Integer.toString(password);
        driver.findElement(passwordTextField).sendKeys(password1);
        Thread.sleep(2000);
        int confirmPassword = excel.getConfirmPassword();
        String confirmPassword1 = Integer.toString(confirmPassword);
        driver.findElement(confirmPasswordTextField).sendKeys(confirmPassword1);
        Thread.sleep(2000);
    }
        public void HR()
        {
        WebElement element=driver.findElement(roleTextField);
        Select hr=new Select(element);
        hr.selectByValue("HR");
        try {
            driver.findElement(checkbox).click();
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        driver.findElement(letsgo).click();
    }
    public void subjectExpert()
    {
        String skills = excel.getSkills();
        WebElement element=driver.findElement(roleTextField);
        Select subjectExp=new Select(element);
        subjectExp.selectByValue("Subject Expert");
        try {
            driver.findElement(skill).sendKeys(skills);
            driver.findElement(checkbox).click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement(letsgo).click();
    }
}
