package edu.assessment.pam.model.impl;

import java.math.BigDecimal;

import edu.assessment.pam.model.IMoney;
import edu.assessment.pam.model.IProduct;

public class NoDiscountProduct implements IProduct {

	private String name;
	private IMoney unitCost;
	private BigDecimal discount;

	public NoDiscountProduct(){
		this.discount= new BigDecimal("0.0");
	}
	
	public NoDiscountProduct (String name, IMoney unitCost){
		this.name=name;
		this.unitCost=unitCost;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public IMoney getUnitCost() {
		return unitCost;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public void setUnitCost(IMoney unitCost) {
		this.unitCost=unitCost;
	}

	@Override
	public BigDecimal getDiscount() {
		return discount;
	}

	@Override
	public void setDiscount(BigDecimal discount) {
		this.discount=discount;
	}

}