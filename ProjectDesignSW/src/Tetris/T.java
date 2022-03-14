
package Tetris;

import java.awt.Color;
import javax.swing.JButton;

public class T extends Figure {

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    int x, y;

    int position;

    public T(JButton[][] matx) {
        super(matx);

        position = 0;

        isStopped = false;
        b1 = matx[dimx / 2][0];
        b2 = matx[dimx / 2 + 1][0];
        b3 = matx[dimx / 2 + 2][0];
        b4 = matx[dimx / 2 + 1][1];

        x = dimx / 2;
        y = 1;
    }

    public void paint() {
        b1.setBackground(Color.GREEN);
        b2.setBackground(Color.GREEN);
        b3.setBackground(Color.GREEN);
        b4.setBackground(Color.GREEN);
    }
    
    public void resetColor(){
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        b4.setBackground(Color.white);
    }
    
    public void move(int n){
        switch(n){
                case 1:
                    if (isStopped) {
                        return;
                    }

                    if (position == 0 && y >= dimy - 1) {
                        isStopped = true;
                        return;
                    }
                    if (position == 1 && y + 1 >= dimy - 1) {
                        isStopped = true;
                        return;
                    }
                    if (position == 3 && y + 1 >= dimy - 1) {
                        isStopped = true;
                        return;
                    }
                    if (position == 2 && y >= dimy - 1) {
                        isStopped = true;
                        return;
                    }

                    if (position == 0
                            && (!matrix[x][y].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 1][y + 1].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 2][y].getBackground().equals(new Color(240, 240, 240)))) {
                        isStopped = true;
                        return;
                    }

                    if (position == 1
                            && (!matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 1][y + 2].getBackground().equals(new Color(240, 240, 240)))) {
                        isStopped = true;
                        return;
                    }

                    if (position == 2
                            && (!matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 1][y + 1].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 2][y + 1].getBackground().equals(new Color(240, 240, 240)))) {
                        isStopped = true;
                        return;
                    }

                    if (position == 3
                            && (!matrix[x + 1][y + 2].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 2][y + 1].getBackground().equals(new Color(240, 240, 240)))) {
                        isStopped = true;
                        return;
                    }

                    if (position == 0) {

                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b1 = matrix[x][y - 1];
                        b2 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 2][y - 1];
                        b4 = matrix[x + 1][y];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);
                    }

                    if (position == 1) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }

                    if (position == 2) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x][y];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 2][y];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }
                    if (position == 3) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x + 2][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }
                break;
                
                case 2:
                    if (isStopped) {
                        return;
                    }
                    if (position == 0 && x + 2 >= dimx - 1) {
                        return;
                    }
                    if (position == 1 && x + 1 >= dimx - 1) {
                        return;
                    }
                    if (position == 2 && x + 2 >= dimx - 1) {
                        return;
                    }
                    if (position == 3 && x + 2 >= dimx - 1) {
                        return;
                    }
                    if (position == 0) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;
                        b1 = matrix[x][y - 1];
                        b2 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 2][y - 1];
                        b4 = matrix[x + 1][y];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);
                    }
                    if (position == 1) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }
                    if (position == 2) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x][y];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 2][y];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }
                    if (position == 3) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x + 2][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }
                break;
                
                case 3:
                    if (isStopped) {
                        return;
                    }
                    if (position == 3 && x < 0) {
                        return;
                    }
                    if (position == 0 && x - 1 < 0) {
                        return;
                    }
                    if (position == 2 && x - 1 < 0) {
                        return;
                    }
                    if (position == 1 && x - 1 < 0) {
                        return;
                    }

                    if (position == 0) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));

                        x--;
                        b1 = matrix[x][y - 1];
                        b2 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 2][y - 1];
                        b4 = matrix[x + 1][y];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);
                    }

                    if (position == 1) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x--;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }
                    if (position == 2) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x--;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x][y];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 2][y];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }
                    if (position == 3) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x--;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x + 2][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.GREEN);
                        b2.setBackground(Color.GREEN);
                        b3.setBackground(Color.GREEN);
                        b4.setBackground(Color.GREEN);

                    }
                break;
                
                default:
                    
                break;
        }
    }
    
    public void rotate() {
        if (x + 2 > dimx - 1 || x < 0) {
            return;
        }

        if (position == 0) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b4 = matrix[x + 1][y - 1];
            b3 = matrix[x + 1][y];
            b2 = matrix[x][y];
            b1 = matrix[x + 1][y + 1];
            b1.setBackground(Color.GREEN);
            b2.setBackground(Color.GREEN);
            b3.setBackground(Color.GREEN);
            b4.setBackground(Color.GREEN);

            position = 1;
        } else if (position == 1) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b4 = matrix[x + 1][y - 1];
            b3 = matrix[x][y];
            b2 = matrix[x + 1][y];
            b1 = matrix[x + 2][y];
            b1.setBackground(Color.GREEN);
            b2.setBackground(Color.GREEN);
            b3.setBackground(Color.GREEN);
            b4.setBackground(Color.GREEN);

            position = 2;
        } else if (position == 2) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b4 = matrix[x + 1][y - 1];
            b3 = matrix[x + 1][y];
            b2 = matrix[x + 2][y];
            b1 = matrix[x + 1][y + 1];
            b1.setBackground(Color.GREEN);
            b2.setBackground(Color.GREEN);
            b3.setBackground(Color.GREEN);
            b4.setBackground(Color.GREEN);

            position = 3;

        } else if (position == 3) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b1 = matrix[x][y - 1];
            b2 = matrix[x + 1][y - 1];
            b3 = matrix[x + 2][y - 1];
            b4 = matrix[x + 1][y];

            b1.setBackground(Color.GREEN);
            b2.setBackground(Color.GREEN);
            b3.setBackground(Color.GREEN);
            b4.setBackground(Color.GREEN);
            position = 0;
        }

    }

}
