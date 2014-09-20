package edu.assessment.pam.factory;

import java.util.HashMap;
import java.util.Map;

import edu.assessment.pam.model.IProduct;
import edu.assessment.pam.model.ProductType;
import edu.assessment.pam.model.impl.Book;
import edu.assessment.pam.model.impl.Grocery;
import edu.assessment.pam.model.impl.NoDiscountProduct;


public enum ProductFactory
{
      BOOK(ProductType.BOOK) { IProduct get() { return new Book(); } },
      GROCERY(ProductType.GROCERY) { IProduct get() { return new Grocery(); } },
      NO_DISCOUNT(ProductType.NO_DISCOUNT) { IProduct get() { return new NoDiscountProduct(); } };
      
      private static final Map<ProductType, ProductFactory> productMap = new HashMap<ProductType, ProductFactory>();
     
      static
      {
        for(ProductFactory product : values())
        	productMap.put(product.getProductType(), product);
      }
     
      private ProductFactory(ProductType productType)
      {
    	  this.productType=productType;
      }
     
      public ProductType getProductType(){
    	  return productType;
      }
      
      public static IProduct getProductByProductType(ProductType productType)
      {
        return productMap.get(productType).get();
      }
     
      abstract IProduct get();
     
      private ProductType productType;

}
