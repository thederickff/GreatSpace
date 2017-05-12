/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacegreating.jogo.proxy;

import com.spacegreating.jogo.interfaces.IImagem;
import javax.swing.ImageIcon;

/**
 *
 * @author Dayvson
 */
public class ImagemReal implements IImagem{

    private final String imagem;
    private ImageIcon imageIcon;
    
    public ImagemReal(String imagem){
        this.imagem = imagem;
    }
    
    @Override
    public ImageIcon carregarImagem() {
        if(imageIcon == null){
            imageIcon = new ImageIcon(getClass().getResource(imagem));
        }
        return imageIcon;
    }
    
}
