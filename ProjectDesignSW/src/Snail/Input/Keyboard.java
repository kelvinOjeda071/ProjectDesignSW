package Snail.Input;


import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Keyboard implements KeyListener {
    private boolean[] keys = new boolean[256];
    public static boolean LEFT, RIGHT;
    
    /* Keyboard constructor */
    public Keyboard(){
        LEFT =  false;
        RIGHT = false;
        
    }
    
    /* Methods */
    /* Updates the scenario */
    public void update(){
        LEFT = keys[KeyEvent.VK_LEFT];        // LEFT key code
        RIGHT = keys[KeyEvent.VK_RIGHT];      // RIGHT key code
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
