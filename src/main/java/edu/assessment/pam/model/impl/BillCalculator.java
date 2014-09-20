package edu.assessment.pam.model.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import edu.assessment.pam.model.IBillCalculator;
import edu.assessment.pam.model.IDiscountPolicy;
import edu.assessment.pam.model.IMoney;
import edu.assessment.pam.model.IOrderEntry;
import edu.assessment.pam.util.MathHelper;

public class BillCalculator implements IBillCalculator{

	private List<IOrderEntry> orderEntries = new LinkedList<IOrderEntry>();
	private IDiscountPolicy discountPolicy;
	private IMoney total, totalDiscount, grossTotal, volumeDiscount;
	private boolean discountPolicyApplied;
	
	public static BillCalculator create (List<IOrderEntry> orderEntries, IDiscountPolicy discountPolicy){
		return new BillCalculator(orderEntries, discountPolicy);
	}
	
	private BillCalculator(List<IOrderEntry> orderEntries, IDiscountPolicy discountPolicy){
		assert orderEntries != null;
		assert discountPolicy != null;
		this.discountPolicy=discountPolicy;
		this.orderEntries=orderEntries;
		total = new Money();
		totalDiscount = new Money();
		grossTotal = new Money();
	}
	
	@Override
	public List<IOrderEntry> getOrderEntries() {
		return orderEntries;
	}

	@Override
	public IMoney getTotal() {
		return total;
	}

	@Override
	public IMoney getTotalDiscount() {
		return totalDiscount;
	}

	@Override
	public void setOrderEntries(List<IOrderEntry> orderEntries) {
		this.orderEntries=orderEntries;
	}

	@Override
	public void setDiscountPolicy(IDiscountPolicy discountPolicy) {
		this.discountPolicy=discountPolicy;
	}

	@Override
	public IDiscountPolicy getDiscountPolicy() {
		return discountPolicy;
	}
	
	@Override
	public IMoney getGrossTotal() {
		return grossTotal;
	}

	@Override
	public boolean isDiscountPolicyApplied() {
		return discountPolicyApplied;
	}

	@Override
	public IMoney getVolumeDiscount() {
		return volumeDiscount;
	}
	@Override
	public void calculate() {
		BigDecimal totBigDec = new BigDecimal("0.0");
		BigDecimal totDiscountBigDec = new BigDecimal("0.0");
		for (IOrderEntry o : orderEntries){
			BigDecimal unitCost = o.getProduct().getUnitCost().getValue();
			BigDecimal partialDiscount = o.getProduct().getDiscount();
			BigDecimal discount = unitCost.multiply(partialDiscount);
			BigDecimal discountedUnit = unitCost.subtract(discount);
			BigDecimal finalPrice = discountedUnit.multiply(new BigDecimal (o.getQuantity()));
			o.getFinalPrice().setValue(MathHelper.roundOffPercentage(finalPrice));
			totDiscountBigDec = totDiscountBigDec.add(discount);
			totBigDec = totBigDec.add(finalPrice);
		}
		grossTotal = new Money(MathHelper.roundOffPercentage(totBigDec));
		if (totBigDec.compareTo(discountPolicy.getLimit())>0){
			discountPolicyApplied = true;
			BigDecimal additionalDiscountPercentage = discountPolicy.getAdditionalDiscount();
			BigDecimal amountDiscounted = totBigDec.multiply(additionalDiscountPercentage);
			volumeDiscount= new Money(amountDiscounted);
			totBigDec=totBigDec.subtract(amountDiscounted);
			totDiscountBigDec=totDiscountBigDec.add(amountDiscounted);
		}
		total = new Money(MathHelper.roundOffFiveCents(totBigDec));
		totalDiscount = new Money(MathHelper.roundOffPercentage(totDiscountBigDec));
	}

}