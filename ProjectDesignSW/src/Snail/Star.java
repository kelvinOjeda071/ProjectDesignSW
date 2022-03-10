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

    public Star(Position position, int height, int width) {
        super(position, height, width, 6);
        this.image = new ImageIcon(getClass().getResource("/SnailImages/star.png"));
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

    }

}
