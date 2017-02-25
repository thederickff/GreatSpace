package jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/*** PROGRAMA DESENVOLVIDO POR DERICK TORVALDS
* DATA:04/02/2016
* VERSAO: 1.0
* CLASSE: CONTAINERDEJANELAS
* OBJETIVO: CRIAR JANELA PRINCIPAL
*/
public class ContainerDeJanelas extends JFrame {

    public ContainerDeJanelas() {
        
        //                  CRIAR A BARRA DE MENU
        /******************************************************************/
        
        JMenuBar barraMenu = new JMenuBar();
        //CIAR UM MENU DO DA BARRA DE  MENU
        JMenu menu = new JMenu("Menu");
        // CRIAR ITEM DO MENU
        JMenuItem sobre = new JMenuItem("Sobre");
        // CRIAR UMA FUNCAO DO SOBRE QUANDO O USUARIO CLIKAR
        sobre.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                
             JOptionPane.showMessageDialog(null, "Jogo desenvolvido por Derick Florencio ", "Informações", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // CRIAR ITEM DO MENU
        JMenuItem sair = new JMenuItem("Sair");
        // CRIAR UMA FUNCAO DO SAIR QUANDO O USUARIO CLIKAR
        sair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // ADICIONAR SOBRE AO MENU
        menu.add(sobre);
        // ADICIONAR UMA NOVA SEPARACAO
        menu.add(new JSeparator());
        // ADICIONAR SAIR AO MENU
        menu.add(sair);
        // ADICIONAR UM MENU PARA A BARRA DE MENU
        barraMenu.add(menu);
        
        //                CRIAR JANELA
        /***********************************************/

        // CRIAR JANELA ADICIONAR O PAINEL FASE AO JFRAME
        add(new Fase());
        // SETAR A BARRAMENU COMO A BARRA DE MENU DA JANELA
        setJMenuBar(barraMenu);
        // SETAR O TITULO DO JOGO
        setTitle("Space Greating 1.0");
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
        new ContainerDeJanelas();
    }
}
