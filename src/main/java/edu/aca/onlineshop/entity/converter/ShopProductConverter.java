package edu.aca.onlineshop.entity.converter;

import edu.aca.onlineshop.entity.Product;
import edu.aca.onlineshop.entity.ShopProduct;

/**
 *
 */
public class ShopProductConverter{
    public static Product convertToProduct(ShopProduct shopProduct){
        Product product = new Product();
        product.setName(shopProduct.getName());
        product.setPrice(shopProduct.getPrice());
        product.setQuantity(shopProduct.getQuantity());
        return product;
    }
}
