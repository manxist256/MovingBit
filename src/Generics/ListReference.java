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

class Parent {
    
}

class Child1 extends Parent {
    
}

class Child2 extends Parent {
    
}

public class ListReference {
    public static void main(String[] args) {
        //List<Parent> list = new ArrayList<Child1>(); //not possible
        //List<Child2> list = new ArrayList<Parent>(); //not possible
    }
}
