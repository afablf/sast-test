import com.liferay.portal.dao.orm.custom.sql.CustomSQL;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.util.Validator;

public class MyClass {

	private static final String BR_DATE_PATTERN = "dd/MM/yyyy";
	private static final String DB_DATE_PATTERN = "yyyy-MM-dd";

	public void myPublicMethod(StringBuffer sql, String startDateToConvert, String endDateToConvert) {
		sql.append(" WHERE p.segment  in ('2W', 'MM') ");

		if (Validator.isNotNull(salesSearchDTO.getSalesReportStart())) {
			final Date dateUser = getDateFromString(BR_DATE_PATTERN, dateToConvert);
			final String startDate = getDateString(DB_DATE_PATTERN, dateUser);
			sql.append(" AND p.billingDate >='" + startDate + "' ");
		} else if (Validator.isNotNull(endDateToConvert)) {
			final Date dateUser = getDateFromString(BR_DATE_PATTERN, endDateToConvert);
			final String endDate = getDateString(DB_DATE_PATTERN, dateUser);
			sql.append(" AND p.billingDate <='" + endDate + "' ");		
		}

	}

	private String getDateString(String pattern, Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}
	
	private Date getDateFromString(String pattern, String dateString) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		return simpleDateFormat.parse(dateString);
	}
}