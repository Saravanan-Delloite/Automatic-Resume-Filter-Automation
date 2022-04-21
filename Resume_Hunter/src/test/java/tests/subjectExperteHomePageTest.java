package tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class subjectExperteHomePageTest {
    static WebDriver driver;
    @BeforeTest
    private static void initialSetup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaharshavardhan\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");

    }
    @Test
    private static void subjectExperteHomePage() throws InterruptedException, IOException {
        subjectExperteHomePage subHome=new subjectExperteHomePage(driver);
        subHome.login();
        subHome.countingNoOfRecuriment();
        subHome.sortByEndDate();
    }
}
