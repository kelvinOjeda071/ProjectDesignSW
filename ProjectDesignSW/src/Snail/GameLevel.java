/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Snail;

import Snail.Input.Keyboard;
import javax.swing.JFrame;

public final class GameLevel {
  
    Scene scene;

    public GameLevel(JFrame frame) {
        generateObjects(frame);
        scene.setFocusable(true);
        
    }
    
    public Scene getScene(){
        return scene;
    }
    
    public void generateObjects(JFrame frame){
        
        Position positionSnail = new Position(1, 1);
        Position positionPlataform1 = new Position(0, 150);
        Position positionPlataform2 = new Position(600, 400);
        Position positionPlataform3 = new Position(850, 150);
        Position positionPlataform4 = new Position(0, 400);
        Position positionPlataform5 = new Position(0, 620);
        Position positionBox1 = new Position(1040, 0);
        Position positionBox2 = new Position(890, 0);
        Position positionBox3 = new Position(0, 250);
        Position positionBox4 = new Position(150,250);
        Position positionDoor1 = new Position(550, 0);
        Position positionDoor2 = new Position(875, 190);
        Position positionEnemy1 = new Position(250, 0);
        Position positionEnemy2 = new Position(950, 200);
        Position positionEnemy3 = new Position(300, 450);
        Position positionEnemy4 = new Position(150, 450);
        Position positionButton1 = new Position(450, 140);
        Position positionButton2 = new Position(790, 390);
        Position positionPortal = new Position(1025, 475);
        Position positionStar1 = new Position(1100, 360);
        Position positionStar2 = new Position(25, 550);
        
        Snail snail = new Snail(positionSnail, 75, 75);
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
        Portal portal = new Portal(positionPortal, 150, 150);
        Star star1 =  new Star(positionStar1, 40, 40);
        Star star2 =  new Star(positionStar2, 40, 40);

        ElementsList list = new ElementsList();
        list.addElement(snail);
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
        list.addElement(button1);
        list.addElement(button2);
        list.addElement(portal);
        list.addElement(door1);
        list.addElement(door2);
        list.addElement(star1);
        list.addElement(star2);
        scene = new Scene(list);
    }
    
    
    public boolean checkInteractions() {
        ElementsList list = scene.list;
        GameElement elementA;
        Snail snail;
        Enemy enemy;
        Portal portal;
        Button button;
        Collision collision;
        for (int i = 1; i < list.getLista().size(); i++) {
            elementA = list.getLista().get(i);
            snail = (Snail) list.getLista().getFirst();
            collision = new Collision(snail, elementA);
            collision.checkCollision();

            if (elementA.tipo == 4) {
                enemy = (Enemy) elementA;
                if (enemy.attackSnail(snail) == false) {
                    return false;
                }
            }

            if (elementA.tipo == 5) {
                portal = (Portal) elementA;
                if (portal.notifyEnd(snail) == false) {
                    return false;
                }
            }

            if (elementA.tipo == 2) {
                button = (Button) elementA;
                button.activate(snail);
            }
        }
        
        return true;
    }
    
    
}
