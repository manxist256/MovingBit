/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.VendingMachine;

/**
 *
 * @author mankank
 */

enum ProductType {    
    
    PEPSI(35), COKE(25), SODA(45);
    
    private final int den;
    
    private ProductType(int den) {
        this.den = den;
    }
    
    public int getDen() {
        return this.den;
    }
}

public class Product {
    ProductType productType;
    
    public void setProductType(ProductType type) {
        this.productType = type;
    }
    
}
