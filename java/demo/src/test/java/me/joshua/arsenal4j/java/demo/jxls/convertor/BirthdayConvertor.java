package me.joshua.arsenal4j.java.demo.jxls.convertor;

import java.text.ParseException;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jxls.reader.convertor.Convertor;

public class BirthdayConvertor implements Convertor {

	private Logger LOG = LogManager.getLogger();
	private static final FastDateFormat BIRTHDAY_FORMAT = FastDateFormat.getInstance("yyyyMMdd");

	@Override
	public Object convert(String birthdayStr) {
		if (null == birthdayStr) {
			return null;
		}
		try {
			return BIRTHDAY_FORMAT.parse(birthdayStr);
		} catch (ParseException e) {
			LOG.error("Convert birthday[" + birthdayStr + "] error, return null", e);
			e.printStackTrace();
		}
		return null;
	}

}
