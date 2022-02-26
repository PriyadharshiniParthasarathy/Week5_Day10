package Week5_Day2_Assignment;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcel_DuplicateLead {

	public static String[][] getExcelData() throws IOException {
	
		
String Filelocation = "./Testdata/Data.xlsx";
XSSFWorkbook Wbook = new XSSFWorkbook(Filelocation);
XSSFSheet sheet = Wbook.getSheetAt(4);
int lastRowNum = sheet.getLastRowNum();
int physicalNumberofrows = sheet.getPhysicalNumberOfRows();
System.out.println("Inclusive of rows----" +physicalNumberofrows);	
System.out.println("NO of Rows----" +lastRowNum);	
short lastCellNum = sheet.getRow(0).getLastCellNum();
System.out.println("NO of cells----" +lastCellNum);	

String[][] data = new String[lastRowNum][lastCellNum];
for(int i=1;i<=lastRowNum;i++) {
	XSSFRow row = sheet.getRow(i);
	for(int j=0;j<lastCellNum;j++) {
		XSSFCell cell = row.getCell(j);
		DataFormatter dft = new DataFormatter();
		String value = dft.formatCellValue(cell);
		//System.out.println(value);	
		data[i-1][j] = value;
		
	}
}
Wbook.close();
return data;

	}




}
