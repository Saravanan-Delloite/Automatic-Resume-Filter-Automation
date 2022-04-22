package TestPage;
import org.testng.annotations.BeforeTest;
import Page.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class HrHomePageTest {
    static WebDriver driver;
    @BeforeTest
    private static void initialSetup(){

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");

    }
    @Test
    private static void HrHomePage() throws InterruptedException, IOException {
        HrHomePage subHome=new HrHomePage(driver);
        subHome.login();
        subHome.SortStartDate();
        subHome.StartDateAsc();
        subHome.StartDateDesc();
        subHome.SortEndDate();
        subHome.EndDateAsc();
        subHome.EndDateDesc();
        subHome.SortDate();
        subHome.NameAsc();
        subHome.NameDesc();

    }
}
