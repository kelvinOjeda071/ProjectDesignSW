/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.GameObjects;

import java.awt.Graphics;
import Asteroid.Math.Vector2D;
import Asteroid.State.ActionGameState;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jonathan Puglla
 */
public class Laser extends MovingObject {

    /* Attributes */
    Vector2D myHeading;
    int objectBelongType;

    /* Constructor */
    public Laser(
            Vector2D position,
            Vector2D velocity,
            double maxVelocity,
            double angle,
            BufferedImage texture,
            ActionGameState gameState,
            int objectBelongType
    ) {
        /* Parent attributes */
        super(position, velocity, maxVelocity, texture, gameState);

        /* Sets the attributes of the constructor */
        this.angle = angle;
        this.objectBelongType = objectBelongType;
        this.velocity = velocity.scale(maxVelocity);
    }

    /* Methods */
 /* Obtains the center of the Laser */
    @Override
    protected Vector2D getCenter() {
        /* Local attributes */
        double posX = position.getX() + width / 2;
        double posY = position.getY() + width / 2;

        /* Returns the center */
        return new Vector2D(posX, posY);
    }

    public int getObjectBelongType() {
        return objectBelongType;
    }

    public void setObjectBelongType(int objectBelongType) {
        this.objectBelongType = objectBelongType;
    }
    

    /* Update the position */
    @Override
    public void update() {
        /* Attributes */
        position = position.add(velocity);

        /* Deletes the laser */
        if (position.getX() < 0
                || position.getY() < 0
                || position.getX() > Constant.WIDTH
                || position.getY() > Constant.HEIGHT) {

            /* Removes the laser */
            destroy();
        }

        /* Detects a collition */
        collidesWith();
    }

    /* Draws the object */
    @Override
    public void draw(Graphics g) {
        /* Graphics attribute */
        Graphics2D g2d = (Graphics2D) g;

        /* Position transformation*/
        at = AffineTransform.getTranslateInstance(
                position.getX() - width / 2,
                position.getY()
        );

        /* Rotation */
        at.rotate(angle, width / 2, 0);

        /* Draws the texture */
        g2d.drawImage(texture, at, null);
    }
}
