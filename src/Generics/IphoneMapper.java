/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

/**
 *
 * @author mankank
 */
class BrandedPhoneTypes {}
class Goldencrow extends BrandedPhoneTypes {}
class Sunnywhite extends BrandedPhoneTypes {}
class Blackglow extends BrandedPhoneTypes {}

class Iphone<T extends BrandedPhoneTypes> {
    public void camera(T t) {
        System.out.println("Camera on");
    }
}
class Iphone7<T extends BrandedPhoneTypes> extends Iphone<T> {
    public void backcamera(T t) {
        System.out.println("Back camera on: i7");
    }
}
class Iphone8<T extends BrandedPhoneTypes> extends Iphone<T> {
    public void backcamera(T t) {
        System.out.println("Back camera on: i8");
    }
}
public class IphoneMapper {
    public static void main(String[] args) {
        Iphone<Goldencrow> iphone1 = new Iphone<>();
        Iphone<Sunnywhite> iphone2 = new Iphone<>();
        Iphone<Blackglow> iphone3 = new Iphone<>();
        Iphone7<Blackglow> iphone4 = new Iphone7<>();
        //iphone4.backcamera(new Blackglow());
    }
}
