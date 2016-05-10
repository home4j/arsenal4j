package me.joshua.arsenal4j.java.demo.jxls;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;

import com.google.common.io.Resources;

import me.joshua.arsenal4j.java.commons.TestUtils;
import me.joshua.arsenal4j.java.demo.model.Employee;

public class JxlsReaderTests {

	@Test
	public void test() throws Throwable {
		try (InputStream configIs = Resources.getResource("excel/employee_reader_config.xml").openStream();
		        InputStream dataIs = Resources.getResource("excel/employees.xlsx").openStream()) {
			XLSReader reader = ReaderBuilder.buildFromXML(configIs);
			List<Employee> employees = new LinkedList<>();
			Map<String, Object> beans = new HashMap<>();
			beans.put("employees", employees);
			reader.read(dataIs, beans);
			Assert.assertEquals(2, employees.size());
			TestUtils.print(employees);
		}
	}
}
