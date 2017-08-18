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
public class ImagemProxy implements IImagem{
    
    private ImagemReal imagemReal;
    private final String imagem;
    
    public ImagemProxy(String imagem){
        this.imagem = imagem;
    }
    
    @Override
    public ImageIcon carregarImagem() {
        
        if(this.imagemReal == null){
            this.imagemReal = new ImagemReal(this.imagem);
        }
        
        return this.imagemReal.carregarImagem();
    }
    
}
