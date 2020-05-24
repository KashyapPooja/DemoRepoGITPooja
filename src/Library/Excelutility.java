package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	
	XSSFWorkbook WB;
	XSSFSheet Sheetnumber;

	//C:\\Users\\DELL\\eclipse-workspace\\TestNGProject\\TestDataExcel\\School_Enquiry.xlsx
	public  Excelutility(String ExcelPath) throws Exception
	{
		
File fil = new File(ExcelPath);
		
		FileInputStream fis = new FileInputStream(fil);
		
		 WB = new XSSFWorkbook(fis);
		

	
	int Totalrows = Sheetnumber.getLastRowNum();
	
	System.out.println("Total rows are " +Totalrows);
	}
	
public String getexceldata(int Sheetnum,int row,int column)
{
	
	 Sheetnumber = 	WB.getSheetAt(Sheetnum);
	 
	String data =  Sheetnumber.getRow(row).getCell(column).getStringCellValue();
	
	return data;
	
}

public int rownumbercalc(int sheetnumber1)
{
	int Sheetrownumber = WB.getSheetAt(sheetnumber1).getLastRowNum();
	Sheetrownumber = Sheetrownumber+1;
	
	return Sheetrownumber;
	
}
}
