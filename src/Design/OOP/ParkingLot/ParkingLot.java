/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.ParkingLot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mankank
 */
// defines the system.
public class ParkingLot {
    List<Floor> floors;
    
    int floorIdAssignee;
    
    public ParkingLot() {
        this.floors = new ArrayList<>();
    }

    public void createFloor() {
        Floor floor = new Floor(floorIdAssignee++);
        floors.add(floor);
    }
    
    public void assignSlot(Vehicle vehicle) {
        for (int i = 0; i < floors.size(); i++) {
            Floor floor = floors.get(i);
            Slot slot = floor.findSlot(vehicle.REQUIRED_CAP);
            if (slot != null) { 
                vehicle.slot = slot;
                System.out.println("Assigned slot number " + slot.slotId + " in section " + slot.sectionId  +" in floor " + floor.floorId);
                return; 
            }
        }
        System.out.println("Can't find a parking slot!");
    }
    
    public void freeSlot(Vehicle vehicle) {
        Slot slot = vehicle.slot;
        slot.freeSlot();
    }
    
}
