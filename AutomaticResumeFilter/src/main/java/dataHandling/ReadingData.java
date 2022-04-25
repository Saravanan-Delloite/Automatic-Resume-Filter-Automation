package dataHandling;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingData {
    public String getData(int sht, int rowNo, int colNo) throws IOException {
        String excelFilePath = "C:\\Users\\kaharshavardhan\\Automatic-Resume-Filter-Automation\\AutomaticResumeFilter\\src\\resources\\subjectExperteHomePage.xlsx";
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sht);
        XSSFRow row = null;
        XSSFCell cell = null;
        row = sheet.getRow(rowNo);
        cell = row.getCell(colNo);
        String send = cell.getStringCellValue();
        return send;
    }
}
