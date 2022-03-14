package Tetris;

import javax.swing.JButton;

/**
 *
 * @author abel
 */
public abstract class Figure {

    JButton[][] matrix;
    int dimx = 0;
    int dimy = 0;
    boolean isStopped;

    public Figure(JButton[][] matrix) {
        this.matrix = matrix;
        dimx = matrix.length;
        dimy = matrix[0].length;
        isStopped = false;
    }

    public JButton[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(JButton[][] matrix) {
        this.matrix = matrix;
    }

    public abstract void paint();

    public abstract void move(int mov);

    public abstract void rotate();

    public abstract void resetColor();

}
