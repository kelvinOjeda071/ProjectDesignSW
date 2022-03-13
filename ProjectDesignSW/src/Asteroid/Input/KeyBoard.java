/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author KelvinOjeda
 */
public class KeyBoard implements KeyListener{
    /* Attributes */
    private boolean[] keys = new boolean[256];
    public static boolean UP1, LEFT1, RIGHT1;
    public static boolean SHOOT1;
    public static boolean UP2, LEFT2, RIGHT2;
    public static boolean SHOOT2;
    
    /* Keyboard constructor */
    public KeyBoard(){
        UP1=LEFT1=RIGHT1=SHOOT1=false;
        UP2=LEFT2=RIGHT2=SHOOT2=false;
        
    }
    
    /* Methods */
    /* Updates the scenario */
    public void update(){
        UP2=keys[KeyEvent.VK_UP];            // UP1 key code
        LEFT2=keys[KeyEvent.VK_LEFT];        // LEFT1 key code
        RIGHT2=keys[KeyEvent.VK_RIGHT];      // RIGHT1 key code
        SHOOT2 = keys[KeyEvent.VK_DOWN];        // SHOOTING key code
        UP1=keys[KeyEvent.VK_W];            // UP1 key code
        LEFT1=keys[KeyEvent.VK_A];          // LEFT1 key code
        RIGHT1=keys[KeyEvent.VK_D];         // RIGHT1 key code
        SHOOT1 = keys[KeyEvent.VK_S];        // SHOOTING key code
        
        
    }

    /* Key is pressed */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }
    
    /* Key is released if not pressed */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
    
    /* Key type event */
    @Override
    public void keyTyped(KeyEvent e){}
    
}
