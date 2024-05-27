package MavenPakage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadingExcelAndPrint {
	Scanner input = new Scanner(System.in);
	String src= "C:\\Selenium\\tableData1.xlsx";
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	//System.out.print(cell.getStringCellValue()+"\t");
	
	
	@Test//(dataProvider = "sheetNumber")
	public void readFromLocal() throws IOException
	{
		ExcelUtility excel = new ExcelUtility();
		//int s= excel.sheetNumber();
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		
		for (int r=0; r<rowCount; r++)
		{
			for ( int c =0; c<colCount; c++)
			{
				XSSFCell cell = sheet.getRow(r).getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING: System.out.print(cell.getStringCellValue()+"\t"); break;
				case NUMERIC: System.out.print((double)cell.getNumericCellValue()+"\t"); break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue()+"\t"); break;
				}
				
				
			}
			System.out.println();
		} 
		wb.close();
	}
}
		
		/////////////// Using Iterator /////////////
		/*
		Iterator itRow = sheet.iterator();
		while(itRow.hasNext())
		{
			XSSFRow row = (XSSFRow) itRow.next();
			Iterator itCell = row.cellIterator();
			
			while (itCell.hasNext())
			{
				XSSFCell cell = (XSSFCell) itCell.next();
				switch(cell.getCellType())
				{
				case STRING: System.out.print(cell.getStringCellValue()+"\t"); break;
				case NUMERIC: System.out.print((double)cell.getNumericCellValue()+"\t"); break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue()+"\t"); break; 
				}
				System.out.print(" | ");
				
			}
			System.out.println();
		}
		*/
		
		

