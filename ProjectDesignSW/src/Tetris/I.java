
package Tetris;

import java.awt.Color;
import javax.swing.*;


public class I extends Figure {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    int x, y;
    boolean isHorizontal;

    public I(JButton[][] matrix) {
        super(matrix);
        isHorizontal = false;
        isStopped = false;
        b1 = matrix[dimx / 2][0];
        b2 = matrix[dimx / 2][1];
        b3 = matrix[dimx / 2][2];
        b4 = matrix[dimx / 2][3];
        x = dimx / 2;
        y = 3;
    }
    
    @Override
    public void draw(){
        b1.setBackground(Color.red);
        b2.setBackground(Color.red);
        b3.setBackground(Color.red);
        b4.setBackground(Color.red);
    }
    
    
    public void move(int n){
        switch (n) {
            case 1://bajar
                if (isStopped) {
                    return;
                } else if (y >= dimy - 1) {
                    isStopped = true;
                    return;
                } else if (!isHorizontal && !matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))) {
                    isStopped = true;
                    return;
                } else if (isHorizontal
                        && (!matrix[x + 1][y + 1].getBackground().equals(new Color(240, 240, 240))
                        || !matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))
                        || ((x - 1 > 0) && !matrix[x - 1][y + 1].getBackground().equals(new Color(240, 240, 240)))
                        || ((x - 2 > 0) && !matrix[x - 2][y + 1].getBackground().equals(new Color(240, 240, 240))))) {
                    isStopped = true;
                    return;
                } else if (isHorizontal) {

                    b1.setBackground(new Color(240, 240, 240));
                    b2.setBackground(new Color(240, 240, 240));
                    b3.setBackground(new Color(240, 240, 240));
                    b4.setBackground(new Color(240, 240, 240));
                    y++;
                    b1 = matrix[x + 1][y];
                    b2 = matrix[x][y];
                    b3 = matrix[x - 1][y];
                    b4 = matrix[x - 2][y];

                    b1.setBackground(Color.red);
                    b2.setBackground(Color.red);
                    b3.setBackground(Color.red);
                    b4.setBackground(Color.red);

                } else {
                    b1.setBackground(new Color(240, 240, 240));
                    b1 = b2;
                    b2 = b3;
                    b3 = b4;
                    b4 = matrix[x][++y];
                    b4.setBackground(Color.red);
                }
                break;
            case 2://moverDerecha
                if (isStopped) {
                    return;
                }
                if (x >= dimx - 1) {
                    return;
                }
                if (!isHorizontal
                        && !matrix[x + 1][y].getBackground().equals(new Color(240, 240, 240))
                        || !matrix[x + 1][y - 1].getBackground().equals(new Color(240, 240, 240))
                        || !matrix[x + 1][y - 2].getBackground().equals(new Color(240, 240, 240))
                        || !matrix[x + 1][y - 3].getBackground().equals(new Color(240, 240, 240))) {
                    return;
                } else if (isHorizontal
                        && (x + 1 >= dimx - 1)) {
                    return;
                }
                if (isHorizontal) {
                    b1.setBackground(new Color(240, 240, 240));
                    b1 = b2;
                    b2 = b3;
                    b3 = b4;
                    b4 = matrix[++x][y];
                    b4.setBackground(Color.red);

                } else {
                    b1.setBackground(new Color(240, 240, 240));
                    b2.setBackground(new Color(240, 240, 240));
                    b3.setBackground(new Color(240, 240, 240));
                    b4.setBackground(new Color(240, 240, 240));

                    x++;

                    b4 = matrix[x][y];
                    b3 = matrix[x][y - 1];
                    b2 = matrix[x][y - 2];
                    b1 = matrix[x][y - 3];
                    b1.setBackground(Color.red);
                    b2.setBackground(Color.red);
                    b3.setBackground(Color.red);
                    b4.setBackground(Color.red);

                }
                break;
            case 3://moverIzquierda
                if (isStopped) {
            return;
        }
        if (x - 1 < 0) {
            return;
        }
        if (!isHorizontal
                && !matrix[x - 1][y].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 1].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 2].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 3].getBackground().equals(new Color(240, 240, 240))) {
            return;
        } else if (isHorizontal
                && (x - 1 <= 1)) {
            return;
        }
        if (isHorizontal) {
            b4.setBackground(new Color(240, 240, 240));
            b4 = b3;
            b3 = b2;
            b2 = b1;
            x--;
            b1 = matrix[x][y];
            b1.setBackground(Color.red);
        } else {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            x--;
            b4 = matrix[x][y];
            b3 = matrix[x][y - 1];
            b2 = matrix[x][y - 2];
            b1 = matrix[x][y - 3];
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);

        }
                break;
            default:
                break;
        }
    }

    public void rotate() {
        if (x + 1 > dimx - 1 || x - 2 < 0) {
            return;
        }

        if (!isHorizontal && !matrix[x - 1][y].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 1].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 2].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 3].getBackground().equals(new Color(240, 240, 240))) {
            return;
        } else if (isHorizontal
                && (x - 1 <= 1)) {
            return;
        }
        if (isHorizontal) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b4 = matrix[x][y];
            b3 = matrix[x][y - 1];
            b2 = matrix[x][y - 2];
            b1 = matrix[x][y - 3];
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);

        } else {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b1 = matrix[x - 2][y];
            b2 = matrix[x - 1][y];
            b3 = matrix[x][y];
            b4 = matrix[x + 1][y];

            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);

        }

        isHorizontal = !isHorizontal;
    }

}
