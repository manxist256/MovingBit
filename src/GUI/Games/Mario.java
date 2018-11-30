/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Games;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author mankank
 */

class MarioGameInvocation {
        public static void main(String[] args) {
                Mario play = new Mario();
        }
}


public class Mario extends JFrame implements ActionListener, MouseListener, KeyListener {
    
    private static final String GAME_NAME = "Mario";
    private static final int C_WIDTH = 600;
    private static final int C_HEIGHT = 600;
    
    private static final int MARIO_WIDTH = 40;
    private static final int MARIO_HEIGHT = 40;
    
    private int mario_x, mario_y, ticks, cntr, toad_x, toad_y;
    
    private Timer t;
    private ArrayList<Rectangle> blocks, cloudBlocks;
    private final Image toad = new ImageIcon("toad.jpg").getImage().getScaledInstance(40, 40, 1);
    private Random rand;
    private boolean toadPlay;
    
    private boolean gameStart;
    private boolean gameEnd;
    
    private Image mario;
    
    public Mario() {
            buildJFrame();
            initializeComponents();
            addListeners();
    }
    
    private void buildJFrame() {
            this.setVisible(true);
            this.setSize(C_WIDTH, C_HEIGHT);
            this.setResizable(false);
            this.setTitle(GAME_NAME);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
            this.t = new Timer(100, this);
            this.blocks = new ArrayList<>();
            this.cloudBlocks = new ArrayList<>();
            this.rand = new Random();
            this.mario = new ImageIcon("Mario.jpeg").getImage().getScaledInstance(MARIO_WIDTH, MARIO_HEIGHT, 1);
            this.mario_x = 20;
            this.mario_y = 500;
            t.start();
    }
    
    private void addListeners() {
            this.addMouseListener(this);
            this.addKeyListener(this);
    }
    
    private void addBlockers() {
            int whichBlock = rand.nextInt(2);
            if (whichBlock == 1) { //add Rectangle
                    int r = 50 + this.rand.nextInt(150);
                    Rectangle rect = new Rectangle(C_WIDTH, (C_HEIGHT - 60) - r, 80, r);
                    blocks.add(rect);
                    toadPlay = false;
            } else if (whichBlock == 0) { //add Toad
                    toadPlay = true;
                    toad_x = C_WIDTH;
                    toad_y = 500;
            }
    }
    
    private void addCloudBlocks() {
                    int r = 50 + this.rand.nextInt(150);
                    Rectangle rect = new Rectangle(C_WIDTH, C_HEIGHT / 2 - 100, r, 40);
                    cloudBlocks.add(rect);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (gameStart) {
                    if (cloudBlocks.isEmpty()) {
                            addCloudBlocks();
                    }
                    
                    if (!cloudBlocks.isEmpty()) {
                            for (int i = 0; i < cloudBlocks.size(); i++) {
                                    Rectangle r = cloudBlocks.get(i);
                                    r.x -= 10;
                                    if (r.x + r.width < 0) {
                                        cloudBlocks.remove(i);
                                        i--;
                                        addCloudBlocks();
                                    }
                            }
                    }
                
                    if (blocks.isEmpty() && !toadPlay) {
                            addBlockers();
                    }
                    ticks++;
                    if (ticks % 2 == 0 && cntr < 25) {
                            cntr += 1;
                    }
                    if (cntr + mario_y > 500) {
                            mario_y = 500;
                    } else {
                            mario_y += cntr;
                    }
                    
                    if (toadPlay) {
                            toad_x -= 10;
                            if (toad_x < 0) {
                                   addBlockers(); 
                            }
                    }
                    
                    if (!blocks.isEmpty()) {
                            for (int i = 0; i < blocks.size(); i++) {
                                    Rectangle r = blocks.get(i);
                                    r.x -= 10;
                                    if (r.x + r.width < 0) {
                                        blocks.remove(i);
                                        i--;
                                        addBlockers();
                                    }
                            }
                    }
                    this.repaint();
            }
    }
    
    @Override
    public void paint(Graphics g) {

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, C_WIDTH, C_HEIGHT);
        
            g.setColor(Color.ORANGE);
            g.fillRect(0, 560, C_WIDTH, 40);
            
            g.setColor(Color.GREEN.brighter());
            g.fillRect(0, 540, C_WIDTH, 20);
            
            if (gameStart) {
                    g.drawImage(mario, mario_x, mario_y, this);
                    
                    for (Rectangle rect : blocks) {
                            g.setColor(Color.GREEN.darker().darker());
                            g.fillRect(rect.x, rect.y, rect.width, rect.height);
                    }
                    
                    for (Rectangle rect : cloudBlocks) {
                            g.setColor(Color.black.brighter());
                            g.fillRect(rect.x, rect.y, rect.width, rect.height);
                    }
                    
                    if (toadPlay) {
                            g.drawImage(toad, toad_x, toad_y, this);
                    }
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!gameStart) {
                gameStart = true;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                case KeyEvent.VK_SPACE : 
                    mario_y -= 10; 
                    cntr = 0;
                    break;
                case KeyEvent.VK_LEFT : 
                    mario_x -= 10; 
                    break;
                case KeyEvent.VK_RIGHT : 
                    mario_x += 10; 
                    break;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
