package TestPage;

import Page.AddQuizPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddQuizPageTest {
   // ReadDataFromExcel readDataFromExcel=new ReadDataFromExcel();
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
    public void addQuiz() throws InterruptedException, IOException {
        addQuizPage = new AddQuizPage(driver);
        addQuizPage.login("expert","expert@123");
        String link = readDataFromExcel.sendData(1, 0);
        String date = (readDataFromExcel.sendData(1, 1));
        String time= readDataFromExcel.sendData(1, 2);
        String questions = readDataFromExcel.sendData(1, 3);
        addQuizPage.addQuizDetails(link, date, time, questions);
        driver.close();
    }
}
