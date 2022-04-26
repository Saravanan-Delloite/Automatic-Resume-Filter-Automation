package Page;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingExcel {
    //    private String name, email, username, skills;
//    private int password, confirmPassword;
    static XSSFWorkbook wbook;
    public static XSSFSheet sheet;
    public static void read()  {
        /*"C:\\Users\\yashmittal2\\Desktop\\Automatic-Resume-Filter-Automation\\AutomaticResumeFilter\\src\\resources\\ARF Signup.xlsx"*/
        try {
            FileInputStream inputStream = new FileInputStream("AutomaticResumeFilter/src/resources/ARF Signup.xlsx");
            wbook = new XSSFWorkbook(inputStream);
            sheet = wbook.getSheetAt(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}