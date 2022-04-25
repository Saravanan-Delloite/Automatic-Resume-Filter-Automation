package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SubjectExperteHomePage {
    WebDriver driver;
    By email=By.xpath("//*[@id='emailAddress']");
    By password=By.xpath("//*[@id='password']");
    By submit=By.xpath("//*[@type='submit']");
    By noOfRecuriment=By.tagName("app-expert-cand-cards");


    By dateDropdown=By.xpath("//*[@class='form-select date-picker']");
    By orderDropdown=By.xpath("//*[@class='form-select status-select']");

    By recurimentTitle=By.className("card-title");
    By quizstatus=By.id("btn");
    By userName=By.id("dropdownMenuButton");
    By signOut=By.className("dropdown-item");

    By underProgress=By.xpath("//div[2]/div/div[1]/div[2]/app-card/div/div/h5");
    By sendMail=By.xpath("//div[3]/button");
    By sendquiz=By.xpath("//div[1]/div[2]/button");

    By completed=By.xpath("//div[2]/div/div[2]/app-card/div/div/h5");
    By browseFile=By.xpath("//*[@id='myModal']/div/div/div[3]");
    By download=By.xpath("//div[1]/div[2]/button");

    By homePage=By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]");


    public SubjectExperteHomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void login(String mail,String passWord) throws InterruptedException {
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(passWord);
        driver.findElement(submit).click();
        Thread.sleep(5000);
    }

    public void countingNoOfRecuriment() throws InterruptedException {
        // WebElement r= driver.findElement(By.xpath("//*[@class='container']"));
        List<WebElement> recuriments=driver.findElements(noOfRecuriment);
        System.out.println(recuriments.size());
        Thread.sleep(5000);

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
    public void sortByNameInAscending() throws InterruptedException {
        dateDropdown(1);
        //Thread.sleep(5000);
        dateDropdown(0);
        //Thread.sleep(6000);
        orderDropdown(1);
        Thread.sleep(5000);
        List<WebElement> title=driver.findElements(recurimentTitle);
        for (WebElement webElement : title) {
            System.out.println(webElement.getText());
        }
        int size=title.size();
        boolean flag=listSortedInAscending(title,size);
        System.out.println(flag);
    }
    public boolean listSortedInAscending(List<WebElement> title,int size) {
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
    public void sortByNameInDescedning() throws InterruptedException {
//        WebElement orderBtnClick = driver.findElement(By.xpath("//*[@class='form-select status-select']"));
//        //orderBtnClick.click();
//        Thread.sleep(2000);
//        Select Desk = new Select(orderBtnClick);
//        Desk.selectByIndex(2);
        orderDropdown(2);
        Thread.sleep(5000);
        List<WebElement> title=driver.findElements(recurimentTitle);
        for (WebElement webElement : title) {
            System.out.println(webElement.getText());
        }
        int size=title.size();
        boolean flag=listSortedInDescending(title,size);
        System.out.println(flag);
    }
    public boolean listSortedInDescending(List<WebElement> title,int size) {
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
    public void quizadding()throws InterruptedException {
        List<WebElement> title=driver.findElements(recurimentTitle);
        List<WebElement> quizStatus=driver.findElements(quizstatus);
        String role="AS";
        String quiz="Add Quiz";
        for(int index=0;index<title.size();index++) {
            // System.out.println(title.get(index).getText()+quizStatus.get(index).getText());
            if((title.get(index).getText()).equals(role)&&(quizStatus.get(index).getText()).equals(quiz)){
                System.out.println("found");
                JavascriptExecutor jse=(JavascriptExecutor)driver;
                jse.executeScript("arguments[0].click()",quizStatus.get(index));
                Thread.sleep(1000);
                break;
            }
            if((title.get(index).getText()).equals(role)&&!(quizStatus.get(index).getText()).equals(quiz)){
                System.out.println("QUIZ ALREADY ADDED"+"\n");
            }


        }

    }
    public void signout(){
        driver.findElement(userName).click();
        driver.findElement(signOut).click();
    }
    public void underprogress() throws InterruptedException {
        //WebElement q=driver.findElement(By.className("under-progress"));
        List<WebElement> title=driver.findElements(underProgress);
        for (WebElement webElement : title) {
            if (webElement.getText().equals("ytr")) {
                System.out.println("found");
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click()", webElement);
//                jse.executeScript("window.scrollTo(0,1500)");
                //title.get(index).click();
                Thread.sleep(5000);
                //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                try {
                    System.out.println("100");
                    driver.findElement(sendMail).click();
                    //driver.findElement(By.className("btn btn-outline-warning")).click();
                    Thread.sleep(5000);
                    //WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);
                    // newTab.get("https://resume-filter-frontend-urtjok3rza-wl.a.run.app/login");
                    Thread.sleep(5000);
                    WebElement sendQuiz = driver.findElement(sendquiz);
                    if (!(sendQuiz.isEnabled())) {
                        System.out.println("quiz should be added by hr");
                    }

                } catch (ElementNotInteractableException e) {
                    System.out.println("quiz added already by hr");
                    try {
                        driver.findElement(sendquiz).click();
                    } catch (ElementClickInterceptedException k) {
                        System.out.println("already quiz sent");
                    }
                }

                break;
            }
        }
    }
    public void completed() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> title=driver.findElements(completed);
        for (WebElement webElement : title) {
            if (webElement.getText().equals("sde")) {
                System.out.println("Found");
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click()", webElement);
                Thread.sleep(5000);
                try {
                    System.out.println("kjhbsdf");
//                    Actions act=new Actions(driver);
//                    WebElement chooseFile=driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]"));
//                    act.moveToElement(chooseFile).click().perform();
//                    Runtime.getRuntime().exec("C:\\Users\\kaharshavardhan\\Downloads\\score.csv");
//                   WebElement chooseFile=driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]"));
//                    jse.executeScript("arguments[0].click()",chooseFile);
                    driver.findElement(browseFile).click();
                    Robot rb;
                    rb = new Robot();
                    rb.delay(2000);
                    StringSelection ss = new StringSelection("C:\\Users\\kaharshavardhan\\Downloads\\score.csv");
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                    rb.keyPress(KeyEvent.VK_CONTROL);
                    rb.keyPress(KeyEvent.VK_V);
                    rb.keyRelease(KeyEvent.VK_CONTROL);
                    rb.keyRelease(KeyEvent.VK_V);
                    rb.keyPress(KeyEvent.VK_ENTER);
                    rb.keyRelease(KeyEvent.VK_ENTER);
                    Thread.sleep(10000);
                    driver.findElement(download).click();
                } catch (ElementNotInteractableException e) {
                    System.out.println("already uploaded scores");
                    driver.findElement(download).click();
                    Thread.sleep(5000);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    public void Home(){
        driver.findElement(homePage).click();

    }
    public void close(){
        //quit browser
        driver.quit();
    }







}

