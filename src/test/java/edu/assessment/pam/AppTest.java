package edu.assessment.pam;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import edu.assessment.pam.factory.ProductFactory;
import edu.assessment.pam.model.IBillCalculator;
import edu.assessment.pam.model.IDiscountPolicy;
import edu.assessment.pam.model.IMoney;
import edu.assessment.pam.model.IOrderEntry;
import edu.assessment.pam.model.IProduct;
import edu.assessment.pam.model.ProductType;
import edu.assessment.pam.model.impl.BillCalculator;
import edu.assessment.pam.model.impl.DiscountPolicyType;
import edu.assessment.pam.model.impl.Money;
import edu.assessment.pam.model.impl.OrderEntry;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
//	1 Pasta 1kg at 4.29
//	1 Book at 10.12
//				Quantity UnitPrice Discount Final Price
//
//	Pasta 1kg   1 		4.29 		7.5% 	3.97
//	Book 		1 		10.12 		12% 	8.91
//
//	Total 12.90
//	(Total discounts 1.53)
	 
    @Test
    public void firstReceipt(){
    	IProduct book = ProductFactory.getProductByProductType(ProductType.BOOK);
    	book.setUnitCost(new Money("10.12"));
    	book.setName("Book");
    	IProduct pasta = ProductFactory.getProductByProductType(ProductType.GROCERY);
    	pasta.setUnitCost(new Money("4.29"));
    	pasta.setName("Pasta 1kg");
    	List<IOrderEntry> entries = new LinkedList<IOrderEntry>();
    	IOrderEntry entryBook = OrderEntry.create(book, 1);
    	IOrderEntry entryPasta = OrderEntry.create(pasta, 1);
    	entries.add(entryPasta);
    	entries.add(entryBook);
    	IDiscountPolicy discountPolicy = DiscountPolicyType.STANDARD.getDiscountPolicy();
    	IBillCalculator billCalculator = BillCalculator.create(entries, discountPolicy);
    	billCalculator.calculate();
    	IMoney total  = new Money("12.90");
    	IMoney totalDiscount  = new Money("1.540");
    	assertEquals(total,billCalculator.getTotal());
    	assertEquals(totalDiscount,billCalculator.getTotalDiscount());
    }
    
//    Input 2:
//    	1 Coffee 500g at 3.21
//    	1 Pasta 1Kg at 4.29
//    	1 Cake at 2.35
    
//    Output 2:
//    					Quantity	UnitPrice  	Discount  	Final Price
//    Coffee 500g     			1	3.21    	7.5%			2.97
//    Pasta 1kg       			1	4.29    	7.5%			3.97
//    Cake            			1	2.35    	0%				2.35
//    Total                                      				9.30
//       (Total discounts 0.56)                             
    

    @Test
    public void secondReceipt(){
    	IProduct coffee = ProductFactory.getProductByProductType(ProductType.GROCERY);
    	coffee.setUnitCost(new Money("3.21"));
    	coffee.setName("Coffee 500g");
      	IProduct pasta = ProductFactory.getProductByProductType(ProductType.GROCERY);
    	pasta.setUnitCost(new Money("4.29"));
    	pasta.setName("Pasta 1kg");
    	IProduct cake = ProductFactory.getProductByProductType(ProductType.NO_DISCOUNT);
    	cake.setUnitCost(new Money("2.35"));
    	cake.setName("Cake");
    	List<IOrderEntry> entries = new LinkedList<IOrderEntry>();
    	IOrderEntry entryCoffee = OrderEntry.create(coffee, 1);
    	IOrderEntry entryPasta = OrderEntry.create(pasta, 1);
    	IOrderEntry entryCake = OrderEntry.create(cake, 1);
    	entries.add(entryCoffee);
    	entries.add(entryPasta);
    	entries.add(entryCake);
    	IDiscountPolicy discountPolicy = DiscountPolicyType.STANDARD.getDiscountPolicy();
    	IBillCalculator billCalculator = BillCalculator.create(entries, discountPolicy);
    	billCalculator.calculate();
    	IMoney total  = new Money("9.30");
    	IMoney totalDiscount  = new Money("0.565");
    	assertEquals(total,billCalculator.getTotal());    	
    	assertEquals(totalDiscount,billCalculator.getTotalDiscount());
    }

//   	Input 3:
//    	10 Chocolate at 2.1
//    	1 Wine at 10.5
//    	1 Book at 15.05
//    	5 Apple at 0.5
//    	Output 3:
//    						Quantity	UnitPrice  	Discount  	Final Price
//    	Chocolate			10			2.10			0%		21.00
//    	Wine				1			10.5			0%		10.50
//    	Book				1			15.05			12%		13.24
//    	Apple				5			0.5				0%		2.50
//    	Gross Total												47.24
//    	Volume Discount									5%		2.36
//    	Total													44.90
//    	               (Total discounts 4.17)
    @Test
    public void thirdReceipt(){
    	IProduct chocolate = ProductFactory.getProductByProductType(ProductType.NO_DISCOUNT);
    	chocolate.setUnitCost(new Money("2.1"));
    	chocolate.setName("Chocolate");
    	IProduct wine = ProductFactory.getProductByProductType(ProductType.NO_DISCOUNT);
    	wine.setUnitCost(new Money("10.5"));
    	wine.setName("Wine");
    	IProduct book = ProductFactory.getProductByProductType(ProductType.BOOK);
    	book.setUnitCost(new Money("15.05"));
    	book.setName("Book");
    	IProduct apple = ProductFactory.getProductByProductType(ProductType.NO_DISCOUNT);
    	apple.setUnitCost(new Money("0.5"));
    	apple.setName("Apple");
    	List<IOrderEntry> entries = new LinkedList<IOrderEntry>();
    	IOrderEntry entryChocolate = OrderEntry.create(chocolate, 10);
    	IOrderEntry entryWine = OrderEntry.create(wine, 1);
    	IOrderEntry entryBook = OrderEntry.create(book, 1);
    	IOrderEntry entryApple = OrderEntry.create(apple, 5);
    	entries.add(entryChocolate);
    	entries.add(entryWine);
    	entries.add(entryBook);
    	entries.add(entryApple);
    	IDiscountPolicy discountPolicy = DiscountPolicyType.STANDARD.getDiscountPolicy();
    	IBillCalculator billCalculator = BillCalculator.create(entries, discountPolicy);
    	billCalculator.calculate();
    	IMoney total  = new Money("44.90");
    	IMoney totalDiscount  = new Money("4.170");
    	IMoney grossTotal  = new Money("47.245");
    	IMoney volumeDiscount  = new Money("2.362200");
    	assertEquals(total,billCalculator.getTotal());
    	assertEquals(totalDiscount,billCalculator.getTotalDiscount());
    	assertEquals(grossTotal,billCalculator.getGrossTotal());
    	assertEquals(volumeDiscount,billCalculator.getVolumeDiscount());
    }
}