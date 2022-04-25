package Page;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadingExcel {
    private String name,email,username,skills;
    private int password,confirmPassword;
    public void readData()  {
        try {

            String excelFilePath = "C:\\Users\\yashmittal2\\Desktop\\Automatic-Resume-Filter-Automation\\AutomaticResumeFilter\\src\\resources\\ARF Signup.xlsx";
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(1).getLastCellNum();

            for (int i = 1; i <= rows; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    XSSFCell cell = row.getCell(j);
                    if (j == 0) {
                        name = cell.getStringCellValue();
                    }
                    if (j == 1) {
                        email = cell.getStringCellValue();
                    }
                    if (j == 2) {
                        username = cell.getStringCellValue();
                    }
                    if (j == 3) {
                        password = (int) cell.getNumericCellValue();
                    }
                    if (j == 4) {
                        confirmPassword = (int) cell.getNumericCellValue();
                    }
                    if (j == 5) {
                        skills =  cell.getStringCellValue();
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String getUsername()
    {
        return  username;
    }
    public int getPassword()
    {
        return password;
    }
    public int getConfirmPassword()
    {
        return confirmPassword;
    }
    public String getSkills()
    {
        return skills;
    }
}
