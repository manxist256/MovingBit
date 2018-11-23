/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.MST;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author mankank
 */

class E {
        int u, v, weight;
        boolean picked;
        public E(int u, int v, int weight) {
                this.u = u;
                this.v = v;
                this.weight = weight;
        }
}

public class PrimsAlgorithm {
    
        private static void performCuts(HashSet<Integer> cut1, int[] v) {
                cut1.add(v[0]);
        }
        
        private static void addEdge(Set set, E e) {
                set.add(e);
        }
        
        private static void buildAdjacencyMap(Map<Integer, HashSet<E>> am, int[] u, int[] v, int[] w, int N) {
                for (int i = 0; i < w.length; i++) {
                        E e = new E(u[i], v[i], w[i]);
                        if (!am.containsKey(u[i])) {
                                HashSet<E> set = new HashSet();
                                am.put(u[i], set);
                        }
                        if (!am.containsKey(v[i])) {
                                HashSet<E> set = new HashSet();
                                am.put(v[i], set);
                        }
                        addEdge(am.get(u[i]), e);
                        addEdge(am.get(v[i]), e);
                }
        }
        
        private static boolean sameCut(int u, int v, HashSet<Integer> cut1) {
                return cut1.contains(u) && cut1.contains(v);
        }
    
        private static E getMinEdge(HashSet<Integer> cut1, Map<Integer, HashSet<E>> am) {
                E e = null; int min = Integer.MAX_VALUE;
                for (int i : cut1) {
                        Set<E> set = am.get(i);
                        for (E edge : set) {
                                if (edge.weight < min && !edge.picked && !sameCut(edge.u, edge.v, cut1)) {
                                        e = edge;
                                        min = edge.weight;
                                }
                        }
                }
                return e;
        }
        
        private static void findMST(HashSet<Integer> cut1, int[] vertices, int[] u, int[] v, int[] w, int N) {
                performCuts(cut1, vertices);
                Map<Integer, HashSet<E>> am = new HashMap<>();
                buildAdjacencyMap(am, u, v, w, N);
                int NN = 0, mst = 0;
                while (NN < N - 1) {
                        E e = getMinEdge(cut1, am);
                        e.picked = true;    
                        System.out.println(e.weight);
                        if (cut1.contains(e.u)) {
                                cut1.add(e.v);
                        } else {
                                cut1.add(e.u);
                        }
                        mst += e.weight;
                        NN++;
                }
                System.out.println("MST is : " + mst);
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt(), M = sc.nextInt(); // no of vertices and edges.
                int[] vertices = new int[N];
                int[] u = new int[M], v = new int[M], weight = new int[M];
                for (int i = 0; i < N; i++) {
                        vertices[i] = sc.nextInt();
                }
                for (int i = 0; i < M; i++) {
                        u[i] = sc.nextInt();
                        v[i] = sc.nextInt();
                        weight[i] = sc.nextInt();
                }
                HashSet<Integer> cut1 = new HashSet<>();
                findMST(cut1, vertices, u, v, weight, N);
        }
}
