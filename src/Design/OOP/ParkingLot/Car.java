/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.ParkingLot;

/**
 *
 * @author mankank
 */
public class Car extends Vehicle {
    
    public Car() {
        REQUIRED_CAP = 4;
    }
    
    public void setSlot(CarSlot slot) {
        this.slot = slot;
    }
    
    public Slot getSlot() {
        return slot;
    }
    
}
