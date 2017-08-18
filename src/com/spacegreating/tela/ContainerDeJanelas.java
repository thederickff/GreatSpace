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
        setTitle("Great Space");
        // SETAR O MODO DE FECHAR A JANELA
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // SETAR O TAMANHO DA JANELA
        setSize(500, 420);
        // SETAR O LOCAL PARA A JANELA SER CRIADA NO MEIO DA TELA
        setLocationRelativeTo(null);
        // SETAR REDIMENSIONAMENTO DA TELA COMO FALSO 
        setResizable(false);
      
    }
//         METODO PRINCIPAL
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContainerDeJanelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContainerDeJanelas().setVisible(true);
            }
        });
        // INSTANCIAR A CLASSE QUE CONTEM A JANELA NO CONSTRUTOR
        
    }
}
