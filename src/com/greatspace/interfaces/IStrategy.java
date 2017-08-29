/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greatspace.interfaces;

import com.greatspace.model.Player;
import java.awt.event.KeyEvent;

/**
 *
 * @author Dayvson
 */
public interface IStrategy {
    public void keyPressed(Player player, KeyEvent key);
    public void keyReleased(Player player, KeyEvent key);
}
