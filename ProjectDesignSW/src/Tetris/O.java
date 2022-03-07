
package Tetris;

import java.awt.Color;
import javax.swing.JButton;

public class O extends Figure {

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    int x, y;
    JButton[][] matrix1;

    public O(JButton[][] matrix2) {
        super(matrix2);
        //this.matrix1 = matrix1;
        isStopped = false;
        b1 = matrix2[dimx / 2][0];
        b2 = matrix2[dimx / 2][1];
        b3 = matrix2[dimx / 2 + 1][0];
        b4 = matrix2[dimx / 2 + 1][1];
        x = dimx / 2;
        y = 1;
        
    }
    
    public void draw(){
        isStopped = false;
        /*b1 = matrix1[dimx / 2][0];
        b2 = matrix1[dimx / 2][1];
        b3 = matrix1[dimx / 2 + 1][0];
        b4 = matrix1[dimx / 2 + 1][1];
        x = dimx / 2;
        y = 1;*/
        
        b1.setBackground(Color.BLUE);
        b2.setBackground(Color.BLUE);
        b3.setBackground(Color.BLUE);
        b4.setBackground(Color.BLUE);
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

                    if (!matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))) {
                        isStopped = true;
                        return;
                    }
                    if (!matrix[x + 1][y + 1].getBackground().equals(new Color(240, 240, 240))
                            || !matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))) {
                        isStopped = true;
                        return;
                    }

                    b1.setBackground(new Color(240, 240, 240));
                    b2.setBackground(new Color(240, 240, 240));
                    b3.setBackground(new Color(240, 240, 240));
                    b4.setBackground(new Color(240, 240, 240));

                    y++;
                    b1 = matrix[x][y - 1];
                    b2 = matrix[x][y];
                    b3 = matrix[x + 1][y - 1];
                    b4 = matrix[x + 1][y];

                    b1.setBackground(Color.BLUE);
                    b2.setBackground(Color.BLUE);
                    b3.setBackground(Color.BLUE);
                    b4.setBackground(Color.BLUE);
                break;
                
                case 2:
                    if (isStopped) {
                        return;
                    }
                    if (x >= dimx - 1) {
                        return;
                    }

                    if ((x + 1 >= dimx - 1)) {
                        return;
                    }

                    b1.setBackground(new Color(240, 240, 240));
                    b2.setBackground(new Color(240, 240, 240));
                    b3.setBackground(new Color(240, 240, 240));
                    b4.setBackground(new Color(240, 240, 240));

                    x++;
                    b1 = matrix[x][y - 1];
                    b2 = matrix[x][y];
                    b3 = matrix[x + 1][y - 1];
                    b4 = matrix[x + 1][y];

                    b1.setBackground(Color.BLUE);
                    b2.setBackground(Color.BLUE);
                    b3.setBackground(Color.BLUE);
                    b4.setBackground(Color.BLUE);
                break;
                
                case 3:
                    if (isStopped) {
                        return;
                    }
                    if (x - 1 < 0) {
                        return;
                    }
                    if (x <= 0) {
                        return;
                    }

                    b1.setBackground(new Color(240, 240, 240));
                    b2.setBackground(new Color(240, 240, 240));
                    b3.setBackground(new Color(240, 240, 240));
                    b4.setBackground(new Color(240, 240, 240));

                    x--;
                    b4 = matrix[x][y - 1];
                    b3 = matrix[x][y];
                    b2 = matrix[x + 1][y - 1];
                    b1 = matrix[x + 1][y];
                    b1.setBackground(Color.BLUE);
                    b2.setBackground(Color.BLUE);
                    b3.setBackground(Color.BLUE);
                    b4.setBackground(Color.BLUE);
                break;
                
                default:
                    
                break;
        }
    }

    public void rotate() {;
    }

}
