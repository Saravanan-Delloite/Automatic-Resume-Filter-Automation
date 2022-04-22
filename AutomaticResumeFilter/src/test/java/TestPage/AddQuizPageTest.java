package TestPage;

import Page.AddQuizPage;
import dataHandling.ReadDataFromExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddQuizPageTest {
    ReadDataFromExcel readDataFromExcel=new ReadDataFromExcel();
    AddQuizPage addQuizPage;
    WebDriver driver;

    @BeforeClass
    public void initialSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\karthikck\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");

    }

    @Test(priority = 1)
    public void addQuiz() throws InterruptedException, IOException {
        addQuizPage = new AddQuizPage(driver);
        addQuizPage.login("expert","expert@123");
        Thread.sleep(5000);
        String link = readDataFromExcel.sendData(1, 0);
        String date = (readDataFromExcel.sendData(1, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(1, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(1, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }

    @Test(priority = 2)
    public void addQuizInvalidUrl1() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(2, 0).replace("\"","");
        String date = (readDataFromExcel.sendData(2, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(2, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(2, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();


    }

    @Test(priority = 3)
    public void addQuizInvalidUrl2() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(3, 0);
        String date = (readDataFromExcel.sendData(3, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(3, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(3, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }

    @Test(priority = 4)
    public void addQuizInvalidTime1() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(4, 0);
        String date = (readDataFromExcel.sendData(4, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(4, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(4, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();


    }

    @Test(priority = 5)
    public void addQuizInvalidTime2() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(5, 0);
        String date = (readDataFromExcel.sendData(5, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(5, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(5, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }

    @Test(priority = 6)
    public void addQuizInvalidTime3() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(6, 0);
        String date = (readDataFromExcel.sendData(6, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(6, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(6, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }

    @Test(priority = 7)
    public void addQuizInvalidTime4() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(7, 0);
        String date = (readDataFromExcel.sendData(7, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(7, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(7, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }

    @Test(priority = 8)
    public void addQuizInvalidQuestions1() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(8, 0);
        String date = (readDataFromExcel.sendData(8, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(8, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(8, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }

    @Test(priority = 9)
    public void addQuizInvalidQuestions2() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(9, 0);
        String date = (readDataFromExcel.sendData(9, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(9, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(9, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }

    @Test(priority = 10)
    public void addQuizInvalidQuestions3() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        String link = readDataFromExcel.sendData(10, 0);
        String date = (readDataFromExcel.sendData(10, 1)).replace("\"","");
        String time= readDataFromExcel.sendData(10, 2).replace("\"","");
        String questions = readDataFromExcel.sendData(10, 3).replace("\"","");
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizDetails(link, date, time, questions);
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }

    @Test(priority = 10)
    public void addQuizInvalidEntries() throws InterruptedException, IOException {
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage = new AddQuizPage(driver);
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
        addQuizPage.addQuizEmptyDetails();
        Thread.sleep(5000);
        addQuizPage.clickHomeBtn();
    }
}
