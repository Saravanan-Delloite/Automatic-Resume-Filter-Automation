package TestPage;

import Page.SubjectExperteHomePage;
import dataHandling.ReadingData;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;



public class SubjectExperteHomePageTest {
    static WebDriver driver;
    static SubjectExperteHomePage subHome=new SubjectExperteHomePage(driver);
    static ReadingData data=new ReadingData();
    @Test(priority = 1)
    private static void initialSetup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaharshavardhan\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
        driver.manage().window().maximize();

    }
    @Test(priority = 2)
    private static void checkOrder() throws InterruptedException, IOException {
        SubjectExperteHomePage subHome=new SubjectExperteHomePage(driver);
        subHome.login("qwer1234","qwer1234");


//        subHome.countingNoOfRecuriment();
        Boolean status=subHome.sortByNameInAscending();
        try {
            Assert.assertEquals(status, true);
        }
        catch (AssertionError e){
            System.out.println("assertion error");
        }
        Boolean status1=subHome.sortByNameInDescedning();
        try {
            Assert.assertEquals(status1, true);
        }
        catch (AssertionError e){
            System.out.println("assertion error");
        }

    }
    @Test(priority = 3)
    public static void addQuiz() throws InterruptedException, IOException {
        SubjectExperteHomePage subHome=new SubjectExperteHomePage(driver);
        String title1=data.getData(0,1,0);
         String str=subHome.quizadding(title1);
         try {
             Assert.assertEquals(str, "Quiz Added");
         }
         catch (AssertionError e){
             System.out.println("assertion error1");
         }
         Thread.sleep(5000);

    }
    @Test(priority = 4)
    public static void quizAdded() throws InterruptedException, IOException {
        SubjectExperteHomePage subHome=new SubjectExperteHomePage(driver);
        String title2=data.getData(0,2,0);

        String str=subHome.quizadding(title2);
       // System.out.println(str);
        try {
            Assert.assertEquals(str, "Add Quiz");
        }
        catch (AssertionError e){
            System.out.println("assertion error2");
        }
        Thread.sleep(5000);

    }
    @Test(priority = 5)
    public static void invalidrecuriment() throws InterruptedException, IOException {
        SubjectExperteHomePage subHome=new SubjectExperteHomePage(driver);
        String title3=data.getData(0,3,0);
        String str=subHome.quizadding(title3);
        //System.out.println(str);
        try {
            Assert.assertEquals(str, "Title not found");
        }
        catch (AssertionError e){
            System.out.println("assertion error3");
        }


    }
    @Test(priority = 6)
    public static void signout() throws InterruptedException {
        SubjectExperteHomePage subHome=new SubjectExperteHomePage(driver);
       subHome.signout();
       subHome.close();
    }


}
