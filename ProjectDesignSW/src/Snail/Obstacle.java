package Snail;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Obstacle extends GameElement {
    private int typeObstacle;
    private final ImageIcon image;

    public Obstacle(int tipoObstaculo, Position posicion, int height, int width) {
        super(posicion, height, width, 1);
        this.typeObstacle = tipoObstaculo;
        this.image = new ImageIcon(getClass().getResource("/SnailImagenes/plataforma.png"));
    }

    

    @Override
    public void draw(Graphics graphics, int height, int width) {
        
        height = this.height;
        width = this.width;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        height = this.height;
        width = this.width;
        
        graphics.setColor(Color.red);
        
        
        if(typeObstacle == 0){ //Plataforma
            graphics.setColor(Color.black);
            graphics.drawImage(this.image.getImage(), posicionX, posicionY, width, height, null);
            //grafico.fillRect(posicionX, posicionY, width, height);
            
            
        }
        
        if(typeObstacle == 1){ //Cajas
            graphics.setColor(Color.red);
            graphics.fillRect(posicionX, posicionY, width, height);
        }
    }

    @Override
    public void move() {
        //System.out.print("Moviendo\n");
    }

 public void open() {
        if (this.typeObstacle == 1) {
            this.setHeight(0);
            this.setWidth(0);
            this.setPosicionY(-1);
            this.setPosicionX(-1);
        }
    }

   

    
    
    
}
