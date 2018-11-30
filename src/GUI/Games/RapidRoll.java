/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Games;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author mankank
 */

class _GameStart {
        public static void main(String[] args) {
                RapidRoll rapidroll = new RapidRoll();
        }
}

public class RapidRoll extends JFrame implements ActionListener, MouseListener, KeyListener {
    
    ArrayList<Rectangle> steps;
    Rectangle ball;
    Random rand;
    Timer t;
    
    //constants
    private static final String GAME_TITLE = "Rapid roll";
    private static final String SCORE_BOARD = "Score : ";
    private static final String CHANCES_LEFT = "Chances left : ";
    private final boolean TRUE = true;
    private final int C_WIDTH = 400;
    private final int C_HEIGHT = 400;
    
    
    private boolean gameStart;
    private boolean gameEnd;
    
    public RapidRoll() {
            initializeComponents();
            buildJFrame();
            addListeners();
            addComponents();
    }
    
    private void initializeComponents() {
            this.steps = new ArrayList<>();
            this.rand = new Random();
            this.ball = new Rectangle(50, 50, 10, 10);
            this.t = new Timer(100, this);
            t.start();
    }
    
    private void addComponents() {
            //this.add(startButton);
    }
    
    private void addListeners() {
            //this.startButton.addMouseListener(this);
            this.addMouseListener(this);
            this.addKeyListener(this);            
    }
    
    private void buildJFrame() {
            this.setVisible(TRUE);
            this.setResizable(TRUE);
            this.setSize(C_WIDTH, C_HEIGHT);
            this.setTitle(GAME_TITLE);
            this.setLayout(new FlowLayout());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private int getRandom() {
            return 20 + rand.nextInt(90);
    }  
    
    private void initializeSteps() {
            int r = getRandom();
            Rectangle r1 = new Rectangle(20, C_HEIGHT / 2 - 20, r, 20);
            Rectangle r2 = new Rectangle(280, C_HEIGHT - 40, r, 20);
            steps.add(r1);
            steps.add(r2);
    }
    
    private void addLeftStep() {
            int r = getRandom();
            Rectangle ls = new Rectangle(20, C_HEIGHT, r, 20);
            steps.add(ls);
    }
    
    private void addRightStep() {
            int r = getRandom();
            Rectangle rs = new Rectangle(280, C_HEIGHT, r, 20);
            steps.add(rs);
    }
    
    int l = 0, chances = 3, score = 0;
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (gameStart) {
                
                    if (ball.y < 10 || ball.y > C_HEIGHT || ball.x < 0 || ball.x > C_WIDTH) {
                            chances--;
                            ball.x = 50; ball.y = 50;
                    }
                    
                    if (chances == 0) {
                            gameStart = false;
                            gameEnd = true;
                    }
                
                    boolean ol = false;
                    for (Rectangle rect : steps) {
                            if (rect.intersects(ball)) {
                                    ball.y = rect.y - 15;
                                    ol = true;
                            }
                    }
                    
                    if (!ol) {
                            ball.y += 4;
                    }
                    
                    if (steps.isEmpty()) {
                        initializeSteps();
                    }
                    
                    for (Rectangle rect : steps) {
                            rect.y -= 5;
                    }
                    
                    for (int i = 0; i < steps.size(); i++) {
                            Rectangle rect = steps.get(i);
                            if (rect.y < 0) {
                                    if (l % 2 == 0) {
                                            addLeftStep();
                                    } else {
                                            addRightStep();
                                    }
                                    score++;
                                    l++;
                                    steps.remove(rect);
                                    i--;
                            }
                    }
                    this.repaint();
            }
    }
    
    @Override
    public void paint(Graphics g) {
            g.setColor(Color.BLUE.darker());
            g.fillRect(0, 0, C_WIDTH, C_HEIGHT);
            
            g.setColor(Color.RED.darker());
            g.fillRect(ball.x, ball.y, ball.width, ball.height);
            
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", 1, 15));
            g.drawString(SCORE_BOARD + score, 280, 40);
            g.drawString(CHANCES_LEFT + chances, 280, 60);
            
            if (gameEnd) {
                    g.setFont(new Font("Arial", 1, 30));
                    g.drawString("Game Over", 120, 200);
                    g.drawString("Your final score : " + score, 80, 240);
            }
            
            for (Rectangle rect : steps) {
                    g.setColor(Color.GREEN.brighter());
                    g.fillRect(rect.x, rect.y, rect.width, rect.height);
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if (!this.gameStart) {
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
        int keycode = e.getKeyCode();
        switch(keycode) {
            case KeyEvent.VK_LEFT : ball.x -= 10;
                break;
            case KeyEvent.VK_RIGHT : ball.x += 10;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
