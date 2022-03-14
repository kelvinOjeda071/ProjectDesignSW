/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Snail;

import javax.swing.JFrame;

public final class GameLevel {

    Scene scene;

    public GameLevel(JFrame frame, boolean mode) {
        generateObjects(frame, mode);
        scene.setFocusable(true);

    }

    public Scene getScene() {
        return scene;
    }

    public void generateObjects(JFrame frame, boolean mode) {

        ElementsList list = new ElementsList();

        if (mode == true) {
            Position positionSnail1 = new Position(1, 1);
            Snail snail1 = new Snail(positionSnail1, 75, 75, 0);
            list.addElement(snail1);
            
            Position positionPlataform1 = new Position(0, 150);
            Position positionPlataform2 = new Position(600, 400);
            Position positionPlataform3 = new Position(850, 150);
            Position positionPlataform4 = new Position(0, 400);
            Position positionPlataform5 = new Position(0, 620);
            Position positionBox1 = new Position(1040, 0);
            Position positionBox2 = new Position(890, 0);
            Position positionBox3 = new Position(0, 250);
            Position positionBox4 = new Position(150, 250);
            Position positionDoor1 = new Position(550, 0);
            Position positionDoor2 = new Position(875, 190);
            Position positionEnemy1 = new Position(250, 0);
            Position positionEnemy2 = new Position(950, 200);
            Position positionEnemy3 = new Position(300, 450);
            Position positionEnemy4 = new Position(150, 450);
            Position positionEnemy5 = new Position(840, 450);
            Position positionButton1 = new Position(450, 140);
            Position positionButton2 = new Position(790, 390);
            Position positionStar1Type1 = new Position(1100, 360);
            Position positionStar2Type1 = new Position(25, 550);
            Position positionStar3Type1 = new Position(1000, 550);

            Position positionPortal = new Position(1025, 475);

            Obstacle plataform1 = new Obstacle(0, positionPlataform1, 600, 40);
            Obstacle plataform2 = new Obstacle(0, positionPlataform2, 600, 40);
            Obstacle plataform3 = new Obstacle(0, positionPlataform3, 350, 40);
            Obstacle plataform4 = new Obstacle(0, positionPlataform4, 350, 40);
            Obstacle plataform5 = new Obstacle(0, positionPlataform5, 1200, 40);
            Obstacle box1 = new Obstacle(2, positionBox1, 150, 150);
            Obstacle box2 = new Obstacle(2, positionBox2, 150, 150);
            Obstacle box3 = new Obstacle(2, positionBox3, 150, 150);
            Obstacle box4 = new Obstacle(2, positionBox4, 150, 150);
            Obstacle door1 = new Obstacle(1, positionDoor1, 50, 150);
            Obstacle door2 = new Obstacle(1, positionDoor2, 50, 210);
            Button button1 = new Button(positionButton1, 30, 20, door1);
            Button button2 = new Button(positionButton2, 30, 20, door2);
            Enemy enemy1 = new Enemy(positionEnemy1, 50, 30);
            Enemy enemy2 = new Enemy(positionEnemy2, 50, 30);
            Enemy enemy3 = new Enemy(positionEnemy3, 50, 30);
            Enemy enemy4 = new Enemy(positionEnemy4, 50, 30);
            Enemy enemy5 = new Enemy(positionEnemy5, 50, 30);
            Star star1Type1 = new Star(positionStar1Type1, 40, 40, 0);
            Star star2Type1 = new Star(positionStar2Type1, 40, 40, 0);
            Star star3Type1 = new Star(positionStar3Type1, 40, 40, 0);
            Portal portal = new Portal(positionPortal, 150, 150);

            list.addElement(plataform1);
            list.addElement(plataform2);
            list.addElement(plataform3);
            list.addElement(plataform4);
            list.addElement(plataform5);
            list.addElement(box1);
            list.addElement(box2);
            list.addElement(box3);
            list.addElement(box4);
            list.addElement(enemy1);
            list.addElement(enemy2);
            list.addElement(enemy3);
            list.addElement(enemy4);
            list.addElement(enemy5);
            list.addElement(button1);
            list.addElement(button2);
            list.addElement(portal);
            list.addElement(door1);
            list.addElement(door2);
            list.addElement(star1Type1);
            list.addElement(star2Type1);
            list.addElement(star3Type1);
            
        } else {
            Position positionSnail1 = new Position(1, 1);
            Position positionSnail2 = new Position(1100, 150);
            Position positionStar1Type1 = new Position(1100, 330);
            Position positionStar2Type1 = new Position(25, 520);
            Position positionStar3Type1 = new Position(1000, 520);
            Position positionStar1Type2 = new Position(1100, 360);
            Position positionStar2Type2 = new Position(25, 550);
            Position positionStar3Type2 = new Position(1000, 550);            
            Position positionPlataform1 = new Position(0, 150);
            Position positionPlataform2 = new Position(500, 400);
            Position positionPlataform3 = new Position(700, 150);
            Position positionPlataform4 = new Position(0, 400);
            Position positionPlataform5 = new Position(0, 620);
            Position positionBox3 = new Position(0, 250);
            Position positionBox4 = new Position(150, 250);
            Position positionDoor1 = new Position(450, 0);
            Position positionDoor2 = new Position(875, 190);
            Position positionDoor3 = new Position(700, 0);
            Position positionEnemy1 = new Position(220, 0);
            Position positionEnemy2 = new Position(950, 200);
            Position positionEnemy3 = new Position(300, 450);
            Position positionEnemy4 = new Position(150, 450);
            Position positionEnemy5 = new Position(840, 450);
            Position positionEnemy6 = new Position(940, 0);
            Position positionButton1 = new Position(350, 140);
            Position positionButton2 = new Position(790, 390);
            Position positionButton3 = new Position(840, 140);            
            Position positionPortal = new Position(1025, 475);

            Snail snail1 = new Snail(positionSnail1, 75, 75, 0);
            Snail snail2 = new Snail(positionSnail2, 75, 75, 1);        
            
            Obstacle plataform1 = new Obstacle(0, positionPlataform1, 500, 40);
            Obstacle plataform2 = new Obstacle(0, positionPlataform2, 700, 40);
            Obstacle plataform3 = new Obstacle(0, positionPlataform3, 500, 40);
            Obstacle plataform4 = new Obstacle(0, positionPlataform4, 350, 40);
            Obstacle plataform5 = new Obstacle(0, positionPlataform5, 1200, 40);
            Obstacle box3 = new Obstacle(2, positionBox3, 150, 150);
            Obstacle box4 = new Obstacle(2, positionBox4, 150, 150);
            Obstacle door1 = new Obstacle(1, positionDoor1, 50, 150);
            Obstacle door2 = new Obstacle(1, positionDoor2, 50, 210);
            Obstacle door3 = new Obstacle(1, positionDoor3, 50, 150);
            Button button1 = new Button(positionButton1, 30, 20, door1);
            Button button2 = new Button(positionButton2, 30, 20, door2);
            Button button3 = new Button(positionButton3, 30, 20, door3);
            Enemy enemy1 = new Enemy(positionEnemy1, 50, 30);
            Enemy enemy2 = new Enemy(positionEnemy2, 50, 30);
            Enemy enemy3 = new Enemy(positionEnemy3, 50, 30);
            Enemy enemy4 = new Enemy(positionEnemy4, 50, 30);
            Enemy enemy5 = new Enemy(positionEnemy5, 50, 30);
            Enemy enemy6 = new Enemy(positionEnemy6, 50, 30);
            Star star1Type1 = new Star(positionStar1Type1, 40, 40, 0);
            Star star2Type1 = new Star(positionStar2Type1, 40, 40, 0);
            Star star3Type1 = new Star(positionStar3Type1, 40, 40, 0);
            Portal portal = new Portal(positionPortal, 150, 150);
            Star star1Type2 = new Star(positionStar1Type2, 40, 40, 1);
            Star star2Type2 = new Star(positionStar2Type2, 40, 40, 1);
            Star star3Type2 = new Star(positionStar3Type2, 40, 40, 1);

            list.addElement(snail1);
            list.addElement(snail2);
            list.addElement(star1Type2);
            list.addElement(star2Type2);
            list.addElement(star3Type2);
            list.addElement(plataform1);
            list.addElement(plataform2);
            list.addElement(plataform3);
            list.addElement(plataform4);
            list.addElement(plataform5);
            list.addElement(box3);
            list.addElement(box4);
            list.addElement(enemy1);
            list.addElement(enemy2);
            list.addElement(enemy3);
            list.addElement(enemy4);
            list.addElement(enemy5);
            list.addElement(enemy6);
            list.addElement(button1);
            list.addElement(button2);
            list.addElement(button3);
            list.addElement(portal);
            list.addElement(door1);
            list.addElement(door2);
            list.addElement(door3);
            list.addElement(star1Type1);
            list.addElement(star2Type1);
            list.addElement(star3Type1);

        }
        
        scene = new Scene(list);
    }

    public boolean checkInteractions() {
        ElementsList list = scene.list;
        GameElement elementA;
        GameElement elementB;
        Snail snail;
        Portal portal;
        Button button;
        Collision collision;
        //int contDie = 0;
        for (int i = 0; i < list.getList().size(); i++) {
            elementA = list.getList().get(i);
            for (int j = list.getList().size() - 1; j >= 0; j--) {
                elementB = list.getList().get(j);
                if (elementA.typeObject == 0) {
                    snail = (Snail) elementA;

                    collision = new Collision(snail, elementB);
                    collision.checkCollision();

                    /* if (elementB.typeObject == 4) {
                        enemy = (Enemy) elementB;
                        contDie = enemy.attackSnail(snail, contDie);
                        System.out.println("CONTDIE DE GAMELEVEL " + contDie);
                        if (enemy.attackSnail(snail, contDie) == 2) {
                            return false;
                        } 
                    }*/
                    if (elementB.typeObject == 5) {
                        portal = (Portal) elementB;
                        if (portal.notifyEnd(snail) == false) {
                            return false;
                        }
                    }

                    if (elementB.typeObject == 2) {
                        button = (Button) elementB;
                        button.activate(snail);
                    }
                }

            }

        }

        return true;
    }

    public int checkRecollection(int score0) {
        ElementsList list = scene.list;
        GameElement elementA;
        GameElement elementB;
        Snail snail;
        Star star;
        //int scoref = 0;

        for (int i = 0; i < list.getList().size(); i++) {
            elementA = list.getList().get(i);
            for (int j = list.getList().size() - 1; j >= 0; j--) {
                elementB = list.getList().get(j);
                if (elementA.typeObject == 0) {
                    snail = (Snail) elementA;
                    if (elementB.typeObject == 6) {
                        star = (Star) elementB;
                        score0 = star.confirmRecollection(snail, score0);
                    }
                }

            }

        }

        //System.out.println("SCORE DE GAMELEVEL " + score0);
        return score0;

    }

    public int checkDie(int contDie0) {
        ElementsList list = scene.list;
        GameElement elementA;
        GameElement elementB;
        Snail snail;
        Enemy enemy;
        //int scoref = 0;

        for (int i = 0; i < list.getList().size(); i++) {
            elementA = list.getList().get(i);
            for (int j = list.getList().size() - 1; j >= 0; j--) {
                elementB = list.getList().get(j);
                if (elementA.typeObject == 0) {
                    snail = (Snail) elementA;
                    if (elementB.typeObject == 4) {
                        enemy = (Enemy) elementB;
                        contDie0 = enemy.attackSnail(snail, contDie0);
                    }
                }

            }

        }

        return contDie0;

    }

}
