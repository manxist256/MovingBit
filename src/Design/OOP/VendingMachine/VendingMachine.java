/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.VendingMachine;

import java.util.List;

/**
 *
 * @author mankank
 */
public interface VendingMachine {
    public abstract void createProduct(String type);
    
    public abstract void insertAmount(int amount);
    
    public abstract Product purchaseProduct(String productType);
    
    public abstract List<Coin> getChange();
    
}
