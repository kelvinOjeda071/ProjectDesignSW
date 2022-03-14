/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Snail;

import Asteroid.IO.JSONParser;
import Login.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class ScoreManager extends JPanel {

    private PriorityQueue<User> highScores;
    private Comparator<User> scoreComparator;
    private User[] auxArrayScoreDataUser;
    //private Position position;

    public ScoreManager() {

        scoreComparator = new Comparator<User>() {
            @Override
            public int compare(User userScore1, User userScore2) {
                return userScore1.getSnailGameScore() < userScore2.getSnailGameScore() ? -1
                        : userScore1.getSnailGameScore() > userScore2.getSnailGameScore() ? 1
                        : 0;
            }
        };

        highScores = new PriorityQueue<User>(10, scoreComparator);

        try {
            ArrayList<User> dataList = JSONParser.readField();
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).getSnailGameScore() != 0) {
                    highScores.add(dataList.get(i));
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void drawText(Graphics g, String string, Position position,
        boolean center, Color color, Font font) {
        g.setColor(color);
        g.setFont(font);
        position = new Position(position.getX(), position.getY());
        if (center) {
            //Take the dimensions of the text
            FontMetrics fm = g.getFontMetrics();
            position.setX(position.getX() - fm.stringWidth(string) / 2);
            position.setY(position.getY() - fm.getHeight() / 2);
        }
        g.drawString(string, (int) position.getX(), (int) position.getY());
    }

    public void paint(Graphics g) {
        //String data ="Nombre  " + " Apellido  " + " Puntaje  " + " Fecha";
        auxArrayScoreDataUser = highScores.toArray(new User[highScores.size()]);
        Arrays.sort(auxArrayScoreDataUser, scoreComparator);
        Font font = new Font("Arial", Font.BOLD, 24);

        Position positionName = new Position(200, 50);
        Position positionScore = new Position(400, 50);
        Position positionDate = new Position(600, 50);

        drawText(g, "NAME", positionName, true, Color.black, font);
        drawText(g, "SCORE", positionScore, true, Color.black, font);
        drawText(g, "DATE", positionDate, true, Color.black, font);

        positionName.setY(positionName.getY() + 50);
        positionScore.setY(positionScore.getY() + 50);
        positionDate.setY(positionDate.getY() + 50);

        for (int i = auxArrayScoreDataUser.length - 1; i > -1; i--) {
            User auxScoreDataUser = auxArrayScoreDataUser[i];

            drawText(g, auxScoreDataUser.getFirstName() + "  " + auxScoreDataUser.getLastName(),
                    positionName, true, Color.black, font);
            drawText(g, Integer.toString(auxScoreDataUser.getSnailGameScore()),
                    positionScore, true, Color.black, font);
            drawText(g, auxScoreDataUser.getDate(),
                    positionDate, true, Color.black, font);

            positionName.setY(positionName.getY() + 50);
            positionScore.setY(positionScore.getY() + 50);
            positionDate.setY(positionDate.getY() + 50);
        }

    }

}
