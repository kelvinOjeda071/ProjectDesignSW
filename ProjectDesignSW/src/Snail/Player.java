package Snail;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Player {
    private String nombre;
    private int puntaje;

    public Player(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    
    public void updateScore(String nombre, int newPuntaje){
        this.nombre = nombre;
        this.puntaje = newPuntaje;
    }
    
}
