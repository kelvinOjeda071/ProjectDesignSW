/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.GameObjects;

import Asteroid.Graphics.Asset;
import Asteroid.Input.KeyBoard;
import Asteroid.Math.Vector2D;
import Asteroid.State.GameModeState;
import java.awt.image.BufferedImage;

/**
 *
 * @author KelvinOjeda
 */
public class MateTwo extends Player {

    /* Direction vector */
    protected Vector2D heading;
    /* Variation of acceleration */
    protected Vector2D acceleration;

    public MateTwo(Vector2D position,
            Vector2D velocity,
            double maxVelocity,
            BufferedImage texture,
            GameModeState gameState,
            Chronometer fireRate,
            Chronometer spawTime,
            Chronometer flikerTime) {
        super(position, velocity, maxVelocity, texture,
                gameState, fireRate, spawTime, flikerTime);
        heading = new Vector2D(0, 1);
        acceleration = new Vector2D();
    }

    /* Methods */
    @Override
    public void update() {
        //Initialize values when the ship is not spawning
        if (!spawnTime.isRunning()) {
            spawning = false;
            visible = true;
        }
        //produce the flickering effect
        if (spawning) {
            if (!flickerTime.isRunning()) {
                flickerTime.run(Constant.FLICKER_TIME);
                visible = !visible;
            }
        }
        /* Shooting effect */
        if (KeyBoard.SHOOT2 && !fireRate.isRunning() && !spawning) {
            gameState.getMovingObjects().add(0,
                    new Laser(
                            getCenter().add(heading.scale(width)),
                            heading,
                            Constant.LASER_VEL,
                            angle,
                            Asset.greenLaser,
                            gameState,
                            2
                    )
            );

            /* Running */
            fireRate.run(Constant.FIRERATE);
        }

        /* Space ship moves to the RIGHT1 */
        if (KeyBoard.RIGHT2) {
            angle += Constant.DELTAANGLE;
        }

        /* Space ship moves to the LEFT1 */
        if (KeyBoard.LEFT2) {
            angle -= Constant.DELTAANGLE;
        }

        /* Space ship moves to the TOP */
        if (KeyBoard.UP2) {
            /* Moves the ship */
            acceleration = heading.scale(Constant.ACC);
            accelerating = true;

        } else {
            if (velocity.getMagnitude() != 0) {
                acceleration = (velocity.scale(-1).normalize()).scale(Constant.ACC / 2);

                /* Ship is not moving */
                accelerating = false;
            }
        }

        /* Acceleration is the velocity variation */
        velocity = velocity.add(acceleration);
        velocity = velocity.limit(maxVelocity);
        heading = heading.setDirection(angle - Math.PI / 2);

        /* Velocity is the position variation */
        position = position.add(velocity);

        /* Sets the movement limit across the SCREEN DIMENSIONS */
        if (position.getX() > Constant.WIDTH) {
            position.setX(0);
        }

        if (position.getY() > Constant.HEIGHT) {
            position.setY(0);
        }

        if (position.getX() < 0) {
            position.setX(Constant.WIDTH);
        }

        if (position.getY() < 0) {
            position.setY(Constant.HEIGHT);
        }

        /* Updates the chronometer */
        fireRate.update();
        spawnTime.update();
        flickerTime.update();

        /* Detects a collition */
        collidesWith();

    }
    @Override
    //reset ship position values
    public void resetValues() {
        angle = 0;
        velocity = new Vector2D();
        position = new Vector2D(3 * Constant.WIDTH / 4 - 
                Asset.player1.getWidth() / 2,
            Constant.HEIGHT / 2 - Asset.player1.getHeight() / 2);
    }


    /*When it is destroyed it reappears but blinking*/
    @Override
    public void destroy() {
        //ship starts flashing
        spawning = true;
        spawnTime.run(Constant.SPAWNING_TIME);
        //remove a player attempt
        if (!gameState.subtractLife2()) {
            super.destroy();
            if (gameState.getLive1() == 0 && gameState.getLive2() == 0) {
                gameState.gameOver();

            }
        }
        //Reset values position
        resetValues();

    }
}
