package edu.assessment.pam;

import java.util.LinkedList;
import java.util.List;

import edu.assessment.pam.factory.ProductFactory;
import edu.assessment.pam.model.IBillCalculator;
import edu.assessment.pam.model.IBillPrinter;
import edu.assessment.pam.model.IDiscountPolicy;
import edu.assessment.pam.model.IOrderEntry;
import edu.assessment.pam.model.IProduct;
import edu.assessment.pam.model.ProductType;
import edu.assessment.pam.model.impl.BillCalculator;
import edu.assessment.pam.model.impl.BillPrinter;
import edu.assessment.pam.model.impl.DiscountPolicyType;
import edu.assessment.pam.model.impl.Money;
import edu.assessment.pam.model.impl.OrderEntry;


public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("OUTPUT 1");
        firstReceipt();
        System.out.println("");
        System.out.println("OUTPUT 2");
        secondReceipt();
        System.out.println("");
        System.out.println("OUTPUT 3");
        thirdReceipt();
    }
   
    public static void firstReceipt(){
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
    	IBillPrinter billPrinter = new BillPrinter();
    	billPrinter.printBill(billCalculator);
    }
    
    public static void secondReceipt(){
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
    	IBillPrinter billPrinter = new BillPrinter();
    	billPrinter.printBill(billCalculator);
    }
    
    public static void thirdReceipt(){
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
    	IBillPrinter billPrinter = new BillPrinter();
    	billPrinter.printBill(billCalculator);
    }
}
