package ninzaCRM.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Chaitra M
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel file and return the value to caller
	 * @param sheetName
	 * @param rowIndex
	 * @param celIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * 
	 */
	public String readDataFromExcel(String sheetName, int rowIndex, int celIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData - NinzaCRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowIndex).getCell(celIndex).getStringCellValue();
		return value;
	}
}
