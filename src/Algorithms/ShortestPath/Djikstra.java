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
import java.util.Set;

/**
 *
 * @author mankank
 */
//SSSP
public class Djikstra {
    
        static class Edge {
            int u, v, weight;
            public Edge(int u, int v, int weight) {
                    this.u = u;
                    this.v = v;
                    this.weight = weight;
            }
            
        }
    
        static class Node {
                int weight, vertice;
                boolean visited;
                public Node(int weight, int vertice) {
                        this.weight = weight;
                        this.vertice = vertice;
                }
        }
        
        private static void buildAdjacencyMap(HashMap<Integer, HashSet<Edge>> map, int[] u, int[] v, int[] w) {
                for (int i = 0; i < w.length; i++) {
                        Edge edge = new Edge(u[i], v[i], w[i]);
                        if (!map.containsKey(u[i])) {
                                HashSet<Edge> set = new HashSet<>();
                                map.put(u[i], set);
                        }
                        Set<Edge> set = map.get(u[i]);
                        set.add(edge);
                }
        }
        
        private static void buildVertices(int[] vertices, HashMap<Integer, Node> nodes) {
              for (int i = 0; i < vertices.length; i++) {
                    if (i == 0) nodes.put(vertices[i], new Node(0, vertices[i]));
                    else nodes.put(vertices[i], new Node(Integer.MAX_VALUE, vertices[i]));
              }  
        }
        
        private static Node getCurrent(HashMap<Integer, Node> nodes) {
                Node c = null; int mw = Integer.MAX_VALUE;
                for(Map.Entry<Integer, Node> etr : nodes.entrySet()) {
                        Node node = etr.getValue();
                        if (node.weight < mw && !node.visited) {
                                c = node;
                                mw = node.weight;
                        }
                }
                return c;
        }
        
        private static void relax(Node node, HashMap<Integer, Node> nodes, HashMap<Integer, HashSet<Edge>> map) {
                int v = node.vertice;
                if (!map.containsKey(v)) {
                        return;
                }
                Set<Edge> e_set = map.get(v);
                for (Edge e : e_set) {
                        int dest = e.v;
                        Node n = nodes.get(dest);
                        if ((node.weight + e.weight < n.weight) && !node.visited) {
                                n.weight = node.weight + e.weight;
                        }
                }
        }
        
        private static void findSSSP(int[] u, int[] v, int[] weight, int[] vertices, int N) {
                HashMap<Integer, HashSet<Edge>> map = new HashMap<>();
                buildAdjacencyMap(map, u, v, weight);
                HashMap<Integer, Node> nodes = new HashMap<>();
                buildVertices(vertices, nodes);
                int NN = 0;
                while (NN  < N - 1) {
                        Node node = getCurrent(nodes);
                        relax(node, nodes, map);
                        node.visited = true;
                        NN++;
                }
                for (Map.Entry<Integer, Node> etr : nodes.entrySet()) {
                        Node node = etr.getValue();
                        System.out.println("Shortest path reaching " + node.vertice + " from starting point is " + node.weight);
                }
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
                findSSSP(u, v, weight, vertices, N);
        }
}
