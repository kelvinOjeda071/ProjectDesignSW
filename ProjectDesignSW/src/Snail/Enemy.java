package Snail;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
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
public class Enemy extends GameElement {

    private final ImageIcon image;
    int Y0move;

    public Enemy(Position position, int height, int width) {
        super(position, height, width, 4);
        this.image = new ImageIcon(getClass().getResource("/SnailImages/spider.png"));
        Y0move = position.getY();
    }

    @Override
    public void draw(Graphics grafic, int width, int height) {
        height = this.height;
        width = this.width;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        grafic.setColor(Color.yellow);
        grafic.drawImage(this.image.getImage(), posicionX, posicionY, width, height, null);
    }

    @Override
    public void move() {

        int x0 = this.position.getX();
        int y0 = this.position.getY();

        if ((y0 >= Y0move) && (y0 < Y0move + 200)) {
            this.position.setY(y0 + 1);
        }
        if (y0 == Y0move + 200) {
            this.position.setY(Y0move);

        }
    }

    public int attackSnail(Snail snail, int contDie) {
        //int contDie = 0;
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
            contDie = contDie + 1;
            snail.setHeight(0);
            snail.setWidth(0);
            snail.setPosicionX(-10);
            snail.setPosicionY(-10);

            //return contDie;
        } else {
            if ((posXSnail + widthSnail + speedSnailX > posXEnemy)
                    && (posXSnail + speedSnailX < posXEnemy + widthEnemy)
                    && (posYSnail + heightSnail > posYEnemy)
                    && (posYSnail < posYEnemy + heightEnemy)) {
                //snail.setPosicionY(posYEnemy - heightSnail );
                //snail.setSpeedX(speedSnailY=0);
                //System.out.println("ENTRO SEGUNDO IF");
                contDie = contDie + 1;
                snail.setHeight(0);
                snail.setWidth(0);
                snail.setPosicionX(-10);
                snail.setPosicionY(-10);
                // return contDie;
            } else {
                //System.out.println("NO ENTRO A NINGUN IF");
                //return contDie;
            }

        }
        return contDie;
    }

}
