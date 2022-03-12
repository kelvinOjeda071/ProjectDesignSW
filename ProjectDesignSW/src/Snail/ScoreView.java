package Snail;

import Snail.ScoreManager;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class ScoreView extends JFrame {

    private ScoreManager manager;
    
    public ScoreView() {
        manager = new ScoreManager();
        this.add(manager);
        this.setSize(800, 300);
        this.setLocation(300, 280);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);

    }
    
}
