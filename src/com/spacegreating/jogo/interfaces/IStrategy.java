/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacegreating.jogo.interfaces;

import com.spacegreating.jogo.Nave;
import java.awt.event.KeyEvent;

/**
 *
 * @author Dayvson
 */
public interface IStrategy {
    public void controle(Nave nave, KeyEvent tecla);
    public void controleReleased(Nave nave, KeyEvent tecla);
}
