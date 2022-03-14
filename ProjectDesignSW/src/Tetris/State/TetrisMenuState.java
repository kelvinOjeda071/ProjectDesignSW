
package Tetris.State;

import Asteroid.GameObjects.Constant;
import Asteroid.Graphics.Asset;
import Asteroid.IO.JSONParser;
import Asteroid.State.GameModeState;
import Asteroid.State.GameState;
import Asteroid.State.MultiplayerState;
import Asteroid.State.ScoreState;
import Asteroid.State.SingleplayerState;
import Asteroid.UI.Action;
import Asteroid.UI.Button;
import Facade.CheckFacade;
import Login.User;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class TetrisMenuState {
    //private ArrayList<Button> buttons;
    public int numPlayers;
    
    public TetrisMenuState() {
        //buttons = new ArrayList<Button>()
    }
    
    public int playerManager(){
        int numberPlayer = 0;
        ArrayList<User> dataList = readData();
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getCurrentActive() == 1) {
                numberPlayer++;
            }
        }
        if (numberPlayer != 1) {
            numPlayers = 2;
            return numPlayers;
        } else {
            numPlayers = 1;
            return numPlayers;
        }  
    }

    public ArrayList<User> readData() {
        try {
            return JSONParser.readField();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
