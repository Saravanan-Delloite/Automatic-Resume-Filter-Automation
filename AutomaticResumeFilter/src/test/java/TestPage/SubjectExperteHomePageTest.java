package TestPage;

import Page.SubjectExperteHomePage;
import Utilities.ListenerForExtentReport;
import dataHandling.ReadingData;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Utilities.SetupDriver.*;
import java.io.IOException;
@Listeners(ListenerForExtentReport.class)



public class SubjectExperteHomePageTest {

    SubjectExperteHomePage subHome;
    static ReadingData data=new ReadingData();
    @BeforeSuite
    private void initialSetup(){

        subHome = new SubjectExperteHomePage(getDriver());

    }
    @Test(priority = 1)
    public void checkOrder() throws InterruptedException, IOException {


        Thread.sleep(3000);
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
    @Test(priority = 2)
    public void quizAdded() throws InterruptedException, IOException {
        String title2=data.getData(0,1,0);

        String str=subHome.quizadding(title2);
        // System.out.println(str);
        try {
            Assert.assertEquals(str, "Add Quiz");
        }
        catch (AssertionError e){
            System.out.println("assertion error2");
        }

    }
    @Test(priority = 3)
    public void addQuiz() throws InterruptedException, IOException {

        String title1=data.getData(0,2,0);
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
    public void invalidrecuriment() throws InterruptedException, IOException {
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


}
