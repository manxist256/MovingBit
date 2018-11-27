/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author mankank
 */

class Person implements Serializable {
        String personId = "uId/serialVersion=16f";
        Name name = new Name();
}

class Name implements Serializable {
        String firstName = "K.K.";
        String lastName = "Manikandan";
}

public class ObjectGraphs_Association {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
                FileOutputStream fos = new FileOutputStream("Person.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(new Person());
                
                FileInputStream fis = new FileInputStream("Person.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Person person = (Person) ois.readObject();
                System.out.println("Person Id : " + person.personId);
                System.out.println("Person name : " + person.name.firstName + person.name.lastName);
        }
}
