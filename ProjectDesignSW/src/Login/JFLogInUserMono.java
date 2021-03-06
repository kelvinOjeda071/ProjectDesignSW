/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login;

import Asteroid.IO.JSONParser;
import Facade.CheckFacade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KelvinOjeda
 */
public class JFLogInUserMono extends javax.swing.JFrame {

    /**
     * Creates new form JFLogInUserMono
     */
    private User user;

    public JFLogInUserMono() {

        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        user = new User();
    }

    public void setEmptyLabels() {
        this.jTFId.setText("");
        this.jTFPassword.setText("");
    }

    public void logInMonoPlayer() {
        String id = this.jTFId.getText();
        String password = this.jTFPassword.getText();
        if (password.equals("") || id.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the fields correctly");
        } else {
            ArrayList<User> dataList = readData();
            boolean isFound[] = new boolean[2];

            for (int i = 0; i < dataList.size(); i++) {

                if (id.equals(dataList.get(i).getId())) {
                    isFound[0] = true;
                    if (password.equals(dataList.get(i).getPassword())) {
                            this.user = dataList.get(i);
                            dataList.get(i).setCurrentActive(1);
                            writeData(dataList);
                            isFound[1] = true;
                            JOptionPane.showMessageDialog(null, "Your "
                                    + "credentials are correct");
                            new CheckFacade().setVisible(true);
                            this.dispose();
                            i = dataList.size();
                    } else {
                        JOptionPane.showMessageDialog(null, "The username "
                                + "or password is wrong");
                        setEmptyLabels();

                    }

                }

            }
            if (isFound[0] == false && isFound[1] == false) {
                JOptionPane.showMessageDialog(null, "The user does not exist yet");
            }

        }
    }

    public void switchLogInMultiPlayer() {
        new JFLogInMultiUser().setVisible(true);
        this.dispose();
    }

    public void switchSignIn() {
        new JFSignInUser().setVisible(true);
        this.dispose();
    }

    private ArrayList<User> readData() {
        try {
            return JSONParser.readField();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    private boolean writeData(ArrayList<User> dataList) {
        boolean isWrited = false;
        try {
            JSONParser.writeFile(dataList);
            isWrited = true;

        } catch (IOException ex) {
            System.out.println(ex);
            isWrited = false;
        }
        return isWrited;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFId = new javax.swing.JTextField();
        jTFPassword = new javax.swing.JPasswordField();
        jBSignIn = new javax.swing.JButton();
        jBLogIn = new javax.swing.JButton();
        jBExit = new javax.swing.JButton();
        jBLogInMultiPlayer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asteroid/Figure/Login/login.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password:");

        jTFId.setBackground(new java.awt.Color(0, 0, 0));
        jTFId.setFont(new java.awt.Font("KenVector Future Thin", 0, 12)); // NOI18N
        jTFId.setForeground(new java.awt.Color(255, 255, 255));
        jTFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdActionPerformed(evt);
            }
        });

        jTFPassword.setBackground(new java.awt.Color(0, 0, 0));
        jTFPassword.setFont(new java.awt.Font("KenVector Future Thin", 0, 12)); // NOI18N
        jTFPassword.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFId)
                            .addComponent(jTFPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jBSignIn.setBackground(new java.awt.Color(0, 0, 0));
        jBSignIn.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jBSignIn.setForeground(new java.awt.Color(255, 255, 255));
        jBSignIn.setText("Sign in");
        jBSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSignInActionPerformed(evt);
            }
        });

        jBLogIn.setBackground(new java.awt.Color(255, 255, 255));
        jBLogIn.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jBLogIn.setForeground(new java.awt.Color(0, 0, 0));
        jBLogIn.setText("Log in");
        jBLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogInActionPerformed(evt);
            }
        });

        jBExit.setBackground(new java.awt.Color(0, 0, 0));
        jBExit.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jBExit.setForeground(new java.awt.Color(255, 255, 255));
        jBExit.setText("X");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        jBLogInMultiPlayer.setBackground(new java.awt.Color(255, 255, 255));
        jBLogInMultiPlayer.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jBLogInMultiPlayer.setForeground(new java.awt.Color(0, 0, 0));
        jBLogInMultiPlayer.setText("Log in two Players");
        jBLogInMultiPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogInMultiPlayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBExit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jBSignIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBLogInMultiPlayer)
                        .addGap(18, 18, 18)
                        .addComponent(jBLogIn)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jBExit)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLogIn)
                    .addComponent(jBSignIn)
                    .addComponent(jBLogInMultiPlayer))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogInActionPerformed
        logInMonoPlayer();
    }//GEN-LAST:event_jBLogInActionPerformed

    private void jBSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSignInActionPerformed
        this.switchSignIn();
    }//GEN-LAST:event_jBSignInActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBExitActionPerformed

    private void jTFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdActionPerformed

    private void jBLogInMultiPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogInMultiPlayerActionPerformed
        switchLogInMultiPlayer();
    }//GEN-LAST:event_jBLogInMultiPlayerActionPerformed

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
            java.util.logging.Logger.getLogger(JFLogInUserMono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogInUserMono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogInUserMono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogInUserMono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLogInUserMono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBLogIn;
    private javax.swing.JButton jBLogInMultiPlayer;
    private javax.swing.JButton jBSignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFId;
    private javax.swing.JPasswordField jTFPassword;
    // End of variables declaration//GEN-END:variables
}
