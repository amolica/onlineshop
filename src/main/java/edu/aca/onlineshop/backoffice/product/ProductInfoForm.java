package edu.aca.onlineshop.backoffice.product;

import edu.aca.onlineshop.entity.ShopProduct;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 */
public class ProductInfoForm{
    private static Scanner scanner = new Scanner(System.in);
    private ShopProduct shopProduct;
    
    public void createProduct(){
        this.shopProduct = new ShopProduct(collectName(), collectPrice(), collectQuantity());
    }
    
    private String collectName(){
        System.out.println("Enter product name:");
        return scanner.next();
    }
    
    private BigDecimal collectPrice(){
        System.out.println("Enter product price:");
        return scanner.nextBigDecimal();
    }
    
    private int collectQuantity(){
        System.out.println("Enter product quantity:");
        return scanner.nextInt();
    }
    
    public ShopProduct getShopProduct(){
        return shopProduct;
    }
}
