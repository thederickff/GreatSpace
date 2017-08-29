package com.greatspace.model;

import com.greatspace.controller.Controller;
import com.greatspace.proxy.ProxyImage;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: Derick Felix
 * @Data: 02/13/2016
 * @Release: 2.1
 * @Class: Player
 */
public class Player extends GameObject {

    private int x, y;
    private int dx, dy;
    private boolean morto;
    private static ProxyImage imagemProxy;
    private Bullet missel;
    
    private Controller controle;

    private List<Bullet> misseis;

    public Player() {
        if(imagemProxy == null)
            imagemProxy = new ProxyImage("/com/greatspace/sprites/ship.gif"); 
        
        this.setImagem(imagemProxy.loadImage().getImage());

        this.setAltura(getImagem().getHeight(null));
        this.setLargura(getImagem().getWidth(null));

        misseis = new ArrayList<Bullet>();
        missel = new Bullet();
    }

    public void mexer() {
        x += dx; // 1 e 462
        y += dy; // 1 e 340

        colisaoJanela();
    }

    public void colisaoJanela() {

        if (this.x < 1) {
            x = 1;
        }

        if (this.x > 462) {
            x = 462;
        }

        if (this.y < 1) {
            y = 1;
        }

        if (this.y > 340) {
            y = 340;
        }
    }

    public List<Bullet> getMisseis() {
        return misseis;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setDx(int d){
        this.dx = d;
    }
    public void setDy(int d){
        this.dy = d;
    }

    public int getY() {
        return y;
    }

    public void setY(int num) {

        this.y = num;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public void atira() {
        Bullet mis = (Bullet) missel.clone();
        mis.setX(x + getLargura());
        mis.setY(y + getAltura()/2);
        
        this.misseis.add(mis);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getLargura(), getAltura());
    }

    public Controller getControle() {
        return controle;
    }

    public void setControle(Controller controle) {
        this.controle = controle;
    }
    
}
