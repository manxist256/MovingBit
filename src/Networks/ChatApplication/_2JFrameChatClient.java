/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networks.ChatApplication;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author mankank
 */
class Client_ extends JFrame implements MouseListener {

        //constants
        private static final int WINDOW_WIDTH = 300;
        private static final int WINDOW_HEIGHT = 300;
        private static final String WINDOW_TITLE = "Nithin";
        private static final int TEXT_FIELD_MAX_CHAR = 20;
        private static final String SEND_LABEL = "Send";
        
        private JTextField inputField;
        private JButton sendButton;
        
        private Socket socket;
        
        private BufferedReader rw_1;
        private PrintWriter pw_1;
        
        private JLabel datalabel;

        public Client_() {
                buildJFrame();
                initializeComponents();
                addComponents();
                addListeners();
        }

        private void buildJFrame() {
                this.setVisible(true);
                this.setResizable(false);
                this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
                this.setTitle(WINDOW_TITLE);
                this.getContentPane().setBackground(Color.CYAN);
                this.setLayout(new FlowLayout());
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        private void initializeComponents() {
                this.inputField = new JTextField(TEXT_FIELD_MAX_CHAR);
                this.sendButton = new JButton(SEND_LABEL);
        }
        
        private void addComponents() {
                this.add(inputField);
                this.add(sendButton);
        }
        
        private void addListeners() {
                this.sendButton.addMouseListener(this);
        }

        public void initializeSocket() throws IOException {
                socket = new Socket(InetAddress.getLocalHost(), 2500);
        }

        public void initializeIO() throws IOException {
                this.rw_1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.pw_1 = new PrintWriter(socket.getOutputStream());
        }

        public void listen() throws IOException {
                while (true) {
                        String msg = rw_1.readLine();
                        this.datalabel = new JLabel();
                        this.add(datalabel);
                        datalabel.setText(msg);
                }
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
                String input = inputField.getText();
                this.pw_1.println(input);
                this.pw_1.flush();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    
}

public class _2JFrameChatClient {
        public static void main(String[] args) throws IOException {
                Client_ client = new Client_();
                client.initializeSocket();
                client.initializeIO();
                client.listen();
        }
}
