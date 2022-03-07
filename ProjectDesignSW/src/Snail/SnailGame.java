package Snail;

import Snail.Input.Keyboard;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.IOException;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class SnailGame extends JFrame {

    private boolean state;
    //private Player jugador;
    private Escene nivel;
    private Keyboard keyboard;
    private Collision colision;
    private float t0;
    private float tf;

    public SnailGame() {
        keyboard = new Keyboard();
        //startGame();
    }

    public void startGame() {
        Position posicionCaracol = new Position(1, 1);
        Position posicionPlataforma1 = new Position(0, 150);
        Position posicionPlataforma2 = new Position(500, 400);
        Position posicionPuerta1 = new Position(400, 1);
        Position positionEnemy = new Position(180, 0);
        Position positionButon = new Position(300, 140);
        Position positionPortal = new Position(900, 340);

        this.setTitle("Snail");

        Snail caracol = new Snail(posicionCaracol, 100, 100);
        Obstacle plataforma1 = new Obstacle(0, posicionPlataforma1, 400, 50);
        Obstacle plataforma2 = new Obstacle(0, posicionPlataforma2, 400, 50);
        Obstacle puerta1 = new Obstacle(1, posicionPuerta1, 50, 200);
        Button boton1 = new Button(positionButon, 10, 10, puerta1);
        Enemy enemy = new Enemy(positionEnemy, 80, 80);
        Portal portal = new Portal(positionPortal, 100, 100);

        ElementsList lista = new ElementsList();
        lista.agregarElemento(caracol);
        lista.agregarElemento(plataforma1);
        lista.agregarElemento(plataforma2);
        lista.agregarElemento(enemy);
        lista.agregarElemento(boton1);
        lista.agregarElemento(portal);
        lista.agregarElemento(puerta1);

        //this.keyboard = new Keyboard();
        nivel = new Escene(lista);

        nivel.addKeyListener(keyboard);
        this.state = true;
        this.add(nivel);
        this.setSize(1200, 800);
        this.setVisible(state);
        this.setLocation(100, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.nivel.update();
        keyboard.update();
        this.repaint();
        boton1.activate(caracol);

        while (state) {
            this.run(boton1, caracol, lista, enemy, portal);
            break;
        }
        
        //t0 = System.nanoTime();
        //System.out.print("TIEMPO INICIAL" + t0);
        /*while (state) 
        {
        
        this.nivel.update();
        keyboard.update();
        this.repaint();
        boton1.activate(caracol);
        
        for(int i = 1; i<lista.getLista().size(); i++){
            GameElement element = lista.getLista().get(i);
            colision = new Collision(caracol, element);
            colision.checkCollision();
        }

        if((enemy.attackSnail(caracol) == false)||(portal.notifyEnd(caracol) == false)){
            
            //tf =System.nanoTime();
            //System.out.print("TIEMPO FINAL" + tf);
            state = false;
            
            
        } 
        
        Thread.sleep(10);
        
        checkState();
        

        }*/
    }

    public void run(Button boton1, Snail caracol, ElementsList lista, Enemy enemy, Portal portal) {

        for (int i = 1; i < lista.getLista().size(); i++) {
            GameElement element = lista.getLista().get(i);
            colision = new Collision(caracol, element);
            colision.checkCollision();
        }

        if ((enemy.attackSnail(caracol) == false) || (portal.notifyEnd(caracol) == false)) {

            //tf =System.nanoTime();
            //System.out.print("TIEMPO FINAL" + tf);
            state = false;
        }

        try {
            Thread.sleep(10);

        } catch (InterruptedException ex) {
            Logger.getLogger(SnailGame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void endGame(boolean state) {
        if (state == false) {
            int punctuation = (int) ((tf - t0) / 1000);
            JOptionPane.showMessageDialog(null, "Tu puntuación: " + punctuation + "\nTIEMPO FINAL: " + tf
                    + "\nTIEMPO INICIAL: " + t0, "GAME OVER", 1);

            exitMenu();
        }
    }

    public void checkState() {
        endGame(this.state);
        startGame();
    }

    public void exitMenu() {
        this.setVisible(false);

    }

}
