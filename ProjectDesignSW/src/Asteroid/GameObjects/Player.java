/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.GameObjects;

import Asteroid.Graphics.Asset;
import Asteroid.Input.KeyBoard;
import Asteroid.Main.AsteroidGame;
import Asteroid.Math.Vector2D;
import Asteroid.State.GameModeState;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author KelvinOjeda
 */
public abstract class Player extends MovingObject {


    /* Delta Time fixing */
    protected Chronometer fireRate;
    /*Determine the period of time in which the player will be spawning */
    protected boolean spawning;
    //know when to draw or not to draw the ship
    protected boolean visible;
    //control the change between visible and not visible
    protected Chronometer spawnTime, flickerTime;

    protected boolean accelerating = false;

    /* Constructor */
    public Player(
            Vector2D position,
            Vector2D velocity,
            double maxVelocity,
            BufferedImage texture,
            GameModeState gameState,
            Chronometer fireRate,
            Chronometer spawnTime,
            Chronometer flikerTime
    ) {
        /* Parent attributes */
        super(position, velocity, maxVelocity, texture, gameState);

        /* Sets the object attributes */
        this.fireRate = fireRate;
        this.spawnTime = spawnTime;
        this.flickerTime = flikerTime;
    }

    /*Cuando se destruya reaparezca pero titilando*/
    @Override
    public void draw(Graphics g) {
        //In the case when visible is false
        if (!visible) {
            return;
        }
        /* Sets the graphics object */
        Graphics2D g2d = (Graphics2D) g;

        /* Effects */
        AffineTransform at1 = AffineTransform.getTranslateInstance(
                position.getX() + width / 2 + 5,
                position.getY() + height / 2 + 10
        );

        AffineTransform at2 = AffineTransform.getTranslateInstance(
                position.getX() + 5,
                position.getY() + height / 2 + 10
        );

        at1.rotate(angle, -5, -10);
        at2.rotate(angle, width / 2 - 5, -10);

        if (accelerating == true) {
            g2d.drawImage(Asset.speed, at1, null);
            g2d.drawImage(Asset.speed, at2, null);
        }

        at = AffineTransform.getTranslateInstance(
                position.getX(), position.getY()
        );

        /* Allows the center rotation of the ship */
        at.rotate(angle, width / 2, height / 2);
        g2d.drawImage(texture, at, null);
    }

    // Reset ship position values
    protected abstract void resetValues();

    // Posibility to start shooting
    public boolean isSpawning() {
        return spawning;
    }

}
