/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.State;

import Asteroid.GameObjects.Constant;
import Asteroid.Graphics.Asset;
import Asteroid.Graphics.Text;
import Asteroid.IO.JSONParser;
import Asteroid.Math.Vector2D;
import Asteroid.UI.Action;
import Asteroid.UI.Button;
import Login.User;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KelvinOjeda
 */
public class ScoreState extends GameState {

    private Button returnButton;
    private PriorityQueue <User> highScores;
    private Comparator <User> scoreComparator;
    private User[] auxArrayScoreDataUser;
    
    public ScoreState() {
        returnButton = new Button(
                Asset.greyBtn, 
                Asset.blueBtn,
                Asset.greyBtn.getHeight(),
                Constant.HEIGHT - Asset.greyBtn.getHeight()*2, 
                Constant.RETURN, 
                new Action (){
                    @Override
                    public void doAction(){
                        GameState.changeState(new MenuState());
                    }
                }
        );
        scoreComparator = new Comparator<User>(){
            @Override
            public int compare(User userScore1, User userScore2) {
                return userScore1.getAsteroidGameScore() < userScore2.getAsteroidGameScore() ? -1 : 
                        userScore1.getAsteroidGameScore() > userScore2.getAsteroidGameScore() ? 1: 
                        0;
            }
        };
        
        highScores = new  PriorityQueue<User> (10, scoreComparator);
        
        
        try {
            ArrayList<User> dataList = JSONParser.readField();
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).getAsteroidGameScore() != 0) {
                    highScores.add(dataList.get(i));
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

       
                
        
    }

    
    @Override
    public void update() {
        returnButton.update();
    }

    @Override
    public void draw(Graphics g) {
        returnButton.draw(g);
        
        auxArrayScoreDataUser = highScores.toArray(new User[highScores.size()]);
        Arrays.sort(auxArrayScoreDataUser,scoreComparator);
        
        Vector2D namePos = new Vector2D(
                 Constant.WIDTH/2 - 250,
                50
        );
        
        Vector2D scorePos = new Vector2D(
                Constant.WIDTH/2,
                50 
        );
        Vector2D datePos = new Vector2D(
                Constant.WIDTH/2 + 250,
                50
        );
        Text.drawText(g,
                "NAME",
                namePos,
                true,
                Color.WHITE,
                Asset.fontMed);
        Text.drawText(g,
                Constant.SCORE,
                scorePos,
                true,
                Color.WHITE,
                Asset.fontMed);
        Text.drawText(g,
                Constant.DATE,
                datePos,
                true,
                Color.WHITE,
                Asset.fontMed);
        namePos.setY(namePos.getY() + 30);
        scorePos.setY(scorePos.getY() + 30);
        datePos.setY(datePos.getY() + 30);
        
        for ( int i = auxArrayScoreDataUser.length-1; i > -1; i-- ){
            User auxScoreDataUser = auxArrayScoreDataUser[i];
            Text.drawText(g,
                auxScoreDataUser.getFirstName() +" "+ auxScoreDataUser.getLastName(),
                namePos,
                true,
                Color.WHITE,
                Asset.fontMed);
            Text.drawText(g,
                Integer.toString( auxScoreDataUser.getAsteroidGameScore()),
                scorePos,
                true,
                Color.WHITE,
                Asset.fontMed);
            Text.drawText(g,
                auxScoreDataUser.getDate(),
                datePos,
                true,
                Color.WHITE,
                Asset.fontMed);
            namePos.setY(namePos.getY() + 25);
            scorePos.setY(scorePos.getY() + 25);
            datePos.setY(datePos.getY() + 25);
        }
    }
    
}
