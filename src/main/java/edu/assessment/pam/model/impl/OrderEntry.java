package edu.assessment.pam.model.impl;

import edu.assessment.pam.model.IMoney;
import edu.assessment.pam.model.IOrderEntry;
import edu.assessment.pam.model.IProduct;

public class OrderEntry implements IOrderEntry {
	private final IProduct product;
	private final int quantity;
	private IMoney finalPrice;
	
	public static OrderEntry create(IProduct product, int quantity){
		return new OrderEntry(product,quantity);
	}
	private OrderEntry(IProduct product, int quantity){
		this.product=product;
		this.quantity=quantity;
		finalPrice = new Money("0.0");
	}

	@Override
	public IProduct getProduct() {
		return product;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
	@Override
	public IMoney getFinalPrice() {
		return finalPrice;
	}
	@Override
	public void setFinalPrice(IMoney finalPrice) {
		this.finalPrice=finalPrice;
	}

}
