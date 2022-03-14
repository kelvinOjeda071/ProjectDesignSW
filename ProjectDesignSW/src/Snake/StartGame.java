/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import Facade.CheckFacade;
import java.awt.Color;

public class StartGame extends javax.swing.JFrame {
    Game game;
    public StartGame() {
        initComponents();
        game = new Game();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPlay1 = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnPlay2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHOQUE");
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPlay1.setBackground(Color.BLUE);
        btnPlay1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnPlay1.setForeground(new java.awt.Color(204, 204, 204));
        btnPlay1.setText("Review Scores");
        btnPlay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlay1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlay1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPlay1none(evt);
            }
        });
        btnPlay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlay1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 200, -1));

        btnPlay.setBackground(Color.BLUE);
        btnPlay.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(204, 204, 204));
        btnPlay.setText("Play");
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                none(evt);
            }
        });
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 70, 130, -1));

        btnPlay2.setBackground(Color.BLUE);
        btnPlay2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnPlay2.setForeground(new java.awt.Color(204, 204, 204));
        btnPlay2.setText("Return");
        btnPlay2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlay2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlay2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPlay2none(evt);
            }
        });
        btnPlay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlay2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 200, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/slither.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 279));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        game = new Game();
        game.startGame();
        this.setVisible(false);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void none(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
        
    }//GEN-LAST:event_none

    private void btnPlayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseEntered
        // TODO add your handling code here:
        btnPlay.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnPlayMouseEntered

    private void btnPlayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseExited
        // TODO add your handling code here:
        btnPlay.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnPlayMouseExited

    private void btnPlay1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlay1MouseEntered
        // TODO add your handling code here:
        btnPlay1.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnPlay1MouseEntered

    private void btnPlay1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlay1MouseExited
        // TODO add your handling code here:
        btnPlay1.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnPlay1MouseExited

    private void btnPlay1none(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlay1none
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlay1none

    private void btnPlay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlay1ActionPerformed
        ScoreView sc = new ScoreView();
        sc.setVisible(true);
    }//GEN-LAST:event_btnPlay1ActionPerformed

    private void btnPlay2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlay2MouseEntered
        // TODO add your handling code here:
        btnPlay2.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnPlay2MouseEntered

    private void btnPlay2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlay2MouseExited
        // TODO add your handling code here:
        btnPlay1.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnPlay2MouseExited

    private void btnPlay2none(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlay2none
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlay2none

    private void btnPlay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlay2ActionPerformed
        new CheckFacade().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPlay2ActionPerformed

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
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnPlay1;
    private javax.swing.JButton btnPlay2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
