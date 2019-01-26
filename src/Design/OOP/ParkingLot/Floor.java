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
public class Floor {
    List<Section> sections;
    int floorId;
    
    static int MAX_SECTION = 8;
    
    int sectionIDAssignee;
    
    public Floor(int id) {
        this.floorId = id;
        this.sections = new ArrayList<>();
        buildSections();
    }
    
    private void buildSections() {
        for (int i = 0; i < MAX_SECTION; i++) {
            Section section = new Section(sectionIDAssignee++);
            sections.add(section);
        }
    }
    
    public Slot findSlot(int size) {
        for (int i = 0; i < sections.size(); i++) {
            Section section = sections.get(i);
            Slot slot = section.findSlot(size);
            if (slot != null) {
                return slot;
            }
        }
        return null;
    }
    
}
