/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.MST;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author mankank
 */

class Edge implements Comparator {

    int u, v, weight;
    
    public Edge() {
        // no args cons for initializing comparator instances.
    }
    
    public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.weight = w;
    }
    
    @Override
    public int compare(Object o1, Object o2) {
            Edge e1 = (Edge) o1;
            Edge e2 = (Edge) o2;
            return e1.weight > e2.weight ? +1 : -1;
    }
        
}

public class KruskalsAlgorithm {
    
        private static void createEdges(TreeSet<Edge> edges, int[] u, int[] v, int[] weight, int M) {
                for (int i = 0; i < M; i++) {
                        Edge edge = new Edge(u[i], v[i], weight[i]);
                        edges.add(edge);
                }
        }
        
        private static void createDisjointSet(HashSet<HashSet<Integer>> disjointset, int[] vertices) {
                for (int i = 0; i < vertices.length; i++) {
                        HashSet<Integer> vertice = new HashSet();
                        vertice.add(vertices[i]);
                        disjointset.add(vertice);
                }
        }
        
        private static HashSet<Integer> findVertex(HashSet<HashSet<Integer>> disjointset, int vertex) {
                for (HashSet s : disjointset) {
                        if (s.contains(vertex)) {
                                return s;
                        }
                }
                return null;
        }
        
        private static void unionSet(HashSet<HashSet<Integer>> disjointset, HashSet<Integer> uS, HashSet<Integer> vS) {
                disjointset.remove(vS);
                disjointset.remove(uS);
                HashSet<Integer> mergeset = new HashSet();
                mergeset.addAll(vS); mergeset.addAll(uS);
                disjointset.add(mergeset);
        }
        
        private static void findMST(HashSet<HashSet<Integer>> disjointset, TreeSet<Edge> sortedEdges, int N) {
                int NN = 0; // should be N - 1
                int mst = 0;
                while (NN < N - 1) {
                        for (Edge edge : sortedEdges) {
                                int u  = edge.u;
                                int v = edge.v;
                                int weight = edge.weight;
                                HashSet<Integer> uS = findVertex(disjointset, u);
                                HashSet<Integer> vS = findVertex(disjointset, v);
                                if (uS.equals(vS)) { //cycle forms
                                        continue;
                                }
                                //System.out.println(weight);
                                sortedEdges.remove(edge);
                                mst += weight;
                                unionSet(disjointset, uS, vS);
                                NN++;
                                break;
                        }
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
                TreeSet<Edge> sortedEdges = new TreeSet<>(new Edge());
                createEdges(sortedEdges, u, v, weight, M);
                HashSet<HashSet<Integer>> disjointset = new HashSet<>();
                createDisjointSet(disjointset, vertices);
                findMST(disjointset, sortedEdges, N);
        }
}
