package TestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class EXcelconfig {
	

XSSFWorkbook WB;

XSSFSheet Sheet0;
	
	public void EXcelconfig(String Excelfilepath) throws Exception
	{
		File fil = new File(Excelfilepath);
		
		FileInputStream fis = new FileInputStream(fil);
		
		XSSFWorkbook WB = new XSSFWorkbook(fis);
		
		
		
		
	}
	
	public String getexceldata(int sheetnumber,int row,int col)
	
	
	{
		
		 Sheet0 = WB.getSheetAt(sheetnumber);
		
		String sheetdata = Sheet0.getRow(row).getCell(col).getStringCellValue()
;		return sheetdata;
	}

}
