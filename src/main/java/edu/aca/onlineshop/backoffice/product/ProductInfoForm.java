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
    
    public void createProduct(String name, BigDecimal price, int quantity){
        this.shopProduct = new ShopProduct(name, price, quantity);
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
