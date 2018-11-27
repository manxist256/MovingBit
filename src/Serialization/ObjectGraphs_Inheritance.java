/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author mankank
 */

class Bulbasaur implements Serializable {
        String name = "bulba bulba!";
}

class Ivasaur extends Bulbasaur {
        String name = "Ivasaurrrrr!";
}

class Venusaur extends Ivasaur {
        String name = "VenuSaurrr";
}

public class ObjectGraphs_Inheritance {
        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
                FileOutputStream fos = new FileOutputStream("Pokemon.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                Bulbasaur b = new Bulbasaur();
                oos.writeObject(b);
                Ivasaur i = new Ivasaur();
                oos.writeObject(i);
                Venusaur v = new Venusaur();
                oos.writeObject(v);
                FileInputStream fis = new FileInputStream("Pokemon.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                int N = 3;
                while (N-- > 0) {
                        Bulbasaur bulbasaur = (Bulbasaur) ois.readObject();
                        if (bulbasaur instanceof Venusaur) {
                                Venusaur venusaur = (Venusaur)bulbasaur;
                                System.out.println(venusaur.name);
                        } else if (bulbasaur instanceof Ivasaur) {
                                Ivasaur ivasaur = (Ivasaur)bulbasaur;
                                System.out.println(ivasaur.name);
                        }  else {
                                System.out.println(bulbasaur.name);
                        }
                }
                
        }
}
