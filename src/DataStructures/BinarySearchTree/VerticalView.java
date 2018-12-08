/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author mankank
 */

class BST$9 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$9() {
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

        public void verticalView() {
                TreeMap<Integer, ArrayList<Node>> map = verticalView(this.root, new TreeMap(), 0);
                for (Map.Entry etr : map.entrySet()) {
                        ArrayList<Node> list = (ArrayList<Node>) etr.getValue();
                        System.out.print(etr.getKey() + " ");
                        for (Node node : list) {
                                System.out.print(node.data + " ");
                        }
                        System.out.println();
                }
                
        }
        
        public TreeMap<Integer, ArrayList<Node>> verticalView(Node node, TreeMap<Integer, ArrayList<Node>> map, int pos) {
                if (node != null) {
                        if (!map.containsKey(pos)) {
                                ArrayList<Node> list = new ArrayList();
                                list.add(node);
                                map.put(pos, list);
                        } else {
                                map.get(pos).add(node);
                        }
                        verticalView(node.left, map, pos - 1);
                        verticalView(node.right, map, pos + 1);
                }
                return map;
        }
        
        
}

public class VerticalView {
        public static void main(String[] args) {
                BST$9 bst = new BST$9();
                bst.insert(1000);
                bst.insert(500);
                bst.insert(1500);
                bst.insert(250);
                bst.insert(750);
                bst.insert(1250);
                bst.insert(1750);
                bst.insert(125);
                bst.insert(375);
                bst.insert(625);
                bst.insert(875);
                bst.insert(1125);
                bst.insert(1375);
                bst.insert(1625);
                bst.insert(1875);
                bst.verticalView();
        }
}
