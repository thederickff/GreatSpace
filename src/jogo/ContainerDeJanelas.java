package jogo;

import javax.swing.JFrame;


/*** PROGRAMA DESENVOLVIDO POR DERICK FLORENCIO.
* DATA:06/02/2016
* VERSAO: 1.2
* CLASSE: CONTAINERDEJANELAS
* OBJETIVO: CRIAR JANELA PRINCIPAL
*/
public class ContainerDeJanelas extends JFrame {

    public ContainerDeJanelas() {
        
        //                CRIAR JANELA
        /***********************************************/

        // CRIAR JANELA ADICIONAR O PAINEL FASE AO JFRAME
        add(new Fase());
        //  CRIAR UM NOVO OBJETO DA CLASSE FASE
        Fase f = new Fase();
        // SETAR A BARRAMENU COMO A BARRA DE MENU DA JANELA
        setJMenuBar(f.criarMenu());
        // SETAR O TITULO DO JOGO
        setTitle("Space Greating");
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
