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
public class User {
    private final int userId;
    private final String userName;
    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
}
