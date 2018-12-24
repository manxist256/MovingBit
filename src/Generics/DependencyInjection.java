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

interface HotDrink {
    public void makeDrink();
}

class Tea implements HotDrink {
    @Override
    public void makeDrink() {
        System.out.println("Tea made");
    }
}

class Coffee implements HotDrink {
    @Override
    public void makeDrink() {
        System.out.println("Coffee made");
    }
}

class Restaurant {
    private HotDrink hotdrink;
    
    public void makeHotDrink(final HotDrink hotdrink) {
        this.hotdrink = hotdrink;
        this.hotdrink.makeDrink();
    }
    
}
public class DependencyInjection {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.makeHotDrink(new Coffee());
        restaurant.makeHotDrink(new Tea());
    }
}
