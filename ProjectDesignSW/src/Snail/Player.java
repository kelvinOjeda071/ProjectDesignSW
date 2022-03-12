package Snail;

import Login.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Player {
    private String name;
    private int score;
    private User user;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public void updateScore(int newScore){
        this.score = newScore;
        user.setSnailGameScore(newScore);
        
    }
    
}
