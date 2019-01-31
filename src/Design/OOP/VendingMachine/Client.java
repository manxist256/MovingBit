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
public class Client {
    public static void main(String[] args) {
        VendingMachine system = VendingMachineFactory.getVendingMachine("A");
        system.createProduct("Pepsi");
        system.createProduct("Pepsi");
        system.createProduct("Pepsi");
        system.createProduct("Coke");
        system.createProduct("Coke");
        system.createProduct("Coke");
        system.createProduct("Soda");
        system.createProduct("Soda");
        system.createProduct("Soda");
        system.insertAmount(10);
        system.insertAmount(10);
        system.insertAmount(5);
        system.insertAmount(5);
        system.purchaseProduct("Coke");
        system.getChange();
        system.insertAmount(25);
        system.insertAmount(25);
        system.purchaseProduct("Pepsi");
        List<Coin> c = system.getChange();
        for (int i = 0; i < c.size(); i++) {
            System.out.print(c.get(i).cointype + " ");
        }
    }
}
