
import POM.Xpath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddRecruitmentTest {
    public static void initial() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver",Xpath.ChromeDriverLoction);
        driver = new ChromeDriver();
        driver.get(Xpath.Website);
        driver.manage().window().maximize();
    }
    @Test
    public static void login()
    {

    }
}

