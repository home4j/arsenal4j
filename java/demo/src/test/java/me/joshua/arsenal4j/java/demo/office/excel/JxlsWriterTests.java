package me.joshua.arsenal4j.java.demo.office.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import com.google.common.io.Resources;

public class JxlsWriterTests {

	private static final List<Employee> employees;

	static {
		employees = new LinkedList<>();
		try {
			employees.add(new Employee("Joshua Jeme", "Tencent", Employee.BIRTHDAY_FORMAT.parse("20140212"), 23,
			        new BigDecimal(100), 1000L));
			// 测试bonus为null时，JEXL解析的结果
			employees.add(new Employee("Joshua Zhan", "163", Employee.BIRTHDAY_FORMAT.parse("20130422"), 32,
			        new BigDecimal(200), null));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws Throwable {
		File output = new File(FileUtils.getTempDirectory(), "employee_output.xlsx");
		try (InputStream is = Resources.getResource("excel/employee_template.xlsx").openStream();
		        OutputStream os = new FileOutputStream(output)) {
			FileUtils.deleteQuietly(output);
			Context context = new Context();
			// 注入Bean，作为函数使用
			context.putVar("dateFormat", Employee.BIRTHDAY_FORMAT);
			context.putVar("employees", employees);
			JxlsHelper.getInstance().processTemplate(is, os, context);
			System.out.println(output.getCanonicalPath());
		}
	}
}
