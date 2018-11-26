/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mankank
 */
public class BufferedReader_ {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new FileReader("a.txt"));
                while (true) {
                    String str = br.readLine();
                    if (str == null) {
                            break;
                    }
                    System.out.println(str); ;
                }
        }
}
