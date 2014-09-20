package edu.assessment.pam.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathHelper {
	
	public static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");
	public static final BigDecimal ROUND_FACTOR_PERCENTAGE = new BigDecimal("0.005");
	
	public static BigDecimal roundOffPercentage(BigDecimal value){
		return round(value, ROUND_FACTOR_PERCENTAGE ,RoundingMode.UP);
	}
	public static BigDecimal roundOffFiveCents(BigDecimal value){
		return round(value, ROUND_FACTOR ,RoundingMode.UP);
	}
	
    public static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
        if (increment.signum() == 0) {
            return value;
        } else {
            BigDecimal divided = value.divide(increment, 0, roundingMode);
            BigDecimal result = divided.multiply(increment);
            return result;
        }
    }
}
