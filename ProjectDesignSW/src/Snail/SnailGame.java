package Snail;

import Snail.Input.Keyboard;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.IOException;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class SnailGame extends JFrame implements Runnable {

    private boolean state = false;
    private Thread thread;
    private Keyboard keyboard;
    private GameLevel level;

    public SnailGame() {
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setTitle("Snail");
        level = new GameLevel(this);
        this.setVisible(state);
    }

    @Override
    public void run() {

        this.keyboard = new Keyboard();

        level.generateObjects(this);

        level.scene.addKeyListener(keyboard);
        state = true;
        this.add(level.getScene());
        this.setSize(1200, 700);
        this.setVisible(state);
        this.setLocation(100, 25);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (state) {

            refresh();
            state = level.checkInteractions();
    
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SnailGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            checkState();

        }
        stop();
    }

    public void refresh() {
        this.level.getScene().update();
        keyboard.update();
        this.repaint();

    }

    public void endGame(boolean state) {
        if (state == false) {
            //int punctuation = (int) ((tf - t0) / 1000);
            JOptionPane.showMessageDialog(null, "Tu puntuación: "  + "\nTIEMPO FINAL: "
                    + "\nTIEMPO INICIAL: "  , "GAME OVER", 1);

            exitMenu();
        }
    }

    public void checkState() {
        endGame(this.state);
    }

    public void exitMenu() {
        this.setVisible(false);

    }

    private void start() {
        thread = new Thread(this);
        thread.start();
        state = true;

    }

    private void stop() {
        try {
            thread.join();
            state = false;
        } catch (InterruptedException e) {
            /* Prints the error */
            e.printStackTrace();
        }
    }

    public void showWindow() {

        new SnailGame().start();

    }

}