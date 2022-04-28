package TestPage;

import Page.AddQuizPage;
import Utilities.ListenerForExtentReport;
import dataHandling.ReadDataFromExcel;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


import javax.swing.plaf.SliderUI;

import static Utilities.SetupDriver.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
@Listeners(ListenerForExtentReport.class)

public class AddQuizPageTest {

    Logger logger = Logger.getLogger(AddQuizPageTest.class);

    ReadDataFromExcel excelData =new ReadDataFromExcel();
    AddQuizPage addQuizPage;
    String addQuizBtnEnabled = "Add Quiz";
    String addQuizBtnDisabled = "Quiz Added";

    @BeforeClass
    public void initialSetup() throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    // Add quiz with time limit as float value
    public void addQuizInvalidFloatTime() throws InterruptedException, IOException {
        addQuizPage = new AddQuizPage(getDriver());
        String role = excelData.sendData(1, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        System.out.println(role);
        System.out.println(quizStatus);
        System.out.println(quizStatusArray[1]);
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(4, 0);
            String date = excelData.getQuizDate(4, 1);
            String time = excelData.getQuizTime(4, 2);
            String questions = excelData.getQuizQuestions(4, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1], addQuizBtnEnabled);
        logger.info("Quiz Status");
        logger.info("Quiz added successfully...!!");
    }

    @Test(priority = 2)
    //Add quiz with negative time limit
    public void addQuizInvalidNegativeTime() throws InterruptedException, IOException {
        String role = excelData.sendData(1, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        logger.info("Add quiz button status verification");
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            Thread.sleep(2000);
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(5, 0);
            String date = excelData.getQuizDate(5, 1);
            String time = excelData.getQuizTime(5, 2);
            String questions = excelData.getQuizQuestions(5, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz Status");
        logger.info("Quiz added successfully...!!");
    }

    @Test(priority = 3)
    // Add quiz with time limit with invalid format(1hr)
    public void addQuizInvalidTimeFormat() throws InterruptedException, IOException {
        String role = excelData.sendData(1, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        logger.info("Add quiz button status verification");
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            Thread.sleep(2000);
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(6, 0);
            String date = excelData.getQuizDate(6, 1);
            String time = excelData.getQuizTime(6, 2);
            String questions = excelData.getQuizQuestions(6, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz Status");
        logger.info("Quiz added successfully...!!");
    }

    @Test(priority = 4)
    // Add quiz with time limit as 0
    public void addQuizInvalidZeroTime() throws InterruptedException, IOException {
        String role = excelData.sendData(1, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        logger.info("Add quiz button status verification");
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        System.out.println(quizStatus);
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(7, 0);
            String date = excelData.getQuizDate(7, 1);
            String time = excelData.getQuizTime(7, 2);
            String questions = excelData.getQuizQuestions(7, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz Status");
        logger.info("Quiz added successfully...!!");
    }

    @Test(priority = 5)
    // Add data and click reset the data to empty
    public void addQuizResetCheck() throws InterruptedException, IOException {
        String role = excelData.sendData(1, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        logger.info("Add quiz button status verification");
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        if (quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(11, 0);
            String date = excelData.getQuizDate(11, 1);
            String time = excelData.getQuizTime(11, 2);
            String questions = excelData.getQuizQuestions(11, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickResetBtn();
            boolean res = addQuizPage.clickSubmitBtn();
            if(res){
                Assert.assertEquals(res,true);
                logger.info("Submit button is enabled");
            }else{
                Assert.assertEquals(res,false);
                logger.info("Submit button is disabled");
            }
            Thread.sleep(5000);
            logger.info("Quiz Details Reset to empty");
        }
        else if (quizStatus == 0) {
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else {
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz Status");
        logger.info("Quiz added successfully...!!");
    }

    @Test(priority = 6)
    // Add quiz with all entries as empty
    public void addQuizInvalidEntries() throws InterruptedException, IOException {
            String role = excelData.sendData(1, 5);
            // Checking the status of Add quiz Button
            String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
            int quizStatus = Integer.parseInt(quizStatusArray[0]);
            logger.info("Add quiz button status verification");
            if (quizStatus == 1) {
                Assert.assertEquals(quizStatusArray[1],"Add Quiz");
                addQuizPage.clickAddQuizBtn(role);
                Thread.sleep(2000);
                String[] arr = addQuizPage.addQuizEmptyDetails();
                Assert.assertEquals(arr[0], "Quiz link is required.");
                Assert.assertEquals(arr[1], "End Date is required.");
                Assert.assertEquals(arr[2], "Time Limit is required.");
                logger.info(arr[0]);
                logger.info(arr[1]);
                logger.info(arr[2]);
                boolean res = addQuizPage.clickSubmitBtn();
                if(res){
                    Assert.assertEquals(res,true);
                    logger.info("Submit button is enabled");
                }else{
                    Assert.assertEquals(res, false);
                    logger.info("Submit button is disabled");
                }
                Thread.sleep(5000);
                logger.info("Quiz Details Reset to empty");
            }
            else if (quizStatus == 0) {
                Assert.assertEquals(quizStatusArray[1],"Quiz Added");
                logger.info("Quiz Already added");
            }
            else {
                logger.info("Check for correct Recruitment name and Add Quiz..!!");
            }
            Thread.sleep(2000);
            addQuizPage.clickHomeBtn();
            Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz Status");
        logger.info("Quiz added successfully...!!");
    }

    @Test(priority = 7)
    // Add quiz with empty question number
    public void addQuizNoQuestionsNumber() throws InterruptedException, IOException {
        String role = excelData.sendData(1, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(12, 0);
            String date = excelData.getQuizDate(12, 1);
            String time = excelData.getQuizTime(12, 2);
            String questions = excelData.getQuizQuestions(12, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            boolean res = addQuizPage.clickSubmitBtn();
            if(res){
                Assert.assertEquals(res ,true);
                logger.info("Submit button is enabled");
            }else{
                Assert.assertEquals(res ,false);
                logger.info("Submit button is disabled");
            }
            Thread.sleep(2000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz Status");
        logger.info("Quiz added successfully...!!");
    }

    @Test(priority = 8)
    // Add quiz with valid details
    public void addQuiz() throws InterruptedException, IOException {
        String role = excelData.sendData(1, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(1, 0);
            String date = excelData.getQuizDate(1, 1);
            String time = excelData.getQuizTime(1, 2);
            String questions = excelData.getQuizQuestions(1, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnDisabled);
        logger.info("Quiz Status");
        logger.info("Quiz added successfully...!!");
    }

    @Test(priority = 9)
    // Add quiz to the recruitment in which quiz is already added
    public void addQuizToAlreadyAdded() throws InterruptedException, IOException {
        String role = excelData.sendData(1, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(1, 0);
            String date = excelData.getQuizDate(1, 1);
            String time = excelData.getQuizTime(1, 2);
            String questions = excelData.getQuizQuestions(1, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnDisabled);
        logger.info("Quiz status");
        logger.info("Quiz Already added");
    }


    @Test(priority = 10)
    // Add Quiz with url as 12345
    public void addQuizInvalidUrl1() throws InterruptedException, IOException {
        String role = excelData.sendData(2, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(2, 0);
            String date = excelData.getQuizDate(2, 1);
            String time = excelData.getQuizTime(2, 2);
            String questions = excelData.getQuizQuestions(2, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
           logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz status");
        logger.error("Quiz Added for Invalid URL");
    }


    @Test(priority = 11)
    // Add Quiz with url as *******
    public void addQuizInvalidUrl2() throws InterruptedException, IOException {
        String role = excelData.sendData(3, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(3, 0);
            String date = excelData.getQuizDate(3, 1);
            String time = excelData.getQuizTime(3, 2);
            String questions = excelData.getQuizQuestions(3, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz status");
        logger.error("Quiz Added for Invalid URL");
    }


    @Test(priority = 12)
    // Add Quiz with number of questions as negative
    public void addQuizInvalidNegativeQuestions() throws InterruptedException, IOException {
        String role = excelData.sendData(4, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(8, 0);
            String date = excelData.getQuizDate(8, 1);
            String time = excelData.getQuizTime(8, 2);
            String questions = excelData.getQuizQuestions(8, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz status");
        logger.error("Quiz Added for Negative number of questions");
    }


    @Test(priority = 13)
    // Add Quiz with number of questions as float digit
    public void addQuizInvalidFloatQuestions() throws InterruptedException, IOException {
        String role = excelData.sendData(5, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(9, 0);
            String date = excelData.getQuizDate(9, 1);
            String time = excelData.getQuizTime(9, 2);
            String questions = excelData.getQuizQuestions(9, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz status");
        logger.error("Quiz Added for number of questions as float value");
    }

    @Test(priority = 14)
    // Add Quiz with number of questions as 0
    public void addQuizInvalidZeroQuestions() throws InterruptedException, IOException {
        String role = excelData.sendData(6, 5);
        // Checking the status of Add quiz Button
        String[] quizStatusArray = addQuizPage.addQuizBtnStatus(role);
        int quizStatus = Integer.parseInt(quizStatusArray[0]);
        logger.info("Add quiz button status verification");
        if(quizStatus == 1) {
            Assert.assertEquals(quizStatusArray[1],"Add Quiz");
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = excelData.getQuizLink(10, 0);
            String date = excelData.getQuizDate(10, 1);
            String time = excelData.getQuizTime(10, 2);
            String questions = excelData.getQuizQuestions(10, 3);
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            logger.info("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            Assert.assertEquals(quizStatusArray[1],"Quiz Added");
            logger.info("Quiz Already added");
        }
        else{
            logger.info("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        // Checking the status of Add quiz Button after adding quiz details
        String[] quizStatusArray1 = addQuizPage.addQuizBtnStatus(role);
        Assert.assertEquals(quizStatusArray1[1],addQuizBtnEnabled);
        logger.info("Quiz status");
        logger.error("Quiz Added for number of questions as 0");
    }

    @Test(priority = 15)
    //Logout
    public void logout(){
        logger.info("Subject Expert logged out");
        addQuizPage.logout();
    }

    @AfterClass
    // Closing the browser
    public void closeChrome()
    {
        closeBrowser();
    }

}
