package Asteroid.GameObjects;

import java.util.ArrayList;

/**
 *
 * @author KelvinOjeda
 */
public class ArrayListPlayer {

    private Player player;
    ArrayList<Player> arrayListPlayer;

    public ArrayListPlayer() {
        this.arrayListPlayer = new ArrayList<>();
    }

    public void add(Player player) {
        this.arrayListPlayer.add(player);
    }
    
    public void remove(Player player){
        this.arrayListPlayer.remove(player);
    }

}
