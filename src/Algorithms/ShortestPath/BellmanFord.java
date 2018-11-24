/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.ShortestPath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
//SSSP
public class BellmanFord {
    
        static class Node {
                long vertice;
                long weight;
                public Node(long v, long w) {
                        vertice = v;
                        weight = w;
                }
        }
        
        static class Edge {
                long u, v, weight;
                public Edge(long u, long v, long weight) {
                        this.u = u;
                        this.v = v;
                        this.weight = weight;
                }
        }
    
        private static void buildNodes(HashMap<Long, Node> nodes, long[] vertices) {
                for (int i = 0; i < vertices.length; i++) {
                        if (i == 0) nodes.put(vertices[i], new Node(vertices[i], 0));
                        else nodes.put(vertices[i], new Node(vertices[i], Integer.MAX_VALUE));
                }
        }
        
        private static void buildEdges(HashSet<Edge> edges, long[] u, long[] v, long[] w) {
                for (int i = 0; i < w.length; i++) {
                        edges.add(new Edge(u[i], v[i], w[i]));
                }
        }
        
        private static int relaxEdges(HashMap<Long, Node> nodes, HashSet<Edge> edges) {
                int t = 0;
                for (Edge e : edges) {
                        Node s = nodes.get(e.u);
                        Node d = nodes.get(e.v);
                        if (s.weight + e.weight < d.weight) {
                                d.weight = s.weight + e.weight;
                                t++;
                        }
                }
                return t;
        }
        
        private static void findSSSP(long[] u, long[] v, long[] weight, long[] vertices, long N) {
                HashMap<Long, Node> nodes = new HashMap<>();
                HashSet<Edge> edges = new HashSet<>();
                buildNodes(nodes, vertices);
                buildEdges(edges, u, v, weight);
                int NN = 0;
                while (NN < N - 1) {
                        int t = relaxEdges(nodes, edges);
                        if (t == 0) {
                                break;
                        }
                        NN++;
                }
                for (Map.Entry<Long, Node> etr : nodes.entrySet()) {
                        Node node = etr.getValue();
                        System.out.println("Shortest path reaching " + node.vertice + " from starting point is " + node.weight);
                }
        }
 
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt(), M = sc.nextInt(); // no of vertices and edges.
                long[] vertices = new long[N];
                long[] u = new long[M], v = new long[M], weight = new long[M];
                for (int i = 0; i < N; i++) {
                        vertices[i] = sc.nextLong();
                }
                for (int i = 0; i < M; i++) {
                        u[i] = sc.nextLong();
                        v[i] = sc.nextLong();
                        weight[i] = sc.nextLong();
                }
                findSSSP(u, v, weight, vertices, N);
        }
}
