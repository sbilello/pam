package edu.assessment.pam.model;

public interface IOrderEntry {
	IProduct getProduct();
	int getQuantity();
	IMoney getFinalPrice();
	void setFinalPrice(IMoney finalPrice);
}
