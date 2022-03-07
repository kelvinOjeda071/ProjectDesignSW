
package Tetris;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board {
    JButton[][] matrix;
    JPanel board;
    int dimx = 10;
    int dimy = 20;

    public Board(JButton[][] matrix, JPanel board) {
        this.matrix = matrix;
        this.board = board;
    }
    
    JButton[][] draw(){
        JButton[][] matrix = new JButton[dimx][dimy];
        for (int x = 0; x < dimx; x++) {
            for (int y = 0; y < dimy; y++) {
                matrix[x][y] = new JButton();
                matrix[x][y].setBackground(new Color(240, 240, 240));
                this.board.add(matrix[x][y], new org.netbeans.lib.awtextra.AbsoluteConstraints(x * 30, y * 30, 35, 35));
            }
        }
        return matrix;
    }
    
}
