/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.State;

import Asteroid.GameObjects.Chronometer;
import Asteroid.GameObjects.Constant;
import Asteroid.GameObjects.MateOne;
import Asteroid.GameObjects.MateTwo;
import Asteroid.GameObjects.Player;
import Asteroid.Graphics.Asset;
import Asteroid.Math.Vector2D;
import static Asteroid.State.GameModeState.PLAYER_START_POSITION_P1;
import static Asteroid.State.GameModeState.PLAYER_START_POSITION_P2;
import java.awt.Graphics;

/**
 *
 * @author KelvinOjeda
 */
public class SingleplayerState extends GameModeState {

    private int live = 3;
    
    public SingleplayerState() {
        super();
        live1 = live;
        player1 = new MateOne(
                PLAYER_START_POSITION_P1,
                new Vector2D(),
                Constant.PLAYER_MAX_VEL,
                Asset.player1,
                this,
                new Chronometer(),
                new Chronometer(),
                new Chronometer()
        );
        movingObjects.add(player1);
    }

    @Override
    public void drawLives(Graphics g) {
        if (live1 < 1) {
            return;
        }
        Vector2D livePosition = new Vector2D(25, 25);

        g.drawImage(Asset.life, (int) livePosition.getX(),
                (int) livePosition.getY(), null);

        g.drawImage(Asset.numbers[10], (int) livePosition.getX() + 40,
                (int) livePosition.getY() + 5, null);

        String livesToString = Integer.toString(live1);

        Vector2D pos = new Vector2D(livePosition.getX(),
                livePosition.getY());

        for (int i = 0; i < livesToString.length(); i++) {
            int number = Integer.parseInt(livesToString.
                    substring(i, i + 1));

            if (number < 0) {
                break;
            }
            g.drawImage(Asset.numbers[number],
                    (int) pos.getX() + 60,
                    (int) pos.getY() + 5, null);
            pos.setX(pos.getX() + 20);
        }

    }

    
}
