
package Tetris;

import java.awt.Color;
import javax.swing.JButton;

public class S extends Figure {

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    int x, y;
    boolean horizontal;

    public S(JButton[][] matx) {
        super(matx);
        horizontal = true;
        isStopped = false;
        b1 = matx[dimx / 2 + 1][0];
        b2 = matx[dimx / 2 + 2][0];
        b3 = matx[dimx / 2 + 1][1];
        b4 = matx[dimx / 2][1];
        x = dimx / 2;
        y = 1;
    }
    
    public void draw(){
        b1.setBackground(Color.MAGENTA);
        b2.setBackground(Color.MAGENTA);
        b3.setBackground(Color.MAGENTA);
        b4.setBackground(Color.MAGENTA);
    }
    
    public void move(int n){
        switch(n){
                case 1:
                    if (isStopped) {
                        return;
                    }

                    if (y >= dimy - 1) {
                        isStopped = true;
                        return;
                    }

                    if (horizontal
                            && (!matrix[x + 1][y + 1].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 2][y].getBackground().equals(new Color(240, 240, 240)))) {
                        isStopped = true;
                        return;
                    }

                    if (!horizontal
                            && (!matrix[x][y].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 1][y + 1].getBackground().equals(new Color(240, 240, 240)))) {
                        isStopped = true;
                        return;
                    }

                    if (horizontal) {

                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b1 = matrix[x + 1][y - 1];
                        b2 = matrix[x + 2][y - 1];
                        b3 = matrix[x + 1][y];
                        b4 = matrix[x][y];
                        b1.setBackground(Color.MAGENTA);
                        b2.setBackground(Color.MAGENTA);
                        b3.setBackground(Color.MAGENTA);
                        b4.setBackground(Color.MAGENTA);
                    } else {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b4 = matrix[x][y - 2];
                        b3 = matrix[x + 1][y - 1];
                        b2 = matrix[x][y - 1];
                        b1 = matrix[x + 1][y];
                        b1.setBackground(Color.MAGENTA);
                        b2.setBackground(Color.MAGENTA);
                        b3.setBackground(Color.MAGENTA);
                        b4.setBackground(Color.MAGENTA);
                    }
                break;
                
                case 2:
                    if (isStopped) {
                        return;
                    }
                    if (horizontal && x + 2 >= dimx - 1) {
                        return;
                    }
                    if (!horizontal && x + 1 >= dimx - 1) {
                        return;
                    }
                    if (horizontal) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;
                        b1 = matrix[x + 1][y - 1];
                        b2 = matrix[x + 2][y - 1];
                        b3 = matrix[x + 1][y];
                        b4 = matrix[x][y];
                        b1.setBackground(Color.MAGENTA);
                        b2.setBackground(Color.MAGENTA);
                        b3.setBackground(Color.MAGENTA);
                        b4.setBackground(Color.MAGENTA);
                    } else {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;

                        b4 = matrix[x][y - 2];
                        b3 = matrix[x + 1][y - 1];
                        b2 = matrix[x][y - 1];
                        b1 = matrix[x + 1][y];
                        b1.setBackground(Color.MAGENTA);
                        b2.setBackground(Color.MAGENTA);
                        b3.setBackground(Color.MAGENTA);
                        b4.setBackground(Color.MAGENTA);

                    }
                break;
                
                case 3:
                    if (isStopped) {
                        return;
                    }
                    if (x - 1 < 0) {
                        return;
                    }

                    if (horizontal) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));

                        x--;
                        b1 = matrix[x + 1][y - 1];
                        b2 = matrix[x + 2][y - 1];
                        b3 = matrix[x + 1][y];
                        b4 = matrix[x][y];
                        b1.setBackground(Color.MAGENTA);
                        b2.setBackground(Color.MAGENTA);
                        b3.setBackground(Color.MAGENTA);
                        b4.setBackground(Color.MAGENTA);
                    } else {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));

                        x--;
                        b4 = matrix[x][y - 2];
                        b3 = matrix[x + 1][y - 1];
                        b2 = matrix[x][y - 1];
                        b1 = matrix[x + 1][y];
                        b1.setBackground(Color.MAGENTA);
                        b2.setBackground(Color.MAGENTA);
                        b3.setBackground(Color.MAGENTA);
                        b4.setBackground(Color.MAGENTA);

                    }
                break;
                
                default:
                    
                break;
        }
    }

    public void rotate() {
        if (x + 1 > dimx - 1 || x < 0) {
            return;
        }

        if (horizontal) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b4 = matrix[x][y - 2];
            b3 = matrix[x + 1][y - 1];
            b2 = matrix[x][y - 1];
            b1 = matrix[x + 1][y];
            b1.setBackground(Color.MAGENTA);
            b2.setBackground(Color.MAGENTA);
            b3.setBackground(Color.MAGENTA);
            b4.setBackground(Color.MAGENTA);

        } else {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b1 = matrix[x + 1][y - 1];
            b2 = matrix[x + 2][y - 1];
            b3 = matrix[x + 1][y];
            b4 = matrix[x][y];

            b1.setBackground(Color.MAGENTA);
            b2.setBackground(Color.MAGENTA);
            b3.setBackground(Color.MAGENTA);
            b4.setBackground(Color.MAGENTA);

        }

        horizontal = !horizontal;
    }

}
