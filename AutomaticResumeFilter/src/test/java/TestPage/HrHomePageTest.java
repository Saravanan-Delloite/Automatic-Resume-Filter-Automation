package TestPage;
import Utilities.ListenerForExtentReport;
import dataHandling.ReadingData;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import Page.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Utilities.SetupDriver.*;

import java.io.IOException;
@Listeners(ListenerForExtentReport.class)

public class HrHomePageTest {
//    static WebDriver driver;
    HrHomePage subHome;
    HrHomePage hr;
    static ReadingData data=new ReadingData();
    @BeforeTest
    private void initialSetup(){

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaharshavardhan\\Downloads\\chromedriver.exe");
//        driver=new ChromeDriver();
//        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
//        driver.manage().window().maximize();
        subHome=new HrHomePage(getDriver());
        hr=new HrHomePage(getDriver());
    }
    @Test(priority = 1)
    private void HrHomePage() throws InterruptedException, IOException {
//        HrHomePage subHome=new HrHomePage(driver);
        subHome.SortStartDate();
        subHome.StartDateAsc();
        subHome.StartDateDesc();
        subHome.SortEndDate();
        subHome.EndDateAsc();
        subHome.EndDateDesc();
        subHome.SortDate();
        subHome.NameAsc();
        subHome.NameDesc();
//        subHome.signout();

    }
    @Test(priority = 2)
    public void quizNotAdded() throws InterruptedException, IOException {
        //HrHomePage hr=new HrHomePage(driver);
        String underProgressRecuriment1= data.getData(1,1,0);
        String str= hr.underprogress(underProgressRecuriment1);
        try {
            Assert.assertEquals(str, "Email Sent Successfully.");
        }
        catch (AssertionError e){
            System.out.println("assertion error1");
        }
        hr.Home();
        Thread.sleep(3000);
    }
    @Test(priority = 3)
    public void quizsentAlready() throws InterruptedException, IOException  {
       // HrHomePage hr=new HrHomePage(driver);
        String underProgressRecuriment2= data.getData(1,2,0);
        String str= hr.underprogress(underProgressRecuriment2);
        try {
            Assert.assertEquals(str, "Already Sent Quiz");
        }
        catch (AssertionError e){
            System.out.println("assertion error2");
        }
        hr.Home();
        Thread.sleep(3000);
    }
    @Test(priority = 4)
    public void wrongTitle() throws InterruptedException, IOException  {
//        HrHomePage hr=new HrHomePage(driver);
        String underProgressRecuriment3= data.getData(1,3,0);
        String str= hr.underprogress(underProgressRecuriment3);
        try {
            Assert.assertEquals(str, "Title not present");
        }
        catch (AssertionError e){
            System.out.println("assertion error3");
        }

    }
    @Test(priority = 5)
    public void updateScores() throws InterruptedException, IOException  {
//        HrHomePage hr=new HrHomePage(driver);
        hr.allRecuriment();
        Thread.sleep(1000);
        String completedRecuriment1= data.getData(1,4,0);
        hr.completed(completedRecuriment1);
        hr.allRecuriment();
        Thread.sleep(3000);

    }
    @Test(priority = 6)
    public void scoredownload() throws InterruptedException, IOException  {
//        HrHomePage hr = new HrHomePage(driver);
        String completedRecuriment2= data.getData(1,5,0);
        hr.completed(completedRecuriment2);
        hr.allRecuriment();
        Thread.sleep(3000);
    }
    @Test(priority = 7)
    public void hrNotAddedQuiz() throws InterruptedException, IOException  {
//        HrHomePage hr = new HrHomePage(driver);
        String completedRecuriment3= data.getData(1,6,0);
       String str= hr.completed(completedRecuriment3);
        try {
            Assert.assertEquals(str, "Data can't be fetched as quiz was not uploaded by Expert and quiz not held.");
        }
        catch (AssertionError e){
            System.out.println("assertion error4");
        }
        hr.allRecuriment();
        Thread.sleep(3000);
    }
    @Test(priority = 8)
    public void wrongRecuriment() throws InterruptedException, IOException  {
//        HrHomePage hr=new HrHomePage(driver);
        String completedRecuriment4= data.getData(1,7,0);
        String str= hr.completed(completedRecuriment4);
        try {
            Assert.assertEquals(str, "Title not present");
        }
        catch (AssertionError e){
            System.out.println("assertion error5");
        }

    }




}
