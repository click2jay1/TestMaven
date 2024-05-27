package MavenPakage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestExcel {

    String src = "C:\\Selenium\\tableData1.xlsx";
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;

    @Test
    public void readFromLocal() throws IOException {
        fis = new FileInputStream(src);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum() + 1;
        int colCount = sheet.getRow(0).getLastCellNum();

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                XSSFCell cell = sheet.getRow(r).getCell(c);

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                }
            }
            System.out.println();
        }
        wb.close(); // Close the workbook after reading
    }
}