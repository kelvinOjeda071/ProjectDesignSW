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
    int tipo;

    public GameElement(Position posicion, int height, int width, int tipo) {
        this.position = posicion;
        this.width = height;
        this.height = width;
        this.tipo = tipo;
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


    public abstract void draw(Graphics grafico,int ancho, int largo);

    public abstract void move();
   
}
