package Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverPage {
    public static WebDriver driver;
    public static void setup(String browserName) {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/");
        }
        else if (browserName.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/");
        }
    }
    public static void terminate()
    {
        driver.close();
    }
}
