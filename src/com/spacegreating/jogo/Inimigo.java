package com.spacegreating.jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * PROGRAMA DESENVOLVIDO POR DERICK FELIX.
 * DATA:13/02/2016 VERSAO: 2.1
 * CLASSE: INIMIGO
 * OBJETIVO: CRIAR OS ATRIBUTOS DOS INIMIGOS
 */
public class Inimigo extends Desenho {

    private int x, y;

    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 1;

    private static int contador = 0;

    public Inimigo(int x, int y) {

        this.x = x;
        this.y = y;

        ImageIcon referencia;

        if (contador++ % 3 == 0) {
            referencia = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/inimigo_2.gif"));

        } else {

            referencia = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/inimigo_1.gif"));
        }
        this.setImagem(referencia.getImage());

        this.setAltura(getImagem().getHeight(null));
        this.setLargura(getImagem().getWidth(null));

        this.setVisivel(true);
    }

    public int GerarPosX() {

        int aax = 456 + (int) (Math.random() * 1600);
        return aax;
    }

    public int GerarPosY() {
        int aay = 10 + (int) (Math.random() * 320);

        return aay;
    }

    public void mexer() {

        if (this.x < 0) {
            this.x = GerarPosX();
            this.y = GerarPosY();
        } else {
            this.x -= VELOCIDADE;
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
