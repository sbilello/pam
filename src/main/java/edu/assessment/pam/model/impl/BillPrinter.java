package edu.assessment.pam.model.impl;

import java.io.PrintStream;

import dnl.utils.text.table.TextTable;
import edu.assessment.pam.model.IBillCalculator;
import edu.assessment.pam.model.IBillPrinter;
import edu.assessment.pam.model.IOrderEntry;
import edu.assessment.pam.util.FormatterHelper;

public class BillPrinter implements IBillPrinter {

	private String[] columnNames = {                                       
						            "",                                          
						            "Quantity",                     
						            "UnitPrice",                                               
						            "Discount",                                          
						    		"Final Price"
						           };
	
	private final PrintStream out = System.out;

	@Override
	public void printBill(IBillCalculator bill) {
		Object [][] data = null;
		if (bill.isDiscountPolicyApplied())
			data = new String[bill.getOrderEntries().size()+3][columnNames.length];
		else
			data = new String[bill.getOrderEntries().size()+1][columnNames.length];
		int i = 0;
		for (IOrderEntry entry : bill.getOrderEntries()){
			data[i][0]=entry.getProduct().getName();
			data[i][1]=entry.getQuantity()+"";
			data[i][2]=FormatterHelper.moneyFormatter(entry.getProduct().getUnitCost().getValue());
			data[i][3]=FormatterHelper.percentageFormatter(entry.getProduct().getDiscount());
			data[i][4]=FormatterHelper.moneyFormatter(entry.getFinalPrice().getValue());
			i++;
		}
		if (bill.isDiscountPolicyApplied()){
			data[i][0]="Gross Total";
			data[i][4]= FormatterHelper.moneyFormatter(bill.getGrossTotal().getValue());
			i++;
			data[i][0]="Volume Discount";
			data[i][3]= FormatterHelper.percentageFormatter(bill.getDiscountPolicy().getAdditionalDiscount());
			data[i][4]= FormatterHelper.moneyFormatter(bill.getVolumeDiscount().getValue());
			i++;
		}
		data[i][0]= "Total";
		data[i][4]= FormatterHelper.moneyFormatter(bill.getTotal().getValue());
		
		TextTable tt = new TextTable(columnNames, data);         
		tt.printTable();
		out.printf("%4s %4s \n", "Total Discount:", FormatterHelper.moneyFormatter(bill.getTotalDiscount().getValue()));
	}
	

	
}