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

enum Cointype {
    QUARTER(25), DIME(10), NICKEL(5), PENNY(1);
    
    int coinprice;
    
    private Cointype(int coinprice) {
        this.coinprice = coinprice;
    }
    
    public int getPrice() {
        return this.coinprice;
    }
    
}

public class Coin {
    Cointype cointype;
    
    public void setCointype(Cointype cointype) {
        this.cointype = cointype;
    }
    
}
