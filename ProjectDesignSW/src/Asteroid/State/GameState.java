/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.State;

import java.awt.Graphics;

/**
 *
 * @author HOME
 */
public abstract class GameState {

    /**
     * actual state of play
     */
    private static GameState currentState = null;

    public static void changeState(GameState newState) {
        currentState = newState;
    }

    public static GameState getCurrentState() {
        return currentState;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

}
