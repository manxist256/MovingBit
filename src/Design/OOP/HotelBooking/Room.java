/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.HotelBooking;

/**
 *
 * @author mankank
 */

enum RoomType {
    SINGLE, DOUBLE, TRIPLE;
}

public class Room {
    int roomId;
    private boolean occupied;
    
    private final RoomType roomType;
    
    public Room(int roomId, RoomType roomType) {
        this.roomId = roomId;
        this.roomType = roomType;
    }
    
    public void setOccupied(boolean status) {
        this.occupied = status;
    }
    
    public boolean getOccupied() {
        return this.occupied;
    }
    
    public RoomType getRoomType() {
        return this.roomType;
    }
    
    public int getRoomId() {
        return this.roomId;
    }
    
}
