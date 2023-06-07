package PackageCommonFunction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class Utilitycommonfunction {
	
	public static void evidencefilecreator(String filename, String requestBody, String responseBody) throws IOException {
		
		File newfile=new File("E:\\New folder\\"+filename+".txt");
		System.out.println("A new file created to record request and response body:"+newfile.getName());
		
		FileWriter datawrite=new FileWriter(newfile);
		datawrite.write("Request body:"+requestBody+"\n\n");
		datawrite.write("Response body:"+responseBody);
		datawrite.close();
		System.out.println("Request body and Response body are saved in file:"+newfile.getName());
		
		
	}
	
	public static ArrayList<String> readdataexcel(String Sheetname, String Testcasename) throws IOException 
	{
		ArrayList<String> ArrayData=new ArrayList<String>();
		
		// Step 1 : Create the object of file input string.
		FileInputStream fis=new FileInputStream("E:\\New folder\\restassuredtestfile.xlsx");
			
		// Step 2 : Access the excel file.
		XSSFWorkbook Workbook=new XSSFWorkbook(fis);
		
		// Step 3 : Access the Sheet name.
		int countofsheet=Workbook.getNumberOfSheets();
		
		for (int i=0; i<countofsheet; i++)
		{	
			String filesheetname=Workbook.getSheetName(i);
			
			if (filesheetname.equalsIgnoreCase(Sheetname))	
			{
			
		// Step 4 : Access the row from where the data is supposed to fetch.
				
				XSSFSheet Sheet=Workbook.getSheetAt(i);
				Iterator<Row> rows=Sheet.iterator();
				
			while(rows.hasNext())
			{
				Row r1=rows.next();
				if (r1.getCell(0).getStringCellValue().equalsIgnoreCase(Testcasename))
				{
				Iterator<Cell> cellvalues=r1.cellIterator();
				
				while(cellvalues.hasNext())
				{
					String testdata=cellvalues.next().getStringCellValue();
					
					ArrayData.add(testdata);							
				}
			}
							
	}
}
		}
		Workbook.close();			
		return ArrayData;
	}
}


































