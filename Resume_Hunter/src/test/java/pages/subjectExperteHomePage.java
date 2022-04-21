package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class subjectExperteHomePage {
    WebDriver driver;
    By email=By.xpath("//*[@id='emailAddress']");
    By password=By.xpath("//*[@id='password']");
    By submit=By.xpath("//*[@type='submit']");
    By noOfRecuriment=By.tagName("app-expert-cand-cards");
    public subjectExperteHomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void login() throws InterruptedException {
        driver.findElement(email).sendKeys("qwer1234");
        driver.findElement(password).sendKeys("qwer1234");
        driver.findElement(submit).click();
        Thread.sleep(5000);
    }
    public void countingNoOfRecuriment() throws InterruptedException {
       // WebElement r= driver.findElement(By.xpath("//*[@class='container']"));
        List<WebElement> recuriments=driver.findElements(noOfRecuriment);
        System.out.println(recuriments.size());
        Thread.sleep(5000);

    }
    public void sortByEndDate(){
        WebElement date=driver.findElement(By.xpath("//*[@class='form-select date-picker']"));
        Select selectdate=new Select(date);

        selectdate.selectByIndex(0);
        WebElement order=driver.findElement(By.xpath("//*[@class='form-select date-picker']"));
        Select selectorder=new Select(date);

        selectorder.selectByIndex(1);


        List<WebElement> title=driver.findElements(By.className("card-title"));
        for(int index=0;index<title.size();index++){
           System.out.println(title.get(index).getText());
        }
        int size=title.size();
        //System.out.println(r2);
        //listSortedOrNot(title,size);



    }





}
