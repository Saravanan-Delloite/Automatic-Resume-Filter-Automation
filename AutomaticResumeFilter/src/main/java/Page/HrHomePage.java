package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HrHomePage {
    WebDriver driver;
    By email=By.xpath("//*[@id='emailAddress']");
    By password=By.xpath("//*[@id='password']");
    By submit=By.xpath("//*[@type='submit']");
    By userName=By.id("dropdownMenuButton");
    By signOut=By.className("dropdown-item");
    public HrHomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void login() throws InterruptedException {
        driver.findElement(email).sendKeys("ramu123");
        driver.findElement(password).sendKeys("ramu@123");
        driver.findElement(submit).click();
        Thread.sleep(5000);
    }
    public void SortStartDate() throws InterruptedException {
        WebElement sortBtnClick = driver.findElement(By.xpath("//*[@class='form-select date-picker']"));
        sortBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(sortBtnClick);
        Desk.selectByVisibleText("Start Date");
    }
    //StartDate in Ascending Order
    public void StartDateAsc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Ascending");
    }
    //StartDate in Descending Order
    public void StartDateDesc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Descending");
    }
    public void SortEndDate() throws InterruptedException {
        WebElement sortBtnClick = driver.findElement(By.xpath("//*[@class='form-select date-picker']"));
        sortBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(sortBtnClick);
        Desk.selectByVisibleText("End Date");
    }
    //EndDate in Ascending Order
    public void EndDateAsc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Ascending");
    }
    //EndDate in Descending Order
    public void EndDateDesc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Descending");
    }
    public void SortDate() throws InterruptedException {
        WebElement sortBtnClick = driver.findElement(By.xpath("//*[@class='form-select date-picker']"));
        sortBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(sortBtnClick);
        Desk.selectByVisibleText("Date");
    }
    //Name in Ascending Order
    public void NameAsc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Ascending");
    }
    //Name in Descending Order
    public void NameDesc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        Thread.sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Descending");
    }
    public void signout(){
        driver.findElement(userName).click();
        driver.findElement(signOut).click();
    }

}
