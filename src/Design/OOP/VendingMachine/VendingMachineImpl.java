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
public class VendingMachineImpl implements VendingMachine {
    ProductManager productManager;
    BalanceManager balanceManager;
    CurrencyManager currencyManager;
    
    public VendingMachineImpl() {
        this.productManager = new ProductManager();
        this.balanceManager = new BalanceManager();
        this.currencyManager = new CurrencyManager();
    }
    
    @Override
    public void createProduct(String product) {
        this.productManager.createProduct(product);
    }
    
    @Override
    public void insertAmount(int amount) {
        boolean validateAmount = currencyManager.validateCoin(amount);
        if (!validateAmount) {
            System.out.println("Amount Invalid Exception");
            return;
        }
        balanceManager.addBalance(amount);
        currencyManager.storeAmount(amount);
    }
    
    @Override
    public Product purchaseProduct(String productType) {
        int price = productManager.getProductPrice(productType);
        int balance = balanceManager.getCurrentBalance();
        //customer has inserted enough amount.
        if (balance >= price) {
            Product product = productManager.getProduct(productType);
            balanceManager.updateBalance(price);
            if (null == product) {
                System.out.println("Product not available");
                return null;
            }
            return product;
        }
        return null;
    }
    
    @Override 
    public List<Coin> getChange() {
        List<Coin> change = currencyManager.getChange(balanceManager.getCurrentBalance());
        if (change == null) {
            System.out.println("Not enough change");
            return null;
        }
        System.out.println(change);
        balanceManager.updateBalance(balanceManager.getCurrentBalance());
        return change;
    }
    
}
