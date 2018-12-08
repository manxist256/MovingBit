/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author mankank
 */

class TSComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
         BST$11.Node n1 = (BST$11.Node)o1;
         BST$11.Node n2 = (BST$11.Node)o2;
         return n1.data < n2.data ? +1 : -1;
    }
    
}

class BST$11 {
    
        static class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$11() {
                this.root = null;
        }
        
        public void insert(int data) {
                Node newnode = new Node(data);
                if (this.root == null) {
                        this.root = newnode;
                        return;
                }
                Node traverse = this.root;
                while (traverse != null) {
                        if (data <= traverse.data) {
                                if (traverse.left == null) {
                                        traverse.left = newnode;
                                        return;
                                }
                                traverse = traverse.left;
                        } else {
                                if (traverse.right == null) {
                                        traverse.right = newnode;
                                        return;
                                }
                                traverse = traverse.right;
                        }
                }
        }

        public void bottomView() {
                TreeMap<Integer, TreeMap<Integer, TreeSet<Node>>> map = bottomView(this.root, new TreeMap(), 0, 0);
                for (Map.Entry etr : map.entrySet()) {
                        TreeMap<Integer, TreeSet<Node>> m1 = (TreeMap<Integer, TreeSet<Node>>) etr.getValue();
                        TreeSet<Node> set = m1.lastEntry().getValue();
                        System.out.print(etr.getKey() + " ");
                        for (Node node : set) {
                                System.out.print(node.data + " ");
                        }
                        System.out.println();
                }
                
        }
        
        public TreeMap<Integer, TreeMap<Integer, TreeSet<Node>>> bottomView(Node node, TreeMap<Integer, TreeMap<Integer, TreeSet<Node>>> map, int pos, int level) {
                if (node != null) {
                        if (!map.containsKey(pos)) {
                                TreeMap<Integer, TreeSet<Node>> imap = new TreeMap();
                                TreeSet<Node> iset = new TreeSet(new TSComparator());
                                iset.add(node);
                                imap.put(level, iset);
                                map.put(pos, imap);
                                
                        } else {
                                Map<Integer, TreeSet<Node>> imap = map.get(pos);
                                if(!imap.containsKey(level)) {
                                        TreeSet<Node> set = new TreeSet(new TSComparator());
                                        imap.put(level, set);
                                        set.add(node);
                                } else {
                                        imap.get(level).add(node);
                                }
                        }
                        bottomView(node.left, map, pos - 1, level + 1);
                        bottomView(node.right, map, pos + 1, level + 1);
                }
                return map;
        }
        
        
}

public class BottomView {
        public static void main(String[] args) {
                BST$11 bst = new BST$11();
//                bst.insert(1000);
//                bst.insert(500);
//                bst.insert(1500);
//                bst.insert(250);
//                bst.insert(750);
//                bst.insert(1250);
//                bst.insert(1750);
//                bst.insert(125);
//                bst.insert(375);
//                bst.insert(625);
//                bst.insert(875);
//                bst.insert(1125);
//                bst.insert(1375);
//                bst.insert(1625);
//                bst.insert(1875);
//                bst.insert(1000);
//                bst.insert(500);
//                bst.insert(1500);
//                bst.insert(1250);
//                bst.insert(1750);
//                bst.insert(1375);
//                bst.insert(1376);
//                bst.insert(1377);
//                bst.insert(1751);
//                bst.bottomView();
        }
}
