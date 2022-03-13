/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.State;

import Asteroid.GameObjects.Asteroid;
import Asteroid.GameObjects.Chronometer;
import Asteroid.GameObjects.MovingObject;
import Asteroid.GameObjects.Player;
import Asteroid.Graphics.Asset;
import Asteroid.Math.Vector2D;
import java.awt.Graphics;
import java.util.ArrayList;
import Asteroid.GameObjects.Constant;
import Asteroid.GameObjects.Message;
import Asteroid.GameObjects.MateOne;
import Asteroid.GameObjects.MateTwo;
import Asteroid.GameObjects.Size;
import Asteroid.GameObjects.Ufo;
import Asteroid.Graphics.Animation;
import Asteroid.IO.JSONParser;
import Asteroid.IO.ScoreData;
import Login.JFLogInUserMono;
import Login.User;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KelvinOjeda
 */
public class ActionGameState extends GameState {

    public static final Vector2D PLAYER_START_POSITION_P1 = new Vector2D(
            Constant.WIDTH / 4 - Asset.player1.getWidth() / 2,
            Constant.HEIGHT / 2 - Asset.player1.getHeight() / 2);

    public static final Vector2D PLAYER_START_POSITION_P2 = new Vector2D(
            3 * Constant.WIDTH / 4 - Asset.player2.getWidth() / 2,
            Constant.HEIGHT / 2 - Asset.player2.getHeight() / 2);

    /* Attributes */
    private Player player1;
    private Player player2;
    private ArrayList<MovingObject> movingObjects = new ArrayList<MovingObject>();
    private int asteroid;
    private ArrayList<Animation> explosions = new ArrayList<Animation>();
    private ArrayList<Message> message = new ArrayList<Message>();

    private int score = 0;
    private int score2 = 0;

    private int numberPlayer = 0;

    /*player1's life*/
    private int live1 = 3;
    private int live2 = 0;

    //number of waves
    private int waves = 1;
    private Chronometer gameOverTimer;
    private boolean gameOver;
    private Chronometer ufoSpawner;


    /* Constructor */
    public ActionGameState() {

        ArrayList<User> dataList = readData();
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getCurrentActive() == 1) {
                numberPlayer++;
            }
        }

        if (numberPlayer == 1) {
            player1 = new MateOne(
                    PLAYER_START_POSITION_P1,
                    new Vector2D(),
                    Constant.PLAYER_MAX_VEL,
                    Asset.player1,
                    this,
                    new Chronometer(),
                    new Chronometer(),
                    new Chronometer()
            );
            movingObjects.add(player1);
        } else {
            this.live2 = 3;
            player1 = new MateOne(
                    PLAYER_START_POSITION_P1,
                    new Vector2D(),
                    Constant.PLAYER_MAX_VEL,
                    Asset.player1,
                    this,
                    new Chronometer(),
                    new Chronometer(),
                    new Chronometer()
            );

            player2 = new MateTwo(
                    PLAYER_START_POSITION_P2,
                    new Vector2D(),
                    Constant.PLAYER_MAX_VEL,
                    Asset.player2,
                    this,
                    new Chronometer(),
                    new Chronometer(),
                    new Chronometer()
            );
            movingObjects.add(player1);
            movingObjects.add(player2);
        }
        gameOverTimer = new Chronometer();
        gameOver = false;


        /* Adds the player1 as a moving object */
 /* Meteors quantity */
        asteroid = 1;

        /* Starts the asteroids wave */
        changeDifficulty();
        ufoSpawner = new Chronometer();
        ufoSpawner.run(Constant.UFO_SPAWN_RATE);
    }

    /* Methods */
    public void addScore(int value, Vector2D pos) {
        score += value;
        /*Pos is the position of the object that was destroyed */
        message.add(new Message(pos, true, "+" + value + " score", Color.WHITE, false, Asset.fontMed));
    }

    /* Increases the number of asteroids if destroyed */
    public void divideObject(Asteroid myAsteroid) {
        /* Gets the meteor enumerator size */
        Size size = myAsteroid.getSize();

        /* Buffered image */
        BufferedImage[] textures = size.textures;

        /* Sets the new meteor enumerator size */
        Size newSize = null;

        /* Updates the asteroid size */
        switch (size) {
            case BIG:
                newSize = Size.MED;
                break;
            case MED:
                newSize = Size.SMALL;
                break;
            case SMALL:
                newSize = Size.TINY;
                break;
            default:
                return;
        }

        /* Ateroids split iteration */
        int i = 0;

        for (i = 0; i < size.quantity; i++) {
            movingObjects.add(
                    new Asteroid(
                            myAsteroid.getPosition(),
                            new Vector2D(0, 1).setDirection(Math.random() * Math.PI * 2),
                            Constant.ASTEROID_VEL * Math.random() + 1,
                            textures[(int) (Math.random() * textures.length)],
                            this,
                            newSize
                    )
            );
        }
    }

    /* Deploys the asteroids */
    private void changeDifficulty() {
        /*draw the message*/
        message.add(new Message(new Vector2D(Constant.WIDTH / 2,
                Constant.HEIGHT / 2), false, "WAVE " + waves,
                Color.WHITE, true, Asset.fontBig));
        /* Asteroid position */
        double x;
        double y;

        /* Counter */
        int i = 0;

        /* Starts the wave*/
        for (i = 0; i < asteroid; i++) {
            x = i % 2 == 0 ? Math.random() * Constant.WIDTH : 0;
            y = i % 2 == 0 ? 0 : Math.random() * Constant.HEIGHT;

            /* Texture */
            BufferedImage texture
                    = Asset.bigs[(int) (Math.random() * Asset.bigs.length)];

            /* Adds the asteroid as a moving object */
            movingObjects.add(
                    new Asteroid(
                            new Vector2D(x, y),
                            new Vector2D(0, 1).setDirection(Math.random() * Math.PI * 2),
                            Constant.ASTEROID_VEL * Math.random() + 1,
                            texture,
                            this,
                            Size.BIG
                    )
            );
        }

        /* Increases game difficulty */
        asteroid++;
        waves++;

    }

    /* Plays the explosion animation */
    public void playExplosion(Vector2D position) {

        explosions.add(
                new Animation(Asset.explosions, 50, position.subtract(new Vector2D(
                        //Explosion in the middle of the object
                        Asset.explosions[0].getWidth() / 2,
                        Asset.explosions[0].getHeight() / 2)))
        );
    }

    private void artificialIntelligenceAction() {
        int rand = (int) (Math.random() * 2);
        double x = rand % 2 == 0 ? Math.random() * Constant.WIDTH : 0;
        double y = rand % 2 == 0 ? 0 : Math.random() * Constant.HEIGHT;
        ArrayList<Vector2D> path = new ArrayList<Vector2D>();
        double posX, posY;
        /*Top Left*/
        posX = Math.random() * (Constant.WIDTH / 2);
        posY = Math.random() * Constant.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));
        /*Top right*/
        posX = Math.random() * (Constant.WIDTH / 2) + Constant.WIDTH / 2;
        posY = Math.random() * Constant.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));
        /*Lower left*/
        posX = Math.random() * (Constant.WIDTH / 2);
        posY = Math.random() * (Constant.HEIGHT / 2) + Constant.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));
        /*Lower right*/
        posX = Math.random() * (Constant.WIDTH / 2) + Constant.WIDTH / 2;
        posY = Math.random() * (Constant.HEIGHT / 2) + Constant.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        movingObjects.add(new Ufo(new Vector2D(x, y),
                new Vector2D(),
                Constant.UFO_MAX_VEL,
                Asset.ufo,
                path,
                this));
    }

    /* Updates the object status */
    public void update() {
        /* Index iteration attribute */
        int i = 0;

        for (i = 0; i < movingObjects.size(); i++) {
            MovingObject auxMovinObject = movingObjects.get(i);
            auxMovinObject.update();
            if (auxMovinObject.isDead()) {
                movingObjects.remove(i);
                i--;
            }
        }

        /* Updates the explosions animation */
        for (i = 0; i < explosions.size(); i++) {
            Animation myAnimation = explosions.get(i);
            myAnimation.update();

            /* Checks if animation is still running */
            if (!myAnimation.isIsRunning()) {
                /* Deletes the animation */
                explosions.remove(i);
            }
        }
        if (gameOver && !gameOverTimer.isRunning()) {
            boolean isFound = false;
            // Save the new Score for the User Login

            ArrayList<User> dataList = readData();
            int z = 0;
            for (int j = 0; j < dataList.size(); j++) {
                if (dataList.get(j).getCurrentActive() == 1) {
                    if (dataList.get(j).getAsteroidGameScore()
                            < score) {
                        dataList.get(j).setAsteroidGameScore(score);
                        dataList.get(i).setDate(setDateNow());
                        writeData(dataList);
                    }
                }

            }
            GameState.changeState(new MenuState());
        }
        if (!ufoSpawner.isRunning()) {
            ufoSpawner.run(Constant.UFO_SPAWN_RATE);
            artificialIntelligenceAction();
        }
        gameOverTimer.update();
        ufoSpawner.update();

        /* Decides if a new wave is necessary */
        for (i = 0; i < movingObjects.size(); i++) {
            if (movingObjects.get(i) instanceof Asteroid) {
                return;
            }
        }

        /* Starts the new wave */
        changeDifficulty();
    }

    private void drawScore(Graphics g) {
        Vector2D pos = new Vector2D(850, 25);
        String scoreToString = Integer.toString(score);
        for (int i = 0; i < scoreToString.length(); i++) {
            g.drawImage(Asset.numbers[Integer.parseInt(scoreToString.
                    substring(i, i + 1))], (int) pos.getX(),
                    (int) pos.getY(), null);
            pos.setX(pos.getX() + 20);
        }
    }

    private void drawLives(Graphics g) {
        if (numberPlayer != 1) {
            if (live2 < 1) {
                return;
            }
            Vector2D livePosition2 = new Vector2D(25, 75);

            g.drawImage(Asset.life2, (int) livePosition2.getX(),
                    (int) livePosition2.getY(), null);

            g.drawImage(Asset.numbers[10], (int) livePosition2.getX() + 40,
                    (int) livePosition2.getY() + 5, null);

            String livesToString2 = Integer.toString(live2);

            Vector2D pos2 = new Vector2D(livePosition2.getX(),
                    livePosition2.getY());

            for (int i = 0; i < livesToString2.length(); i++) {
                int number = Integer.parseInt(livesToString2.
                        substring(i, i + 1));

                if (number < 0) {
                    break;
                }
                g.drawImage(Asset.numbers[number],
                        (int) pos2.getX() + 60,
                        (int) pos2.getY() + 5, null);
                pos2.setX(pos2.getX() + 20);
            }

        }
        if (live1 < 1) {
            return;
        }

        Vector2D livePosition = new Vector2D(25, 25);

        g.drawImage(Asset.life, (int) livePosition.getX(),
                (int) livePosition.getY(), null);

        g.drawImage(Asset.numbers[10], (int) livePosition.getX() + 40,
                (int) livePosition.getY() + 5, null);

        String livesToString = Integer.toString(live1);

        Vector2D pos = new Vector2D(livePosition.getX(),
                livePosition.getY());

        for (int i = 0; i < livesToString.length(); i++) {
            int number = Integer.parseInt(livesToString.
                    substring(i, i + 1));

            if (number < 0) {
                break;
            }
            g.drawImage(Asset.numbers[number],
                    (int) pos.getX() + 60,
                    (int) pos.getY() + 5, null);
            pos.setX(pos.getX() + 20);
        }

    }

    /* Draws the desired object */
    public void draw(Graphics g) {

        /* Anti aliasing */
        Graphics2D g2d = (Graphics2D) g;

        /* Bilinear interpolation */
        g2d.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );

        /* Draws the object */
        int i = 0;
        //Draw the message
        for (i = 0; i < message.size(); i++) {
            message.get(i).draw(g2d);
            if (message.get(i).isDead()) {
                message.remove(i);
            }
        }

        for (i = 0; i < movingObjects.size(); i++) {
            movingObjects.get(i).draw(g);
        }

        /* Draws the animation */
 /* Updates the explosions animation */
        for (i = 0; i < explosions.size(); i++) {
            Animation myAnimation = explosions.get(i);
            g2d.drawImage(
                    myAnimation.getCurrentFrame(),
                    (int) myAnimation.getPosition().getX(),
                    (int) myAnimation.getPosition().getY(),
                    null
            );

        }
        drawScore(g);
        drawLives(g);
    }

    /* Get */
 /* Array List access */
    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }

    //array of possible messages
    public ArrayList<Message> getMessage() {
        return message;
    }

    /* For getting the position of the player1 in Ufo*/
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getLive1() {
        return live1;
    }

    public int getLive2() {
        return live2;
    }

    //subtract one life from the ship
    public boolean subtractLife1() {
        live1--;
        return live1 > 0;
    }

    public boolean subtractLife2() {
        live2--;
        return live2 > 0;
    }

    public void gameOver() {
        Message gameOverMsg = new Message(
                PLAYER_START_POSITION_P1,
                true,
                "GAME OVER",
                Color.WHITE,
                true,
                Asset.fontBig);

        this.message.add(gameOverMsg);
        gameOverTimer.run(Constant.GAME_OVER_TIME);
        gameOver = true;
    }

    public ArrayList<Message> getMessages() {
        return message;
    }

    private ArrayList<User> readData() {
        try {
            return JSONParser.readField();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    private boolean writeData(ArrayList<User> dataList) {
        boolean isWrited = false;
        try {
            JSONParser.writeFile(dataList);
            isWrited = true;

        } catch (IOException ex) {
            System.out.println(ex);
            isWrited = false;
        }
        return isWrited;
    }

    private String setDateNow() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }
}
