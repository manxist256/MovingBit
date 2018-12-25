/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mankank
 */

class FoodType { }

class Leaf extends FoodType { }

class Grass extends FoodType { }

class Food<T extends FoodType> {
    public List<T> createFood(Class clazz) throws InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList<>();
        list.add((T)clazz.newInstance());
        return list;
    }
}

public class TypeErasure {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Food<Grass> food = new Food();
        List<Grass> list = food.createFood(Leaf.class);
    }
}
