/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.HotelBooking;

import java.util.List;
import java.util.Random;

/**
 *
 * @author mankank
 */
public class Booking {
    
    private final String bookingId;
    private final int usedId;
    private final int hotelId;
    private final List<Integer> rooms;
    
    public Booking(int userId, int hotelId, List<Integer> rooms) {
        this.usedId = userId;
        this.hotelId = hotelId;
        this.rooms = rooms;
        this.bookingId = generateBookingId(userId, hotelId);
    }
    
    private String generateBookingId(int userId, int hotelId) {
        return String.valueOf(new Random().nextInt(200)) + userId + hotelId;
    }
    
    public String getBookingId() {
        return this.bookingId;
    }
    
    public int getUserId() {
        return this.usedId;
    }
    
    public int getHotelId() {
        return this.hotelId;
    }
    
    public List<Integer> getRooms() {
        return this.rooms;
    }
    
}
