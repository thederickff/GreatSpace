/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greatspace.controller;

import com.greatspace.interfaces.IStrategy;
import com.greatspace.model.Player;
import java.awt.event.KeyEvent;

/**
 *
 * @author Dayvson
 */
public enum Controller implements IStrategy {
    PLAYER_1 {
        @Override
        public void keyPressed(Player player, KeyEvent key){
            int codigo = key.getKeyCode();
            if (!player.isMorto()) {
                switch(codigo){
                    case KeyEvent.VK_G:
                        player.atira();
                        break;
                    case KeyEvent.VK_W:
                        player.setDy(-1);
                        break;
                    case KeyEvent.VK_S:
                        player.setDy(1);
                        break;
                    case KeyEvent.VK_A:
                        player.setDx(-1);
                        break;
                    case KeyEvent.VK_D:
                        player.setDx(1);
                        break;
                }
            }
        }
        
        @Override
        public void keyReleased(Player player, KeyEvent key){
            int codigo = key.getKeyCode();
            if (!player.isMorto()) {
                switch(codigo){
                    case KeyEvent.VK_W:
                        player.setDy(0);
                        break;
                    case KeyEvent.VK_S:
                        player.setDy(0);
                        break;
                    case KeyEvent.VK_A:
                        player.setDx(0);
                        break;
                    case KeyEvent.VK_D:
                        player.setDx(0);
                        break;
                }
            }
        }
    },
    PLAYER_2 {
        @Override
        public void keyPressed(Player player, KeyEvent key){
            int codigo = key.getKeyCode();
            if (!player.isMorto()) {
                switch(codigo){
                    case KeyEvent.VK_INSERT:
                        player.atira();
                        break;
                    case KeyEvent.VK_UP:
                        player.setDy(-1);
                        break;
                    case KeyEvent.VK_DOWN:
                        player.setDy(1);
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setDx(-1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setDx(1);
                        break;
                }
            }
        }
        
        @Override
        public void keyReleased(Player player, KeyEvent key){
            int codigo = key.getKeyCode();
            if (!player.isMorto()) {
                switch(codigo){
                    case KeyEvent.VK_UP:
                        player.setDy(0);
                        break;
                    case KeyEvent.VK_DOWN:
                        player.setDy(0);
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setDx(0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setDx(0);
                        break;
                }
            }
        }
    }
}
