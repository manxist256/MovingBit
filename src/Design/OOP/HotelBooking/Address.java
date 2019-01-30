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
public class Address {
    //for simplicity keeping the city name as address only
    private final String city;
    public Address(String city) {
        this.city = city;
    }
    
    public String getCity() {
        return this.city;
    }
    
}
