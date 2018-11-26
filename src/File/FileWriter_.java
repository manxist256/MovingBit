/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mankank
 */
public class FileWriter_ {
        public static void main(String[] args) throws IOException {
                FileWriter fw = new FileWriter("a.txt", true); //pass append = true, else filewriter constructor will delete the older file named a.txt and creates new a.txt.
                fw.write("Appending new characters to existing file... \n"); //manually provide new line command. FileWriter doesn't supports it.
                fw.write("Appending new characters to existing file...");
                fw.close();
        }
}
