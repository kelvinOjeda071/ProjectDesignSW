package Asteroid.Graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

/*
 * @author KelvinOjeda
 */
public class Asset {
    /* Attributes */
    private String newPath;
    
    /* Ship texture attribute */
    public static BufferedImage player1;
    public static BufferedImage player2;
    
    /* Movement texture attribute */
    public static BufferedImage speed;
    
    /* Laser texture attribute */
    public static BufferedImage greenLaser;
    
    /* Meteros */
    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] meds = new BufferedImage[2];
    public static BufferedImage[] smalls = new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];
    
    /* Explosion */
    public static BufferedImage[] explosions = new BufferedImage[9];
    /* Ufo */
    public static BufferedImage ufo;
    
    /* Number */
    public static BufferedImage[] numbers = new BufferedImage[11];
    
    /* Life */
    public static BufferedImage life;
    public static BufferedImage life2;
    
    // fonts
	public static Font fontBig;
	public static Font fontMed;
    //button
      public static BufferedImage blueBtn;
	public static BufferedImage greyBtn;
    public static void init(){
        /* Ship texture */
        player1 = Loader.ImageLoader("/Asteroid/Figure/Ships/player1.png");
        player2 = Loader.ImageLoader("/Asteroid/Figure/Ships/player2.png");
        
        /* Movement effect texture */
        speed= Loader.ImageLoader("/Asteroid/Figure/Effects/fire01.png");
        
        /* Laser texture */
        greenLaser = Loader.ImageLoader("/Asteroid/Figure/Effects/laserGreen.png");
        
        /* UFO texture */
        ufo = Loader.ImageLoader("/Asteroid/Figure/Ships/ufo.png");
        
        /*Life texture*/
        life = Loader.ImageLoader("/Asteroid/Figure/Life/life.png");
        life2 = Loader.ImageLoader("/Asteroid/Figure/Life/life2.png");
        
        //fond texture
        
        fontBig = Loader.loadFont("/Asteroid/Figure/Fonts/futureFont.ttf", 42);	
	fontMed = Loader.loadFont("/Asteroid/Figure/Fonts/futureFont.ttf", 20);
        
        
        /* Loads the meteors using a for bucle */
        int x;
        
        
        
        /* Big asteroids */
        for (x = 0; x < bigs.length; x++){
            bigs[x] = Loader.ImageLoader(
                "/Asteroid/Figure/Asteroids/big" + (x + 1) +".png"
            );
        }
        
        /* Medium asteroids */
        for (x = 0; x < meds.length; x++){
            meds[x] = Loader.ImageLoader(
                "/Asteroid/Figure/Asteroids/med" + (x + 1) +".png"
            );
        }
        
        /* Small asteroids */
        for (x = 0; x < smalls.length; x++){
            smalls[x] = Loader.ImageLoader(
                "/Asteroid/Figure/Asteroids/small" + (x + 1) +".png"
            );
        }
        
        /* Tiny asteroids */
        for (x = 0; x < tinies.length; x++){
            tinies[x] = Loader.ImageLoader(
                "/Asteroid/Figure/Asteroids/tiny" + (x + 1) +".png"
            );
        }
        
        /* Explosion */
        for (x = 0; x < explosions.length; x++){
            explosions[x] = Loader.ImageLoader(
                "/Asteroid/Figure/Explosion/explosion" + x + ".png"
            );
        }
        for (x = 0; x < numbers.length; x++) {
            numbers[x]= Loader.ImageLoader(
                    "/Asteroid/Figure/Numbers/" + x + ".png"
            ); 
        }
        greyBtn = Loader.ImageLoader("/Asteroid/Figure/Button/blue_button.png");
	blueBtn = Loader.ImageLoader("/Asteroid/Figure/Button/grey_button.png");
        
    }
    
    /* Constructor */
    public Asset(String newPath) {
        this.newPath = newPath;
    }
    
    
}
