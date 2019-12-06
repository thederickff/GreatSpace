package com.greatspace.controller;

import com.greatspace.interfaces.IStrategy;
import com.greatspace.model.Player;

import java.awt.event.KeyEvent;

import static com.greatspace.controller.Touch.*;

/**
 *
 * @author Dayvson
 */
public enum Controller implements IStrategy {

    PLAYER_1 {
        @Override
        public void keyPressed(Player player, KeyEvent key)
        {

            int codigo = key.getKeyCode();
            if (!player.isDead()) {
                switch (codigo) {
                    case PLAYER_ONE_FIRE:
                        player.fire();
                        break;
                    case PLAYER_ONE_MOVE_UP:
                        player.setDy(-1);
                        break;
                    case PLAYER_ONE_MOVE_DOWN:
                        player.setDy(1);
                        break;
                    case PLAYER_ONE_MOVE_LEFT:
                        player.setDx(-1);
                        break;
                    case PLAYER_ONE_MOVE_RIGHT:
                        player.setDx(1);
                        break;
                }
            }
        }

        @Override
        public void keyReleased(Player player, KeyEvent key)
        {
            int codigo = key.getKeyCode();

            if (!player.isDead()) {
                switch (codigo) {
                    case PLAYER_ONE_MOVE_UP:
                        player.setDy(0);
                        break;
                    case PLAYER_ONE_MOVE_DOWN:
                        player.setDy(0);
                        break;
                    case PLAYER_ONE_MOVE_LEFT:
                        player.setDx(0);
                        break;
                    case PLAYER_ONE_MOVE_RIGHT:
                        player.setDx(0);
                        break;
                }
            }
        }
    },
    PLAYER_2 {
        @Override
        public void keyPressed(Player player, KeyEvent key)
        {
            int codigo = key.getKeyCode();
            if (!player.isDead()) {
                switch (codigo) {
                    case PLAYER_TWO_FIRE:
                        player.fire();
                        break;
                    case PLAYER_TWO_MOVE_UP:
                        player.setDy(-1);
                        break;
                    case PLAYER_TWO_MOVE_DOWN:
                        player.setDy(1);
                        break;
                    case PLAYER_TWO_MOVE_LEFT:
                        player.setDx(-1);
                        break;
                    case PLAYER_TWO_MOVE_RIGHT:
                        player.setDx(1);
                        break;
                }
            }
        }

        @Override
        public void keyReleased(Player player, KeyEvent key)
        {
            int codigo = key.getKeyCode();
            if (!player.isDead()) {
                switch (codigo) {
                    case PLAYER_TWO_MOVE_UP:
                        player.setDy(0);
                        break;
                    case PLAYER_TWO_MOVE_DOWN:
                        player.setDy(0);
                        break;
                    case PLAYER_TWO_MOVE_LEFT:
                        player.setDx(0);
                        break;
                    case PLAYER_TWO_MOVE_RIGHT:
                        player.setDx(0);
                        break;
                }
            }
        }
    }
}
