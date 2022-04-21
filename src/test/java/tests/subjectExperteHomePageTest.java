package tests;
import pages.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class subjectExperteHomePageTest {
    @Test
    private static void test1() throws InterruptedException, IOException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaharshavardhan\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
        subjectExperteHomePage subHome=new subjectExperteHomePage(driver);
        subHome.login();
        subHome.countingNoOfRecuriment();
        subHome.sortByEndDate();
    }
}
