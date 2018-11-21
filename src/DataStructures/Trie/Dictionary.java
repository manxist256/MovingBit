/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.Trie;

import java.util.ArrayList;

/**
 *
 * @author mankank
 */

class Node {
        char c;
        boolean word;
        final Node[] arr;
        public Node () {
                this.arr = new Node[26];
        }
}

class  TrieDictionary {
        Node root;
        public TrieDictionary() {
                this.root = new Node();
        }
        
        public void insertWord(String word) {
                word = word.toLowerCase();
                int i = 0, max = word.length();
                Node walker = this.root;
                while (i < max) {
                        char c = word.charAt(i);
                        int index = c - 97;
                        Node newnode = new Node();
                        if (walker.arr[index] == null) {
                                newnode.c = c;
                                walker.arr[index] = newnode;
                        }
                        walker = walker.arr[index];
                        if (i == word.length() - 1) {
                                walker.word = true;
                        }
                        i++;
                }
        }
        
        public void searchWord(String word) {
                word = word.toLowerCase();
                Node walker = this.root;
                int i = 0;
                while (i < word.length()) {
                        if (walker.arr[word.charAt(i) - 97] == null) {
                                System.out.println(word + " not exist.");
                                return;
                        }
                        walker = walker.arr[word.charAt(i++) - 97];
                }
                if (walker.word == true) {
                        System.out.println(word + " exist.");
                } else {
                        System.out.println(word + " not exist.");
                }
        }
        
        public void buildPossibilities(String pattern) {
                Node walker = this.root;
                int i = 0;
                ArrayList<String> result = new ArrayList<>();
                try {
                        while (i < pattern.length()) {
                                walker = walker.arr[pattern.charAt(i) - 97];
                                i++;
                                if (i == pattern.length()) {
                                        if (walker.word) {
                                                result.add(pattern);
                                        }
                                }
                        }
                } catch (Exception e) {
                        System.out.println("No word starts with " + pattern);
                }
                StringBuilder p = new StringBuilder(pattern);
                this.buildPossibilities(walker, p, result);
                result.forEach(System.out::println);
        }

        private void buildPossibilities(Node walker, StringBuilder pattern, ArrayList<String> result) {
                if (walker != null) {
                        Node arr[] = walker.arr;
                        for (Node arr1 : arr) {
                                if (arr1 != null) {
                                    pattern.append(arr1.c);
                                    if (arr1.word) {
                                            result.add(pattern.toString());
                                    }
                                    this.buildPossibilities(arr1, pattern, result);
                                    pattern.deleteCharAt(pattern.length() - 1);
                                }
                        }
                }
        }
        
}

public class Dictionary {
        public static void main(String[] args) {
                TrieDictionary trie = new TrieDictionary();
                trie.insertWord("manikandan");
                trie.insertWord("manik");
                trie.insertWord("manixs");
                trie.insertWord("manixsd");
                trie.insertWord("manixsa");
                trie.insertWord("manixya");
                trie.insertWord("nithin");
                trie.insertWord("nis");
                trie.insertWord("nise");
                trie.insertWord("mad");
                //trie.searchWord("nithin");
                //trie.buildPossibilities("n");
        }
}
