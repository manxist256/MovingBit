/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.HotelBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mankank
 */
public class HotelManager {
    
    Map<Integer, Hotel> hotelList;
    
    public HotelManager() {
        this.hotelList = new HashMap<>();
    }
    
    public void addHotel(String hotelName, int hotelId, String city) {
        Hotel hotel = new Hotel(hotelId, hotelName, city);
        this.hotelList.put(hotelId, hotel);
    }
    
    public Hotel searchHotel(String hotelName, String city) {
        for (Map.Entry<Integer, Hotel> etr : this.hotelList.entrySet()) {
            Hotel hotel = etr.getValue();
            if (hotel.getHotelName().equals(hotelName) && hotel.getAddress().equals(city)) {
                return hotel;
            }
        }
        return null;
    }
    
    public List<Room> getAvailableRooms(int hotelId) {
        List<Room> available_rooms = new ArrayList<>(); 
        Hotel hotel = hotelList.get(hotelId);
        for (Room room : hotel.getRoomList()) {
            if (!room.getOccupied()) {
                available_rooms.add(room);
            }
        }
        return available_rooms;
    }
    
    public void registerRooms(int hotelId, List<Integer> rooms) {
        Hotel hotel = this.hotelList.get(hotelId);
        hotel.registerRooms(rooms);
    }
    
}
