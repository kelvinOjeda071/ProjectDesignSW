
package Tetris;

import java.awt.Color;
import javax.swing.JButton;

public class L extends Figure {

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    int x, y;

    int position;

    public L(JButton[][] matrix) {
        super(matrix);

        position = 0;

        isStopped = false;
        b1 = matrix[dimx / 2][0];
        b2 = matrix[dimx / 2 + 1][0];
        b3 = matrix[dimx / 2 + 2][0];
        b4 = matrix[dimx / 2][1];
        x = dimx / 2;
        y = 1;
    }
    
    public void draw(){
        b1.setBackground(Color.orange);
        b2.setBackground(Color.orange);
        b3.setBackground(Color.orange);
        b4.setBackground(Color.orange);
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
                            && (!matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 1][y].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x + 2][y].getBackground().equals(new Color(240, 240, 240)))) {
                        isStopped = true;
                        return;
                    }

                    if (position == 1
                            && (!matrix[x][y].getBackground().equals(new Color(240, 240, 240))
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
                            || !matrix[x + 2][y + 2].getBackground().equals(new Color(240, 240, 240)))) {
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
                        b4 = matrix[x][y];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);
                    }

                    if (position == 1) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b4 = matrix[x][y - 1];
                        b3 = matrix[x + 1][y - 1];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

                    }
                    if (position == 2) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b4 = matrix[x + 2][y - 1];
                        b3 = matrix[x][y];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 2][y];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

                    }
                    if (position == 3) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        y++;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x + 1][y + 1];
                        b1 = matrix[x + 2][y + 1];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

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
                        b4 = matrix[x][y];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);
                    }

                    if (position == 1) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;
                        b4 = matrix[x][y - 1];
                        b3 = matrix[x + 1][y - 1];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

                    }
                    if (position == 2) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;
                        b4 = matrix[x + 2][y - 1];
                        b3 = matrix[x][y];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 2][y];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

                    }
                    if (position == 3) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x++;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x + 1][y + 1];
                        b1 = matrix[x + 2][y + 1];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

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
                        b4 = matrix[x][y];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);
                    }

                    if (position == 1) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x--;
                        b4 = matrix[x][y - 1];
                        b3 = matrix[x + 1][y - 1];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 1][y + 1];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

                    }
                    if (position == 2) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x--;
                        b4 = matrix[x + 2][y - 1];
                        b3 = matrix[x][y];
                        b2 = matrix[x + 1][y];
                        b1 = matrix[x + 2][y];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

                    }
                    if (position == 3) {
                        b1.setBackground(new Color(240, 240, 240));
                        b2.setBackground(new Color(240, 240, 240));
                        b3.setBackground(new Color(240, 240, 240));
                        b4.setBackground(new Color(240, 240, 240));
                        x--;
                        b4 = matrix[x + 1][y - 1];
                        b3 = matrix[x + 1][y];
                        b2 = matrix[x + 1][y + 1];
                        b1 = matrix[x + 2][y + 1];
                        b1.setBackground(Color.orange);
                        b2.setBackground(Color.orange);
                        b3.setBackground(Color.orange);
                        b4.setBackground(Color.orange);

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

            b4 = matrix[x][y - 1];
            b1 = matrix[x + 1][y - 1];
            b2 = matrix[x + 1][y];
            b3 = matrix[x + 1][y + 1];
            b1.setBackground(Color.orange);
            b2.setBackground(Color.orange);
            b3.setBackground(Color.orange);
            b4.setBackground(Color.orange);

            position = 1;
        } else if (position == 1) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b4 = matrix[x + 2][y - 1];
            b3 = matrix[x][y];
            b2 = matrix[x + 1][y];
            b1 = matrix[x + 2][y];
            b1.setBackground(Color.orange);
            b2.setBackground(Color.orange);
            b3.setBackground(Color.orange);
            b4.setBackground(Color.orange);

            position = 2;
        } else if (position == 2) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b4 = matrix[x + 1][y - 1];
            b3 = matrix[x + 1][y];
            b2 = matrix[x + 1][y + 1];
            b1 = matrix[x + 2][y + 1];
            b1.setBackground(Color.orange);
            b2.setBackground(Color.orange);
            b3.setBackground(Color.orange);
            b4.setBackground(Color.orange);

            position = 3;

        } else if (position == 3) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b1 = matrix[x][y - 1];
            b2 = matrix[x + 1][y - 1];
            b3 = matrix[x + 2][y - 1];
            b4 = matrix[x][y];

            b1.setBackground(Color.orange);
            b2.setBackground(Color.orange);
            b3.setBackground(Color.orange);
            b4.setBackground(Color.orange);
            position = 0;
        }

    }

}
