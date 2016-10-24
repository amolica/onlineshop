package edu.aca.onlineshop.backoffice.product;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductCreator{
    private static Scanner scanner = new Scanner(System.in);
    private ShopProduct shopProduct;
    
    public void createProduct(){
        String name = collectName();
        BigDecimal price = collectPrice();
        int quantity = collectQuantity();
        this.shopProduct = new ShopProduct(name, price, quantity);
    }
    
    private String collectName(){
        System.out.println("Enter shopProduct name:");
        return scanner.next();
    }
    private BigDecimal collectPrice(){
        System.out.println("Enter shopProduct price:");
        return scanner.nextBigDecimal();
    }
    private int collectQuantity(){
        System.out.println("Enter shopProduct quantity:");
        return scanner.nextInt();
    }
    
    public ShopProduct getShopProduct(){
        return shopProduct;
    }
}
