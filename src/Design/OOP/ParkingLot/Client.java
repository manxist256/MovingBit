/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.ParkingLot;

/**
 *
 * @author mankank
 */
public class Client {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createFloor();
        parkingLot.createFloor();
        parkingLot.createFloor();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();
        parkingLot.assignSlot(car1);
        parkingLot.assignSlot(car2);
        parkingLot.assignSlot(car3);
        parkingLot.assignSlot(car4);
        parkingLot.assignSlot(car5);
        parkingLot.assignSlot(car6);
        parkingLot.assignSlot(car7);
        parkingLot.assignSlot(car8);
        parkingLot.assignSlot(car9);
        parkingLot.freeSlot(car3);
        parkingLot.assignSlot(car10);
    }
}
