package com.greatspace.model;

import com.greatspace.proxy.ProxyImage;
import java.awt.Rectangle;

/**
 * PROGRAMA DESENVOLVIDO POR DERICK FELIX.
 * DATA:13/02/2016
 * VERSAO: 2.1
 * CLASSE: MISSEL 
 * OBJETIVO: CRIAR OS ATRIBUTOS DOS MISSEIS
 */
public class Bullet extends GameObject {

    private int x;
    private int y;
    private static ProxyImage imagemProxy;
    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 3;

    public Bullet() {
        if(imagemProxy == null)
            imagemProxy = new ProxyImage("/com/greatspace/sprites/bullet.png"); 
        
        this.setImagem(imagemProxy.loadImage().getImage());
        this.setAltura(getImagem().getHeight(null));
        this.setLargura(getImagem().getWidth(null));

        this.setVisivel(true);
    }

    public void mexer() {

        this.x += VELOCIDADE;
        if (this.x > LARGURA_TELA) {
            setVisivel(false);
        }

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getLargura(), getAltura());
    }

}
