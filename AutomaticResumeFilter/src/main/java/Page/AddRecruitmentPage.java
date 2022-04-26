package Page;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.FileInputStream;
import java.time.Duration;

public class AddRecruitmentPage
{
    WebDriver driver;
    static XSSFSheet sheets;
    static JavascriptExecutor jse;
    public AddRecruitmentPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public static By Add_recruitment_Page_Btn=By.xpath("//*[contains(text(),'Add recruitment')]");
    public static By Recruitment_Name=By.id("inputName");
    public static By recruit_Category=By.id("inputEmail");
    public static By Skill=By.id("inputSkills");
    public static By Expert=By.id("expert");
    public static By Start_Date=By.id("inputStartDate");
    public static By End_Date=By.id("inputEndDate");
    public static By Reset_Button=By.xpath("//*[contains(text(),'Reset')]");
    public static By Upload_Resume=By.id("resumes");
    public static By Add_Recruitment_Btn=By.xpath("//button[@class='btn btn-warning']");
    public static By Recruitment_Name_Warning=By.xpath("//*[contains(text(),' Recruitment name is required')]");
    public static By Category_Warning=By.xpath("//*[contains(text(),' Category is required. ')]");
    public static By Skill_Warning=By.xpath("//*[contains(text(),' Skills are required to compare with Resume skills. ')]");
    public static By Expertee_Warning=By.xpath("//*[contains(text(),' Assigning an Expert is required ')]");
    public static By Start_DateWarning=By.xpath("//*[contains(text(),' Start Date is required. ')]");
    public static By End_Date_Warning=By.xpath("//*[contains(text(),' End Date is required. ')]");
    public static By Zip_File_Warning=By.xpath("//*[contains(text(),'Reset')]");

    public void initialSetup() throws Exception
    {
        /*System.setProperty("webdriver.chrome.driver","C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");*/
        driver.findElement(Add_recruitment_Page_Btn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void selectRecruitmentName()
    {
        jse = (JavascriptExecutor)driver;
        sendValues(Recruitment_Name,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sendValues(recruit_Category,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sendValues(Skill,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
   public boolean assertName()
   {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       return driver.findElement(Recruitment_Name_Warning).isDisplayed();
   }
    public boolean assertCategory()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(Category_Warning).isDisplayed();
    }
    public  boolean checkSkillWarning()
    {
        jse.executeScript("window.scrollBy(0,850)");
        sendValues(Expert,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(Skill_Warning).isDisplayed();
    }
    public boolean checkExpertWarning()
    {
        sendValues(Start_Date,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(Expertee_Warning).isDisplayed();
    }

    public  boolean checkStartDateWarning()
    {
        sendValues(End_Date,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(Start_DateWarning).isDisplayed();
    }
    public  boolean checkEndDateWarning()
    {
        sendValues(Start_Date,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(End_Date_Warning).isEnabled();
    }
    public boolean checkResetBtn()
    {
        return driver.findElement(Reset_Button).isEnabled();
    }
    public  void sendItems() throws Exception
    {
        jse.executeScript("window.scrollBy(0,-850)");
        initalizeXlsheet();
        Thread.sleep(500);
        sendValues(Recruitment_Name, String.valueOf(sheets.getRow(1).getCell(0)));
        System.out.println(driver.findElement(Recruitment_Name).getText());
        Thread.sleep(500);
        sendValues(recruit_Category,String.valueOf(sheets.getRow(1).getCell(1)));
        Thread.sleep(500);
        sendValues(Skill,String.valueOf(sheets.getRow(1).getCell(2)));
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,850)");
        Thread.sleep(500);
        selectListElem(Expert,String.valueOf(sheets.getRow(1).getCell(3)));
        Thread.sleep(300);
        sendValues(Start_Date,String.valueOf(sheets.getRow(1).getCell(4)));
        Thread.sleep(300);
        sendValues(End_Date,String.valueOf(sheets.getRow(1).getCell(5)));
        Thread.sleep(300);
        sendValues(Upload_Resume,"C:\\Users\\ksaravanakumar\\Documents\\Automatic-Resume-Filter-Automation\\AutomaticResumeFilter\\src\\resources\\Resumes.zip");
        Thread.sleep(5000);
        /*jse.executeScript("window.scrollBy(0,850)");*/
    }
    public boolean checkRecuitmentBtn()
    {
        return driver.findElement(Add_Recruitment_Btn).isEnabled();
    }
    public void clickAddRecruitmentBtn() throws Exception
    {
        WebElement add_Recruitment = driver.findElement(Add_Recruitment_Btn);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", add_Recruitment);
        Thread.sleep(6000);
    }
    public  void selectListElem(By userRole,String role)
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
        FileInputStream fs = new FileInputStream("AutomaticResumeFilter/src/resources/RecuitmentData.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        sheets = workbook.getSheetAt(0);
    }
    public void getText(By locator)
    {
        driver.findElement(locator).getAttribute("textContent");
    }
}
