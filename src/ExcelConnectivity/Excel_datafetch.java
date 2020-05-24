package ExcelConnectivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_datafetch {

	public static void main(String[] args) throws Exception {
		
		//TO spcify the location of FIle
		
		File fil = new File("C:\\Users\\DELL\\Desktop\\TestingFile.xlsx");
		
		//Load the input file
		
		FileInputStream fis = new FileInputStream(fil);
		
		//Sprcify the Workbook
		
		XSSFWorkbook WB = new XSSFWorkbook(fis);
		
		//Specify the sheet number/sheetname
		
		
	XSSFSheet sheet0 =	WB.getSheetAt(0);
	
	String Row1col0 = sheet0.getRow(1).getCell(1).getStringCellValue();
	
	System.out.println("Row o and coloumn 0 value is " +Row1col0);
	
	String Row3col1 = sheet0.getRow(3).getCell(1).getStringCellValue();
	
	System.out.println(Row3col1);
	
	int Rowtotal = sheet0.getLastRowNum();
	
	System.out.println("Total row is " +Rowtotal);
	
	System.out.println("******************");
	
	for(int i = 0; i<Rowtotal;i++)
	{
		String Rowdata = sheet0.getRow(i).getCell(0).getStringCellValue();	
		
		
		//System.out.println(Rowdata);
		
		//System.out.println("@@@@@@@");
		
		String Coldata = sheet0.getRow(1).getCell(i).getStringCellValue();
		
		System.out.println(Coldata);
	}
	
	
	
	

	}

}
