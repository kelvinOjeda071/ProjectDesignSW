
package Asteroid.GameObjects;

import java.util.ArrayList;

/**
 *
 * @author KelvinOjeda
 */
public class ArrayListMovingObject {
    private MovingObject movingObject;
    private ArrayList<MovingObject> arrayListMovingObeject;

    public ArrayListMovingObject() {
        this.arrayListMovingObeject = new ArrayList <>();
    }
    public void add(MovingObject movingObject){
        this.arrayListMovingObeject.add(movingObject);
    }
    
    public void remove(MovingObject movingObject){
        this.arrayListMovingObeject.remove(movingObject);
    }
    
    public int size(){
        return arrayListMovingObeject.size();
    }
    
    public MovingObject get(int i){
        return this.arrayListMovingObeject.get(i);
    }
    
    public boolean contains(MovingObject movingObject){
        return this.arrayListMovingObeject.contains(movingObject);
    }
    
}
