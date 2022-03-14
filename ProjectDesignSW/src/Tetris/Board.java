package Tetris;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends Figure {

    JButton[][] matrix;
    JPanel board;

    public Board(JButton[][] matrix, JPanel board) {//, JPanel board
        super(matrix);
        this.board = board;
    }

    public JButton[][] drawB() {
        dimx = 10;
        dimy = 20;
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

    public void paint() {
    }

    public void move(int mov) {
    }

    public void rotate() {
    }
    public void resetColor(){
    }
}
