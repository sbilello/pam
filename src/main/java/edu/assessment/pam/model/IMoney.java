package edu.assessment.pam.model;

import java.math.BigDecimal;
import java.util.Currency;

public interface IMoney {
	BigDecimal getValue();
	void setValue(BigDecimal value);
	void setCurrency(Currency currency);
	Currency getCurrency();
}
