/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.HotelBooking;

import java.util.List;

/**
 *
 * @author mankank
 */
public class HotelBookingSystem {
    private final HotelManager hotelManager;
    private final BookingManager bookingManager;
    
    public HotelBookingSystem() {
        this.hotelManager = new HotelManager();
        this.bookingManager = new BookingManager();
    }
    
    public String bookHotel(int userId, int hotelId, List<Integer> rooms) {
        this.hotelManager.registerRooms(hotelId, rooms);
        return bookingManager.bookHotel(userId, hotelId, rooms);
    }
    
    public void addHotel(String hotelName, int hotelId, String city) {
        this.hotelManager.addHotel(hotelName, hotelId, city);
    }
    
    //for simplicity we always get 1 result for user-desired hotel search
    public Hotel searchHotel(String hotelName, String city) {
        return this.hotelManager.searchHotel(hotelName, city);
    }
    
    public List<Room> getAvailableRooms(int hotelId) {
        return this.hotelManager.getAvailableRooms(hotelId);
    }
    
    public Booking getBooking(String bookingId) {
        return this.bookingManager.getBooking(bookingId);
    }
    
}
