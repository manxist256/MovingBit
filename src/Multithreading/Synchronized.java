/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multithreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mankank
 */
//Exclusively creating data inconsistency problem formed out of multithreading.
//Race condition
class S_AccountTransactions {
    
        public synchronized void withdraw() throws FileNotFoundException, IOException {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("s_account.txt"));
                int amount = Integer.parseInt(bufferedReader.readLine());
                //System.out.println(amount);
                PrintWriter pw = new PrintWriter(new FileWriter("s_account.txt")); 
                pw.println(amount - 1000); // 1k is withdrawn
                pw.flush();
        }
        
        public synchronized void deposit() throws FileNotFoundException, IOException {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("s_account.txt"));
                int amount = Integer.parseInt(bufferedReader.readLine());
                //System.out.println(amount);
                PrintWriter pw = new PrintWriter(new FileWriter("s_account.txt")); 
                pw.println(amount + 1000); // 1k is deposited
                pw.flush();
        }
}

class SDIThreadW extends Thread {
    
        S_AccountTransactions account;
        
        public SDIThreadW(S_AccountTransactions account) {
                this.account = account;
        }

        @Override
        public void run() {
            try {
                    account.withdraw();
            } catch (IOException ex) {
                    Logger.getLogger(DIThreadW.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}

class SDIThreadD extends Thread {

        S_AccountTransactions account;
        
        public SDIThreadD(S_AccountTransactions account) {
                this.account = account;
        }
    
        @Override
        public void run() {
            try {
                    account.deposit();
            } catch (IOException ex) {
                    Logger.getLogger(DIThreadW.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}

public class Synchronized {
        public static void main(String[] args) throws FileNotFoundException {
                PrintWriter pw = new PrintWriter("s_account.txt"); 
                pw.println(5000); //account initially has 5k
                pw.flush();
                S_AccountTransactions account = new S_AccountTransactions();
                SDIThreadW withdrawop = new SDIThreadW(account);
                SDIThreadD depositop = new SDIThreadD(account);
                depositop.start();
                withdrawop.start();
        }
}
