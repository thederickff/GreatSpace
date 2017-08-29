/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greatspace.proxy;

import javax.swing.ImageIcon;
import com.greatspace.interfaces.IImage;

/**
 *
 * @author Dayvson
 */
public class ProxyImage implements IImage {

    private RealImage realImage;
    private final String path;

    public ProxyImage(String path) {
        this.path = path;
    }

    @Override
    public ImageIcon loadImage() {

        if (this.realImage == null) {
            this.realImage = new RealImage(this.path);
        }

        return this.realImage.loadImage();
    }

}
