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
public class Section {
    
    List<CarSlot> carSlots;
    List<MotorCycleSlot> MCSlots;
    
    int sectionId;
    int carSlotIdAssignee;
    int mcslotIdAssignee;
    
    static int MAX_SLOTS_PER_TYPE = 5;
    
    public Section(int sectionId) {
        this.sectionId = sectionId;
        this.carSlots = new ArrayList<>();
        this.MCSlots = new ArrayList<>();
        buildSlots();
    }
    
    private void buildSlots() {
        buildCarSlots();
        buildMCSlots();
    }
    
    private void buildCarSlots() {
        for (int i = 0; i < MAX_SLOTS_PER_TYPE; i++) {
            CarSlot slot = new CarSlot(carSlotIdAssignee++, sectionId);
            carSlots.add(slot);
        }
    }
    
    private void buildMCSlots() {
        for (int i = 0; i < MAX_SLOTS_PER_TYPE; i++) {
            MotorCycleSlot slot = new MotorCycleSlot(mcslotIdAssignee++, sectionId);
            MCSlots.add(slot);
        }
    }
    
    public Slot findSlot(int size) {
        if (size == 1) {
            for (int i = 0; i < MCSlots.size(); i++) {
                if (MCSlots.get(i).free) {
                    MCSlots.get(i).free = false;
                    return MCSlots.get(i);
                }
            }
        } else if (size == 4) {
            for (int i = 0; i < carSlots.size(); i++) {
                if (carSlots.get(i).free) {
                    carSlots.get(i).free = false;
                    return carSlots.get(i);
                }
            }
        }
        return null;
    }
    
}
