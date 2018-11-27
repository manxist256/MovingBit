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
import java.util.Scanner;

/**
 *
 * @author mankank
 */

class Cat implements Serializable {
        String name;
        int age;
        public Cat(String name, int age) {
                this.name = name;
                this.age = age;
        }
}

class Cow implements Serializable {
        String name;
        int age;
        public Cow(String name, int age) {
                this.name = name;
                this.age = age;
        }
}

public class Animals {
        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
                Scanner sc = new Scanner(System.in);
                FileOutputStream fos = new FileOutputStream("animals.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                int N = 5;
                while (N-- > 2) {
                        Cat cat = new Cat(sc.nextLine(), Integer.parseInt(sc.nextLine()));
                        oos.writeObject(cat); 
                }
                while (N-- > -1) {
                        Cow cow = new Cow(sc.nextLine(), Integer.parseInt(sc.nextLine()));
                        oos.writeObject(cow); 
                }
                FileInputStream fis = new FileInputStream("animals.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (N++ < 3) {
                        Object object = ois.readObject();
                        if (object instanceof Cat) {
                                Cat cat = (Cat)object;
                                System.out.println(cat.name + " " + cat.age);
                        } else if (object instanceof Cow) {
                                Cow cow = (Cow)object;
                                System.out.println(cow.name + " " + cow.age);
                        }
                }
        }
}   
