package edu.assessment.pam.model.impl;

import java.math.BigDecimal;
import java.util.Currency;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import edu.assessment.pam.constants.Constant;
import edu.assessment.pam.model.IMoney;

public class Money implements IMoney {

	private Currency currency = Currency.getInstance(Constant.DEFAULT_LOCALE);
	private BigDecimal value;

	public Money(){
		value = new BigDecimal("0.0");
	}
	
	public Money(BigDecimal value){
		this.value=value;
	}
	public Money(String money){
		value = new BigDecimal(money);
	}
	
	@Override
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public void setValue(BigDecimal value) {
		this.value=value;
	}

	@Override
	public Currency getCurrency() {
		return currency;
	}

	@Override
	public void setCurrency(Currency currency) {
		this.currency=currency;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Money) {
			Money other = (Money) obj;
            EqualsBuilder builder = new EqualsBuilder();
            builder.append(this.currency, other.currency)
            	   .append(this.value, other.value);
            return builder.isEquals();
        }
        return false;
    }

	
	@Override
	public int hashCode(){
		HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(currency)
        	   .append(value);
        return builder.toHashCode();
	}
}