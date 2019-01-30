/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.HotelBooking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mankank
 */
public class BookingManager {
    private final Map<String, Booking> bookings;
    
    public BookingManager() {
        this.bookings = new HashMap<>();
    }
    
    public String bookHotel(int userId, int hotelId, List<Integer> rooms) {
        Booking newBooking = new Booking(userId, hotelId, rooms);
        bookings.put(newBooking.getBookingId(), newBooking);
        return newBooking.getBookingId();
    }
    
    public Booking getBooking(String bookingId) {
        return this.bookings.get(bookingId);
    }

}
