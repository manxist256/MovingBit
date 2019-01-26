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
public class MotorCycleSlot extends Slot {
    static int CAPACITY = 1;
    
    public MotorCycleSlot(int slotId, int sectionId) {
        this.slotId = slotId;
        this.free = true;
        this.sectionId = sectionId;
    }
}
