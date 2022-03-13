package Tetris;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JPanel;
import javax.swing.JLabel;

import Facade.CheckFacade;

public class Tetris extends javax.swing.JFrame {

    JButton[][] matrixes = new JButton[3][3];//Game 1
    JButton[][] matrixes1 = new JButton[3][3];
    JButton[][] matrixes2 = new JButton[3][3];//Game 2
    JButton[][] matrixes12 = new JButton[3][3];
    Figure figure1;
    Manager manager1 = new Manager();
    Manager manager2 = new Manager();

    int numPlayers = 2;

    public Tetris() {
        initComponents();
        this.setLocationRelativeTo(null);

        if (numPlayers == 1) {
            setSize(510, 750);
            jLScore.setText("0.0");

            //Game 1
            Board newBoard = new Board(matrixes, Board1);
            JButton[][] matrix = newBoard.drawB();

            Table newTable = new Table(matrixes1, Table1);
            JButton[][] matrix1 = newTable.drawT();

            manager1.Manager(matrix, matrix1, Table1, jLScore);
        } else {
            jLScore.setText("0.0");
            jLScore2.setText("0.0");

            //Game 1
            Board newBoard = new Board(matrixes, Board1);
            JButton[][] matrix = newBoard.drawB();

            Table newTable = new Table(matrixes1, Table1);
            JButton[][] matrix1 = newTable.drawT();

            //Game 2
            Board newBoard2 = new Board(matrixes2, Board2);
            JButton[][] matrix2 = newBoard2.drawB();

            Table newTable2 = new Table(matrixes12, Table2);
            JButton[][] matrix12 = newTable2.drawT();

            manager1.Manager(matrix, matrix1, Table1, jLScore);
            manager2.Manager(matrix2, matrix12, Table2, jLScore2);
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

        Table1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLScore2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLScore = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        Board1 = new javax.swing.JPanel();
        Board2 = new javax.swing.JPanel();
        Table2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table1.setBackground(new java.awt.Color(204, 0, 204));
        Table1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Table1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 160, 160));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        btnStart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnStartKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Score");

        jLScore2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLScore.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Score");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLScore, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnStart)
                        .addGap(184, 184, 184)
                        .addComponent(btnExit)))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(927, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLScore, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStart)
                            .addComponent(btnExit))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel2)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        Board1.setBackground(new java.awt.Color(255, 200, 236));
        Board1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Board1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 320, 610));

        Board2.setBackground(new java.awt.Color(255, 200, 236));
        Board2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Board2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 320, 610));

        Table2.setBackground(new java.awt.Color(204, 0, 204));
        Table2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Table2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 160, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnStartKeyPressed
        manager1.movementsControl(evt);
        manager2.movementsControl2(evt);
    }//GEN-LAST:event_btnStartKeyPressed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

        Board1.removeAll();//Gamer1
        Board2.removeAll();//Gamer2

        Table1.removeAll();//Gamer1
        Table2.removeAll();//Gamer2

        if (numPlayers == 1) {
            setSize(510, 750);
            jLScore.setText("0.0");

            //Game 1
            Board newBoard = new Board(matrixes, Board1);
            JButton[][] matrix = newBoard.drawB();

            Table newTable = new Table(matrixes1, Table1);
            JButton[][] matrix1 = newTable.drawT();

            manager1.start(matrix, matrix1, Table1, jLScore);
        } else {
            jLScore.setText("0.0");
            jLScore2.setText("0.0");

            //Game 1
            Board newBoard = new Board(matrixes, Board1);
            JButton[][] matrix = newBoard.drawB();

            Table newTable = new Table(matrixes1, Table1);
            JButton[][] matrix1 = newTable.drawT();

            //Game 2
            Board newBoard2 = new Board(matrixes2, Board2);
            JButton[][] matrix2 = newBoard2.drawB();

            Table newTable2 = new Table(matrixes12, Table2);
            JButton[][] matrix12 = newTable2.drawT();

            manager1.start(matrix, matrix1, Table1, jLScore);
            manager2.start(matrix2, matrix12, Table2, jLScore2);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CheckFacade newFacade = new CheckFacade();
        newFacade.setVisible(true);

    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tetris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Board1;
    private javax.swing.JPanel Board2;
    private javax.swing.JPanel Table1;
    private javax.swing.JPanel Table2;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLScore;
    private javax.swing.JLabel jLScore2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
