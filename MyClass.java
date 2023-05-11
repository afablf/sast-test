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

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat sdfDataBase = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat sdfDataBaseBR = new SimpleDateFormat("dd/MM/yyyy");


	public void myPublicMethod(StringBuffer sql, String startDateToConvert, String endDateToConvert) {
		sql.append(" WHERE p.segment  in ('2W', 'WW') ");

		if (Validator.isNotNull(startDateToConvert)) {
			final Date dateUser = MyClass.sdf.parse(startDateToConvert);
			final String startDate = MyClass.sdfDataBase.format(dateUser);
			sql.append(" AND p.billingDate >='" + startDate + "' ");
		} else if (Validator.isNotNull(endDateToConvert)) {
			final Date dateUser = MyClass.sdf.parse(endDateToConvert);
			final String startDate = MyClass.sdfDataBase.format(dateUser);
			sql.append(" AND p.billingDate <='" + endDate + "' ");		
		}

	}

}