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
public class BalanceManager {
    private int balance;
    
    public void addBalance(int balance) {
        this.balance += balance;
    }
    
    public int getCurrentBalance() {
        return this.balance;
    }
    
    //after purchase
    public void updateBalance(int amount) {
        this.balance -= amount;
    }
    
}
