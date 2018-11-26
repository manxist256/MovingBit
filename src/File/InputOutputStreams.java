/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author mankank
 */
public class InputOutputStreams {
        public static void main(String[] args) throws FileNotFoundException, IOException {
                FileInputStream fis = new FileInputStream("a.txt");
                while (fis.available() > 0) {
                    System.out.println(fis.read());
                }
                FileOutputStream fos = new FileOutputStream("a.txt", true);
                fos.write(100);
                BufferedInputStream b = new BufferedInputStream(new FileInputStream("a.txt"));
                BufferedInputStream b_ = new BufferedInputStream(System.in);
        }   
}
