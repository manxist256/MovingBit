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
public class MotorCycle extends Vehicle {
    
    public MotorCycle() {
        REQUIRED_CAP = 1;
    } 
    
    public void setSlot(MotorCycleSlot slot) {
        this.slot = slot;
    }
    
    public Slot getSlot() {
        return slot;
    }
    
}
