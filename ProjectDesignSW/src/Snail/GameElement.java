package Snail;


import java.awt.Graphics;
import java.awt.event.KeyEvent;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public abstract class GameElement{

    Position position;
    int width;
    int height;
    int typeObject;

    public GameElement(Position position, int height, int width, int type) {
        this.position = position;
        this.width = height;
        this.height = width;
        this.typeObject = type;
    }

    public void setPosicionX(int x) {
        this.position.setX(x);
    }
    
    public void setPosicionY(int y) {
        this.position.setY(y);
    }
    
    
    public int getWidth() {
        return width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public Position getPosition() {
        return position;
    }


    public abstract void draw(Graphics graphics,int width, int height);

    public abstract void move();
   
}
