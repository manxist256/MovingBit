/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author mankank
 */
public class File_ {
        public static void main(String[] args) throws IOException {
                File file = new File("text.txt");
                if (!file.exists()) {
                        file.createNewFile();
                }
                System.out.println(file.isFile());
                System.out.println(file.isDirectory());
        }
}
