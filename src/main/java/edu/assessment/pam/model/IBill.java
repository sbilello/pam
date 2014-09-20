package edu.assessment.pam.model;

import java.util.List;

public interface IBill {
	List<IProduct> getProducts();
	double getTotal();
	double getTotalDiscount();
	void printBill();
	void setProducts(List<IProduct> products);
}
