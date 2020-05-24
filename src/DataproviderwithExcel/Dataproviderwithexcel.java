package DataproviderwithExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataproviderwithexcel {
	
	XSSFWorkbook workbook;
	
	XSSFSheet sheet;
	
	//How to read excel file
	
	public Dataproviderwithexcel(String Excelnewfile)
	{
	
		try {
			File src = new File(Excelnewfile);
		
		
	
			FileInputStream	Input = new FileInputStream(src);
		
		
             workbook =  new XSSFWorkbook(Input);
  
               
		}
		
		
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	

	
	}
	
	public String data(int Sheetnumber, int row, int column)
	{
		sheet = 	workbook.getSheetAt(Sheetnumber);
		
	String Datanew = 	sheet.getRow(row).getCell(column).getStringCellValue();
		
		return Datanew;
		
	}
	
	public  int rowcount(int sheetindex)
	{
		
		int Rownumbers = workbook.getSheetAt(sheetindex).getLastRowNum();
         Rownumbers = Rownumbers+1;
         
         return Rownumbers;
     
	}

}
