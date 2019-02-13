/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.BFS;

import java.util.HashMap;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class SnakeAndLadderGreedyBFS {
    
    static class Cell {
        int cellid;
        int level;
        public Cell(int cellid, int level) {
            this.cellid = cellid;
            this.level = level;
        }
    }
    
    public static void computeMinDice(HashMap<Integer, Integer> ladders, HashMap<Integer, Integer> snakes, int N) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(1, 0));
        boolean f = false;
        while (!queue.isEmpty() && !false) {
            Cell deq = queue.remove();
            int max = deq.cellid + 6 <= N ? deq.cellid + 6 : N; 
            //compute max
            for (int i = max; i > deq.cellid; i--) {
                if (!snakes.containsKey(i)) {
                    if (i == N) {
                        System.out.println(deq.level + 1);
                        return;
                    }
                    Cell cell = new Cell(i, deq.level + 1);
                    queue.offer(cell);
                    break;
                }
            }
            //compute ladders
            for (int i = deq.cellid + 1; i <= max; i++) {
                if (ladders.containsKey(i)) {
                    Cell cell = new Cell(ladders.get(i), deq.level + 1);
                    queue.offer(cell);
                }
            }
//            Iterator itr = queue.iterator();
//            while (itr.hasNext()) {
//                Cell cell = (Cell) itr.next();
//                System.out.print(cell.cellid + " " + cell.level + " : ");
//            }
//            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), LSC = sc.nextInt(); // LC = ladder count and snakes count
        HashMap<Integer, Integer> ladders = new HashMap<>();
        HashMap<Integer, Integer> snakes = new HashMap<>();
        for (int i = 0; i < LSC; i++) {
            ladders.put(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i < LSC; i++) {
            snakes.put(sc.nextInt(), sc.nextInt());
        }
        computeMinDice(ladders, snakes, N);
    }
}
