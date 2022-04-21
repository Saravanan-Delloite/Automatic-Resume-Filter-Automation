package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddQuizPage;

import java.util.concurrent.TimeUnit;

public class AddQuizTest {

    AddQuizPage addQuizPage;
    WebDriver driver;

    @BeforeClass
    public void initialSetup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\karthikck\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
    }

    @Test
    public void addQuiz() throws InterruptedException {
        addQuizPage = new AddQuizPage(driver);
        addQuizPage.login("expert","expert@123");
        addQuizPage.addQuizDetails("www.google.com", "03/12/2020", "01:00", "5");
        driver.close();
    }

}
