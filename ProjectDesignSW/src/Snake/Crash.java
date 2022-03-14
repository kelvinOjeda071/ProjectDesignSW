package Snake;

import java.awt.Point;
import java.util.ArrayList;

public class Crash {

    boolean state;

    public Boolean checkEnemyCrash(ArrayList<Point> snk, ArrayList<Point> ene) {
        state = false;
        if (snk.get(snk.size() - 1).distance(ene.get(ene.size() - 1)) < 20) {
            state = true;
        }
        for (int i = 1; i < snk.size(); i++) {
            if (ene.get(ene.size() - 1).distance(snk.get(i)) < 10) {
                state = true;
            }
        }
        return state;
    }

    public Boolean checkSnakeCrash(ArrayList<Point> snk, ArrayList<Point> ene) {
        state = false;
        for (int j = 1; j < ene.size(); j++) {
            if (snk.get(snk.size() - 1).distance(ene.get(j)) < 10) {
                state = true;
            }
        }
        return state;
    }
}
