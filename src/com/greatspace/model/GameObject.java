package com.greatspace.model;

import java.awt.Image;

/**
 * Date: 13/02/2016
 */
public abstract class GameObject implements Cloneable {

    private Image image;
    private int height;
    private int width;

    private boolean visivel;

    public int getAltura()
    {
        return height;
    }

    public void setHeight(int a)
    {
        this.height = a;
    }

    public int getLargura()
    {
        return width;
    }

    public void setWidth(int l)
    {

        this.width = l;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image i)
    {
        this.image = i;
    }

    public boolean isVisible()
    {
        return visivel;
    }

    public void setVisibility(boolean v)
    {
        this.visivel = v;
    }

    @Override
    public Object clone()
    {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
