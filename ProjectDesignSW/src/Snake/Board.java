/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends javax.swing.JFrame{
    Food food;
    Entity entity;
    Snake snake;
    Enemy enemy;
    Image OSC;

    public Board() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 1000, 1000);
        this.setLayout(new FlowLayout());
        this.setBackground(Color.black);//Color Fondo
        this.setVisible(true);
        jP1.setBackground(Color.black);
    }
    
    public void paint(Graphics g) {
        Dimension d = getSize();
        checkOffscreenImage();
        paintOffscreen(OSC.getGraphics(), OSC.getGraphics(), Color.GREEN);//COLOR SERPIENTE
        g.drawImage(OSC, 0, 0, null);
        jLabel1.setText("Score A ---> "+snake.score.getSnakeScore());
        jLabel2.setText("Score B ---> "+enemy.score.getEnemyScore());
        
        jP1.paint(g);
    }
    
    public int boardGetEnemyScore(){
        return enemy.score.getEnemyScore();
        
    }
    
    public int boardGetSnakeScore(){
        return snake.score.getSnakeScore();
    }


    private void checkOffscreenImage() {
        Dimension d = getSize();
        if (OSC == null || OSC.getWidth(null) != d.width
                || OSC.getHeight(null) != d.height) {
            OSC = createImage(d.width, d.height);
        }
    }

    public void paintOffscreen(Graphics gSn, Graphics gEn, Color colorFood) {
        //jPanel2.repaint();
        gSn.clearRect(0, 0, 1000, 1000);
        //snake
        Point first = new Point();
        Point last = snake.snake.get(0);
        gSn.setColor(snake.checkSpeed());

        //enemy.keyPressed();
        
        //enemy
        Point firstEn = new Point();
        Point lastEn = enemy.enemy.get(0);
        gEn.setColor(enemy.checkSpeed());//COLOR ENEMIGO

        Graphics2D g2 = (Graphics2D) gSn;
        Graphics2D g3 = (Graphics2D) gEn;

        g2.setStroke(new BasicStroke(9 + (float) snake.getSnake().size() / 60)); // aumenta el grosor
        g3.setStroke(new BasicStroke(9 + (float) enemy.getEnemy().size() / 20)); // aumenta el grosor
        //snake
        for (int i = 1; i < snake.snake.size(); i++) {
            first = snake.snake.get(i);
            g2.drawLine(first.x, first.y, last.x, last.y);
            last = new Point(first);
        }
        //enemy
        for (int i = 1; i < enemy.enemy.size(); i++) {
            firstEn = enemy.enemy.get(i);
            g3.drawLine(firstEn.x, firstEn.y, lastEn.x, lastEn.y);
            lastEn = new Point(firstEn);
        }

        //comida
        g2.setColor(colorFood);//color de la comida
        for (int i = 0; i < food.food.size(); i++) {
            g2.fillOval(food.food.get(i).x, food.food.get(i).y, 20, 20); //ancho y alto de la comida
        }
    }
    
    
    
    
    public void settLbel( String text){
        jLPlayer1W.setText(text);
    }
    public void settLbel2( String text){
        jLPlayer2W.setText(text);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLPlayer1W = new javax.swing.JLabel();
        jLPlayer2W = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jP1.setForeground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Wide Latin", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Wide Latin", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Press SPACE for increase speed");

        jLabel4.setFont(new java.awt.Font("Wide Latin", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Press CTRL for decrease speed");

        jLPlayer1W.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        jLPlayer1W.setForeground(new java.awt.Color(255, 51, 51));

        jLPlayer2W.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        jLPlayer2W.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jP1Layout = new javax.swing.GroupLayout(jP1);
        jP1.setLayout(jP1Layout);
        jP1Layout.setHorizontalGroup(
            jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(102, 102, 102)
                .addGroup(jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLPlayer2W)
                    .addComponent(jLPlayer1W))
                .addContainerGap(537, Short.MAX_VALUE))
        );
        jP1Layout.setVerticalGroup(
            jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLPlayer1W))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLPlayer2W))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(713, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLPlayer1W;
    private javax.swing.JLabel jLPlayer2W;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jP1;
    // End of variables declaration//GEN-END:variables
}
