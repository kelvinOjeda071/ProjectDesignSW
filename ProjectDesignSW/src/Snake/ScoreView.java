package Snake;

import javax.swing.JButton;
import javax.swing.JFrame;

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
