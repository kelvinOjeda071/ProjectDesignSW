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
    
    private LinkedList <GameElement> list;
    //private GameElement elemento;

    public ElementsList() {
        list = new LinkedList<GameElement>();
    }

    public LinkedList<GameElement> getLista() {
        return list;
    }
    
  

    public void setLista(LinkedList<GameElement> list) {
        this.list = list;
    }
    
    public void addElement (GameElement element){
        //this.elemento = elemento;
        list.add(element);
    }
     
    public void deleteElement(Position position){
        Iterator <GameElement> it = getLista().iterator();
        while(it.hasNext()){
            Position pos = it.next().getPosition();
            if((pos.getX() == position.getX()) && (pos.getY() == position.getY())){
                it.remove();
            }
        }
    }
    
    
    
    
}
