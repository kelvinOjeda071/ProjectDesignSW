package Tetris;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Table {
    JButton[][] matrix;
    JPanel table;
    int random;
    int dimx = 10;
    int dimy = 20;
    
    public Table(JButton[][] matrix, JPanel table) {
        this.matrix = matrix;
        this.table = table;
    }
    
    public void draw(int r){
        //Graphics  g = new Graphics();
        JButton b = new JButton();
        JButton c = new JButton();
        JButton d = new JButton();
        JButton e = new JButton();
        
        switch(r){
            case 0://I
                table.removeAll();
                table.setEnabled(false);
                table.setEnabled(true);
                b.setBounds(5, 5, 30, 30);
                b.setBackground(Color.red);
                table.add(b);
                c.setBounds(5, 30, 30, 30);
                c.setBackground(Color.red);
                table.add(c);
                d.setBounds(5, 55, 30, 30);
                d.setBackground(Color.red);
                table.add(d);
                e.setBounds(5, 80, 30, 30);
                e.setBackground(Color.red);
                table.add(e);
                break;
            case 1://0
                table.removeAll();
                table.setEnabled(false);
                table.setEnabled(true);
                b.setBounds(5, 5, 30, 30);
                b.setBackground(Color.BLUE);
                table.add(b);
                c.setBounds(30, 5, 30, 30);
                c.setBackground(Color.BLUE);
                table.add(c);
                d.setBounds(5, 30, 30, 30);
                d.setBackground(Color.BLUE);
                table.add(d);
                e.setBounds(30, 30, 30, 30);
                e.setBackground(Color.BLUE);
                table.add(e);
                break;
            case 2://Z
                table.removeAll();
                table.setEnabled(false);
                table.setEnabled(true);
                b.setBounds(5, 5, 30, 30);
                b.setBackground(Color.cyan);
                table.add(b);
                c.setBounds(30, 5, 30, 30);
                c.setBackground(Color.cyan);
                table.add(c);
                d.setBounds(30, 30, 30, 30);
                d.setBackground(Color.cyan);
                table.add(d);
                e.setBounds(55, 30, 30, 30);
                e.setBackground(Color.cyan);
                table.add(e);
                break;
            case 3://L
                table.removeAll();
                table.setEnabled(false);
                table.setEnabled(true);
                b.setBounds(5, 5, 30, 30);
                b.setBackground(Color.YELLOW);
                table.add(b);
                c.setBounds(30, 5, 30, 30);
                c.setBackground(Color.YELLOW);
                table.add(c);
                d.setBounds(55, 5, 30, 30);
                d.setBackground(Color.YELLOW);
                table.add(d);
                e.setBounds(5, 30, 30, 30);
                e.setBackground(Color.YELLOW);
                table.add(e);
                break;
            case 4://T
                table.removeAll();
                table.setEnabled(false);
                table.setEnabled(true);
                b.setBounds(5, 5, 30, 30);
                b.setBackground(Color.GREEN);
                table.add(b);
                c.setBounds(30, 5, 30, 30);
                c.setBackground(Color.GREEN);
                table.add(c);
                d.setBounds(55, 5, 30, 30);
                d.setBackground(Color.GREEN);
                table.add(d);
                e.setBounds(30, 30, 30, 30);
                e.setBackground(Color.GREEN);
                table.add(e);
                break;
            case 5://S
                table.removeAll();
                table.setEnabled(false);
                table.setEnabled(true);
                b.setBounds(30, 5, 30, 30);
                b.setBackground(Color.MAGENTA);
                table.add(b);
                c.setBounds(55, 5, 30, 30);
                c.setBackground(Color.MAGENTA);
                table.add(c);
                d.setBounds(5, 30, 30, 30);
                d.setBackground(Color.MAGENTA);
                table.add(d);
                e.setBounds(30, 30, 30, 30);
                e.setBackground(Color.MAGENTA);
                table.add(e);
                break;
            default :
                break;
        } 
                
    }
}