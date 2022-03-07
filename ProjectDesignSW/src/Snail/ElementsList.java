package Snail;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ElementsList {
    
    private LinkedList <GameElement> lista;
    //private GameElement elemento;

    public ElementsList() {
        lista = new LinkedList<GameElement>();
    }

    public LinkedList<GameElement> getLista() {
        return lista;
    }
    
  

    public void setLista(LinkedList<GameElement> lista) {
        this.lista = lista;
    }
    
    public void agregarElemento (GameElement elemento){
        //this.elemento = elemento;
        lista.add(elemento);
    }
     
    public void eliminarElemento(Position posicion){
        Iterator <GameElement> it = getLista().iterator();
        while(it.hasNext()){
            Position pos = it.next().getPosition();
            if((pos.getX() == posicion.getX()) && (pos.getY() == posicion.getY())){
                it.remove();
            }
        }
    }
    
    
    
    
}
