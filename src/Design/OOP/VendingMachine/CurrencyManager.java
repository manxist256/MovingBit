/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design.OOP.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author mankank
 */
public class CurrencyManager {
    
    Map<Cointype, List<Coin>> map = new TreeMap<Cointype, List<Coin>>() {{
        put(Cointype.QUARTER, new ArrayList<>());
        put(Cointype.DIME, new ArrayList<>());
        put(Cointype.NICKEL, new ArrayList<>());
        put(Cointype.PENNY, new ArrayList<>());
    }};
    
    public boolean validateCoin(int value) {
        for (Cointype type : Cointype.values()) {
            if (type.coinprice == value) {
                return true;
            }
        }
        return false;
    }
    
    public void storeAmount(int amount) {
        Coin coin = new Coin();
        for (Cointype type : Cointype.values()) {
            if (type.getPrice() == amount) {
                coin.setCointype(type);
                map.get(type).add(coin);
                break;
            }
        }
        System.out.println(map);
    }
    
    public List<Coin> getChange(int amt) {
        List<Coin> change = new ArrayList<>();
        for (Cointype type : Cointype.values()) {
            int coin_price = type.getPrice();
            List<Coin> value = map.get(type);
            int r = amt / coin_price;
            if (r <= value.size()) {
                for (int i = 0; i < r; i++) {
                    change.add(value.get(0));
                    value.remove(0);
                }
                amt = amt % coin_price;
            } else {
                amt -= (coin_price * value.size());
                change.addAll(value);
                value.clear();
            }
        }
        if (amt > 0) return null;
        return change;
    }
    
}
