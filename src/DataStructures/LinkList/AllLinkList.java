/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.LinkList;

import java.util.HashSet;

/**
 *
 * @author mankank
 */
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}
class LinkList {
    Node head;
    public LinkList() {
        this.head = null;
    }
    /**
     * Insert at end
     */
    public void insert(int data) {
        Node newnode = new Node(data);
        if (this.head == null) {
            this.head = newnode; 
            return;
        }
        Node traverse = this.head;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        traverse.next = newnode;
    }
    
    /**
     * Traverse link list
     */
    public void traverse() {
        Node traverse = this.head;
        while (traverse != null) {
            System.out.print(traverse.data + "->");
            traverse = traverse.next;
        }
        System.out.println("null");
    }
    
    /**
     * Delete link list
     */
    public void deleteLL() {
        this.head = null;
    }
    
    /**
     * Delete a link list node based on data
     */
    public void deleteNodeBasedOnData(int data) {
        Node traverse = this.head;
        if (data == this.head.data) {
            this.head = this.head.next;
            return;
        }
        while (traverse != null) {
            if (traverse.next != null && traverse.next.data == data) {
                traverse.next = traverse.next.next;
            }
            traverse = traverse.next;
        }
    }
    
    /**
     * Delete a link list node based on index
     */
    public void deleteNodeBasedOnIndex(int position) {
        // position == 5, traverse 4 times;
        Node traverse = this.head;
        position -= 1;
        if (position == 0) {
            this.head = traverse.next;
            return;
        }
        while (traverse != null && position-- > 1) {
            traverse = traverse.next;
        }
        try {
            traverse.next = traverse.next.next;
        } catch(Exception e) {
            System.out.println("Position doesn't exists");
        }
        
    }
    
    /**
     * find length of link list : iterative
     * @return int : length
     */
    public int lengthLLIterative() {
        int l = 0;
        Node traverse = this.head;
        while (traverse != null) {
            traverse = traverse.next;
            l++;
        }
        return l;
    }
    
    /**
     * find length of link list : recursive
     * @return int : length
     */
    public int lengthLLRecursive(Node node) {
        if (node != null) {
            return 1 + lengthLLRecursive(node.next);
        }
        return 0;
    }
    
    /**
     * search an element : iterative
     */
    public void searchDataIterative(int data) {
        Node traverse = this.head;
        while (traverse != null) {
            if (traverse.data == data) {
                System.out.println(data + " found!");
                return;
            }
            traverse = traverse.next;
        }
        System.out.println("oops " + data + " not found.");
    }
    
    /**
     * search an element : recursive
     */
    public boolean searchDataRecursive(int data, Node node) {
        if (node != null && node.data == data) {
            return true;
        }
        if (node != null) {
            return searchDataRecursive(data, node.next);
        }
        return false;
    }
    
    /**
     * get nTh node in LL
     * @return int : nth node 
     */
    public int getNthNode(int n) {
        int data = -1;
        Node traverse = this.head;
        while (traverse != null && n-- > 0) {
            traverse = traverse.next;
        }
        if (traverse != null)
            data = traverse.data;
        else
            System.out.println("nth data not found.");
        return data;
    }
    
    /**
     * get nTh node from end of LL
     * @return int : nth from end of ll 
     */
    public int getNthNodeFromEnd(int n) {
        int length = this.lengthLLRecursive(this.head);
        n = length - (n + 1);
        int data = -1;
        Node traverse = this.head;
        while (traverse != null && n-- > 0) {
            traverse = traverse.next;
        }
        if (traverse != null)
            data = traverse.data;
        else
            System.out.println("nth data not found.");
        return data;
    }
    
    /**
     * print middle of ll
     */
    public void getMiddleElementLL () {
        Node fp = this.head;
        Node sp = this.head;
        while (fp != null) {
            if (fp.next == null) break;
            fp = fp.next.next;
            sp = sp.next;
        }
        System.out.println(sp.data);
    }
    
    /**
     * count data occurence
     */
    public int dataOccurence(int data) {
        int c = 0;
        Node traverse = this.head;
        while (traverse != null) {
            if (traverse.data == data) {
                c++;
            }
            traverse = traverse.next;
        }
        return c;
    }
    
    /**
     * get last node of ll
     * @return node
     */
    public Node getLastNode() {
        Node traverse = this.head;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        return traverse;
    }
    
    /**
     * creates loop in ll
     */
    public void createLoop() {
        Node lastNode = this.getLastNode();
        lastNode.next = this.head;
    }
    
    /**
     * detects loop in ll
     * @return boolean
     */
    public boolean detectloop() {
        createLoop();
        Node fp = this.head;
        Node sp = this.head;
        while (true) {
            try {
                fp = fp.next.next;
                sp = sp.next;
                if (fp == sp) {
                    return true;
                }
            } catch(Exception e) {
                System.out.println
                    ("no loop detected.");
                return false;
            }
        }
        
    }
    
    /**
     * length of loop in linklist
     */
    public void loopLength () {
        createLoop();
        Node fp = this.head;
        Node sp = this.head;
        Node initialLoopNode = null;
        while (true) {
            try {
                fp = fp.next.next;
                sp = sp.next;
                if (fp == sp) {
                    initialLoopNode = fp;
                    break;
                }
            } catch(Exception e) {
                System.out.println
                    ("no loop exists to detect length");
                break;
            }
        }
        int looplength = 0;
        if (initialLoopNode != null) {
            Node sfp = initialLoopNode;
            Node ssp = initialLoopNode;
            while (true) {
                fp = fp.next.next;
                sp = sp.next;
                looplength += 1;
                if (fp == sp) {
                    break;
                }
            }
        }
        System.out.println("Loop length : " + looplength);
    }
    
    /**
     * reverse LL
     */
    public void reverseLL() {
        Node firstptr = this.head;
        Node secondptr = null;
        while (firstptr != null) {
            Node temp = firstptr.next;
            firstptr.next = secondptr;
            secondptr = firstptr;
            firstptr = temp;
        }
        this.head = secondptr;
    }
    
    /**
     * check ll is palindrome / not
     */
    public void checkLLPalindrome() {
        int length = this.lengthLLRecursive(this.head);
        int traverseL = length / 2;
        Node secondptr = this.head;
        while (traverseL -- > 0) {
            secondptr = secondptr.next;
        }
        Node firstptr = secondptr.next;
        while (firstptr != null) {
            Node temp = firstptr.next;
            firstptr.next = secondptr;
            secondptr = firstptr;
            firstptr = temp;
        }
        Node ln = secondptr;
        Node fn = this.head;
        int t = length / 2;
        while (t-- > 0) {
            System.out.println(fn.data + " " +ln.data);
            if (fn.data == ln.data) {
                fn = fn.next;
                ln = ln.next;
                continue;
            }
            System.out.println("Not palindrome.");
            return;
        }
        System.out.println("Palindrome!");
    }
    
    /**
     * remove duplicates from ll sorted
     */
    public void removeDuplicatesSortedLL() {
        if (this.lengthLLRecursive(this.head) == 1) {
            return;
        }
        Node fp = this.head.next;
        Node sp = this.head;
        while (fp != null) {
            if (fp.data == sp.data) {
                fp = fp.next;
                sp.next = fp;
            } else {
                fp = fp.next;
                sp = sp.next;
            }
        }
    }
    
    /**
     * remove duplicates from ll unsorted
     */
    public void removeDuplicatesUnSortedLL() {
        HashSet<Integer> set = new HashSet<>();
        if (this.lengthLLRecursive(this.head) == 1) {
            return;
        }
        Node fp = this.head.next;
        Node sp = this.head;
        set.add(sp.data);
        while (fp != null) {
            if (set.contains(fp.data)) {
                fp = fp.next;
                sp.next = fp;
            } else {
                set.add(fp.data);
                fp = fp.next;
                sp = sp.next;
            }
        }
    }
    
    /**
     * swap nodes in ll without swapping data
     */
    public void swapNodesInLL(int key1, int key2) {
        // search element 1
        Node fp1 = this.head;
        Node sp1 = null;
        while (fp1 != null) {
            if (fp1.data == key1) {
                break;
            } else {
                sp1 = fp1;
                fp1 = fp1.next;
            }
        }
        // search element 12
        Node fp2 = this.head;
        Node sp2 = null;
        while (fp2 != null) {
            if (fp2.data == key2) {
                break;
            } else {
                sp2 = fp2;
                fp2 = fp2.next;
            }
        }
        Node temp = fp2.next;
        sp1.next = fp2;
        if (fp2 != fp1.next) {
           fp2.next = fp1.next;
        } else {
            fp2.next = sp2;
        }
        sp2.next = fp1;
        if (fp1 != temp) {
            fp1.next = temp;
        } else {
            fp1.next = sp1;
        }
    }
    
    /**
     * k wise swap nodes in ll
     */
    public void kWiseSwap(int k) {
        Node ln, pv = null;
        Node fp = this.head;
        Node sp = null;
        boolean hf = false;
        while (fp != null) {
            int tv = k;
            ln = fp; //10
            while (tv-- > 0 && fp != null) {
                Node temp = fp.next;
                fp.next = sp;
                sp = fp;
                fp = temp;
            }
            if (!hf) {
                this.head = sp;
                hf = true;
            }
            if (pv != null) {
                pv.next = sp;
            }
            pv = ln; // 10
            sp = null;
        }
    }
    
    /**
     * move last node front
     */
    public void moveLastNodeFront() {
        Node traverse = this.head;
        Node lastNode = this.head;
        while (traverse.next != null) {
            traverse = traverse.next;
            if (traverse.next.next == null) {
                lastNode = traverse.next;
                traverse.next = null;
                break;
            }
        }
        lastNode.next = this.head;
        this.head = lastNode;
    }
    
    /**
     * Seggregate even and odd nodes
     */
    public void seggregateEvenAndOddNodes() {
        Node ttl = this.head;
        while (ttl.next != null) {
            ttl = ttl.next;
        }
        Node tttl = ttl;
        Node fp = this.head;
        Node sp = null;
        boolean fe = false;
        while (fp != null && fp != tttl) {
            if (fp.data % 2 != 0) {
                Node temp = fp;
                if (sp != null) {
                    sp.next = fp.next;
                }
                ttl.next = temp;
                ttl = temp;
                fp = fp.next;
                temp.next = null;
            } else {
                sp = fp;
                fp = fp.next;
                if (!fe) {
                    this.head = sp;
                    fe = true;
                } 
            }
        }
    }
    
    public LinkList intersectionOf2SortedLL(LinkList l1, LinkList l2) {
        Node t1 = l1.head;
        Node t2 = l2.head;
        LinkList l3 = new LinkList();
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                t1 = t1.next;
            } else if (t2.data < t1.data) {
                t2 = t2.next;
            } else {
                l3.insert(t1.data);
                t1 = t1.next;
                t2 = t2.next;
            }
        }
        return l3;
    }
}
public class AllLinkList {
    public static void main(String[] args) {
        LinkList linklist = new LinkList();
        linklist.insert(10);
        linklist.insert(20);
        //linklist.insert(33);
        //linklist.insert(43);
        linklist.insert(50);
        linklist.insert(60);
        linklist.insert(70);
        linklist.insert(80);
        /*linklist.insert(10);
        linklist.insert(20);
        linklist.insert(30);
        linklist.insert(40);
        linklist.insert(50);*/
        //linklist.insert(50);
        /*linklist.insert(20);
        linklist.insert(30);
        linklist.insert(30);
        linklist.insert(40);
        linklist.insert(50);
        linklist.insert(50);
        linklist.insert(60);*/
        //linklist.insert(50);
        linklist.traverse();
        //linklist.deleteLL();
        //linklist.traverse();
        //linklist.deleteNodeBasedOnData(30);
        //linklist.traverse();
        //linklist.deleteNodeBasedOnIndex(3);
        //linklist.traverse();
        //int length = linklist.lengthLLIterative();
        //System.out.println(length);
        //int s = linklist.lengthLLRecursive(linklist.head);
        //System.out.println(s);
        //linklist.searchDataIterative(23);
        //boolean yes = linklist.searchDataRecursive(60, linklist.head);
        //System.out.println(yes);
        //System.out.println(linklist.getNthNode(5));
        //System.out.println(linklist.getNthNodeFromEnd(7));
        //linklist.getMiddleElementLL();
        //System.out.println(linklist.dataOccurence(50));
        //System.out.println(linklist.detectloop());
        //linklist.loopLength();
        //linklist.reverseLL();
        //linklist.traverse();
        //linklist.checkLLPalindrome();
        //linklist.removeDuplicates();
        //linklist.traverse();
        //linklist.removeDuplicatesUnSortedLL();
        //linklist.traverse();
        //linklist.swapNodesInLL(10, 50);
        //linklist.traverse();
        //linklist.kWiseSwap(3);
        //linklist.traverse();
        //linklist.moveLastNodeFront();
        //linklist.traverse();
        //linklist.seggregateEvenAndOddNodes();
        //linklist.traverse();
        /*LinkList l1 = new LinkList();
        l1.insert(1);
        l1.insert(2);
        l1.insert(3);
        l1.insert(4);
        l1.insert(6);
        LinkList l2 = new LinkList();
        l2.insert(2);
        l2.insert(4);
        l2.insert(6);
        l2.insert(8);
        LinkList l3 = linklist.intersectionOf2SortedLL(l1, l2);
        l3.traverse();*/
    }
}

