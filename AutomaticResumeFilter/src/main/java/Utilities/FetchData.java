package Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class FetchData {

    public static List<List<String>> testData = new ArrayList<>();
    public static List<List<String>> getTestData() {

        try {
            XSSFWorkbook xsf = new XSSFWorkbook("src/main/LoginDetails.xlsx");
            XSSFSheet sheet = xsf.getSheetAt(0);
            for(int i=2; i<=2; i++) {
                List<String> line = new ArrayList<>();
                line.add(sheet.getRow(i).getCell(1).getStringCellValue());
                line.add(sheet.getRow(i).getCell(2).getStringCellValue());
                line.add(sheet.getRow(i).getCell(3).getStringCellValue());
//                line.add(Integer.toString((int)sheet.getRow(i).getCell(3).getNumericCellValue()));
//                line.add(Integer.toString((int)sheet.getRow(i).getCell(4).getNumericCellValue()));
//                line.add(Integer.toString((int)sheet.getRow(i).getCell(5).getNumericCellValue()));
                testData.add(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }

}