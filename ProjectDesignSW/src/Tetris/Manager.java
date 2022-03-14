package Tetris;

import Asteroid.IO.JSONParser;
import Facade.CheckFacade;
import Login.User;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Manager {

    JButton[][] matrixes = new JButton[10][20];
    ;
    Timer step;
    TimerTask down;
    Figure figure;
    Figure figure1;
    Random random = new Random();
    Random random1 = new Random();
    int dimx = 10;
    int dimy = 20;
    int counter = 0;
    int counter1 = 0;
    double score = 0;
    int r = (int) (random1.nextFloat() * 6);

    Manager() {

    }

    public void Manager(JButton[][] matrix, JButton[][] matrix1, JPanel table, JLabel jLScore, JButton exit) {
        figure = new L(matrix);
        figure.paint();
        figure.move(1);

        figure1 = new L(matrix1);
        figure1.paint();
        //figura1.move(1);

        step = new Timer();
        down = new TimerTask() {
            @Override
            public void run() {
                for (int x = 0; x < dimx; x++) {
                    if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                        counter++;
                    }
                }
                // Funcion para saber si se perdió en el juego
                if (counter > 5) {
                    javax.swing.JOptionPane.showMessageDialog(null, "You lost\n"
                            + "END.\n", "GAME OVER", javax.swing.JOptionPane.OK_OPTION);
                    exit.setEnabled(true);
                    step.cancel();
                    counter = 0;
                    updateScore((int) score);
                    return;
                }
                // Función para saber si 
                for (int y = 0; y < dimy; y++) {
                    boolean completo = true;
                    for (int x = 0; x < dimx; x++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            completo = false;
                        }
                    }
                    if (completo) {
                        score = score + 10;
                        jLScore.setText(String.valueOf(score));
                        //----------------------------------------------------------------------
                        for (int z = y; z > 0; z--) {
                            for (int j = 0; j < dimx; j++) {
                                matrix[j][z].setBackground(matrix[j][z - 1].getBackground());

                            }
                        }

                    }

                }

                if (figure.isStopped) {
                    table.setEnabled(false);
                    table.setEnabled(true);
                    int ra = (int) (random1.nextFloat() * 6);
                    //ta.di(ra);
                    if (r == 0) {//----------BIG TABLE
                        figure = new I(matrix);
                        figure.paint();
                    }
                    if (r == 1) {
                        figure = new O(matrix);
                        figure.paint();
                    }
                    if (r == 2) {
                        figure = new Z(matrix);
                        figure.paint();
                    }
                    if (r == 3) {
                        figure = new L(matrix);
                        figure.paint();
                    }
                    if (r == 4) {
                        figure = new T(matrix);
                        figure.paint();
                    }
                    if (r == 5) {
                        figure = new S(matrix);
                        figure.paint();
                    }
                    if (ra == 0) {//----------SMALL TABLE
                        figure1.resetColor();
                        figure1 = new I(matrix1);
                        figure1.paint();
                    }
                    if (ra == 1) {
                        figure1.resetColor();
                        figure1 = new O(matrix1);
                        figure1.paint();
                    }
                    if (ra == 2) {
                        figure1.resetColor();
                        figure1 = new Z(matrix1);
                        figure1.paint();
                    }
                    if (ra == 3) {
                        figure1.resetColor();
                        figure1 = new L(matrix1);
                        figure1.paint();
                    }
                    if (ra == 4) {
                        figure1.resetColor();
                        figure1 = new T(matrix1);
                        figure1.paint();
                    }
                    if (ra == 5) {
                        figure1.resetColor();
                        figure1 = new S(matrix1);
                        figure1.paint();
                    }
                    r = ra;
                } else {
                    figure.paint();
                    figure.move(1);
                    counter = 0;
                }

                //cells in the board are not visible anymore once they are filled
                //with an object
                for (int x = 0; x < dimx; x++) {
                    for (int y = 0; y < dimy; y++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            matrix[x][y].setVisible(false);
                        } else {
                            matrix[x][y].setVisible(true);
                        }
                    }
                }

            }
        };
        step.schedule(down, 0, 500);
    }

    public void movementsControl(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_S) {
            figure.move(1);
        }
        if (evt.getKeyCode() == KeyEvent.VK_D) {
            figure.move(2);
        }
        if (evt.getKeyCode() == KeyEvent.VK_A) {
            figure.move(3);
        }
        if (evt.getKeyCode() == KeyEvent.VK_W) {
            figure.rotate();
        }
    }

    public void movementsControl2(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_K) {
            figure.move(1);
        }
        if (evt.getKeyCode() == KeyEvent.VK_L) {
            figure.move(2);
        }
        if (evt.getKeyCode() == KeyEvent.VK_J) {
            figure.move(3);
        }
        if (evt.getKeyCode() == KeyEvent.VK_I) {
            figure.rotate();
        }
    }
    
    public void updateScore(int score) {
        int i = 0;
        // Save the new Score for the User Login

        ArrayList<User> dataList = readData();
        for (int j = 0; j < dataList.size(); j++) {
            if (dataList.get(j).getCurrentActive() == 1) {
                if (dataList.get(j).getTetrisGameScore()
                        < score) {
                    dataList.get(j).setTetrisGameScore(score);
                    dataList.get(i).setDate(setDateNow());
                    writeData(dataList);
                }
            }

        }
    }
    
    public void showScores(JTextArea scoresArea){
        String scores = "Username\t\tScore\t\tDate\n\n";
        ArrayList<User> users = readData();
        for(int i = 0; i < users.size(); i++){
            scores += users.get(i).getFirstName() + " " + users.get(i).getLastName()
                    + "\t" + users.get(i).getTetrisGameScore() +
                    "\t\t" + users.get(i).getDate() + "\n";
        }
        scoresArea.setText(scores);
    }
    
    public ArrayList<User> readData() {
        try {
            return JSONParser.readField();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public boolean writeData(ArrayList<User> dataList) {
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

    public String setDateNow() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }

    public void start(JButton[][] matrix, JButton[][] matrix1, JPanel table, JLabel jLScore, JButton exit) {
        step.cancel();
        score = 0;
        figure = new L(matrix);
        figure.move(1);

        figure1 = new L(matrix1);
        figure1.paint();

        Table ta = new Table(matrix, table);
        //int r = (int) (random1.nextFloat() * 6);
        step = new Timer();

        down = new TimerTask() {
            @Override
            public void run() {
                for (int x = 0; x < dimx; x++) {
                    if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                        counter++;
                    }
                }

                if (counter > 5) {
                    javax.swing.JOptionPane.showMessageDialog(null, "You lost\n"
                            + "END!\n", "GAME OVER", javax.swing.JOptionPane.OK_OPTION);
                    exit.setEnabled(true);
                    step.cancel();
                    counter = 0;
                    updateScore((int) score);
                    return;
                }

                for (int y = 0; y < dimy; y++) {
                    boolean isComplete = true;
                    for (int x = 0; x < dimx; x++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            isComplete = false;
                        }
                    }
                    if (isComplete) {
                        score = score + 10;
                        jLScore.setText(String.valueOf(score));

                        for (int z = y; z > 0; z--) {
                            for (int j = 0; j < dimx; j++) {
                                matrix[j][z].setBackground(matrix[j][z - 1].getBackground());

                            }
                        }

                    }

                }

                if (figure.isStopped) {
                    //System.out.println(r+ " -- "+uno);
                    int ra = (int) (random1.nextFloat() * 6);
                    //tabla.removeAll();

                    if (r == 0) {//----------BIG TABLE
                        figure = new I(matrix);
                        figure.paint();
                    }
                    if (r == 1) {
                        figure = new O(matrix);
                        figure.paint();
                    }
                    if (r == 2) {
                        figure = new Z(matrix);
                        figure.paint();
                    }
                    if (r == 3) {
                        figure = new L(matrix);
                        figure.paint();

                    }
                    if (r == 4) {
                        figure = new T(matrix);
                        figure.paint();
                    }
                    if (r == 5) {
                        figure = new S(matrix);
                        figure.paint();
                    }
                    if (ra == 0) {//----------SMALL TABLE
                        figure1.resetColor();
                        figure1 = new I(matrix1);
                        figure1.paint();
                    }
                    if (ra == 1) {
                        figure1.resetColor();
                        figure1 = new O(matrix1);
                        figure1.paint();
                    }
                    if (ra == 2) {
                        figure1.resetColor();
                        figure1 = new Z(matrix1);
                        figure1.paint();
                    }
                    if (ra == 3) {
                        figure1.resetColor();
                        figure1 = new L(matrix1);
                        figure1.paint();
                    }
                    if (ra == 4) {
                        figure1.resetColor();
                        figure1 = new T(matrix1);
                        figure1.paint();
                    }
                    if (ra == 5) {
                        figure1.resetColor();
                        figure1 = new S(matrix1);
                        figure1.paint();
                    }
                    r = ra;
                } else {
                    figure.move(1);
                    figure.paint();
                    counter = 0;
                }
                for (int x = 0; x < dimx; x++) {
                    for (int y = 0; y < dimy; y++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            matrix[x][y].setVisible(false);
                            //----------------------------------------------------------------------
                        } else {
                            matrix[x][y].setVisible(true);
                        }
                    }
                }

            }
        };
        step.schedule(down, 0, 500);
    }

    public static void startAction(JPanel Tablero) {

    }

}
