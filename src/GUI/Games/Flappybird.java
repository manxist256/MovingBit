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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author mankank
 */

class Button implements MouseListener {
    
    Flappybird flappybirdgame;
    
    public Button(Flappybird flappybird) {
            this.flappybirdgame = flappybird;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if (!flappybirdgame.gameStart) {
                    flappybirdgame.startGame();
            }
            this.flappybirdgame.yColumn -= 5;
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
    
}

class Main {
        public static void main(String[] args) {
                Flappybird flappybird = new Flappybird();
        }
}

public class Flappybird extends JFrame implements ActionListener {
    
    private final String FLAPPY_BIRD_TITLE = "Flappy bird";
    private final String START_GAME_TEXT = "Start game";
    private final int C_WIDTH = 500;
    private final int C_HEIGHT = 500;
    
    private Timer timer;
    protected Rectangle bird;
    private JButton startButton;
    protected boolean gameStart = false;
    protected boolean gameFinish = false;
    private ArrayList<Rectangle> blockers;
    private Random random;
    
    private int score;
    
    public Flappybird() {
            initializeComponents();
            buildJFrame();
            addComponents();
            addListeners();
            initializeBlockers();
    }
    
    private void buildJFrame() {
            this.setVisible(true);
            this.setTitle(FLAPPY_BIRD_TITLE);
            this.setSize(C_WIDTH, C_HEIGHT);
            this.setResizable(true);
            this.setLayout(new FlowLayout());
            this.getContentPane().setBackground(Color.YELLOW.darker());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initializeComponents() {
            this.blockers = new ArrayList<>();
            this.bird = new Rectangle(20, 400, 10, 10);
            this.startButton = new JButton(START_GAME_TEXT);
            this.random = new Random();
            this.timer = new Timer(40, this);
            timer.start();
    }
    
    private void addListeners() {
            this.startButton.addMouseListener(new Button(this));
            this.addMouseListener(new Button(this));
    }
    
    private void addComponents() {
            this.add(startButton);
    }
    
    private void initializeBlockers() {
            int r = 100 + random.nextInt(100);
            Rectangle blocker1 = new Rectangle(C_WIDTH, 0, 100, r);
            Rectangle blocker2 = new Rectangle(C_WIDTH, (C_HEIGHT - 90) - r, 100, r);
            blockers.add(blocker1);
            blockers.add(blocker2);
    }
    
    int yColumn, ticks;
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (gameStart && !gameFinish) {
                    ticks++;
                    if (this.bird.y <= 400) {
                        if (ticks % 2 == 0 && yColumn < 20)
                                yColumn += 1;
                        bird.y += yColumn;
                    }
                    for (Rectangle rect : blockers) {
                            rect.x -= 4;
                            if (rect.intersects(bird)) {
                                    gameStart = false;
                                    gameFinish = true;
                                    bird.x -= 10;
                                    bird.y = 400;
                            }
                    }
                    int c = 0;
                    for (int i = 0; i < blockers.size(); i++) {
                            //System.out.println(sc);
                            Rectangle r = blockers.get(i);
                            if (r.x + r.width < 0) {
                                    blockers.remove(r);
                                    c++;
                                    i--;
                            }
                            if (c != 0 && c % 2 == 0) { //always c will be 2 to execute the if block.
                                initializeBlockers();
                                c = 0;
                                score++;
                            }
                    }
                    this.repaint();
            }
    }
    
    @Override
    public void paint(Graphics g) {
            g.setColor(Color.cyan);
            g.fillRect(0,0,C_WIDTH,C_HEIGHT);
            
            g.setColor(Color.ORANGE.darker());
            g.fillRect(0, C_HEIGHT - 70, C_WIDTH, 70);
            
            g.setColor(Color.GREEN.brighter().brighter());
            g.fillRect(0, C_HEIGHT - 90, C_WIDTH, 20);
        
            for (Rectangle rect : blockers) {
                    g.setColor(Color.GREEN.darker().darker());
                    g.fillRect(rect.x, rect.y, rect.width, rect.height);
            }
            
            g.setColor(Color.red);
            g.fillRect(bird.x, bird.y, bird.width, bird.height);
            
            if (gameStart) {
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial", 1, 20));
                    g.drawString("Score : " + score, C_WIDTH - 100, 50);
            }
            
            if (gameFinish) {
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial",1 , 20));
                    g.drawString("Game Over Final score: " + score, C_WIDTH - 370, 250);
            }
    }
    
    public void startGame() {
            this.gameStart = true;
    }
   
}
