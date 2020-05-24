package TestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class newutilexcel {
	
	XSSFWorkbook WB ;
	
	XSSFSheet sheet;
	
	public newutilexcel(String Excel_Path) throws Exception
	{
		try {
			File fil = new File(Excel_Path);
			
			FileInputStream Fis = new FileInputStream(fil);
			
			XSSFWorkbook WB = new XSSFWorkbook(Fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
	public String getexceldata(int Sheetnumber,int row,int column)
	{
		
	sheet = 	WB.getSheetAt(Sheetnumber);
	
String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	
	public int ROwcount(int sheetnumbernew)
	{
	;
        
       int Rownumber =  WB.getSheetAt(sheetnumbernew).getLastRowNum();
		
       Rownumber = Rownumber+1;
		return Rownumber;
	}

}
