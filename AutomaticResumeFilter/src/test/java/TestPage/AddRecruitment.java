package TestPage;

import Page.AddRecruitmentPage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import static Page.AddRecruitmentPage.*;

public class AddRecruitment
{
    static WebDriver driver;
    static JavascriptExecutor jse;
    static XSSFSheet sheet;
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
    public void selectItems() throws Exception
    {
        Thread.sleep(500);
        sendValues(Recruitment_Name,"");
        Thread.sleep(500);
        sendValues(recruit_Category,"");
        Thread.sleep(500);
        sendValues(Skill,"");
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,800)");
        Thread.sleep(250);
        sendValues(Expert,"");
        Thread.sleep(300);
        sendValues(Start_Date,"");
        Thread.sleep(300);
        sendValues(End_Date,"");
        Thread.sleep(300);
        clickListElem(Reset_Button);
        /*System.out.println("hlo");*/
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,-800)");
    }
    @Test
    public void sendItems() throws Exception
    {
        initalizeXlsheet();
        Thread.sleep(500);
        sendValues(Recruitment_Name, String.valueOf(sheet.getRow(1).getCell(0)));
        Thread.sleep(500);
        sendValues(recruit_Category,String.valueOf(sheet.getRow(1).getCell(1)));
        Thread.sleep(500);
        sendValues(Skill,String.valueOf(sheet.getRow(1).getCell(2)));
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,850)");
        Thread.sleep(250);
        selectListElem(Expert,String.valueOf(sheet.getRow(1).getCell(3)));
        Thread.sleep(300);
        sendValues(Start_Date,String.valueOf(sheet.getRow(1).getCell(4)));
        Thread.sleep(300);
        sendValues(End_Date,String.valueOf(sheet.getRow(1).getCell(5)));
        Thread.sleep(300);
        sendValues(Upload_Resume,"C:\\Users\\ksaravanakumar\\Documents\\Automatic-Resume-Filter-Automation\\AutomaticResumeFilter\\src\\resources\\Resumes.zip");
    }
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
    public void clickListElem(By userRole)
    {
        driver.findElement(userRole).click();

    }
    public void initalizeXlsheet() throws Exception
    {
        FileInputStream fs = new FileInputStream("C:\\Users\\ksaravanakumar\\Documents\\Automatic-Resume-Filter-Automation\\AutomaticResumeFilter\\src\\resources\\RecuitmentData.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        sheet = workbook.getSheetAt(0);
    }

}
