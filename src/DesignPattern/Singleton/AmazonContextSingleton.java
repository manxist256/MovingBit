/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern.Singleton;

/**
 *
 * @author mankank
 */
class MarketPlaceProvider {
    public String getMarketPlace() {
        return "India";
    }
}

class AmazonContext {
    private final String MarketPlace;
    private static final AmazonContext AMAZON_CONTEXT = new AmazonContext();
    private AmazonContext() {
        MarketPlaceProvider mp = new MarketPlaceProvider();
        this.MarketPlace = mp.getMarketPlace();
    }
    
    public static AmazonContext getInstance() {
        return AMAZON_CONTEXT;
    }
    
    public String getMP() {
        return this.MarketPlace;
    }
    
}


public class AmazonContextSingleton {
    public static void main(String[] args) {
        AmazonContext ac = AmazonContext.getInstance();
        System.out.println(ac.getMP());
    }
}
