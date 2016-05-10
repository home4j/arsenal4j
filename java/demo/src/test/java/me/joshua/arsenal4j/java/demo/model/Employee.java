package me.joshua.arsenal4j.java.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class Employee extends BaseObject {

	private static final long serialVersionUID = -631104225329523221L;
	public static final FastDateFormat BIRTHDAY_FORMAT = FastDateFormat.getInstance("yyyyMMdd");

	private String name;
	private String company;
	private Date birthday;
	private Integer age;
	private BigDecimal salary;
	/**
	 * 单位分
	 */
	private Long bonus;

	public Employee() {
		super();
	}

	public Employee(String name, String company, Date birthday, Integer age, BigDecimal salary, Long bonus) {
		super();
		this.name = name;
		this.company = company;
		this.birthday = birthday;
		this.age = age;
		this.salary = salary;
		this.bonus = bonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Long getBonus() {
		return bonus;
	}

	public void setBonus(Long bonus) {
		this.bonus = bonus;
	}

}
