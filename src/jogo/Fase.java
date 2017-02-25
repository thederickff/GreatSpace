package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*** PROGRAMA DESENVOLVIDO POR DERICK TORVALDS.
* DATA:11/02/2016
* VERSAO: 1.4
* CLASSE: FASE
* OBJETIVO: CRIAR JANELA DO JOGO
*/
public class Fase extends JPanel implements ActionListener {

    private Image fundo;
    private Image Inicio;
    private Nave nave;
    private Timer timer;

    private boolean emJogo;
    private boolean inicio;
    private boolean ganhoJogo;

    private List<Inimigo> inimigos;

    private int[][] coordenadas = {{1600, 29}, {1499, 59}, {1380, 89},
    {780, 109}, {580, 139}, {880, 239}, {790, 259},
    {760, 50}, {790, 150}, {1980, 209}, {560, 45}, {510, 70},
    {930, 159}, {590, 80}, {530, 60}, {940, 59}, {990, 30},
    {920, 200}, {900, 259}, {660, 50}, {540, 90}, {810, 220},
    {860, 20}, {740, 180}, {820, 128}, {490, 170}, {700, 30},
    {920, 300}, {856, 328}, {456, 320}};

    public Fase() {

        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());

        ImageIcon referencia = new ImageIcon(getClass().getResource("/jogo/res/fundo.png"));
        fundo = referencia.getImage();
        nave = new Nave();

        emJogo = false;
        ganhoJogo = false;
        inicio = true;

        inicializaInimigos();

        timer = new Timer(5, this);
        timer.start();

    }
    public JMenuBar criarMenu(){
        
        JMenuBar menub = new JMenuBar();
        
        JMenu jogo = new JMenu("<html><u>J</u>ogo</html>");
        
        /*JMenuItem carregar  = new JMenuItem("<html><u>C</u>arregar Jogo</html>");
        carregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Esta opção ainda não e possivel ainda", "Erro", 2);
            }
        });*/
        
      /*  JMenuItem salvar = new JMenuItem("<html><u>S</u>alvar Jogo</html>");
        salvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });*/
        JMenuItem fechar = new JMenuItem("<html><u>F</u>echar</html>");
        fechar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        //arquivo.add(carregar);
       // arquivo.add(salvar);
        jogo.add(fechar);
        
        JMenu ajuda = new JMenu("<html>Aj<u>u</u>da</html>");
        
        JMenuItem sobre = new JMenuItem("<html>S<u>o</u>bre<html>");
        sobre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"<html>Space Greating<br> "
                        +" Jogo Desenvolvido por <u>Derick Florencio</u>!</html>","Sobre",1);
            }
        });
        JMenuItem coj = new JMenuItem("<html><u>C</u>omo Jogar...</html>");
        coj.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, "<html>Para atirar tecle Insert<br>"
                     + "Para mover a nave para cima tecle W<br>"
                     + "Para mover a nave para baixo tecle S<br>"
                     + "Para mover a nave para esquerda tecle A<br>"
                     + "Para mover a nave para Direita tecle D<br></html>", "Como se Joga...", JOptionPane.QUESTION_MESSAGE);
            }
        });
        JMenuItem versao = new JMenuItem("<html><u>V</u>ersão</html>");
        versao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"<html>VERSÃO 1.4<br>"
                        + "<u>O que veio de novo:</u><br><br>"
                        + "- Mudanças de controle <br>"
                        + " <br>"
                        + " <br>"
                        + "<br></html>","Versão",1);
            }
        });
        ajuda.add(coj);
        ajuda.add(versao);
        ajuda.add(sobre);
        
        menub.add(jogo);
        menub.add(ajuda);
        
        
        
        
       return menub; 
    }

    public void inicializaInimigos() {

        inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < coordenadas.length; i++) {
            inimigos.add(new Inimigo(coordenadas[i][0], coordenadas[i][1]));

        }

    }

    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);

        if (emJogo) {

            graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);

            List<Missel> misseis = nave.getMisseis();

            for (int i = 0; i < misseis.size(); i++) {

                Missel m = (Missel) misseis.get(i);
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

            }
            
            

            for (int i = 0; i < inimigos.size(); i++) {

                Inimigo in = inimigos.get(i);
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);

            }

            graficos.setColor(Color.WHITE);
            graficos.drawString("INIMIGOS: " + inimigos.size(), 5, 15);
            
           
                
            

        } else  if(ganhoJogo) {

            
             ImageIcon ganhojogo = new ImageIcon(getClass().getResource("/jogo/res/jogo_vencido.png"));
            
            graficos.drawImage(ganhojogo.getImage(), 0,0,null);
            
        }else if(inicio){
            
            ImageIcon bg_ = new ImageIcon(getClass().getResource("/jogo/res/Tela_Inicio.png"));
            Inicio = bg_.getImage();
            graficos.drawImage(Inicio, 0, 0, null);
           
        }else{
           ImageIcon fimJogo = new ImageIcon(getClass().getResource("/jogo/res/game_over.png"));

            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        if (inimigos.isEmpty()) {
            emJogo = false;
            ganhoJogo = true;
        }

        List<Missel> misseis = nave.getMisseis();

        for (int i = 0; i < misseis.size(); i++) {

            Missel m = (Missel) misseis.get(i);

            if (m.isVisivel()) {
                m.mexer();
            } else {
                misseis.remove(i);
            }

        }

        for (int i = 0; i < inimigos.size(); i++) {

            Inimigo in = inimigos.get(i);

            if (in.isVisivel()) {
                in.mexer();
            } else {
                inimigos.remove(i);
            }

        }

        nave.mexer();
        checarColisoes();
        repaint();
    }

    public void checarColisoes() {

        Rectangle formaNave = nave.getBounds();
        Rectangle formaInimigo;
        Rectangle formaMissel;

        for (int i = 0; i < inimigos.size(); i++) {

            Inimigo tempInimigo = inimigos.get(i);
            formaInimigo = tempInimigo.getBounds();
             
            if (formaNave.intersects(formaInimigo)) {

                nave.setVisivel(false);
             
                emJogo = false;

            }

        }

        List<Missel> misseis = nave.getMisseis();

        for (int i = 0; i < misseis.size(); i++) {

            Missel tempMissel = misseis.get(i);
            formaMissel = tempMissel.getBounds();

            for (int j = 0; j < inimigos.size(); j++) {

                Inimigo tempInimigo = inimigos.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {

                    tempInimigo.setVisivel(false);
                    tempMissel.setVisivel(false);

                }

            }

        }

    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
              if(emJogo == false){
                emJogo = true;
                ganhoJogo = false;
                if(inicio == true){
                    inicio = false;
                }
                nave = new Nave();
                inicializaInimigos();
              }
            }
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                emJogo = false;
                
            }

            nave.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            nave.keyReleased(e);
        }

    }

}
