package TestPage;
///
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.time.Duration;

import static Page.AddRecruitmentPage.*;

public class AddRecruitment
{
    static WebDriver driver;
    static JavascriptExecutor jse;
    //
    static XSSFSheet sheet;
    @BeforeClass
    public void initialSetup() throws Exception
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
        login("saran123","Admin123");
        driver.findElement(Add_recruitment_Page_Btn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void login(String username, String password) {
        driver.findElement(username_box).sendKeys(username);
        driver.findElement(password_box).sendKeys(password);
        driver.findElement(loginBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test(priority = 1)
    public void selectRecruitmentName()
    {
        jse = (JavascriptExecutor)driver;
        sendValues(Recruitment_Name,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test(priority = 2)
    public void selectCategory()
    {
        sendValues(recruit_Category,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    //
    @Test(priority = 3)
    public void SelectSkills()
    {
        sendValues(Skill,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test(priority = 4)
    public void AssertNameandCategory()
    {
        Assert.assertTrue(driver.findElement(Recruitment_Name_Warning).isDisplayed());
        Assert.assertTrue(driver.findElement(Category_Warning).isDisplayed());
        jse.executeScript("window.scrollBy(0,850)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    //
    @Test(priority = 5)
    public void selectExpert()
    {
        sendValues(Expert,"");
    }
    @Test(priority = 6)
    public void checkSkillWarning()
    {
        Assert.assertTrue(driver.findElement(Skill_Warning).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    //
    @Test(priority = 7)
    public void selectStartDate()
    {
        sendValues(Start_Date,"");
    }
    @Test(priority = 8)
    public void checkExpertWarning()
    {
        Assert.assertTrue(driver.findElement(Expertee_Warning).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test(priority = 9)
    public void selectEndDate()
    {
        sendValues(End_Date,"");
    }
    @Test(priority = 10)
    public void checkStartDateWarning()
    {
        Assert.assertTrue(driver.findElement(Start_DateWarning).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sendValues(Start_Date,"");
    }
    @Test (priority = 11)
    public void checkEndDateWarning()
    {
        Assert.assertTrue(driver.findElement(End_Date_Warning).isDisplayed());
        jse.executeScript("window.scrollBy(0,-850)");
    }
    @Test(priority = 12)
    public void sendItems() throws Exception
    {
        initalizeXlsheet();
        jse = (JavascriptExecutor)driver;
        Thread.sleep(500);
        sendValues(Recruitment_Name, String.valueOf(sheet.getRow(1).getCell(0)));
        System.out.println(driver.findElement(Recruitment_Name).getText());
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
        Thread.sleep(300);
        driver.findElement(Add_Recruitment_Btn).click();
        Thread.sleep(10000);
    }
    public void selectListElem(By userRole,String role)
    {
        WebElement webDropdown = driver.findElement(userRole);
        Select dropdown = new Select(webDropdown);
        dropdown.selectByVisibleText(role);
    }
    public void sendValues(By locator,String data)
    {
        driver.findElement(locator).sendKeys(data);
    }
    public void initalizeXlsheet() throws Exception
    {
        FileInputStream fs = new FileInputStream("src/resources/RecuitmentData.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        sheet = workbook.getSheetAt(0);
    }

}
