package Tetris;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Manager {

    //JButton[][] matrixes;
    Timer step;
    TimerTask down;
    Figure figure;
    Figure figure1;
    Random random = new Random();
    Random random1 = new Random();
    int dimx = 10;
    int dimy = 20;
    int counter = 0;
    int r = (int) (random1.nextFloat() * 6);
    double score = 0;

    //Clip clip;
    Manager() {
        //this.table = table;
    }

    public void Manager(JButton[][] matrix, JPanel table, JLabel jLScore) {
        
        figure = new L(matrix);
        figure.draw();
        figure.move(1);

        Table ta = new Table(matrix, table);
        //int r=(int) (random.nextFloat() * 6);
        //figura1 = new L(matrix1);
        //figura1.dibujar();

        step = new Timer();
        down = new TimerTask() {
            @Override
            public void run() {
                /*if (!clip.isActive()) try {
                    clip.start();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }*/

                for (int x = 0; x < dimx; x++) {
                    if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                        counter++;
                    }
                }
                // Funcion para saber si se perdió en el juego
                if (counter > 5) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Has perdido\n"
                            + "Fin.\n", "Fin del juego", javax.swing.JOptionPane.OK_OPTION);
                    step.cancel();

                    counter = 0;
                    return;
                }
                // Función para saber si 
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

                // Función que genera la siguiente figure al azar
                if (figure.isStopped) {
                    int ra = (int) (random1.nextFloat() * 6);
                    if (r == 0) {
                        ta.draw(ra);
                        figure = new I(matrix);
                        figure.draw();
                    }
                    if (r == 1) {
                        ta.draw(ra);
                        figure = new O(matrix);
                        figure.draw();
                    }
                    if (r == 2) {
                        ta.draw(ra);
                        figure = new Z(matrix);
                        figure.draw();
                    }
                    if (r == 3) {
                        ta.draw(ra);
                        figure = new L(matrix);
                        figure.draw();
                    }
                    if (r == 4) {
                        ta.draw(ra);
                        figure = new T(matrix);
                        figure.draw();
                    }
                    if (r == 5) {
                        ta.draw(ra);
                        figure = new S(matrix);
                        figure.draw();
                    }
                    r = ra;
                } else {
                    figure.draw();
                    figure.move(1);
                    counter = 0;
                }

                // Las celdas del tablero ya no son visibles una vez se rellenan
                // con un objeto
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
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            figure.move(1);
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            figure.move(2);
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            figure.move(3);
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            figure.rotate();
        }
    }

    public void start(JButton[][] matrix, JPanel table, JLabel jLScore) {
        score = 0;
        jLScore.setText(String.valueOf(score));
        //Tablero.removeAll();
        //cont = 0;

        figure = new L(matrix);
        figure.move(1);

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
                    javax.swing.JOptionPane.showMessageDialog(null, "Has perdido\n"
                            + "Fin.\n", "Fin del juego", javax.swing.JOptionPane.OK_OPTION);
                    step.cancel();
                    counter = 0;
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

                //int r = (int) (random1.nextFloat() * 6);
                if (figure.isStopped) {
                    //System.out.println(r+ " -- "+one);
                    int ra = (int) (random1.nextFloat() * 6);
                    table.removeAll();
                    ta.draw(ra);
                    if (r == 0) {
                        //tabla.removeAll();
                        //ta.draw(ra);
                        figure = new I(matrix);
                        figure.draw();
                    }
                    if (r == 1) {
                        //tabla.removeAll();
                        //ta.draw(ra);
                        figure = new O(matrix);
                        figure.draw();
                    }
                    if (r == 2) {
                        //tabla.removeAll();
                        //ta.draw(ra);
                        figure = new Z(matrix);
                        figure.draw();
                    }
                    if (r == 3) {
                        //tabla.removeAll();
                        //ta.draw(ra);
                        figure = new L(matrix);
                        figure.draw();

                    }
                    if (r == 4) {
                        //tabla.removeAll();
                        //ta.draw(ra);
                        figure = new T(matrix);
                        figure.draw();
                    }
                    if (r == 5) {
                        //tabla.removeAll();
                        //ta.draw(ra);
                        figure = new S(matrix);
                        figure.draw();
                    }
                    r = ra;
                } else {
                    figure.move(1);
                    figure.draw();
                    counter = 0;
                }
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

    public static void comerzarAccion(JPanel Tablero) {

    }

}
