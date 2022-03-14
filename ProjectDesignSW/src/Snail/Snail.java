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
import java.awt.geom.AffineTransform;

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

    public int typeSnail;
    private final ImageIcon image;
    private final ImageIcon image2;
    public int speedX;
    public int speedY;
    //public boolean orientation;

    public Snail(Position position, int height, int width, int type) {
        super(position, height, width, 0);
        ///super.position.x = 1;
        //super.position.y = 1;
        //this.position.y = 1;
        //this.position.x = 1;
        this.typeSnail = type;
        //this.orientation = true;
        this.image = new ImageIcon(getClass().getResource("/SnailImages/snail.png"));
        this.image2 = new ImageIcon(getClass().getResource("/SnailImages/snail2.png"));
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    
    @Override
    public void draw(Graphics graphics, int width, int height) {
        height = this.height;
        width = this.width;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        Graphics2D g2d = (Graphics2D) graphics;

        if (typeSnail == 0) {
            g2d.setColor(Color.red);
            g2d.drawImage(this.image.getImage(), posicionX, posicionY, width, height, null);
           
        }
        
        if (typeSnail == 1) {
            g2d.setColor(Color.red);
            g2d.drawImage(this.image2.getImage(), posicionX, posicionY, width, height, null);
            
        }

    }

    @Override
    public void move() {

        if (typeSnail == 0) {
            int x0 = this.position.getX();
            int y0 = this.position.getY();

            if ((0 < y0) && (y0 < 800)) {
                this.position.setY(y0 + this.speedY);
            }

            if ((x0 >= 0) && (x0 <= 1200)) {
                if (Keyboard.RIGHT) {

                    this.position.setX(x0 + this.speedX);
                    //this.orientation = false;
                    
                }
                //this.position.setX(x0+2);
            }

            if ((x0 >= 0) && (x0 <= 1200)) {
                if (Keyboard.LEFT) {
                    //girar();
                    this.position.setX(x0 - this.speedX);
                    //this.orientation = false;
                    
                }
            }

            if (x0 < 0) {
                this.position.setX(0);
            }

        }

        if (typeSnail == 1) {
            int x0 = this.position.getX();
            int y0 = this.position.getY();

            if ((0 < y0) && (y0 < 800)) {
                this.position.setY(y0 + this.speedY);
                
            }

            if ((x0 >= 0) && (x0 <= 1200)) {
                if (Keyboard.D) {

                    this.position.setX(x0 + this.speedX);
                    
                }
                //this.position.setX(x0+2);
            }

            if ((x0 >= 0) && (x0 <= 1200)) {
                if (Keyboard.A) {
                    //girar();
                    this.position.setX(x0 - this.speedX);
                    
                }
            }
            if (x0 < 0) {
                this.position.setX(0);
            }
        }

    }

}
