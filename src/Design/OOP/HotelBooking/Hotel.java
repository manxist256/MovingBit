/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.HotelBooking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mankank
 */
public class Hotel {
    private final int hotelId;
    
    private final String hotelName;
    
    private final Address address;
    
    private final List<Room> rooms;
    
    private int roomIdAssignee;
    
    //maintain a userManager which holds user details mapped to each room.
    //such that given a room in a hotel, it will provide the user details of the one booked the room.
    
    public Hotel(int hotelId, String hotelName, String city) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = new Address(city);
        this.rooms = new ArrayList<>();
        this.roomIdAssignee = 1;
        createRooms();
    }
    
    private void createRooms() {
        for (int i = 0; i < 5; i++) { //create single occupancy
            this.rooms.add(new Room(roomIdAssignee++, RoomType.SINGLE));
        }
        for (int i = 0; i < 5; i++) { //create double occupancy
            this.rooms.add(new Room(roomIdAssignee++, RoomType.DOUBLE));
        }
        for (int i = 0; i < 5; i++) { //create triple occupancy
            this.rooms.add(new Room(roomIdAssignee++, RoomType.TRIPLE));
        }
    }
    
    public String getHotelName() {
        return this.hotelName;
    }
    
    public String getAddress() {
        return this.address.getCity();
    }
    
    public int getHotelId() {
        return this.hotelId;
    }
    
    public List<Room> getRoomList() {
        return this.rooms;
    }
    
    public void registerRooms(List<Integer> rooms) {
        for (Room room : this.getRoomList()) {
            if (rooms.contains(room.getRoomId())) {
                room.setOccupied(true);
            }
        }
    }
    
}
