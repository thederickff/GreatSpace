package com.greatspace.model;

import com.greatspace.controller.Controller;
import com.greatspace.proxy.ProxyImage;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


/**
 * Date: 13/02/2016
 */
public class Player extends GameObject {

    private int x, y;
    private int dx, dy;
    private boolean morto;
    private static ProxyImage imagemProxy;
    private Bullet missel;

    private Controller controle;

    private List<Bullet> bullets;

    public Player() {
        if (imagemProxy == null)
            imagemProxy = new ProxyImage("/com/greatspace/sprites/ship.gif");

        this.setImage(imagemProxy.loadImage().getImage());

        this.setHeight(getImage().getHeight(null));
        this.setWidth(getImage().getWidth(null));

        bullets = new ArrayList<Bullet>();
        missel = new Bullet();
    }

    public void mexer() {
        x += dx*2; // 1 e 462
        y += dy*2; // 1 e 340

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

    public List<Bullet> getBullet() {
        return bullets;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setDx(int d) {
        this.dx = d;
    }

    public void setDy(int d) {
        this.dy = d;
    }

    public int getY() {
        return y;
    }

    public void setY(int num) {

        this.y = num;
    }

    public boolean isDead() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public void fire() {
        Bullet mis = (Bullet) missel.clone();
        mis.setX(x + getLargura());
        mis.setY(y + getAltura() / 2);

        this.bullets.add(mis);
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
