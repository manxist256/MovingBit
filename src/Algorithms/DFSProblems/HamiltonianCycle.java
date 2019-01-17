/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DFSProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class HamiltonianCycle {
    
    private static void getcycle(int[][] adjmat, HashSet<Integer> visited, HashSet<Integer> unvisited, ArrayList<Integer> cycle, int curr) {
        if (cycle.size() == adjmat.length + 1) {
            return;
        }
        visited.add(curr);
        unvisited.remove(curr);
        cycle.add(curr);
        for (int i = 0; i < adjmat.length; i++) {
            if (i == curr) continue; //self loop situation
            if (adjmat[curr][i] == 1 && !visited.contains(i)) {
                getcycle(adjmat, visited, unvisited, cycle, i);
            }
        }
        if (cycle.size() != adjmat.length + 1) {
            if (cycle.size() == adjmat.length) {
                int last = cycle.get(cycle.size() - 1);
                int first = cycle.get(0);
                if (adjmat[first][last] == 1) {
                    cycle.add(first);
                    return;
                }
            }
            visited.remove(curr);
            unvisited.add(curr);
            cycle.remove(Integer.valueOf(curr));
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int[][] adjmat = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjmat[i][j] = sc.nextInt();
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> unvisited = new HashSet<>();
        for (int i = 0; i < V; i++) {
            unvisited.add(i);
        }
        ArrayList<Integer> cycle = new ArrayList<>();
        getcycle(adjmat, visited, unvisited, cycle, 0);
        for (int i : cycle) {
            System.out.print(i + " ");
        }
    }
}
