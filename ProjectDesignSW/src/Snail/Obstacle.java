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
    private final ImageIcon image1;
    private final ImageIcon image2;
    private final ImageIcon image3;

    public Obstacle(int typeObstacle, Position position, int height, int width) {
        super(position, height, width, 1);
        this.typeObstacle = typeObstacle;
        this.image1 = new ImageIcon(getClass().getResource("/SnailImages/platform.png"));
        this.image2 = new ImageIcon(getClass().getResource("/SnailImages/box.png"));
        this.image3 = new ImageIcon(getClass().getResource("/SnailImages/wall.png"));
    }

    @Override
    public void draw(Graphics graphics, int height, int width) {

        height = this.height;
        width = this.width;
        int positionX = this.position.getX();
        int positionY = this.position.getY();
        height = this.height;
        width = this.width;

        graphics.setColor(Color.red);

        if (typeObstacle == 0) { //Plataforma
            graphics.setColor(Color.black);
            graphics.drawImage(this.image1.getImage(), positionX, positionY, width, height, null);
            //grafico.fillRect(posicionX, posicionY, width, height);

        }

        if (typeObstacle == 2) { //Caja
            graphics.setColor(Color.black);
            graphics.drawImage(this.image2.getImage(), positionX, positionY, width, height, null);

        }
        
        if (typeObstacle == 1) {//Muro
            graphics.setColor(Color.black);
            graphics.drawImage(this.image3.getImage(), positionX, positionY, width, height, null);
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
