package libraries;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import baseClass.*;

public class Utils extends CommonVariables {

	static String ExcelPath;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	static int GetRowCount() {
		try {
			wb = new XSSFWorkbook(TestDataPath);
			sheet = wb.getSheet("Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);

		return rowCount;

	}

	static void GetCellData(int rowNum, int colNum) {

		try {
			wb = new XSSFWorkbook(TestDataPath);
			sheet = wb.getSheet("Sheet1");
			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
//		sheet.getRow(0).getCell(1).getStringCellValue();
			System.out.println(value);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			// TODO: handle exception
		}

	}

	public static Object[] ReadRowData(String TCName){
		boolean bTag = false;
		Object[] arr = new Object[15];
		try {
			wb = new XSSFWorkbook(TestDataPath);
			sheet = wb.getSheet("Sheet1");
			DataFormatter formatter = new DataFormatter();
			int rowcount = GetRowCount() + 1;
			for (int i = 1; i < rowcount; i++) {
				Row r1 = sheet.getRow(i);
				Object exlTCName = formatter.formatCellValue(r1.getCell(1));
				if (TCName.equals(exlTCName)) { 
					int colCount = r1.getLastCellNum(); //Iterating to get the row data
					for (int j = 2; j <= colCount - 1; j++) {
						arr[j - 2] = formatter.formatCellValue(r1.getCell(j));
					}

					bTag = true;
					break;
				}
			}

			if (bTag == false) {
				System.out.println("Test case Name not found in test data sheet");
			}

		}

		catch (Exception e) {
			System.out.println("unknown exception");
		}
		return arr;
	}

}
