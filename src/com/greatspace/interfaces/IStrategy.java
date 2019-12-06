package com.greatspace.interfaces;

import com.greatspace.model.Player;
import java.awt.event.KeyEvent;

/**
 *
 * @author Dayvson
 */
public interface IStrategy {

    void keyPressed(Player player, KeyEvent key);

    void keyReleased(Player player, KeyEvent key);

}
