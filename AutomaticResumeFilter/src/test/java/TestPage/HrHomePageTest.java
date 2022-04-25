package TestPage;
import dataHandling.ReadingData;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import Page.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class HrHomePageTest {
    static WebDriver driver;

    static ReadingData data=new ReadingData();
    @BeforeTest
    private static void initialSetup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaharshavardhan\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
        driver.manage().window().maximize();
    }
//    @Test
//    private static void HrHomePage() throws InterruptedException, IOException {
//        HrHomePage subHome=new HrHomePage(driver);
//        subHome.login();
//        subHome.SortStartDate();
//        subHome.StartDateAsc();
//        subHome.StartDateDesc();
//        subHome.SortEndDate();
//        subHome.EndDateAsc();
//        subHome.EndDateDesc();
//        subHome.SortDate();
//        subHome.NameAsc();
//        subHome.NameDesc();
//
//    }
    @Test(priority = 1)
    public static void quizNotAdded() throws InterruptedException, IOException {
        HrHomePage hr=new HrHomePage(driver);
        String underProgressRecuriment1= data.getData(1,1,0);
        hr.login();
        String str= hr.underprogress(underProgressRecuriment1);
        try {
            Assert.assertEquals(str, "Email Sent Successfully.");
        }
        catch (AssertionError e){
            System.out.println("assertion error1");
        }
        hr.Home();
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public static void quizsentAlready() throws InterruptedException, IOException  {
        HrHomePage hr=new HrHomePage(driver);
        String underProgressRecuriment2= data.getData(1,2,0);
        String str= hr.underprogress(underProgressRecuriment2);
        try {
            Assert.assertEquals(str, "Already Sent Quiz");
        }
        catch (AssertionError e){
            System.out.println("assertion error2");
        }
        hr.Home();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public static void wrongTitle() throws InterruptedException, IOException  {
        HrHomePage hr=new HrHomePage(driver);
        String underProgressRecuriment3= data.getData(1,3,0);
        String str= hr.underprogress(underProgressRecuriment3);
        try {
            Assert.assertEquals(str, "Title not present");
        }
        catch (AssertionError e){
            System.out.println("assertion error3");
        }

    }
    @Test(priority = 4)
    public static void updateScores() throws InterruptedException, IOException  {
        HrHomePage hr=new HrHomePage(driver);
        String completedRecuriment1= data.getData(1,4,0);
        hr.completed(completedRecuriment1);
        hr.Home();
        Thread.sleep(5000);

    }
    @Test(priority = 5)
    public static void scoredownload() throws InterruptedException, IOException  {
        HrHomePage hr = new HrHomePage(driver);
        String completedRecuriment2= data.getData(1,5,0);
        hr.completed(completedRecuriment2);
        hr.Home();
        Thread.sleep(5000);
    }
    @Test(priority = 6)
    public static void hrNotAddedQuiz() throws InterruptedException, IOException  {
        HrHomePage hr = new HrHomePage(driver);
        String completedRecuriment3= data.getData(1,6,0);
       String str= hr.completed(completedRecuriment3);
        try {
            Assert.assertEquals(str, "Data can't be fetched as quiz was not uploaded by Expert and quiz not held.");
        }
        catch (AssertionError e){
            System.out.println("assertion error4");
        }
        hr.Home();
        Thread.sleep(5000);
    }
    @Test(priority = 7)
    public static void wrongRecuriment() throws InterruptedException, IOException  {
        HrHomePage hr=new HrHomePage(driver);
        String completedRecuriment4= data.getData(1,7,0);
        String str= hr.completed(completedRecuriment4);
        try {
            Assert.assertEquals(str, "Title not present");
        }
        catch (AssertionError e){
            System.out.println("assertion error5");
        }

    }
    @Test(priority = 8)
    public static void signout() throws InterruptedException {
        SubjectExperteHomePage subHome=new SubjectExperteHomePage(driver);
        subHome.signout();
        Thread.sleep(5000);
        subHome.close();
    }



}
