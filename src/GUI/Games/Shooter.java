/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Games;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author mankank
 */

class GameStart_ {
        public static void main(String[] args) {
                Shooter shooter = new Shooter();
        }
}

public class Shooter extends JFrame implements ActionListener, MouseListener, KeyListener {
    
        //constants
        private static final String GAME_TITLE = "Shooter";
        private static final int C_WIDTH = 600;
        private static final int C_HEIGHT = 600;
        
        private Timer t;
        private Random rand;
        
        private boolean gameStart;
        
        private Rectangle slider;
        private Rectangle shooter;
        private Rectangle shootBall;
        
        int shootertime;
        
        public Shooter() {
                buildJFrame();
                initializeComponents();
                addListeners();
        }
        
        private void buildJFrame() {
                this.setVisible(true);
                this.setResizable(false);
                this.setSize(C_WIDTH, C_HEIGHT);
                this.setTitle(GAME_TITLE);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        private void initializeComponents() {
                this.t = new Timer(100, this);
                this.rand = new Random();
                this.slider = new Rectangle(0, 0, 20, 200);
                this.shooter = new Rectangle(C_WIDTH - 20, C_HEIGHT, 20, 300);
                this.shootertime = getShooterTime();
                t.start();
        }
        
        private void addListeners() {
                this.addMouseListener(this);
                this.addKeyListener(this);
        }

        int r;
        
        private int getShooterTime() {
                int random = rand.nextInt(90);
                if (random < 15) {
                    random = 16;
                } else if (random > 75) {
                    random = 74;
                }
                return random + r;
        }
        
        private void createNewShootBall(int shooterY) {
                this.shootBall = new Rectangle(C_WIDTH, shooterY + 150, 20, 20);
        }
        
        int score;
        
        boolean intersection = false;
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if (gameStart) {
                        r++;
                        shooter.y -= 10;
                        if (shootBall != null) {
                                shootBall.x -= 50;
                                if (shootBall.intersects(slider)) {
                                        score -= 5;
                                        intersection = true;
                                }
                        }
                        
                        if (!intersection && shootBall != null && shootBall.x < slider.x) {
                                score += 5;
                                intersection = true;
                        }
                        
                        if (r == shootertime) {
                                createNewShootBall(shooter.y);
                                intersection = false;
                        }
                        
                        if (shooter.y + shooter.height <= 0) {
                                shooter.y = C_HEIGHT;
                                shootertime = getShooterTime();
                        }

                        this.repaint();
                }
        }
    
        @Override
        public void paint(Graphics g) {
                g.setColor(Color.white);
                g.fillRect(0, 0, C_WIDTH, C_HEIGHT);

                g.drawImage(new ImageIcon("mountain.png").getImage(), 0, 320, this);
                g.drawImage(new ImageIcon("cloud.jpeg").getImage(), 300, 20, this);

                g.setColor(Color.BLACK);
                g.fillRect(slider.x, slider.y, slider.width, slider.height);

                g.setColor(Color.RED);
                g.fillRect(shooter.x, shooter.y, shooter.width, shooter.height);
                
                if (shootBall != null) {
                        g.setColor(Color.YELLOW);
                        g.fillRect(shootBall.x, shootBall.y, shootBall.width, shootBall.height);
                }
                
                if (gameStart) {
                        g.setColor(Color.RED);
                        g.setFont(new Font("Arial", 1, 20));
                        g.drawString("Score : " + score, C_WIDTH - 100, 40);
                }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if (!gameStart) {
                    this.gameStart = true;
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch(key) {
                case KeyEvent.VK_UP :
                        if (slider.y > 0) {
                                slider.y -= 30;
                        }
                        break;
                case KeyEvent.VK_DOWN :
                        if (slider.y + slider.height < C_HEIGHT) {
                                slider.y += 30;
                        }
                        break;
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
}
