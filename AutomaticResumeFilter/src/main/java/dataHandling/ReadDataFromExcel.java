package dataHandling;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {
    public String sendData(int i,int j) throws IOException {
        String excelFilePath = "C:\\Users\\karthikck\\IdeaProjects\\Automatic-Resume-Filter-Automation\\AutomaticResumeFilter\\src\\resources\\quizData.xlsx";
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        XSSFRow row = null;
        XSSFCell cell = null;
        row = sheet.getRow(i);
        cell = row.getCell(j);
        String send = cell.getStringCellValue();
        return send;
    }
}
