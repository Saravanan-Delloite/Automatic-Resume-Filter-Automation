package Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelDataConfig {
    XSSFWorkbook book;
    XSSFSheet sheet1;

    public ExcelDataConfig(String excelPath)  {
        try {
            File src = new File(excelPath);

            FileInputStream fis = new FileInputStream(src);

            book = new XSSFWorkbook(fis);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetNumber, int row, int column)
    {
        sheet1 = book.getSheetAt(sheetNumber);
        String details = sheet1.getRow(row).getCell(column).getStringCellValue();
        return details;
    }
}
