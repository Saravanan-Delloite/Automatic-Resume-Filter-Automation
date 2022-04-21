package pages;

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

    public void clickHomeBtn(){
        driver.findElement(homeBtn).click();
    }

    public void login(String username, String password) throws InterruptedException {
        driver.findElement(username_box).sendKeys(username);
        driver.findElement(password_box).sendKeys(password);
        driver.findElement(loginBtn).click();
        Thread.sleep(10000);
        driver.findElement(addQuizBtn).click();

    }

    public void addQuizDetails(String link,String dueDate,String time, String questions){
        driver.findElement(quizLink).sendKeys(link);
        driver.findElement(date).sendKeys(dueDate);
        driver.findElement(timeLimit).sendKeys(time);
        driver.findElement(numberOfQue).sendKeys(questions);
        driver.findElement(submit).click();
    }

}
