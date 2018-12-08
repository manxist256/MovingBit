/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author mankank
 */

class BST$10 implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
                int n1 = (int)o1;
                int n2 = (int)o2;
                return n1 > n2 ? +1 : -1;
        }
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$10() {
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

        public void topView() {
                TreeMap<Integer, TreeMap<Integer, Node>> map = verticalView(this.root, new TreeMap(), 0, 0);
                for (Map.Entry etr : map.entrySet()) {
                        TreeMap<Integer, Node> set = (TreeMap<Integer, Node>) etr.getValue();
                        System.out.print(etr.getKey() + " ");
                        System.out.println(set.firstEntry().getValue().data);
                }
                
        }
        
        public TreeMap<Integer, TreeMap<Integer, Node>> verticalView(Node node, TreeMap<Integer, TreeMap<Integer, Node>> map, int pos, int level) {
                if (node != null) {
                        if (!map.containsKey(pos)) {
                                TreeMap imap = new TreeMap();
                                map.put(pos, imap);
                                imap.put(level, node);
                                
                        } else {
                                map.get(pos).put(level, node);
                        }
                        verticalView(node.left, map, pos - 1, level + 1);
                        verticalView(node.right, map, pos + 1, level + 1);
                }
                return map;
        }
        
        
}

public class TopView {
        public static void main(String[] args) {
                BST$10 bst = new BST$10();
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
                bst.topView();
        }
}
