package TestPage;

import Page.SubjectExperteHomePage;
import Utilities.ListenerForExtentReport;
import dataHandling.ReadingData;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Utilities.SetupDriver.*;
import java.io.IOException;
@Listeners(ListenerForExtentReport.class)



public class SubjectExperteHomePageTest {

    SubjectExperteHomePage subHome;
    Logger logger=Logger.getLogger(HrHomePageTest.class);
    static ReadingData data=new ReadingData();
    @BeforeSuite
    private void initialSetup(){

        subHome = new SubjectExperteHomePage(getDriver());

    }
    @Test(priority = 1)
    public void checkOrder() throws InterruptedException, IOException {


        Thread.sleep(3000);
        Boolean status=subHome.sortByNameInAscending();
        //checking names sorted in ascending order
        try {
            Assert.assertEquals(status, true);
        }
        catch (AssertionError e){
            logger.error("assertion error");
        }
        Boolean status1=subHome.sortByNameInDescedning();
        //checking names sorted in descending order
        try {
            Assert.assertEquals(status1, true);
        }
        catch (AssertionError e){
            logger.error("assertion error");
        }

    }
    @Test(priority = 2)
    public void quizAdded() throws InterruptedException, IOException {
        String title2=data.getData(0,1,0);

        String str=subHome.quizadding(title2);
        // checking quiz added or not
        try {
            Assert.assertEquals(str, "Add Quiz");
        }
        catch (AssertionError e){
            logger.error("assertion error2");
        }

    }
    @Test(priority = 3)
    public void addQuiz() throws InterruptedException, IOException {

        String title1=data.getData(0,2,0);
         String str=subHome.quizadding(title1);
        // checking quiz added or not
         try {
             Assert.assertEquals(str, "Quiz Added");
         }
         catch (AssertionError e){
             logger.error("assertion error1");
         }
         Thread.sleep(5000);

    }

    @Test(priority = 4)
    public void invalidrecuriment() throws InterruptedException, IOException {
        String title3=data.getData(0,3,0);
        String str=subHome.quizadding(title3);
        //checking by giving wrong title
        try {
            Assert.assertEquals(str, "Title not found");
        }
        catch (AssertionError e){
            logger.error("assertion error3");
        }


    }


}
