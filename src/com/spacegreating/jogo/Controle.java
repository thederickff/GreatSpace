/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacegreating.jogo;

import com.spacegreating.jogo.interfaces.IStrategy;
import java.awt.event.KeyEvent;

/**
 *
 * @author Dayvson
 */
public enum Controle implements IStrategy {
    PLAYER_1 {
        @Override
        public void controle(Nave nave, KeyEvent tecla){
            int codigo = tecla.getKeyCode();
            if (!nave.isMorto()) {
                switch(codigo){
                    case KeyEvent.VK_G:
                        nave.atira();
                        break;
                    case KeyEvent.VK_W:
                        nave.setDy(-1);
                        break;
                    case KeyEvent.VK_S:
                        nave.setDy(1);
                        break;
                    case KeyEvent.VK_A:
                        nave.setDx(-1);
                        break;
                    case KeyEvent.VK_D:
                        nave.setDx(1);
                        break;
                }
            }
        }
        
        @Override
        public void controleReleased(Nave nave, KeyEvent tecla){
            int codigo = tecla.getKeyCode();
            if (!nave.isMorto()) {
                switch(codigo){
                    case KeyEvent.VK_W:
                        nave.setDy(0);
                        break;
                    case KeyEvent.VK_S:
                        nave.setDy(0);
                        break;
                    case KeyEvent.VK_A:
                        nave.setDx(0);
                        break;
                    case KeyEvent.VK_D:
                        nave.setDx(0);
                        break;
                }
            }
        }
    },
    PLAYER_2 {
        @Override
        public void controle(Nave nave, KeyEvent tecla){
            int codigo = tecla.getKeyCode();
            if (!nave.isMorto()) {
                switch(codigo){
                    case KeyEvent.VK_INSERT:
                        nave.atira();
                        break;
                    case KeyEvent.VK_UP:
                        nave.setDy(-1);
                        break;
                    case KeyEvent.VK_DOWN:
                        nave.setDy(1);
                        break;
                    case KeyEvent.VK_LEFT:
                        nave.setDx(-1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        nave.setDx(1);
                        break;
                }
            }
        }
        
        @Override
        public void controleReleased(Nave nave, KeyEvent tecla){
            int codigo = tecla.getKeyCode();
            if (!nave.isMorto()) {
                switch(codigo){
                    case KeyEvent.VK_UP:
                        nave.setDy(0);
                        break;
                    case KeyEvent.VK_DOWN:
                        nave.setDy(0);
                        break;
                    case KeyEvent.VK_LEFT:
                        nave.setDx(0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        nave.setDx(0);
                        break;
                }
            }
        }
    }
}
