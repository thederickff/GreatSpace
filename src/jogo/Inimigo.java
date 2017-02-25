package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/** PROGRAMA DESENVOLVIDO POR DERICK TORVALDS.
* DATA:06/02/2016
* VERSAO: 1.2
* CLASSE: INIMIGO
* OBJETIVO: CRIAR OS ATRIBUTOS DOS INIMIGOS
*/
public class Inimigo {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;

    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 1;

    private static int contador = 0;

    public Inimigo(int x, int y) {

        this.x = x;
        this.y = y;

        ImageIcon referencia;

        if (contador++ % 3 == 0) {
            referencia = new ImageIcon(getClass().getResource("/jogo/res/inimigo_2.gif"));

        } else {

            referencia = new ImageIcon(getClass().getResource("/jogo/res/inimigo_1.gif"));
        }
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);

        isVisivel = true;
    }

    public void mexer() {

        if (this.x < 0) {
            this.x = LARGURA_TELA;
        } else {
            this.x -= VELOCIDADE;
        }

    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

}
