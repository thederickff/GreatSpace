package com.spacegreating.tela;

import javax.swing.JFrame;


/*** PROGRAMA DESENVOLVIDO POR DERICK FELIX.
* DATA:13/02/2016
* VERSAO: 2.1
* CLASSE: CONTAINERDEJANELAS
* OBJETIVO: CRIAR JANELA PRINCIPAL
*/
public class ContainerDeJanelas extends JFrame {

    public ContainerDeJanelas() {
        
        //                CRIAR JANELA
        /***********************************************/
         //  CRIAR UM NOVO OBJETO DA CLASSE FASE
        Fase f = new Fase();
        f.verificarPlayer();
        // CRIAR JANELA ADICIONAR O PAINEL FASE AO JFRAME
        add(f);
        // SETAR A BARRAMENU COMO A BARRA DE MENU DA JANELA
        setJMenuBar(f.criarMenu());
        // SETAR O TITULO DO JOGO
        setTitle("Space Greating 2.1");
        // SETAR O MODO DE FECHAR A JANELA
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // SETAR O TAMANHO DA JANELA
        setSize(500, 420);
        // SETAR O LOCAL PARA A JANELA SER CRIADA NO MEIO DA TELA
        setLocationRelativeTo(null);
        // SETAR REDIMENSIONAMENTO DA TELA COMO FALSO 
        setResizable(false);
        // SETAR A VISIBILIDADE DA TELA COMO VERDADEIRO
        setVisible(true);

    }
//         METODO PRINCIPAL
    public static void main(String[] args) {
        
        // INSTANCIAR A CLASSE QUE CONTEM A JANELA NO CONSTRUTOR
        ContainerDeJanelas cdj = new ContainerDeJanelas();
    }
}