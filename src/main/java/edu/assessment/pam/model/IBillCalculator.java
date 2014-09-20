package edu.assessment.pam.model;

import java.util.List;

public interface IBillCalculator {
	List<IOrderEntry> getOrderEntries();
	IMoney getTotal();
	IMoney getTotalDiscount();
	IDiscountPolicy getDiscountPolicy();
	void setOrderEntries(List<IOrderEntry> orderEntries);
	void setDiscountPolicy(IDiscountPolicy discountPolicy);
	void calculate();
	IMoney getGrossTotal();
	IMoney getVolumeDiscount();
	boolean isDiscountPolicyApplied();
}
