package TestPractice.Guru99Bank.TestBase;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtility {
	static String sourcefolder;
	static LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String,String>>> getsheetdata;

	public ExcelUtility(String sourcefolder) {
		super();
		this.sourcefolder=sourcefolder;
		// TODO Auto-generated constructor stub
	}
	@Test
	public static void readData(String fileName) throws IOException
	{
		String inputfile=sourcefolder+"/TestData/"+fileName;
		FileInputStream fis=new FileInputStream(inputfile);
		Workbook wb=new XSSFWorkbook(fis);
		int sheetcount=wb.getNumberOfSheets();
		System.out.println(sheetcount);
		
		 getsheetdata=new LinkedHashMap<String, LinkedHashMap<String,LinkedHashMap<String,String>>>();
		for(int i=0;i<sheetcount;i++)
		{
			String sheetname=wb.getSheetAt(i).getSheetName();
			System.out.println("sheetname:"+sheetname);
			Sheet st=wb.getSheetAt(i);
			int noOfrowCount=st.getPhysicalNumberOfRows();
			System.out.println("no of sheets:"+noOfrowCount);
			Row headerrow=st.getRow(i);
			System.out.println("header row:"+headerrow);
			
			LinkedHashMap<String, LinkedHashMap<String,String>> sheetmap=new LinkedHashMap<String, LinkedHashMap<String,String>>();
			for(int j=1;j<noOfrowCount;j++)
			{
				Row rowno=st.getRow(j);
				int noOfCell=rowno.getLastCellNum();
				
				LinkedHashMap<String,String> rowmap=new LinkedHashMap<String, String>();
				for(int k=0;k<noOfCell;k++)
				{
					String headerdata;
					if(rowno.getCell(k)==null)
					{
						headerdata="";
					}
					else
					{
						headerdata=headerrow.getCell(k).toString();	
					}
					
					String cellData;
					if(rowno.getCell(k)==null)
					{
						cellData="";
					}else{
						cellData=rowno.getCell(k).toString();
					}
					
					rowmap.put(headerdata, cellData);
				}
			String uniquecol=st.getRow(j).getCell(0).toString();
			sheetmap.put(uniquecol, rowmap);
				
			}	
			getsheetdata.put(sheetname, sheetmap);
		}
		
		
	}
	
	
	public LinkedHashMap<String, LinkedHashMap<String, String>> getsheetdata(String Sheetname)
	{
		return getsheetdata.get(Sheetname);
		
	}
	
	public LinkedHashMap<String, String> getsheet(String Sheetname,String testcaseID)
	{
		return getsheetdata.get(Sheetname).get(testcaseID);
		
	}
	
	public String getcolumnData(String Sheetname,String testcaseID,String columnname)
	{
		return getsheetdata.get(Sheetname).get(testcaseID).get(columnname);
		
	}
	
}
