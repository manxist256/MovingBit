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
public class VendingMachineFactory {
    
    public static VendingMachine getVendingMachine(String type) {
        if (type.equals("A")) {
            return new VendingMachineImpl();
        }
        return null;
    }
}
