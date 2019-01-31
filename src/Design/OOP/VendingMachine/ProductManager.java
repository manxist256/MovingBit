/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.VendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author mankank
 */
public class ProductManager {
    List<Product> products;
    
    Map<String, ProductType> map = new HashMap<String, ProductType>() {{
        put("Pepsi", ProductType.PEPSI);
        put("Coke", ProductType.COKE);
        put("Soda", ProductType.SODA);
    }};
    
    public ProductManager() {
        this.products = new ArrayList<>();
    }
 
    public void createProduct(String productType) {
        Product product = new Product();
        product.setProductType(map.get(productType));
        products.add(product);
    }
    
    public Product getProduct(String productType) {
        ProductType type = map.get(productType);
        for (Product product : products) {
            if (type == product.productType) {
                products.remove(product);
                return product;
            }
        }
        return null;
    }
    
    public int getProductPrice(String productType) {
        ProductType type = map.get(productType);
        return type.getDen();
    }
}
