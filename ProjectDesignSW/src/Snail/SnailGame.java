package Snail;

import Asteroid.IO.JSONParser;
import Login.User;
import Snail.Input.Keyboard;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
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
    private int score;
    private int contDie;
    private Player player;
    private StartMenu startMenu;
    private boolean mode;
    private int numPlayer = 0;

    public SnailGame() {
        setSize(1200, 800);
        this.setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setTitle("Snail");

        this.setVisible(state);

        ArrayList<User> dataList = readData();
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getCurrentActive() == 1) {
                numPlayer++;
            }
        }

        if (numPlayer == 1) {
            this.mode = true;
        }

        if (numPlayer == 2) {
            this.mode = false;
        }
    }

    @Override
    public void run() {

        this.keyboard = new Keyboard();

        level = new GameLevel(this, mode);

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
            score = level.checkRecollection(score);
            contDie = level.checkDie(contDie);
            if (mode == false) {
                if (contDie == 2) {
                    state = false;
                }
            }

            if (mode == true) {
                if (contDie == 1) {
                    state = false;
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SnailGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            endGame(this.state);

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
            startMenu = new StartMenu();
            //int punctuation = (int) ((tf - t0) / 1000);
            JOptionPane.showMessageDialog(null, "Your score is " + score, "GAME OVER", 1);
            //player.updateScore(score);
            this.setVisible(false);
            //startMenu.setVisible(true);
            //boolean isFound= false;
            // Save the new Score for the User Login
            try {
                ArrayList<User> dataList = JSONParser.readField();
                int z = 0;
                for (int j = 0; j < dataList.size(); j++) {
                    if (dataList.get(j).getCurrentActive() == 1) {
                        if (dataList.get(j).getSnailGameScore()
                                < score) {
                            dataList.get(j).setSnailGameScore(score);
                            dataList.get(j).setDate(setDateNow());
                            writeData(dataList);
                        }
                    }

                }

            } catch (IOException ex) {
                Logger.getLogger(SnailGame.class.getName()).log(Level.SEVERE, null, ex);
            }

            startMenu.setVisible(true);

        }
    }

    public void start() {

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
        startMenu = new StartMenu();
        startMenu.setVisible(true);

    }

    private ArrayList<User> readData() {
        try {
            return JSONParser.readField();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    private boolean writeData(ArrayList<User> dataList) {
        boolean isWrited = false;
        try {
            JSONParser.writeFile(dataList);
            isWrited = true;

        } catch (IOException ex) {
            System.out.println(ex);
            isWrited = false;
        }
        return isWrited;
    }

    private String setDateNow() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }

}
