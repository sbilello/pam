package edu.assessment.pam.model.impl;

import java.math.BigDecimal;

import edu.assessment.pam.model.IDiscountPolicy;


public enum DiscountPolicyType {
	STANDARD(new BigDecimal("0.05"),new BigDecimal("40.0"));
	
	DiscountPolicyType(BigDecimal additionalDiscount, BigDecimal limit){
		this.discountPolicy=new DiscountPolicy(additionalDiscount,limit);
	}
	
	private IDiscountPolicy discountPolicy;
	
	public IDiscountPolicy getDiscountPolicy(){
		return discountPolicy;
	}
	
	private class DiscountPolicy implements IDiscountPolicy{

		private BigDecimal additionalDiscount;
		private BigDecimal limit;
		
		public DiscountPolicy(BigDecimal additionalDiscount, BigDecimal limit){
			this.additionalDiscount=additionalDiscount;
			this.limit=limit;
		}
		
		@Override
		public BigDecimal getLimit() {
			return limit;
		}

		@Override
		public BigDecimal getAdditionalDiscount() {
			return additionalDiscount;
		}
	}
}

	
