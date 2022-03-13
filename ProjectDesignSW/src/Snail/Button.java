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
public class Button extends GameElement {

    private Obstacle obstacle;
    private final ImageIcon image;

    public Button(Position position, int height, int width, Obstacle obstacle) {
        super(position, height, width, 2);
        this.obstacle = obstacle;
        this.image = new ImageIcon(getClass().getResource("/SnailImages/button.png"));
    }

    public void activate(Snail snail) {
        int posYSnail = snail.position.y;
        int posXSnail = snail.position.x;
        int heightSnail = snail.height;
        int widthSnail = snail.width;
        int speedSnailX = snail.speedX;
        int speedSnailY = snail.speedY;

        int posYEnemy = this.position.y;
        int posXEnemy = this.position.x;
        int heightEnemy = this.height;
        int widthEnemy = this.width;

        if ((posXSnail + widthSnail > posXEnemy)
                && (posXSnail < posXEnemy + widthEnemy)
                && (posYSnail + heightSnail + speedSnailY > posYEnemy)
                && (posYSnail + speedSnailY < posYEnemy + heightEnemy)) {
            //this.snail.setPosicionX(posXEnemy - widthSnail );
            //System.out.println("ENTRO PRIMER IF");
            this.obstacle.open();
        } else {
            if ((posXSnail + widthSnail + speedSnailX > posXEnemy)
                    && (posXSnail + speedSnailX < posXEnemy + widthEnemy)
                    && (posYSnail + heightSnail > posYEnemy)
                    && (posYSnail < posYEnemy + heightEnemy)) {
                //snail.setPosicionY(posYEnemy - heightSnail );
                //snail.setSpeedX(speedSnailY=0);
                //System.out.println("ENTRO SEGUNDO IF");
                this.obstacle.open();
            } else {
                //System.out.println("NO ENTRO A NINGUN IF");
            }

        }

    }

    @Override
    public void draw(Graphics grafic, int width, int height) {
        height = this.height;
        width = this.width;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        height = this.height;
        width = this.width;
        grafic.setColor(Color.yellow);
        grafic.drawImage(this.image.getImage(), posicionX, posicionY, width, height, null);
    }

    public void move() {

    }

}
