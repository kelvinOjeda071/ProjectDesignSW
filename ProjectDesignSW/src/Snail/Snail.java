package Snail;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Snail.Input.Keyboard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Snail extends GameElement {

    private final ImageIcon imagen;
    public int speedX;
    public int speedY;
    private int tipo;

    public Snail(Position posicion, int height, int width) {
        super(posicion, height, width, 0);
        ///super.position.x = 1;
        //super.position.y = 1;
        //this.position.y = 1;
        //this.position.x = 1;
        //this.speedX = 2;
        this.imagen = new ImageIcon(getClass().getResource("/SnailImagenes/caracol.png"));
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    @Override
    public void draw(Graphics grafico, int width, int height) {
        height = this.height;
        width = this.width;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        Graphics2D g2d = (Graphics2D) grafico;
        g2d.setColor(Color.red);
        g2d.drawImage(this.imagen.getImage(), posicionX, posicionY, width, height, null);

    }

    public void girar() {

    }


    @Override
    public void move() {

        int x0 = this.position.getX();
        int y0 = this.position.getY();

        if ((0 < y0) && (y0 < 800)) {
            this.position.setY(y0 + this.speedY);
        }

        if ((x0 >= 0) && (x0 <= 1200)) {
            if (Keyboard.RIGHT) {

                this.position.setX(x0 + this.speedX);
            }
            //this.position.setX(x0+2);
        }

        if ((x0 >= 0) && (x0 <= 1200)) {
            if (Keyboard.LEFT) {
                //girar();
                this.position.setX(x0 - this.speedX);
            }
        }

    }

}
