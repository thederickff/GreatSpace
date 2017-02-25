/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacegreating.jogo;

import java.awt.Image;

/**
 * PROGRAMA DESENVOLVIDO POR DERICK FELIX.
 * DATA:13/02/2016
 * VERSAO: 2.1
 * CLASSE: DESENHO 
 * OBJETIVO: CRIA OS ATRIBUTOS DE TODAS AS CLASSES
 */
public class Desenho {

    private Image imagem;

    private int altura;
    private int largura;

    private boolean visivel;

    public int getAltura() {

        return altura;
    }

    public void setAltura(int a) {

        this.altura = a;
    }

    public int getLargura() {

        return largura;
    }

    public void setLargura(int l) {

        this.largura = l;
    }

    public Image getImagem() {

        return imagem;
    }

    public void setImagem(Image i) {

        this.imagem = i;
    }

    public boolean isVisivel() {

        return visivel;
    }

    public void setVisivel(boolean v) {

        this.visivel = v;
    }

}
