/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tetris.State;

import Asteroid.GameObjects.Player;
import Asteroid.IO.JSONParser;
import Asteroid.State.GameState;
import Asteroid.State.MenuState;
import Login.User;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KelvinOjeda
 */
public class TetrisScoreState {

    private PriorityQueue<User> highScores;
    private Comparator<User> scoreComparator;
    

    public TetrisScoreState() {

        scoreComparator = new Comparator<User>() {
            @Override
            public int compare(User userScore1, User userScore2) {
                return userScore1.getTetrisGameScore() < userScore2.getTetrisGameScore() ? -1
                        : userScore1.getTetrisGameScore() > userScore2.getTetrisGameScore() ? 1
                        : 0;
            }
        };

        highScores = new PriorityQueue<User>(10, scoreComparator);

        try {
            ArrayList<User> dataList = JSONParser.readField();
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).getTetrisGameScore() != 0) {
                    highScores.add(dataList.get(i));
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void updateScore(int score) {
        int i = 0;
        // Save the new Score for the User Login

        ArrayList<User> dataList = readData();
        for (int j = 0; j < dataList.size(); j++) {
            if (dataList.get(j).getCurrentActive() == 1) {
                if (dataList.get(j).getTetrisGameScore()
                        < score) {
                    dataList.get(j).setTetrisGameScore(score);
                    dataList.get(i).setDate(setDateNow());
                    writeData(dataList);
                }
            }

        }
    }
    
    public ArrayList<User> readData() {
        try {
            return JSONParser.readField();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public boolean writeData(ArrayList<User> dataList) {
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

    public String setDateNow() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }

}
