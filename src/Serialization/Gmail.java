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
public class Gmail implements Serializable {
        transient static String ACCOUNT = "GMAIL"; // transient and static can't come together as static members won't get serialized.
        String username;
        transient String password; //stored as default value = null.
        transient final int maxStorage = 15; //will be stored in file as final variables will be replaced by it's value in compile time itself and it won't be in variable form at runtime.
        transient final int minStorage; // will not be stored ie., default value will be stored as the value is assigned in run time only and it will be as 'final variable' in run and jvm find it to be transient and replaces the original value with default value = 0.
        public Gmail (String username, String password, int minStorage) {
                this.username = username;
                this.password = password;
                this.minStorage = minStorage;
        }
}

class Main {
        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
                FileOutputStream fos = new FileOutputStream("Gmail.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                Gmail account = new Gmail("Manikandan", "*****", 100);
                oos.writeObject(account);
                
                FileInputStream fis = new FileInputStream("Gmail.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Gmail acnt = (Gmail) ois.readObject();
                System.out.println(acnt.username + " " +acnt.password + " " +acnt.maxStorage + " " + acnt.minStorage);
        }
}
