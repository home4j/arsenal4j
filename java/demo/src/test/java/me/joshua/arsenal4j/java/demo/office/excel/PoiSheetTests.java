package me.joshua.arsenal4j.java.demo.office.excel;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.Resources;

import me.joshua.arsenal4j.java.commons.TestUtils;

/**
 * 表格测试
 * 
 * @author daonan.zhan
 */
public class PoiSheetTests {

	@Test
	public void test() throws Throwable {
		Workbook wb = WorkbookFactory.create(new File(Resources.getResource("excel/employees.xlsx").getFile()));
		Sheet sheet = wb.getSheet("employees");
		Iterator<Row> itr = sheet.iterator();
		itr.next();
		List<Employee> employees = new LinkedList<>();
		while (itr.hasNext()) {
			employees.add(populate(itr.next()));
		}
		IOUtils.closeQuietly(wb);

		Assert.assertEquals(2, employees.size());
		TestUtils.print(employees);
	}

	private Employee populate(Row row) {
		if (null == row) {
			return null;
		}
		Employee employee = new Employee();
		int i = 0;
		Cell cell = null;
		cell = row.getCell(i++);
		// 当数据为空时cell为null，需要额外的判断
		if (null != cell) {
			employee.setName(cell.getStringCellValue());
		}
		cell = row.getCell(i++);
		if (null != cell) {
			employee.setCompany(cell.getStringCellValue());
		}
		cell = row.getCell(i++);
		if (null != cell) {
			try {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				employee.setBirthday(Employee.BIRTHDAY_FORMAT.parse(cell.getStringCellValue()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		cell = row.getCell(i++);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			employee.setAge(Integer.parseInt(cell.getStringCellValue()));
		}
		cell = row.getCell(i++);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			employee.setSalary(new BigDecimal(cell.getStringCellValue()));
		}
		cell = row.getCell(i++);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			employee.setBonus(Long.parseLong(cell.getStringCellValue()));
		}
		return employee;
	}
}
