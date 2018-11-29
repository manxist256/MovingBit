/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.StandAloneApplications;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mankank
 */

class Math {
        public static void main(String[] args) {
            Calculator calculator = new Calculator();
        }
}

class Addition implements ActionListener {

        JTextField j1, j2;
        JLabel jlabel;

        public Addition(Calculator c) {
            j1 = c.j1;
            j2 = c.j2;
            this.jlabel = c.jlabel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int addition = Integer.parseInt(j1.getText()) + Integer.parseInt(j2.getText());
            this.jlabel.setText(String.valueOf(addition)); 
        }

}

class Subtraction implements ActionListener {

        JTextField j1, j2;
        JLabel jlabel;

        public Subtraction(Calculator c) {
                j1 = c.j1;
                j2 = c.j2;
                this.jlabel = c.jlabel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                int sub = Integer.parseInt(j1.getText()) - Integer.parseInt(j2.getText());
                this.jlabel.setText(String.valueOf(sub)); 
        }
    
}

class Division implements ActionListener {

        JTextField j1, j2;
        JLabel jlabel;

        public Division(Calculator c) {
                j1 = c.j1;
                j2 = c.j2;
                this.jlabel = c.jlabel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                try {
                        int div = Integer.parseInt(j1.getText()) / Integer.parseInt(j2.getText());
                        this.jlabel.setText(String.valueOf(div)); 
                } catch(ArithmeticException ex) {
                        JOptionPane.showMessageDialog(null, "Can't divide by zero");
                }
        }
    
}

class Multiplication implements ActionListener {

        JTextField j1, j2;
        JLabel jlabel;

        public Multiplication(Calculator c) {
                j1 = c.j1;
                j2 = c.j2;
                this.jlabel = c.jlabel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                int mul = Integer.parseInt(j1.getText()) * Integer.parseInt(j2.getText());
                this.jlabel.setText(String.valueOf(mul)); 
        }
    
}

public class Calculator extends JFrame {
    
        static String TITLE  = "Calculator";
        static String ADD  = "Add";
        static String SUB  = "Sub";
        static String MUL  = "Mul";
        static String DIV  = "Div";
        static String RESULT  = "Result";
        protected JTextField j1, j2;
        protected JButton add, sub, div, mul;
        protected JLabel jlabel;

        public Calculator() {
                buildjFrame();
                initializeComponents();
                addComponents();
                addListeners();
        }
        
        private void buildjFrame() {
                this.setVisible(true);
                this.setSize(600, 400);
                this.setLayout(new FlowLayout());
                this.setTitle(TITLE);
                this.getContentPane().setBackground(Color.yellow.darker());
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        private void initializeComponents() {
                this.j1 = new JTextField(2);
                this.j2 = new JTextField(2);
                this.add = new JButton(ADD);
                this.sub = new JButton(SUB);
                this.div = new JButton(DIV);
                this.mul = new JButton(MUL);
                this.jlabel = new JLabel(RESULT);
        }
        
        private void addComponents() {
                this.add(j1);
                this.add(j2);
                this.add(add);
                this.add(sub);
                this.add(mul);
                this.add(div);
                this.add(jlabel);
        }
        
        private void addListeners() {
                this.add.addActionListener(new Addition(this));
                this.sub.addActionListener(new Subtraction(this));
                this.div.addActionListener(new Division(this));
                this.mul.addActionListener(new Multiplication(this));
        }
}
