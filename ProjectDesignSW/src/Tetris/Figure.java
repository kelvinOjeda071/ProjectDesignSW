package Tetris;

import javax.swing.JButton;

/**
 *
 * @author abel
 */
public abstract class Figure {

    JButton[][] matrix;
    int dimx, dimy;
    boolean isStopped;

    public Figure(JButton[][] matrix) {
        this.matrix = matrix;
        dimx = matrix.length;
        dimy = matrix[0].length;
        isStopped = false;
    }
    
    public abstract void draw();

    public abstract void move(int mov);

    public abstract void rotate();

}
