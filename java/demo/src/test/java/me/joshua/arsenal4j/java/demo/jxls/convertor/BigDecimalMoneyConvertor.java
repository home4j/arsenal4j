package me.joshua.arsenal4j.java.demo.jxls.convertor;

import java.math.BigDecimal;

import org.jxls.reader.convertor.Convertor;

public class BigDecimalMoneyConvertor implements Convertor {

	@Override
	public Object convert(String dataStr) {
		if (null == dataStr) {
			return null;
		}

		BigDecimal money = new BigDecimal(dataStr);
		money = money.multiply(new BigDecimal(100));

		return money;
	}

}
