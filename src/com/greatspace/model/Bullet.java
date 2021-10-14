package com.greatspace.model;

import com.greatspace.proxy.ProxyImage;
import java.awt.Rectangle;

/**
 * Date: 13/02/2016
 */
public class Bullet extends GameObject {

    private int x;
    private int y;
    private static ProxyImage imagemProxy;
    private static final int LARGURA_TELA = 1366;
    private static final int VELOCIDADE = 3;
    private static int Y = 0;

    public Bullet()
    {
        if (imagemProxy == null) {
            imagemProxy = new ProxyImage("/com/greatspace/sprites/bullet.png");
        }

        this.setImage(imagemProxy.loadImage().getImage());
        this.setHeight(getImage().getHeight(null));
        this.setWidth(getImage().getWidth(null));

        this.setVisibility(true);

        switch ((int) (Math.random() * 3)) {
          case 1:
            Y = 1;
            break;
          case 2:
            Y = -1;
            break;
        }
        System.out.println(Y);

    }

    public void mexer()
    {

        this.x += VELOCIDADE;
        this.y += Y;

        if (this.x > LARGURA_TELA) {
            setVisibility(false);
        }

    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, getLargura(), getAltura());
    }

}
