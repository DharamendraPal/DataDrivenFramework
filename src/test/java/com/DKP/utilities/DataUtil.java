package com.DKP.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import com.DKP.base.TestBase;

public class DataUtil extends TestBase {
	
	@DataProvider(name="dp")
	public static Object[][] getData(Method m) {
		String sheetName = m.getName();
		int rowCount = excel.getRowCount(sheetName);
		int colCount = excel.getColumnCount(sheetName);
	
		Object[][] data = new Object[rowCount-1][1];
		
		Hashtable<String,String> table=null;
		
		for(int rows=2;rows<=rowCount;rows++) {
			table =new Hashtable<String,String>();
			
			for(int cols=0; cols<colCount; cols++) {
				table.put(excel.getCellData(sheetName, cols, 1), excel.getCellData(sheetName, cols, rows));
				data[rows-2][0]=table;	
			}	
		}
		return data;
		
	}
	
	
	public static boolean isTestRunnable(String testname, ExcelReader excel)
	{
		String SheetName="test_suite";
		int rowcount=excel.getRowCount(SheetName);
		for(int rNum=2;rNum<=rowcount;rNum++)
		{
			String testcase =excel.getCellData(SheetName, "TCID", rNum);
			
			if(testcase.equalsIgnoreCase(testname))
			{
				 String runmode=excel.getCellData(SheetName, "runmode", rNum);
				 if(runmode.equalsIgnoreCase("Y"))
					 return true ;
				 else
					 return false;
			}
		}
		return false;
		
	}
	
	


}
