/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Asteroid.State;

import Asteroid.GameObjects.Constant;
import Asteroid.Graphics.Asset;
import Asteroid.IO.JSONParser;
import Asteroid.State.GameModeState;
import Asteroid.State.GameState;
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
 * @author HOME
 */
public class MenuState extends GameState {

    private ArrayList<Button> buttons;

    public MenuState() {
        buttons = new ArrayList<Button>();
        int numberPlayer = 0;
        ArrayList<User> dataList = readData();
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getCurrentActive() == 1) {
                numberPlayer++;
            }
        }
        if (numberPlayer != 1) {
            buttons.add(new Button(
                    Asset.greyBtn,
                    Asset.blueBtn,
                    Constant.WIDTH / 2 - Asset.greyBtn.getWidth() / 2,
                    Constant.HEIGHT / 2 - Asset.greyBtn.getHeight() * 2,
                    Constant.PLAY,
                    new Action() {
                @Override
                public void doAction() {
                    GameState.changeState(new MultiplayerState());

                }
            }
            ));
            
        } else {
            buttons.add(new Button(
                    Asset.greyBtn,
                    Asset.blueBtn,
                    Constant.WIDTH / 2 - Asset.greyBtn.getWidth() / 2,
                    Constant.HEIGHT / 2 - Asset.greyBtn.getHeight() * 2,
                    Constant.PLAY,
                    new Action() {
                @Override
                public void doAction() {
                    GameState.changeState(new SingleplayerState());

                }
            }
            ));
        }

        buttons.add(new Button(
                Asset.greyBtn,
                Asset.blueBtn,
                Constant.WIDTH / 2 - Asset.greyBtn.getWidth() / 2,
                Constant.HEIGHT / 2 + Asset.greyBtn.getHeight() * 2,
                Constant.RETURN,
                new Action() {
            @Override
            public void doAction() {
                CheckFacade checkFacade = new CheckFacade();
                checkFacade.setVisible(true);
            }
        }
        ));
        buttons.add(new Button(
                Asset.greyBtn,
                Asset.blueBtn,
                Constant.WIDTH / 2 - Asset.greyBtn.getWidth() / 2,
                Constant.HEIGHT / 2,
                Constant.HIGH_SCORES,
                new Action() {
            @Override
            public void doAction() {
                GameState.changeState(new ScoreState());
            }
        }
        ));

    }

    @Override
    public void update() {
        for (Button b : buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for (Button b : buttons) {
            b.draw(g);
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
