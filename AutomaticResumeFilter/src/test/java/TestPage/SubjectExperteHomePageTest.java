package TestPage;

import Page.SubjectExperteHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;



public class SubjectExperteHomePageTest {
    static WebDriver driver;
    @BeforeTest
    private static void initialSetup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaharshavardhan\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
        driver.manage().window().maximize();

    }
    @Test
    private static void subjectExperteHomePage() throws InterruptedException, IOException {
        SubjectExperteHomePage subHome=new SubjectExperteHomePage(driver);
        subHome.login("admin123","admin123");
//        subHome.countingNoOfRecuriment();
        //subHome.sortByNameInAscending();
//      subHome.sortByNameInDescedning();
//       subHome.quizadding();
//       subHome.signout();
        subHome.underprogress();
        subHome.Home();
        subHome.completed();
        subHome.close();
    }
}
