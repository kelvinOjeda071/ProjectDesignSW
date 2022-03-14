package Login;

import Asteroid.IO.JSONParser;
import Facade.CheckFacade;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KelvinOjeda
 */
public class User {

    private String firstName;
    private String lastName;
    private String id;
    private String password;
    private String date;
    private int asteroidGameScore;
    private int snailGameScore;
    private int tetrisGameScore;
    private int snakeGameScore;
    private int currentActive;

    public User(String firstName, String lastName, String id, String password, int scoreSignIn, int currentActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
        this.asteroidGameScore = scoreSignIn;
        this.snailGameScore = scoreSignIn;
        this.tetrisGameScore = scoreSignIn;
        this.snakeGameScore = scoreSignIn;
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.date = format.format(today);
        this.currentActive = currentActive;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAsteroidGameScore() {
        return asteroidGameScore;
    }

    public void setAsteroidGameScore(int asteroidGameScore) {
        this.asteroidGameScore = asteroidGameScore;
    }

    public int getSnailGameScore() {
        return snailGameScore;
    }

    public void setSnailGameScore(int snailGameScore) {
        this.snailGameScore = snailGameScore;
    }

    public int getTetrisGameScore() {
        return tetrisGameScore;
    }

    public void setTetrisGameScore(int tetrisGameScore) {
        this.tetrisGameScore = tetrisGameScore;
    }

    public int getSnakeGameScore() {
        return snakeGameScore;
    }

    public void setSnakeGameScore(int snakeGameScore) {
        this.snakeGameScore = snakeGameScore;
    }

    public int getCurrentActive() {
        return currentActive;
    }

    public void setCurrentActive(int currentActive) {
        this.currentActive = currentActive;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void signIn(JFSignInUser jFSignInUser) {
        jFSignInUser.signIn();
    }

    public void logIn(JFLogInUserMono jFLogIn) {
        jFLogIn.logInMonoPlayer();
    }

    public void playGame(CheckFacade checkFacade) {
        checkFacade.setVisible(true);
    }

}
