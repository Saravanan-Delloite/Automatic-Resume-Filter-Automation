package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import static Page.DriverPage.driver;

public class ScreenshotClass {
    int number = 0;
    public void getScreenShotFail() throws IOException
    {
        String filename="FailedScreenshot"+""+number+".jpg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(System.getProperty("user.dir")+"/FailedScreenshot/"+filename);
        FileUtils.copyFile(src,des);
        number+=1;
    }
    public void getScreenShotPass() throws IOException
    {
        String filename="PassScreenshot"+""+number+".jpg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File des = new File(System.getProperty("user.dir")+"/PassedScreenshot/"+filename);
        FileUtils.copyFile(src,des);
        number+=1;
    }


}
