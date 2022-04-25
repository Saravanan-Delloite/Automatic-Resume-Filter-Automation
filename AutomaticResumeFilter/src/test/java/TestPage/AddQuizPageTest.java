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
    public void addQuizInvalidFloatTime() throws InterruptedException, IOException {
        addQuizPage = new AddQuizPage(driver);
        addQuizPage.login("expert","expert@123");
        Thread.sleep(5000);
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if(quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(4, 0);
            String date = (readDataFromExcel.sendData(4, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(4, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(4, 3).replace("\"", "");
            //driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            System.out.println("Quiz Already added");
        }
        else{
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if(quizStatus1 == 1){
            System.out.println("Quiz not added because of invalid input");
        }
        else if(quizStatus1 == -1){
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else{
            System.out.println("Quiz added successfully..!!");
        }
    }

    @Test(priority = 2)
    public void addQuizInvalidNegativeTime() throws InterruptedException, IOException {

        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if(quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(5, 0);
            String date = (readDataFromExcel.sendData(5, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(5, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(5, 3).replace("\"", "");
            //driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            System.out.println("Quiz Already added");
        }
        else{
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if(quizStatus1 == 1){
            System.out.println("Quiz not added because of invalid input");
        }
        else if(quizStatus1 == -1){
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else{
            System.out.println("Quiz added successfully..!!");
        }
    }

    @Test(priority = 3)
    public void addQuizInvalidTimeFormat() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if(quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(6, 0);
            String date = (readDataFromExcel.sendData(6, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(6, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(6, 3).replace("\"", "");
            //driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            System.out.println("Quiz Already added");
        }
        else{
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if(quizStatus1 == 1){
            System.out.println("Quiz not added because of invalid input");
        }
        else if(quizStatus1 == -1){
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else{
            System.out.println("Quiz added successfully..!!");
        }
    }

    @Test(priority = 4)
    public void addQuizInvalidZeroTime() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if(quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(7, 0);
            String date = (readDataFromExcel.sendData(7, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(7, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(7, 3).replace("\"", "");
            //driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            System.out.println("Quiz Already added");
        }
        else{
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if(quizStatus1 == 1){
            System.out.println("Quiz not added because of invalid input");
        }
        else if(quizStatus1 == -1){
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else{
            System.out.println("Quiz added successfully..!!");
        }
    }

    @Test(priority = 5)
    public void addQuizResetCheck() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if (quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(11, 0);
            String date = (readDataFromExcel.sendData(11, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(11, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(11, 3).replace("\"", "");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickResetBtn();
            boolean res = addQuizPage.clickSubmitBtn();
            if(res){
                System.out.println("Submit button is enabled");
            }else{
                System.out.println("Submit button is disabled");
            }
            Thread.sleep(5000);
            System.out.println("Quiz Details Reset to empty");
        }
        else if (quizStatus == 0) {
            System.out.println("Quiz Already added");
        }
        else {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if (quizStatus1 == 1) {
            System.out.println("Quiz not added because of input reset");
        }
        else if (quizStatus1 == -1) {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else {
            System.out.println("Quiz added successfully..!!");
        }
    }

    @Test(priority = 6)
    public void addQuizInvalidEntries() throws InterruptedException, IOException {
            String role = readDataFromExcel.sendData(1, 5);
            int quizStatus = addQuizPage.addQuizBtnStatus(role);
            System.out.println(quizStatus);
            if (quizStatus == 1) {
                addQuizPage.clickAddQuizBtn(role);
                Thread.sleep(2000);
                String[] arr = addQuizPage.addQuizEmptyDetails();
                System.out.println(arr[0]);
                System.out.println(arr[1]);
                System.out.println(arr[2]);
                boolean res = addQuizPage.clickSubmitBtn();
                if(res){
                    System.out.println("Submit button is enabled");
                }else{
                    System.out.println("Submit button is disabled");
                }
                Thread.sleep(5000);
                System.out.println("Quiz Details Reset to empty");
            }
            else if (quizStatus == 0) {
                System.out.println("Quiz Already added");
            }
            else {
                System.out.println("Check for correct Recruitment name and Add Quiz..!!");
            }
            Thread.sleep(2000);
            addQuizPage.clickHomeBtn();
            Thread.sleep(2000);
            int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
            if (quizStatus1 == 1) {
                System.out.println("Quiz not added because of input reset");
            }
            else if (quizStatus1 == -1) {
                System.out.println("Check for correct Recruitment name and Add Quiz..!!");
            }
            else {
                System.out.println("Quiz added successfully..!!");
            }
    }


    @Test(priority = 7)
    public void addQuiz() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if(quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(1, 0);
            String date = (readDataFromExcel.sendData(1, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(1, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(1, 3).replace("\"", "");
            //driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            System.out.println("Quiz Already added");
        }
        else{
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if(quizStatus1 == 1){
            System.out.println("Quiz not added because of invalid input");
        }
        else if(quizStatus1 == -1){
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else{
            System.out.println("Quiz added successfully..!!");
        }
    }

    @Test(priority = 8)
    public void addQuizInvalidUrl1() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if(quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(2, 0);
            String date = (readDataFromExcel.sendData(2, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(2, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(2, 3).replace("\"", "");
            //driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            System.out.println("Quiz Already added");
        }
        else{
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if(quizStatus1 == 1){
            System.out.println("Quiz not added because of invalid input");
        }
        else if(quizStatus1 == -1){
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else{
            System.out.println("Quiz added successfully..!!");
        }
    }


    @Test(priority = 9)
    public void addQuizInvalidUrl2() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if(quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(3, 0);
            String date = (readDataFromExcel.sendData(3, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(3, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(3, 3).replace("\"", "");
            //driver.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/expert/add-quiz/183");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if(quizStatus == 0){
            System.out.println("Quiz Already added");
        }
        else{
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if(quizStatus1 == 1){
            System.out.println("Quiz not added because of invalid input");
        }
        else if(quizStatus1 == -1){
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else{
            System.out.println("Quiz added successfully..!!");
        }
    }


    @Test(priority = 10)
    public void addQuizInvalidNegativeQuestions() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if (quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(8, 0);
            String date = (readDataFromExcel.sendData(8, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(8, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(8, 3).replace("\"", "");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if (quizStatus == 0) {
            System.out.println("Quiz Already added");
        }
        else {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if (quizStatus1 == 1) {
            System.out.println("Quiz not added because of invalid input");
        }
        else if (quizStatus1 == -1) {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else {
            System.out.println("Quiz added successfully..!!");
        }
    }


    @Test(priority = 11)
    public void addQuizInvalidFloatQuestions() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if (quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(9, 0);
            String date = (readDataFromExcel.sendData(9, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(9, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(9, 3).replace("\"", "");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if (quizStatus == 0) {
            System.out.println("Quiz Already added");
        }
        else {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if (quizStatus1 == 1) {
            System.out.println("Quiz not added because of invalid input");
        }
        else if (quizStatus1 == -1) {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else {
            System.out.println("Quiz added successfully..!!");
        }
    }

    @Test(priority = 12)
    public void addQuizInvalidZeroQuestions() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if (quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(10, 0);
            String date = (readDataFromExcel.sendData(10, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(10, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(10, 3).replace("\"", "");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if (quizStatus == 0) {
            System.out.println("Quiz Already added");
        }
        else {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if (quizStatus1 == 1) {
            System.out.println("Quiz not added because of invalid input");
        }
        else if (quizStatus1 == -1) {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else {
            System.out.println("Quiz added successfully..!!");
        }
    }

    @Test(priority = 13)
    public void addQuizNoQuestionsNumber() throws InterruptedException, IOException {
        String role = readDataFromExcel.sendData(1, 5);
        int quizStatus = addQuizPage.addQuizBtnStatus(role);
        System.out.println(quizStatus);
        if (quizStatus == 1) {
            addQuizPage.clickAddQuizBtn(role);
            Thread.sleep(2000);
            String link = readDataFromExcel.sendData(12, 0);
            String date = (readDataFromExcel.sendData(12, 1)).replace("\"", "");
            String time = readDataFromExcel.sendData(12, 2).replace("\"", "");
            String questions = readDataFromExcel.sendData(12, 3).replace("\"", "");
            addQuizPage.addQuizDetails(link, date, time, questions);
            addQuizPage.clickSubmitBtn();
            Thread.sleep(5000);
            System.out.println("Quiz Details Filled");
        }
        else if (quizStatus == 0) {
            System.out.println("Quiz Already added");
        }
        else {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        Thread.sleep(2000);
        addQuizPage.clickHomeBtn();
        Thread.sleep(2000);
        int quizStatus1 = addQuizPage.addQuizBtnStatus(role);
        if (quizStatus1 == 1) {
            System.out.println("Quiz not added because of invalid input");
        }
        else if (quizStatus1 == -1) {
            System.out.println("Check for correct Recruitment name and Add Quiz..!!");
        }
        else {
            System.out.println("Quiz added successfully..!!");
        }
    }

}
