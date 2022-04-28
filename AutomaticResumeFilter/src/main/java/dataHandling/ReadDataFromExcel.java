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
        String excelFilePath = "C:\\Users\\karthikck\\Desktop\\Automation Testing\\AutomaticResumeFilter\\src\\resources\\quizData.xlsx";
        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell = null;
        row = sheet.getRow(i);
        cell = row.getCell(j);
        String send = cell.getStringCellValue();
        return send;
    }

    public String getQuizLink(int row, int col) throws IOException {
        String link = sendData(row, col);
        return link;
    }

    public String getQuizDate(int row, int col) throws IOException {
        String date = sendData(row, col);
        return date;
    }

    public String getQuizTime(int row, int col) throws IOException {
        String time = sendData(row, col);
        return time;
    }

    public String getQuizQuestions(int row, int col) throws IOException {
        String questions = sendData(row, col);
        return questions;
    }
}
