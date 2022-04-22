package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddQuizPage {
    WebDriver driver;

    public AddQuizPage(WebDriver driver){
        this.driver = driver;
    }

    By username_box = By.xpath("//*[@id='emailAddress']");
    By password_box = By.xpath("//*[@id='password']");
    By loginBtn = By.xpath("//button[text()=' Login ']");
    By addQuizBtn =By.xpath("/html/body/app-root/app-expert-dashboard/div[2]/div/app-expert-cand-cards[11]/div/div/div[3]/button");

    By homeBtn = By.xpath("//a[text()='Home']");
    By quizLink = By.xpath("//*[@id='quizlink']");
    By date = By.xpath("//*[@id='date']");
    By timeLimit = By.xpath("//input[@formcontrolname='due_time']");
    By numberOfQue = By.xpath("//input[@formcontrolname='questions']");
    By reset = By.xpath("//button[@type='reset']");
    By submit = By.xpath("//button[text()=' Submit Quiz ']");

    By linkErrorMsg = By.xpath("//div[text()=' Quiz link is required. ']");
    By dateErrorMsg =By.xpath("//div[text()=' End Date is required. ']");
    By timeErrorMsg = By.xpath("//div[text()=' Time Limit is required. ']");

    public void clickHomeBtn(){
        driver.findElement(homeBtn).click();
    }

    public void clickResetBtn(){
        driver.findElement(reset).click();
    }

    public void login(String username, String password) throws InterruptedException {
        driver.findElement(username_box).sendKeys(username);
        driver.findElement(password_box).sendKeys(password);
        driver.findElement(loginBtn).click();
    }



    public void addQuizDetails (String link, String dueDate, String time, String questions){
        driver.findElement(quizLink).sendKeys(link);
        driver.findElement(date).sendKeys(dueDate);
        driver.findElement(timeLimit).sendKeys(time);
        driver.findElement(numberOfQue).sendKeys(questions);
        if(driver.findElement(submit).isEnabled()){
            driver.findElement(submit).click();
        }
    }

    public void addQuizEmptyDetails(){
        driver.findElement(quizLink).click();
        driver.findElement(date).click();
        driver.findElement(timeLimit).click();
        driver.findElement(numberOfQue).click();
        if(driver.findElement(submit).isEnabled()){
            driver.findElement(submit).click();
        }

    }
}
