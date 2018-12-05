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
class AccountTransactions {
    
        public void withdraw() throws FileNotFoundException, IOException {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("account.txt"));
                int amount = Integer.parseInt(bufferedReader.readLine());
                PrintWriter pw = new PrintWriter(new FileWriter("account.txt")); 
                pw.println(amount - 1000); // 1k is withdrawn
                pw.flush();
        }
        
        public void deposit() throws FileNotFoundException, IOException {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("account.txt"));
                int amount = Integer.parseInt(bufferedReader.readLine());
                PrintWriter pw = new PrintWriter(new FileWriter("account.txt")); 
                pw.println(amount + 1000); // 1k is deposited
                pw.flush();
        }
}

class DIThreadW extends Thread {
    
        AccountTransactions account;
        
        public DIThreadW(AccountTransactions account) {
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

class DIThreadD extends Thread {

        AccountTransactions account;
        
        public DIThreadD(AccountTransactions account) {
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

public class DataInconsistency {
        public static void main(String[] args) throws FileNotFoundException {
                PrintWriter pw = new PrintWriter("account.txt"); 
                pw.println(5000); //account initially has 5k
                pw.flush();
                AccountTransactions account = new AccountTransactions();
                DIThreadW withdrawop = new DIThreadW(account);
                DIThreadD depositop = new DIThreadD(account);
                withdrawop.start();
                depositop.start();
        }
}
