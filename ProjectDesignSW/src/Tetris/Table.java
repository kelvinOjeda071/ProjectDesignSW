
package Tetris;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Table extends Figure {
    JPanel table;
    
    public Table(JButton[][] matrix, JPanel table) {
        super(matrix);
        this.table = table;
    }
    
    public JButton[][] drawT(){
        dimx = 5; dimy = 5;
        JButton[][] matriz = new JButton[dimx][dimy];
        for (int x = 0; x < dimx; x++) {
            for (int y = 0; y < dimy; y++) {
                matriz[x][y] = new JButton();
                matriz[x][y].setBackground(new Color(240, 240, 240));
                this.table.add(matriz[x][y], new org.netbeans.lib.awtextra.AbsoluteConstraints(x * 30, y * 30, 35, 35));//x * 30, y * 30, 35, 35
            }
        }
        return matriz;
    }
    
    public void paint() {
    }
    
    public void move(int mov) {
    }
    
    public void rotate() {
    }
    
}
