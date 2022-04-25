package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import java.io.IOException;

public class SignupOperation extends SignupPageDisplayAndEnable{
    static String skills;
    static PageLibrary.ReadingExcel excel = new PageLibrary.ReadingExcel();


    static By checkbox = By.xpath("//input[@type='checkbox']");
    static By skill = By.xpath("//input[@placeholder='Enter Categories']");
    static By letsgo = By.xpath("//button[@type='submit']");
    static By dropdown = By.xpath("//div[@id='dropdownMenuButton']");
    static By logout = By.xpath("//a[@class='dropdown-item']");
    static By Register = By.xpath("//a[text()='Register now']");


    public SignupOperation(WebDriver driver){
        this.driver=driver;
        excel.read();
    }
    public static void userSignupHR() throws InterruptedException {
        String name = excel.sheet.getRow(1).getCell(0).getStringCellValue();
        driver.findElement(nameTextField).sendKeys(name);
        String email = excel.sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(emailTextField).sendKeys(email);
        String userName = excel.sheet.getRow(1).getCell(2).getStringCellValue();
        driver.findElement(userNameTextField).sendKeys(userName);
        int password = (int) excel.sheet.getRow(1).getCell(3).getNumericCellValue();
        String password1 = Integer.toString(password);
        driver.findElement(passwordTextField).sendKeys(password1);
        String pass = driver.findElement(passwordTextField).getText();
        int confirmPassword = (int) excel.sheet.getRow(1).getCell(4).getNumericCellValue();
        String confirmPassword1 = Integer.toString(confirmPassword);
        driver.findElement(confirmPasswordTextField).sendKeys(confirmPassword1);
        String confirmpass=driver.findElement(confirmPasswordTextField).getText();
        if(pass==confirmpass)
        {
            System.out.println("Password is matched");
        }
        else
        {
            System.out.println("password is Not matched");
        }
    }
    public void HR()
    {
        WebElement element=driver.findElement(roleTextField);
        Select hr=new Select(element);
        hr.selectByValue("HR");
        try {
            Thread.sleep(3000);
            driver.findElement(checkbox).click();
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        driver.findElement(letsgo).click();
        driver.findElement(dropdown).click();
        driver.findElement(logout).click();
        driver.findElement(Register).click();
    }
    public void userSignupSubjectExpert()
    {
        String name = excel.sheet.getRow(2).getCell(0).getStringCellValue();
        driver.findElement(nameTextField).sendKeys(name);
        String email = excel.sheet.getRow(2).getCell(1).getStringCellValue();
        driver.findElement(emailTextField).sendKeys(email);
        String userName = excel.sheet.getRow(2).getCell(2).getStringCellValue();
        driver.findElement(userNameTextField).sendKeys(userName);
        int password = (int) excel.sheet.getRow(2).getCell(3).getNumericCellValue();
        String password1 = Integer.toString(password);
        driver.findElement(passwordTextField).sendKeys(password1);
        int confirmPassword = (int) excel.sheet.getRow(2).getCell(4).getNumericCellValue();
        String confirmPassword1 = Integer.toString(confirmPassword);
        driver.findElement(confirmPasswordTextField).sendKeys(confirmPassword1);
        skills = excel.sheet.getRow(2).getCell(5).getStringCellValue();
    }
    public void subjectExpert() throws InterruptedException {
        WebElement element=driver.findElement(roleTextField);
        Select subjectExp=new Select(element);
        subjectExp.selectByValue("Subject Expert");
        try {
            driver.findElement(skill).sendKeys(skills);
            Thread.sleep(3000);
            WebElement iAgree = driver.findElement(checkbox);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", iAgree);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(3000);
        WebElement clicksignup = driver.findElement(letsgo);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", clicksignup);
        driver.findElement(dropdown).click();
        driver.findElement(logout).click();
    }
}
