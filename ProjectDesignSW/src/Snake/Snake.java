package Snake;

import Asteroid.IO.JSONParser;
import Login.User;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Snake extends Entity {

    Dead dead = new Dead();
    ArrayList<Point> snake;
    int point;
    int lifeSn = 0;
    PointerInfo a = MouseInfo.getPointerInfo();

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
            generate();
            board.enemy.generate();
            checkOutOfBorder();
            drop();
        }
    }

    @Override
    public void generate() {
        a = MouseInfo.getPointerInfo();
        Point p = a.getLocation();
        Point last = snake.get(snake.size() - 1);
        Point n = new Point();
        //showLocationHead(last); 
        move(snake, last, p, n);
    }

    @Override
    public boolean drop() {
        boolean state = false;
        if (crash.checkSnakeCrash(snake, board.enemy.getEnemy()) == true) {
            for (int i = 0; i < snake.size(); i++) {
                Point dead = new Point();
                dead = snake.get(i);
                board.food.food.add(dead);
            }
            lifeSn++;
            board.settLbel(lifeSn + "X");
            //dead.setVisible(true);
            //this.stop();
            snake.clear();
            size = 10;
            snake.add(new Point(r.nextInt(900), r.nextInt(900)));
        }

        if (crash.checkEnemyCrash(snake, board.enemy.getEnemy()) == true) {
            for (int i = 0; i < board.enemy.enemy.size(); i++) {
                Point dead = new Point();
                dead = board.enemy.enemy.get(i);
                board.food.food.add(dead);
            }
            board.enemy.lifeEn++;
            board.settLbel2(board.enemy.lifeEn + "X");
            //enemy.stop();
            board.enemy.enemy.clear();
            board.enemy.size = 10;
            board.enemy.enemy.add(new Point(r.nextInt(900), r.nextInt(900)));

        }
        if (lifeSn > 2 || board.enemy.lifeEn > 2) {
            ArrayList<User> dataList = readData();
            int highScore = 0;
            if (this.board.boardGetEnemyScore() > this.board.boardGetSnakeScore()) {
                highScore = this.board.boardGetEnemyScore();
            } else {
                highScore = this.board.boardGetSnakeScore();
            }
            System.out.println(this.board.boardGetEnemyScore());
            System.out.println(this.board.boardGetSnakeScore());
            System.out.println(highScore);
            for (int j = 0; j < dataList.size(); j++) {
                if (dataList.get(j).getCurrentActive() == 1) {

                    if (dataList.get(j).getSnakeGameScore()
                            < highScore) {
                        dataList.get(j).setSnakeGameScore(highScore);
                        dataList.get(j).setDate(setDateNow());
                        writeData(dataList);
                    }
                }
            }
            dead.setVisible(true);
            this.board.dispose();
            this.stop();
        }

        return state;

    }

    public void checkOutOfBorder() {
        if (snake.get(snake.size() - 1).x < 15 || snake.get(snake.size() - 1).y < 44
                || snake.get(snake.size() - 1).x > 996 || snake.get(snake.size() - 1).y > 985) {
            System.exit(0);
        }
    }

    public Color checkSpeed() {
        board.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                    speed = 30;
                    color = Color.RED;
                }
                if (evt.getKeyCode() != KeyEvent.VK_SPACE) {
                    speed = 10;
                    color = Color.BLUE;
                }
            }
        });
        return color;
    }

    public void move(ArrayList b, Point last, Point p, Point n) {
        if (last.distance(p) > 1) {
            n = super.calculateCoord(last, p);
            b.add(n);
            //count++;
            if (b.size() >= size) {
                for (int i = 0; i < b.size() - size; i++) {
                    b.remove(i);
                }
            }
        }
        board.repaint();
        point = super.eatFood(n);
        score.setSnakeScore(point);

    }

    public ArrayList<Point> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<Point> snake) {
        this.snake = snake;
    }

    public ArrayList<User> readData() {
        try {
            return JSONParser.readField();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean writeData(ArrayList<User> dataList) {
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

    public String setDateNow() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }

}
