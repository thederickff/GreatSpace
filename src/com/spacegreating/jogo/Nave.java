package com.spacegreating.jogo;

import com.spacegreating.jogo.proxy.ImagemProxy;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


/**
 * PROGRAMA DESENVOLVIDO POR DERICK FELIX.
 * DATA:13/02/2016 
 * VERSAO: 2.1
 * CLASSE: NAVE 
 * OBJETIVO: CRIAR ATRIBUTOS DA NAVE
 */
public class Nave extends Desenho {

    private int x, y;
    private int dx, dy;
    private boolean morto;
    private static ImagemProxy imagemProxy;
    private Missel missel;
    
    private Controle controle;

    private List<Missel> misseis;

    public Nave() {
        if(imagemProxy == null)
            imagemProxy = new ImagemProxy("/com/spacegreating/sprites/nave.gif"); 
        
        this.setImagem(imagemProxy.carregarImagem().getImage());

        this.setAltura(getImagem().getHeight(null));
        this.setLargura(getImagem().getWidth(null));

        misseis = new ArrayList<Missel>();
        missel = new Missel();
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

    public List<Missel> getMisseis() {
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
        Missel mis = (Missel) missel.clone();
        mis.setX(x + getLargura());
        mis.setY(y + getAltura()/2);
        
        this.misseis.add(mis);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getLargura(), getAltura());
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }
    
}
