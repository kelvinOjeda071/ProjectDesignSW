package Snail;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bryan
 */
public class Scene extends JPanel {

    private Image image;
    ElementsList list;
    GameElement element;

    public Scene() {
    }

    public Scene(String background) {
        if (background != null) {

        } else {
            image = null;
        }

        repaint();

    }

    public Scene(ElementsList list) {
        this.list = list;
        setFocusable(true);

    }

    void update() {
        GameElement gameElement;
        for (int i = 0; i < list.getList().size(); i++) {
            gameElement = list.getList().get(i);
            gameElement.move();
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        image = new ImageIcon(getClass().getResource("/SnailImages/background.jpg")).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        GameElement gameElement;
        for (int i = 0; i < list.getList().size(); i++) {
            gameElement = list.getList().get(i);
            gameElement.draw(g, gameElement.getHeight(), gameElement.getWidth());
            gameElement = null;

        }
    }

}
