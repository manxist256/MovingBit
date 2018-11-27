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

class Dog implements Serializable {
        String name;
        int age;
        public Dog(String name, int age) {
                this.name = name;
                this.age = age;
        }
}

public class Serialization_ {
        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
                Scanner sc = new Scanner(System.in);
                FileOutputStream fos = new FileOutputStream("dog.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                int N = 5;
                while (N-- > 0) {
                        Dog dog = new Dog(sc.nextLine(), Integer.parseInt(sc.nextLine()));
                        oos.writeObject(dog); 
                }
                FileInputStream fis = new FileInputStream("dog.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (N++ < 4) { 
                        Dog dog = (Dog)ois.readObject();
                        System.out.println(dog.name + " "+dog.age);
                }
                
        }
}
