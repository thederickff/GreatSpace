package com.spacegreating.jogo;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * PROGRAMA DESENVOLVIDO POR DERICK FELIX.
 * DATA:13/02/2016
 * VERSAO: 2.1
 * CLASSE: MISSEL 
 * OBJETIVO: CRIAR OS ATRIBUTOS DOS MISSEIS
 */
public class Missel extends Desenho {

    private int x;
    private int y;

    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 3;

    public Missel(int x, int y) {

        this.x = x;
        this.y = y;

        ImageIcon referencia = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/missel.png"));
        this.setImagem(referencia.getImage());

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
