package edu.assessment.pam.model;

import java.math.BigDecimal;


public interface IProduct {
	 String getName();
	 IMoney getUnitCost();
	 BigDecimal getDiscount();
	 void setName(String name);
	 void setUnitCost(IMoney unitCost);
	 void setDiscount(BigDecimal discount);
}