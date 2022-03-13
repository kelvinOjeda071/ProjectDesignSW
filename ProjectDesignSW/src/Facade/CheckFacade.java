/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Facade;

import Asteroid.IO.JSONParser;
import Asteroid.Main.AsteroidGame;
import Login.User;
import Snail.SnailGame;
import Snake.Game;
import Snake.SnakeGame;
import Tetris.State.TetrisMenuState;
import Tetris.Tetris;
import Tetris.TetrisMenu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KelvinOjeda
 */
public class CheckFacade extends javax.swing.JFrame {

    /**
     * Creates new form CheckFacade
     */
    private AsteroidGame asteroidGame;
    private SnailGame snailGame;
    private Game snakeGame;
    private TetrisMenu tetris;

    public CheckFacade() {
        initComponents();

        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBackGroud = new javax.swing.JPanel();
        jBAsteroidGame = new javax.swing.JButton();
        jBSnailGame = new javax.swing.JButton();
        jBTetrisGame = new javax.swing.JButton();
        jBSnakeGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPBackGroud.setBackground(new java.awt.Color(255, 255, 255));

        jBAsteroidGame.setBackground(new java.awt.Color(0, 0, 0));
        jBAsteroidGame.setFont(new java.awt.Font("KenVector Future Thin", 1, 18)); // NOI18N
        jBAsteroidGame.setForeground(new java.awt.Color(255, 255, 255));
        jBAsteroidGame.setText("Asteroid Game");
        jBAsteroidGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAsteroidGameActionPerformed(evt);
            }
        });

        jBSnailGame.setBackground(new java.awt.Color(0, 0, 0));
        jBSnailGame.setFont(new java.awt.Font("KenVector Future Thin", 1, 18)); // NOI18N
        jBSnailGame.setForeground(new java.awt.Color(255, 255, 255));
        jBSnailGame.setText("Snail Game");
        jBSnailGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSnailGameActionPerformed(evt);
            }
        });

        jBTetrisGame.setBackground(new java.awt.Color(0, 0, 0));
        jBTetrisGame.setFont(new java.awt.Font("KenVector Future Thin", 1, 18)); // NOI18N
        jBTetrisGame.setForeground(new java.awt.Color(255, 255, 255));
        jBTetrisGame.setText("Tetris Game");
        jBTetrisGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTetrisGameActionPerformed(evt);
            }
        });

        jBSnakeGame.setBackground(new java.awt.Color(0, 0, 0));
        jBSnakeGame.setFont(new java.awt.Font("KenVector Future Thin", 1, 18)); // NOI18N
        jBSnakeGame.setForeground(new java.awt.Color(255, 255, 255));
        jBSnakeGame.setText("Snake Game");
        jBSnakeGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSnakeGameActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asteroid/Figure/IconFacade/snail.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asteroid/Figure/IconFacade/tetris.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asteroid/Figure/IconFacade/asteroids.jpg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asteroid/Figure/IconFacade/snake.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("KenVector Future Thin", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("My Games");

        jBExit.setBackground(new java.awt.Color(0, 0, 0));
        jBExit.setFont(new java.awt.Font("KenVector Future Thin", 1, 24)); // NOI18N
        jBExit.setForeground(new java.awt.Color(255, 255, 255));
        jBExit.setText("X");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBackGroudLayout = new javax.swing.GroupLayout(jPBackGroud);
        jPBackGroud.setLayout(jPBackGroudLayout);
        jPBackGroudLayout.setHorizontalGroup(
            jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackGroudLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255)
                .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBackGroudLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jBAsteroidGame, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jBSnailGame, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPBackGroudLayout.createSequentialGroup()
                        .addComponent(jBTetrisGame, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSnakeGame, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPBackGroudLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40))))
        );
        jPBackGroudLayout.setVerticalGroup(
            jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBackGroudLayout.createSequentialGroup()
                .addGroup(jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBackGroudLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBackGroudLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBackGroudLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBackGroudLayout.createSequentialGroup()
                        .addGroup(jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)))
                .addGroup(jPBackGroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTetrisGame, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSnakeGame, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSnailGame, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAsteroidGame, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBackGroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBackGroud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAsteroidGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAsteroidGameActionPerformed
        asteroidGame = new AsteroidGame();
        asteroidGame.showWindow();
        this.setVisible(false);
    }//GEN-LAST:event_jBAsteroidGameActionPerformed

    private void jBSnakeGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSnakeGameActionPerformed
        snakeGame = new Game();
        snakeGame.startGame();
        this.setVisible(false);
    }//GEN-LAST:event_jBSnakeGameActionPerformed

    private void jBSnailGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSnailGameActionPerformed
        /*snailGame = new SnailGame();
        snailGame.showWindow();
        this.setVisible(false);*/

    }//GEN-LAST:event_jBSnailGameActionPerformed

    private void jBTetrisGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTetrisGameActionPerformed
        tetris = new TetrisMenu();
        tetris.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBTetrisGameActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed

        try {
            ArrayList<User> dataList = JSONParser.readField();
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).getCurrentActive() == 1) {
                    dataList.get(i).setCurrentActive(0);
                }
            }
            JSONParser.writeFile(dataList);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CheckFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CheckFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);

    }//GEN-LAST:event_jBExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckFacade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckFacade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckFacade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckFacade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckFacade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAsteroidGame;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBSnailGame;
    private javax.swing.JButton jBSnakeGame;
    private javax.swing.JButton jBTetrisGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPBackGroud;
    // End of variables declaration//GEN-END:variables
}
