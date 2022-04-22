package TestPage;

import Page.AddRecruitmentPage;
import jdk.jfr.Category;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static Page.AddRecruitmentPage.*;

public class AddRecruitment
{
    static WebDriver driver;
    static JavascriptExecutor jse;
    AddRecruitmentPage add=new AddRecruitmentPage();
    @Test
    public void initialSetup() throws Exception
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
        login("saran123","Admin123");
        driver.findElement(Add_recruitment_Page_Btn).click();
        Thread.sleep(1500);
        jse = (JavascriptExecutor)driver;

    }
    public static void login(String username, String password) throws InterruptedException {
        driver.findElement(username_box).sendKeys(username);
        driver.findElement(password_box).sendKeys(password);
        driver.findElement(loginBtn).click();
        Thread.sleep(3000);
    }
    @Test
    public void operations() throws Exception
    {
        Thread.sleep(1000);
        sendValues(Recruitment_Name,"");
        Thread.sleep(1000);
        sendValues(recruit_Category,"");
        Thread.sleep(500);
        sendValues(Skill,"");
        Thread.sleep(500);
        jse.executeScript("");
        Thread.sleep(250);
        selectListElem(Expert,"");
        Thread.sleep(300);
        sendValues(Start_Date,"");
        Thread.sleep(300);
        sendValues(End_Date,"");
        Thread.sleep(300);
        System.out.println("hlo");
    }
    /*@Test
    public void operations() throws Exception
    {
        Thread.sleep(1000);
        sendValues(Recruitment_Name,"hi");
        Thread.sleep(1000);
        sendValues(recruit_Category,"Dev");
        Thread.sleep(500);
        sendValues(Skill,"css,java");
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(250);
        selectListElem(Expert," vinay - Frontend ");
        Thread.sleep(300);
        sendValues(Start_Date,"04232022");
        Thread.sleep(300);
        sendValues(End_Date,"04262022");
        Thread.sleep(300);
    }*/
    public void selectListElem(By userRole,String role)
    {
        WebElement webDropdown = driver.findElement(userRole);
        Select dropdown = new Select(webDropdown);
        //dropdown.selectByValue(role);
        dropdown.selectByVisibleText(role);
    }
    public void sendValues(By locator,String data)
    {
        driver.findElement(locator).sendKeys(data);
    }

}
