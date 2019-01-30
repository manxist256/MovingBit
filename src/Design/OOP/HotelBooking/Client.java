/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.HotelBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelBookingSystem system = new HotelBookingSystem();
        //better to have userManager.
        User user = new User(27, "Manikandan");
        system.addHotel("OYO", 145, "Madurai");
        system.addHotel("Taj", 155, "Madurai");
        system.addHotel("OYO", 333, "Chennai");
        system.addHotel("Taj", 690, "Chennai");
        Hotel hotel = system.searchHotel("OYO", "Madurai");
        List<Room> rl = system.getAvailableRooms(hotel.getHotelId());
        System.out.println("Available rooms for Hotel : " + hotel.getHotelName() + " at " + hotel.getAddress());
        for (Room room : rl) {
            System.out.print(room.getRoomId() + " " + room.getRoomType() + " ");
        }
        System.out.println("How many rooms to book : ");
        int c = sc.nextInt();
        List<Integer> bookRooms = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            bookRooms.add(sc.nextInt());
        }
        String bookingId = system.bookHotel(user.getUserId(), hotel.getHotelId(), bookRooms);
        System.out.println(bookingId);
        Booking booking = system.getBooking(bookingId);
        System.out.println("Booking details");
        System.out.println("Booking id " + booking.getBookingId());
        System.out.println("HotelId " + booking.getHotelId());
        System.out.println("userId " + booking.getUserId());
        List<Integer> rooms = booking.getRooms();
        System.out.println("Booked rooms");
        for (Integer i : rooms) {
            System.out.print(i + " ");
        }
//        Hotel hotel2 = system.searchHotel("OYO", "Madurai");
//        List<Room> rl2 = system.getAvailableRooms(hotel.getHotelId());
//        System.out.println("Available rooms for Hotel : " + hotel2.getHotelName() + " at " + hotel2.getAddress());
//        for (Room room : rl2) {
//            System.out.print(room.getRoomId() + " " + room.getRoomType() + " ");
//        }
//        System.out.println("How many rooms to book : ");
//        int c1 = sc.nextInt();
//        List<Integer> bookRooms1 = new ArrayList<>();
//        for (int i = 0; i < c1; i++) {
//            bookRooms1.add(sc.nextInt());
//        }
//        String bookingId1 = system.bookHotel(user.getUserId(), hotel2.getHotelId(), bookRooms1);
//        System.out.println(bookingId1);
//        
//        Hotel hotel3 = system.searchHotel("OYO", "Madurai");
//        List<Room> rl3 = system.getAvailableRooms(hotel.getHotelId());
//        System.out.println("Available rooms for Hotel : " + hotel3.getHotelName() + " at " + hotel3.getAddress());
//        for (Room room : rl3) {
//            System.out.print(room.getRoomId() + " " + room.getRoomType() + " ");
//        }
    }
}
