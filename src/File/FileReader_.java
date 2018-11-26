/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mankank
 */
public class FileReader_ {
        public static void main(String[] args) throws FileNotFoundException, IOException {
                FileReader fr = new FileReader("a.txt");
                while (fr.read() > 0) { //Not so recommended. FileReader reads characted by characted. If there are 1000 words, it will traverse 1000 times in the file to read it.
                    System.out.println((char)fr.read());
                }
        }
}
