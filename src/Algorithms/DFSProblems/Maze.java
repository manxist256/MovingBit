/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DFSProblems;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
//Rate in a maze | Backtracking
public class Maze {
    
        boolean reached = false;
    
        private void isReachable (int[][] maze, int[][] path, int N) {
                isReachable(maze, N, 0, 0, path);
                printpath(path);
                System.out.println(reached ? "reachable" : "not-reachable");
        }
        
        private void printpath(int[][] path) {
                System.out.println("path :");
                for (int i = 0; i < path.length; i++) {
                        for (int j = 0; j < path.length; j++) {
                                System.out.print(path[i][j] + " ");
                        }
                        System.out.println();
                }
        }
        
        private void isReachable(int[][] maze, int N, int x, int y, int[][] path) {
                if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || reached || maze[x][y] == 0) {
                        return;
                }
                path[x][y] = 1; 
                if (x == N - 1 && y == N - 1) {
                        reached = true;
                        return;
                }
                isReachable(maze, N, x, y + 1, path);
                isReachable(maze, N, x + 1, y, path);
                if (!reached) path[x][y] = 0;
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[][] maze = new int[N][N];
                int[][] path = new int[N][N];
                for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                                maze[i][j] = sc.nextInt();
                        }
                }
                new Maze().isReachable(maze, path,  N);
        }
}
