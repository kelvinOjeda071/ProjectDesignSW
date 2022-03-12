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
    public static boolean UP, LEFT, RIGHT;
    public static boolean SHOOT;
    public static boolean UP1, LEFT1, RIGHT1;
    public static boolean SHOOT1;
    
    /* Keyboard constructor */
    public KeyBoard(){
        UP=LEFT=RIGHT=SHOOT=false;
        UP1=LEFT1=RIGHT1=SHOOT1=false;
        
    }
    
    /* Methods */
    /* Updates the scenario */
    public void update(){
        UP=keys[KeyEvent.VK_UP];            // UP key code
        LEFT=keys[KeyEvent.VK_LEFT];        // LEFT key code
        RIGHT=keys[KeyEvent.VK_RIGHT];      // RIGHT key code
        SHOOT = keys[KeyEvent.VK_P];        // SHOOTING key code
        UP1=keys[KeyEvent.VK_W];            // UP key code
        LEFT1=keys[KeyEvent.VK_A];          // LEFT key code
        RIGHT1=keys[KeyEvent.VK_D];         // RIGHT key code
        SHOOT1 = keys[KeyEvent.VK_Q];        // SHOOTING key code
        
        
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
