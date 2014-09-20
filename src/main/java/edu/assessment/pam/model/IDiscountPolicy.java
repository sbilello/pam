package edu.assessment.pam.model;

import java.math.BigDecimal;


public interface IDiscountPolicy {
	BigDecimal getAdditionalDiscount();
	BigDecimal getLimit();
}
