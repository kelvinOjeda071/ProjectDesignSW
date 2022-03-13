package Snake;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Enemy extends Entity {

    ArrayList<Point> enemy;
    int point;
    PointerInfo a = MouseInfo.getPointerInfo();
    int lifeEn=0;
    Point last;
    Point newPoint;

    public Enemy() {
        color = Color.ORANGE;
    }

    @Override
    public void run() {
        crash = new Crash();
        score = new Score();
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void generate() {

        a = MouseInfo.getPointerInfo();
        Point lastEn = enemy.get(enemy.size() - 1);
        Point pEn = new Point(r.nextInt(900), r.nextInt(900));
        //Point pEn= a.getLocation();
        /*pEn.x+=Math.random()*(-50-500);
        pEn.y+=Math.random()*(-50-500);*/
        Point nEn = new Point();
        move(enemy, lastEn, pEn, nEn);
        //keyPressed();
    }

    public Color checkSpeed() {
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_E) {
                    speed = 30;
                    color = Color.RED;
                }
                if (evt.getKeyCode() != KeyEvent.VK_E) {
                    speed = 10;
                    color = Color.ORANGE;
                }
            }
        });
        return color;
    }

    public Point keyPressed() {
        //int key = e.getKeyCode();
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt2) {
                evt2.setKeyCode(KeyEvent.VK_LEFT);
                if ((evt2.getKeyCode() == KeyEvent.VK_LEFT)) {
                    last = enemy.get(enemy.size() - 1);
                    newPoint = new Point(last.x - 50, last.y);
                    System.out.println("left");
                } else {
                    newPoint = new Point(8, 8);
                }

                /*
            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }*/
            }
        });
        return newPoint;
    }

    public Point getPoint() {
        int index = (int) (Math.random() * (enemy.size() - 1));

        Point p = board.food.food.get(index);
        return p;
    }

    public void move(ArrayList b, Point last, Point p, Point n) {
        if (last.distance(p) > 1) {
            n = super.calculateCoord(last, p);
            b.add(n);
            if (b.size() >= size) {
                for (int i = 0; i < b.size() - size; i++) {
                    b.remove(i);
                }
            }
        }
        board.repaint();
        point = super.eatFood(n);
        score.setEnemyScore(point);
    }

    public boolean drop() {
        if (crash.checkEnemyCrash(board.snake.getSnake(), enemy) == true) {
            for (int i = 0; i < enemy.size(); i++) {
                Point dead = new Point();
                dead = enemy.get(i);
                board.food.food.add(dead);
            }
            enemy.clear();
            size = 10;
            enemy.add(new Point(r.nextInt(900), r.nextInt(900)));
        }
        return true;
    }

    public ArrayList<Point> getEnemy() {
        return enemy;
    }

    public void setEnemy(ArrayList<Point> enemy) {
        this.enemy = enemy;
    }
}
