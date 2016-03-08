package me.joshua.arsenal4j.demo.poi;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.junit.Test;

import com.google.common.io.Resources;

/**
 * 表格测试
 * 
 * @author daonan.zhan
 */
public class SheetTests {

	@Test
	public void test() throws Throwable {
		Workbook wb = WorkbookFactory.create(new File(Resources.getResource("poi/contacts.xlsx").getFile()));
		Sheet sheet = wb.getSheet("contacts");
		for (Row row : sheet) {
			for (int i = 0; i < row.getLastCellNum(); i++) {
				Cell cell = row.getCell(i);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				System.out.println(cell.getStringCellValue());
			}
		}
		IOUtils.closeQuietly(wb);
	}
}
