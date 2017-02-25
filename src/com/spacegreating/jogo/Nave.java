package com.spacegreating.jogo;

import com.spacegreating.tela.Fase;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

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
     ImageIcon referencia;

    private List<Missel> misseis;

    public Nave(int X, int Y) {
        
        
        referencia = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/nave.gif"));
        
           
            
        this.setImagem(referencia.getImage());

        this.setAltura(getImagem().getHeight(null));
        this.setLargura(getImagem().getWidth(null));

        misseis = new ArrayList<Missel>();

        this.x = X;
        this.y = Y;

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
        this.misseis.add(new Missel(x + getLargura(), y + getAltura() / 2));
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getLargura(), getAltura());
    }

    public void keyPressed1(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        if (morto != true) {
            if (codigo == KeyEvent.VK_G) {

                atira();

            }
            if (codigo == KeyEvent.VK_W) {
                dy = -1;
            }

            if (codigo == KeyEvent.VK_S) {
                dy = 1;
            }

            if (codigo == KeyEvent.VK_A) {
                dx = -1;
            }

            if (codigo == KeyEvent.VK_D) {
                dx = 1;
            }
        }
    }

    public void keyPressed2(KeyEvent tecla) {

        int codigo = tecla.getKeyCode();
        if (morto != true) {
            if (codigo == KeyEvent.VK_INSERT) {
                atira();
            }

            if (codigo == KeyEvent.VK_UP) {
                dy = -1;
            }

            if (codigo == KeyEvent.VK_DOWN) {
                dy = 1;
            }

            if (codigo == KeyEvent.VK_LEFT) {
                dx = -1;
            }

            if (codigo == KeyEvent.VK_RIGHT) {
                dx = 1;
            }
        }
    }

    public void keyReleased1(KeyEvent tecla) {

        int codigo = tecla.getKeyCode();

        if (morto != true) {
            if (codigo == KeyEvent.VK_W) {
                dy = 0;
            }

            if (codigo == KeyEvent.VK_S) {
                dy = 0;
            }

            if (codigo == KeyEvent.VK_A) {
                dx = 0;
            }

            if (codigo == KeyEvent.VK_D) {
                dx = 0;
            }
        }

    }

    public void keyReleased2(KeyEvent tecla) {

        int codigo = tecla.getKeyCode();

        if (morto != true) {
         
            if (codigo == KeyEvent.VK_UP) {
                dy = 0;
            }

            if (codigo == KeyEvent.VK_DOWN) {
                dy = 0;
            }

            if (codigo == KeyEvent.VK_LEFT) {
                dx = 0;
            }

            if (codigo == KeyEvent.VK_RIGHT) {
                dx = 0;
            }
        }
    }

}
