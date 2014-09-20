package edu.assessment.pam.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class FormatterHelper {
	private static final DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(Locale.UK);
	private static final DecimalFormat percentageFormat = (DecimalFormat) DecimalFormat.getInstance(Locale.UK);
	
	static {
		decimalFormat.setMinimumFractionDigits(2);
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setGroupingUsed(false);		
		decimalFormat.setRoundingMode(RoundingMode.FLOOR);

		percentageFormat.setMaximumFractionDigits(2);
		percentageFormat.setGroupingUsed(false);		
		percentageFormat.setRoundingMode(RoundingMode.FLOOR);
	}
	
	public static String percentageFormatter(BigDecimal value){
		assert value != null;
		return percentageFormat.format(value.multiply(new BigDecimal("100")))+"%";
	}
	
	public static String moneyFormatter(BigDecimal value){
		assert value != null;
		return decimalFormat.format(value);
	}
}
