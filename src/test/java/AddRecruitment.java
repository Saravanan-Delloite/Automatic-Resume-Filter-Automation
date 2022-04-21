import POM.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;


public class AddRecruitment
{
    static WebDriver driver;
    @Test
    public static void initial()
    {
        System.setProperty("webdriver.chrome.driver", Xpath.ChromeDriverLoction);
        driver = new ChromeDriver();
        driver.get(Xpath.Website);
        driver.manage().window().maximize();
    }
    @Test
    public static void login()
    {
        driver.findElement(By.id("emailAddress")).sendKeys("saran123");
        driver.findElement(By.id("password")).sendKeys("Admin123");
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div/div/div/div/form/div[4]/button")).click();
    }
    @Test(priority = 3)
    public static void addrecfucntionalites() throws Exception
    {
        File RecruitmentData=new File("xlas.xmls");
        FileInputStream Input=new FileInputStream(RecruitmentData);
        driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a"));
        driver.findElement(By.id("inputName")).sendKeys("");
    }
}
