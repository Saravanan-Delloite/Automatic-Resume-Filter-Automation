package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddQuizPage {
    WebDriver driver;

    public AddQuizPage(WebDriver driver){
        this.driver = driver;
    }

    By username_box = By.xpath("//*[@id='emailAddress']");
    By password_box = By.xpath("//*[@id='password']");
    By loginBtn = By.xpath("//button[text()=' Login ']");
    By recruitmentTitle = By.className("card-title");
    By addQuizBtn =By.id("btn");

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

    public void clickAddQuizBtn(String role)throws InterruptedException {
        List<WebElement> title = driver.findElements(recruitmentTitle);
        List<WebElement> quizStatus = driver.findElements(addQuizBtn);
        for (int index = 0; index < title.size(); index++) {
            if((title.get(index).getText()).equals(role)) {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click()", quizStatus.get(index));
                Thread.sleep(1000);
            }
        }
    }


    public int addQuizBtnStatus(String role) {
        List<WebElement> title=driver.findElements(By.className("card-title"));
        List<WebElement> quizStatus=driver.findElements(By.id("btn"));
        int res=0;
        for(int index=0;index<title.size();index++) {
            if((title.get(index).getText()).equals(role) && (quizStatus.get(index)).isEnabled()){
                res=1;
            }
            else if(!(title.get(index).getText()).equals(role)){
                res=-1;
            }
            else{
                res=0;
            }
        }
        return res;
    }

    public void addQuizDetails (String link, String dueDate, String time, String questions){
        driver.findElement(quizLink).sendKeys(link);
        driver.findElement(date).sendKeys(dueDate);
        driver.findElement(timeLimit).sendKeys(time);
        driver.findElement(numberOfQue).sendKeys(questions);
    }

    public boolean clickSubmitBtn(){
        if(driver.findElement(submit).isEnabled()){
            driver.findElement(submit).click();
            return true;
        }else{
            return false;
        }
    }

    public String[] addQuizEmptyDetails(){
        driver.findElement(quizLink).click();
        driver.findElement(date).click();
        driver.findElement(timeLimit).click();
        driver.findElement(numberOfQue).click();
        if(driver.findElement(submit).isEnabled()){
            driver.findElement(submit).click();
        }
        String[] arr = new String[3];
        arr[0] = driver.findElement(linkErrorMsg).getText();
        arr[1] = driver.findElement(dateErrorMsg).getText();
        arr[2] = driver.findElement(timeErrorMsg).getText();
        return arr;
    }
}
