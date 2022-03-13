/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Snail;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Star extends GameElement {

    private final ImageIcon image;
    private final ImageIcon image2;
    private int typeStar;

    public Star(Position position, int height, int width, int typeStar) {
        super(position, height, width, 6);
        this.typeStar = typeStar;
        this.image = new ImageIcon(getClass().getResource("/SnailImages/star.png"));
        this.image2 = new ImageIcon(getClass().getResource("/SnailImages/star2.png"));
    }

    @Override
    public void draw(Graphics grafic, int width, int height) {
        height = this.height;
        width = this.width;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        grafic.setColor(Color.yellow);

        if (typeStar == 0) {
            grafic.setColor(Color.yellow);
            grafic.drawImage(this.image.getImage(), posicionX, posicionY, width, height, null);
        }

        if (typeStar == 1) {
            grafic.setColor(Color.yellow);
            grafic.drawImage(this.image2.getImage(), posicionX, posicionY, width, height, null);
        }

    }

    @Override
    public void move() {

    }

    public int confirmRecollection(Snail snail, int score) {

        if (snail.typeSnail == this.typeStar) {
            int posYSnail = snail.position.y;
            int posXSnail = snail.position.x;
            int heightSnail = snail.height;
            int widthSnail = snail.width;
            int speedSnailX = snail.speedX;
            int speedSnailY = snail.speedY;

            int posYStar = this.position.y;
            int posXStar = this.position.x;
            int heightStar = this.height;
            int widthStar = this.width;

            if ((posXSnail + widthSnail > posXStar)
                    && (posXSnail < posXStar + widthStar)
                    && (posYSnail + heightSnail + speedSnailY > posYStar)
                    && (posYSnail + speedSnailY < posYStar + heightStar)) {
                //this.snail.setPosicionX(posXEnemy - widthSnail );

                score = score + 1;
                this.setHeight(0);
                this.setWidth(0);
                this.setPosicionY(-1);
                this.setPosicionX(-1);
                //System.out.println("ENTRO PRIMER IF STAR " + score);
            } else {
                if ((posXSnail + widthSnail + speedSnailX > posXStar)
                        && (posXSnail + speedSnailX < posXStar + widthStar)
                        && (posYSnail + heightSnail > posYStar)
                        && (posYSnail < posYStar + heightStar)) {
                    //snail.setPosicionY(posYEnemy - heightSnail );
                    //snail.setSpeedX(speedSnailY=0);

                    score = score + 1;
                    this.setHeight(0);
                    this.setWidth(0);
                    this.setPosicionY(-1);
                    this.setPosicionX(-1);
                    //System.out.println("ENTRO SEGUNDO IF STAR " + score);
                } else {
                    //System.out.println("NO ENTRO A NINGUN IF");

                }
            }
            return score;
        }
        return score;

    }

}
