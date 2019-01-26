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
public class Slot {
    boolean free;
    int slotId;
    int sectionId;
    
    public void freeSlot() {
        this.free = true;
    }
}
