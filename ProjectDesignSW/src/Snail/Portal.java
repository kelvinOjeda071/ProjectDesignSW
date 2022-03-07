package Snail;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
public class Portal extends GameElement {

    private int tipo;
    private Snail snail;
    private final ImageIcon imagen;

    public Portal(Position posicion, int ancho, int largo) {
        super(posicion, ancho, largo, 5);
        this.imagen = new ImageIcon(getClass().getResource("/SnailImagenes/portal.png"));

    }

    @Override
    public void draw(Graphics grafico, int ancho, int largo) {
        height = this.height;
        width = this.width;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        Graphics2D g2d = (Graphics2D) grafico;
        g2d.setColor(Color.red);
        g2d.drawImage(this.imagen.getImage(), posicionX, posicionY, width, height, null);
    }

    public void move() {
        
    }

    public boolean notifyEnd(Snail snail) {

        int posYSnail = snail.position.y;
        int posXSnail = snail.position.x;
        int heightSnail = snail.height;
        int widthSnail = snail.width;
        int speedSnailX = snail.speedX;
        int speedSnailY = snail.speedY;

        int posYPortal = this.position.y;
        int posXPortal = this.position.x;
        int heightPortal = this.height;
        int widthPortal = this.width;

        if ((posXSnail + widthSnail > posXPortal)
                && (posXSnail < posXPortal + widthPortal)
                && (posYSnail + heightSnail + speedSnailY > posYPortal)
                && (posYSnail + speedSnailY < posYPortal + heightPortal)) {
            //this.snail.setPosicionX(posXPortal - widthSnail );
            //System.out.println("ENTRO PRIMER IF");
            return false;
        } else {
            if ((posXSnail + widthSnail + speedSnailX > posXPortal)
                    && (posXSnail + speedSnailX < posXPortal + widthPortal)
                    && (posYSnail + heightSnail > posYPortal)
                    && (posYSnail < posYPortal + heightPortal)) {
                //snail.setPosicionY(posYPortal - heightSnail );
                //snail.setSpeedX(speedSnailY=0);
                //System.out.println("ENTRO SEGUNDO IF");
                return false;
            } else {
                //System.out.println("NO ENTRO A NINGUN IF");
                return true;
            }

        }

    }

}
