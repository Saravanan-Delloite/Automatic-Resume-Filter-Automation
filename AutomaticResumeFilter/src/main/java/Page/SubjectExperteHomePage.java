package Page;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SubjectExperteHomePage {
    WebDriver driver;
    Logger logger=Logger.getLogger(SubjectExperteHomePage.class);
    By email=By.xpath("//*[@id='emailAddress']");
    By password=By.xpath("//*[@id='password']");
    By submit=By.xpath("//*[@type='submit']");

    By dateDropdown=By.xpath("//*[@class='form-select date-picker']");
    By orderDropdown=By.xpath("//*[@class='form-select status-select']");

    By recurimentTitle=By.className("card-title");
    By quizstatus=By.id("btn");
    By userName=By.id("dropdownMenuButton");
    By signOut=By.className("dropdown-item");

    By homePage=By.xpath("//*[@id='navbarNav']/ul/li[2]/a");




    public SubjectExperteHomePage(WebDriver driver)
    {
        this.driver=driver;
    }



    public void dateDropdown(int index){
        WebElement date=driver.findElement(dateDropdown);
        Select selectDate=new Select(date);
        selectDate.selectByIndex(index);

    }
    public void orderDropdown(int index){
        WebElement order=driver.findElement(orderDropdown);
        Select selectOrder=new Select(order);
        selectOrder.selectByIndex(index);
    }
    public boolean sortByNameInAscending() throws InterruptedException {
        // sorting recuriments by names in ascending order
        dateDropdown(1);
        dateDropdown(0);
        orderDropdown(1);
        Thread.sleep(5000);
        List<WebElement> title=driver.findElements(recurimentTitle);
        int size=title.size();
        boolean flag=listSortedInAscending(title,size);
        //System.out.println(flag);
        return flag;
    }
    public boolean listSortedInAscending(List<WebElement> title,int size) {
        // checking details present in ascending order
        for (int index = 0; index < size; index++) {
            for (int index1 = index + 1; index1 < size; index1++) {
                if (title.get(index).getText().charAt(0) > title.get(index1).getText()
                        .charAt(0)) {
                    System.out.println(title.get(index).getText().charAt(0));
                    System.out.println(title.get(index1).getText().charAt(0));
                    return false;
                }
            }
        }

        return true;
    }
    public boolean sortByNameInDescedning() throws InterruptedException {
        //sorting recuriments by names in descending order
        orderDropdown(2);
        Thread.sleep(5000);
        List<WebElement> title=driver.findElements(recurimentTitle);
        int size=title.size();
        boolean flag=listSortedInDescending(title,size);
        //System.out.println(flag);
        return flag;
    }
    public boolean listSortedInDescending(List<WebElement> title,int size) {
        //checking names got sorted in descending order
        for (int index = 0; index < size; index++) {
            for (int index1 = index + 1; index1 < size; index1++) {
                if (title.get(index).getText().charAt(0) < title.get(index1).getText()
                        .charAt(0)) {
                    return false;
                }
            }
        }

        return true;
    }
    public String quizadding(String role)throws InterruptedException {
        //getting recuriments names
        List<WebElement> title=driver.findElements(recurimentTitle);
        //getting quiz status
        List<WebElement> quizStatus=driver.findElements(quizstatus);
        int count=0;
        String quiz="Add Quiz";
        String message="";
        for(int index=0;index<title.size();index++) {
            if((title.get(index).getText()).equals(role)&&(quizStatus.get(index).getText()).equals(quiz)){
                message=quizStatus.get(index).getText();
                JavascriptExecutor jse=(JavascriptExecutor)driver;
                jse.executeScript("arguments[0].scrollIntoView()",quizStatus.get(index));
                jse.executeScript("arguments[0].click()",quizStatus.get(index));
               Thread.sleep(1000);
               Home();
                count++;
                break;
            }
            if((title.get(index).getText()).equals(role)&&!(quizStatus.get(index).getText()).equals(quiz)){
                JavascriptExecutor jse=(JavascriptExecutor)driver;
                jse.executeScript("arguments[0].scrollIntoView()",quizStatus.get(index));
                String message1=quizStatus.get(index).getText();
                count++;
                if(!(quizStatus.get(index).isEnabled())) {
                    logger.info("quiz already added");
                    return message1;
                }
            }
        }
        if(count==0){
            logger.info("recuriment not present");
            return "Title not found";
        }
        return message;
    }
    public void signout(){
        //signout
        driver.findElement(userName).click();
        driver.findElement(signOut).click();
    }
    public void Home() throws InterruptedException {
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        WebElement homeButton=driver.findElement(homePage);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].scrollIntoView()",homeButton);
        jse.executeScript("arguments[0].click()",homeButton);
      // driver.findElement(homePage).click();
        Thread.sleep(1000);

    }
    public void close(){
        //quit browser
        driver.quit();
    }







}

