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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author KelvinOjeda
 */
public class JFSignInUser extends javax.swing.JFrame {

    /**
     * Creates new form JFSingInUser
     */
    private Pattern patterName = Pattern.compile("[a-zA-ZñáéíóúÑÁÉÍÓÚ\\s]{1,25}");
    private Pattern patterId = Pattern.compile("[0-9]{10}");
    private Pattern patterPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-zñáéíóú])(?=.*[A-ZÑÁÉÍÓÚ]).{6,64}$");
    private User user;

    public JFSignInUser() {

        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setEmptyLabels() {
        this.jTFFirstName.setText("");
        this.jTFLastName.setText("");
        this.jTFId.setText("");
        this.jPFPassword.setText("");
        this.jPFReplyPassword.setText("");
    }

    public void switchlogIn() {
        new JFLogInUserMono().setVisible(true);
        this.dispose();
    }

    public void signIn() {
        Matcher matFirstName = this.patterName.matcher(this.jTFFirstName.getText());
        Matcher matLastName = this.patterName.matcher(this.jTFLastName.getText());
        Matcher matId = this.patterId.matcher(this.jTFId.getText());
        Matcher matPassword = this.patterPassword.matcher(
                this.jPFPassword.getText());
        Matcher matReplyPassword = this.patterPassword.matcher(
                this.jPFReplyPassword.getText());
        boolean isFound = false;

        if (matFirstName.matches() && matLastName.matches() && matId.matches()
                && matPassword.matches() && matReplyPassword.matches()) {
            if (this.jPFPassword.getText().equals(jPFReplyPassword.getText())) {
                ArrayList<User> dataList = readData();
                int j = 0;
                for (int i = 0; i < dataList.size(); i++) {
                    if (this.jTFId.getText().equals(dataList.get(i).getId())) {
                        j++;
                        if (j == 1) {
                            JOptionPane.showMessageDialog(null, "The user is"
                                    + " already registered");
                            j = dataList.size();
                            i = j;
                            isFound = true;
                        }
                    }
                }

                if (isFound == false) {

                    this.user = new User(this.jTFFirstName.getText().toUpperCase(),
                            this.jTFLastName.getText().toUpperCase(),
                            this.jTFId.getText(),
                            this.jPFPassword.getText(),
                            0, // Score
                            0 // Current Active
                    );
                    dataList.add(user);

                    writeData(dataList);
                    JOptionPane.showMessageDialog(null, "Successfully"
                            + " registered user");
                    setEmptyLabels();
                    switchlogIn();
                    this.dispose();

                }

            } else {

                JOptionPane.showMessageDialog(null,
                        "Passwords are not the same");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter the fields correctly");
        }

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFFirstName = new javax.swing.JTextField();
        jTFLastName = new javax.swing.JTextField();
        jTFId = new javax.swing.JTextField();
        jPFPassword = new javax.swing.JPasswordField();
        jPFReplyPassword = new javax.swing.JPasswordField();
        jBLogIn = new javax.swing.JButton();
        jBSignIn = new javax.swing.JButton();
        jBExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asteroid/Figure/Login/sign.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("First Name:");

        jLabel3.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name:");

        jLabel4.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ID:");

        jLabel5.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Repeat Password:");

        jLabel6.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Password:");

        jTFFirstName.setBackground(new java.awt.Color(0, 0, 0));
        jTFFirstName.setFont(new java.awt.Font("KenVector Future Thin", 0, 12)); // NOI18N
        jTFFirstName.setForeground(new java.awt.Color(255, 255, 255));
        jTFFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFirstNameActionPerformed(evt);
            }
        });

        jTFLastName.setBackground(new java.awt.Color(0, 0, 0));
        jTFLastName.setFont(new java.awt.Font("KenVector Future Thin", 0, 12)); // NOI18N
        jTFLastName.setForeground(new java.awt.Color(255, 255, 255));
        jTFLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNameActionPerformed(evt);
            }
        });

        jTFId.setBackground(new java.awt.Color(0, 0, 0));
        jTFId.setFont(new java.awt.Font("KenVector Future Thin", 0, 12)); // NOI18N
        jTFId.setForeground(new java.awt.Color(255, 255, 255));
        jTFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdActionPerformed(evt);
            }
        });

        jPFPassword.setBackground(new java.awt.Color(0, 0, 0));
        jPFPassword.setFont(new java.awt.Font("KenVector Future Thin", 0, 12)); // NOI18N
        jPFPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPFPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPFPasswordActionPerformed(evt);
            }
        });

        jPFReplyPassword.setBackground(new java.awt.Color(0, 0, 0));
        jPFReplyPassword.setFont(new java.awt.Font("KenVector Future Thin", 0, 12)); // NOI18N
        jPFReplyPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPFReplyPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPFReplyPasswordActionPerformed(evt);
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

        jBSignIn.setBackground(new java.awt.Color(0, 0, 0));
        jBSignIn.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jBSignIn.setForeground(new java.awt.Color(255, 255, 255));
        jBSignIn.setText("Sign in");
        jBSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSignInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPFPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPFReplyPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBSignIn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBLogIn)))))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPFReplyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLogIn)
                    .addComponent(jBSignIn)))
        );

        jBExit.setBackground(new java.awt.Color(0, 0, 0));
        jBExit.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jBExit.setForeground(new java.awt.Color(255, 255, 255));
        jBExit.setText("X");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBExit))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jBExit)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
    private void jBSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSignInActionPerformed
        this.signIn();
    }//GEN-LAST:event_jBSignInActionPerformed

    private void jBLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogInActionPerformed
        this.switchlogIn();
    }//GEN-LAST:event_jBLogInActionPerformed

    private void jTFFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFFirstNameActionPerformed

    private void jTFLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFLastNameActionPerformed

    private void jTFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdActionPerformed

    private void jPFPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPFPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPFPasswordActionPerformed

    private void jPFReplyPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPFReplyPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPFReplyPasswordActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
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
            java.util.logging.Logger.getLogger(JFSignInUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFSignInUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFSignInUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFSignInUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFSignInUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBLogIn;
    private javax.swing.JButton jBSignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JPasswordField jPFReplyPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFFirstName;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFLastName;
    // End of variables declaration//GEN-END:variables
}
