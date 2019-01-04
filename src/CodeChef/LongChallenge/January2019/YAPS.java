/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeChef.LongChallenge.January2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author mankank
 */
public class YAPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        map.put(2, new HashSet<>());
        map.put(3, new HashSet<>());
        map.put(5, new HashSet<>());
        map.put(7, new HashSet<>());
        map.put(11, new HashSet<>());
        while (T-- > 0) {
            
        }
    }
}
