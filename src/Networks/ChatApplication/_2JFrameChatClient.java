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
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author mankank
 */
class Client_ extends JFrame implements MouseListener {

        //constants
        private static final int WINDOW_WIDTH = 300;
        private static final int WINDOW_HEIGHT = 300;
        private static final String WINDOW_TITLE = "Nithin";
        
        private Socket socket;
        
        private BufferedReader rw_1;
        
        private JLabel datalabel;

        public Client_() {
                buildJFrame();
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

        public void initializeSocket() throws IOException {
                socket = new Socket(InetAddress.getLocalHost(), 2500);
        }

        public void initializeIO() throws IOException {
                this.rw_1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
