package edu.aca.onlineshop.backoffice.product;

import edu.aca.onlineshop.entity.ShopProduct;

import java.math.BigDecimal;

/**
 *
 */
public class ProductInfoForm{
    private ShopProduct shopProduct;
    
    public void createProduct(String name, BigDecimal price, int quantity){
        this.shopProduct = new ShopProduct(name, price, quantity);
    }
    
    public ShopProduct getShopProduct(){
        return shopProduct;
    }
}
