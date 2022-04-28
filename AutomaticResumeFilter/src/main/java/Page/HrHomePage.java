package Page;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static java.lang.Thread.sleep;


public class HrHomePage {
    Logger logger=Logger.getLogger(HrHomePage.class);
    WebDriver driver;
    By email=By.xpath("//*[@id='emailAddress']");
    By password=By.xpath("//*[@id='password']");
    By submit=By.xpath("//*[@type='submit']");

    By underProgress=By.xpath("//div[2]/div/div[1]/div[2]/app-card/div/div/h5");
    By sendMail=By.xpath("//div[3]/button");
    By sendquiz=By.xpath("//div[1]/div[2]/button");
    By emailStatus=By.xpath("//ngb-alert");

    By completed=By.xpath("//div/div[2]/div/app-card/div/div/h5");
    By allRecuriment=By.xpath("//*[@id='navbarNav']/ul/li[4]/a");
    By browseFile=By.xpath("//*[@id='myModal']/div/div/div[3]");
    By download=By.xpath("//div[1]/div[2]/button");
    By alert=By.xpath("//ngb-alert");

    By homePage=By.xpath("//*[@id='navbarNav']/ul/li[2]");

    By userName=By.id("dropdownMenuButton");
    By signOut=By.className("dropdown-item");

    public HrHomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void login() throws InterruptedException {
        driver.findElement(email).sendKeys("admin123");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(submit).click();
        sleep(5000);
    }
    public void SortStartDate() throws InterruptedException {
        WebElement sortBtnClick = driver.findElement(By.xpath("//*[@class='form-select date-picker']"));
        sortBtnClick.click();
        sleep(2000);
        Select Desk = new Select(sortBtnClick);
        Desk.selectByVisibleText("Start Date");
    }
    //StartDate in Ascending Order
    public void StartDateAsc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Ascending");
    }
    //StartDate in Descending Order
    public void StartDateDesc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Descending");
    }
    public void SortEndDate() throws InterruptedException {
        WebElement sortBtnClick = driver.findElement(By.xpath("//*[@class='form-select date-picker']"));
        sortBtnClick.click();
        sleep(2000);
        Select Desk = new Select(sortBtnClick);
        Desk.selectByVisibleText("End Date");
    }
    //EndDate in Ascending Order
    public void EndDateAsc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Ascending");
    }
    //EndDate in Descending Order
    public void EndDateDesc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Descending");
    }
    public void SortDate() throws InterruptedException {
        WebElement sortBtnClick = driver.findElement(By.xpath("//*[@class='form-select date-picker']"));
        sortBtnClick.click();
        sleep(2000);
        Select Desk = new Select(sortBtnClick);
        Desk.selectByVisibleText("Date");
    }
    //Name in Ascending Order
    public void NameAsc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Ascending");
    }
    //Name in Descending Order
    public void NameDesc() throws InterruptedException {
        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
        orderBtnClick.click();
        sleep(2000);
        Select Desk = new Select(orderBtnClick);
        Desk.selectByVisibleText("Descending");
    }
    public String underprogress(String recuriment) throws InterruptedException {
        int count=0;
        //getting all under progress recuriments title
        List<WebElement> title=driver.findElements(underProgress);
        for (WebElement webElement : title) {
            //checking the title
            if (webElement.getText().equals(recuriment)) {
                count++;
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                //jse.executeScript("arguments[0].scrollIntoView()", webElement);
                jse.executeScript("arguments[0].click()", webElement);
                sleep(3000);
                //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                try {
                    //checking popup
                    driver.findElement(sendMail).click();
                    sleep(5000);
                    String alert=driver.findElement(emailStatus).getText();
                    sleep(2000);
                    WebElement sendQuiz = driver.findElement(sendquiz);
                    if (!(sendQuiz.isEnabled())) {
                        logger.info("quiz should be added by hr");
                        return alert;
                    }
                } catch (ElementNotInteractableException e) {
                    //checking quiz button enabled or not
                    logger.info("quiz added already by hr");
                    try {
                        driver.findElement(sendquiz).click();
                    } catch (ElementClickInterceptedException k) {
                        WebElement sendQuiz = driver.findElement(sendquiz);
                        if(!(sendQuiz.isEnabled())) {
                            logger.info("quiz already sent");
                            String str=driver.findElement(sendquiz).getText();
                            return str;
                        }
                    }
                }
                break;
            }
        }
        if(count==0){
            logger.info("title not present");
            return "Title not present";
        }

        return null;
    }
    public String completed(String recuriment) throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //getting all completed recuriments title
        List<WebElement> title=driver.findElements(completed);
        int count=0;
        for (WebElement webElement : title) {
            //checking recuriment title
            if (webElement.getText().equals(recuriment)) {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                //jse.executeScript("arguments[0].scrollIntoView()", webElement);
                jse.executeScript("arguments[0].click()", webElement);
                sleep(3000);
                try {
                    driver.findElement(browseFile).click();
                    //uploading file
                    Robot rb;
                    rb = new Robot();
                    rb.delay(2000);
                    StringSelection ss = new StringSelection("C:\\Users\\kaharshavardhan\\Desktop\\Resume_filter\\AutomaticResumeFilter\\src\\resources\\score.csv");
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                    rb.keyPress(KeyEvent.VK_CONTROL);
                    rb.keyPress(KeyEvent.VK_V);
                    rb.keyRelease(KeyEvent.VK_CONTROL);
                    rb.keyRelease(KeyEvent.VK_V);
                    rb.keyPress(KeyEvent.VK_ENTER);
                    rb.keyRelease(KeyEvent.VK_ENTER);
                    sleep(5000);
                    //clicking on file
                    driver.findElement(download).click();
                    return null;

                } catch (ElementClickInterceptedException k){
                    logger.info("quiz not sent to students by hr");
                    String message=driver.findElement(alert).getText();
                    return message;
                } catch (ElementNotInteractableException e) {
                    logger.info("already uploaded scores");
                    driver.findElement(download).click();
                    sleep(2000);
                    return null;

                } catch (AWTException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        if(count==0){
            logger.info("title not present");
            return "Title not present";
        }
        return null;
    }
    public void Home(){
        driver.findElement(homePage).click();

    }
    public void allRecuriment() throws InterruptedException {
        // click on allRecuriment
        driver.findElement(allRecuriment).click();
       Thread.sleep(1000);
    }
    public void close(){
        driver.quit();
    }

    public void signout(){
        //signout
        driver.findElement(userName).click();
        driver.findElement(signOut).click();
    }


}
