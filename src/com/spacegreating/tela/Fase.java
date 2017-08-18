package com.spacegreating.tela;

import com.spacegreating.jogo.Controle;
import com.spacegreating.jogo.Missel;
import com.spacegreating.jogo.Inimigo;
import com.spacegreating.jogo.Nave;
import com.spacegreating.jogo.proxy.ImagemProxy;
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

/**
 * * PROGRAMA DESENVOLVIDO POR DERICK FELIX.
 * DATA:13/02/2016 
 * VERSAO: 2.1
 * CLASSE: FASE 
 * OBJETIVO: CRIAR JANELA DO JOGO
 */
public class Fase extends JPanel implements ActionListener {

    private int recp;
    private final Image fundo;
    private Image Inicio;
    private final Nave nave;
    private final Timer timer;
    private final Nave naveUm;
    private final Nave naveDois;

    private boolean p2 = false;
    private boolean emJogo;
    private boolean inicio;
    private boolean ganhoJogo;

    private List<Inimigo> inimigos;

    public Fase() {
        
        this.nave = new Nave();
        
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());

        ImageIcon referencia = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/fundo.png"));
        fundo = referencia.getImage();
        
        naveUm = (Nave) nave.clone();
        naveUm.setX(100);
        naveUm.setY(100);
        naveUm.setControle(Controle.PLAYER_1);
        
        naveDois = (Nave) nave.clone();
        naveDois.setX(100);
        naveDois.setY(200);
        naveDois.setControle(Controle.PLAYER_2);
        
        emJogo = false;
        ganhoJogo = false;
        inicio = true;
       
        inicializaInimigos();

        timer = new Timer(5, this);
        timer.start();
    }

    public void verificarPlayer() {
        recp = Integer.parseInt(JOptionPane.showInputDialog(null, "<html>Digite 1 para 1 Jogador<br>"
                + "Digite 2 para 2 Jogadores</html>", "Quantos Jogadores", 1));
        
        if(recp == 2){
            p2 = true;
        }
        
    }

    public JMenuBar criarMenu() {
        // Create a new MenuBar
        JMenuBar menub = new JMenuBar();
        // Create a new Menu
        JMenu jogo = new JMenu("Jogo");
        // Create a new Menu Item of Jogo menu
        JMenuItem fechar = new JMenuItem("Fechar");
        fechar.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        // Add fechar menu item to the jogo menu
        jogo.add(fechar);

        JMenu ajuda = new JMenu("Ajuda");

        JMenuItem sobre = new JMenuItem("Sobre");
        sobre.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "<html><strong>Great Space</strong><br> "
                    + "Developed by <strong>Derick Florencio</strong>!<br><br>"
                    + "<strong>What's new:</strong><br><br>"
                    + "- Bug Fixes <br>"
                    + "- Changes in game controler <br>"
                    + "<br></html>", "Sobre", 1);
        });
        JMenuItem coj = new JMenuItem("Como Jogar");
        coj.addActionListener((ActionEvent e) -> {
                JOptionPane.showMessageDialog(null, "<html>"
                        + "<strong>Nave 1</strong><br>"
                        + "Atirar - <strong>G</strong><br>"
                        + "Cima - <strong>W</strong><br>"
                        + "Baixo - <strong>S</strong><br>"
                        + "Esquerda - <strong>A</strong><br>"
                        + "Direita - <strong>D</strong><br><br>"
                        + "<strong>Nave 2</strong><br>"
                        + "Atirar - <strong>Insert</strong><br>"
                        + "Cima - <strong>SETA UP</strong><br>"
                        + "Baixo - <strong>SETA DOWN</strong><br>"
                        + "Esquerda - <strong>SETA LEFT</strong><br>"
                        + "Direita - <strong>SETA RIGHT</strong><br>"
                        + "</html>", "Como se Joga", JOptionPane.QUESTION_MESSAGE);
            });
        // Add coj and sobre menu item to ajuda menu
        ajuda.add(coj);
        ajuda.add(sobre);
        // Add jogo and ajuda menu to the Menu Bar
        menub.add(jogo);
        menub.add(ajuda);
        // Return the menu bar
        return menub;
    }

    private void inicializaInimigos() {
        inimigos = new ArrayList<>();
        Inimigo inimigo = new Inimigo();
        ImagemProxy imagemInimigoUm = new ImagemProxy("/com/spacegreating/sprites/inimigo_1.gif");
        ImagemProxy imagemInimigoDois = new ImagemProxy("/com/spacegreating/sprites/inimigo_2.gif");
        for (int i = 0; i < 100; i++) {
            Inimigo ini = (Inimigo) inimigo.clone();
            ini.setX(Inimigo.GerarPosX());
            ini.setY(Inimigo.GerarPosY());
            
            if (i % 3 == 0) {
                ini.setImagem(imagemInimigoDois.carregarImagem().getImage());
            }else{
                ini.setImagem(imagemInimigoUm.carregarImagem().getImage());
            }
            
            ini.setAltura(ini.getImagem().getHeight(null));
            ini.setLargura(ini.getImagem().getWidth(null));

            ini.setVisivel(true);
            inimigos.add(ini);
        }
    }

    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);

        if (emJogo) {

            if (naveUm.isMorto() == false) {
                graficos.drawImage(naveUm.getImagem(), naveUm.getX(), naveUm.getY(), this);
            }
            if (p2 == true) {
                if (naveDois.isMorto() == false) {
                    ImageIcon naveDois_ = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/nave2.gif"));
                    naveDois.setImagem(naveDois_.getImage());
                    graficos.drawImage(naveDois.getImagem(), naveDois.getX(), naveDois.getY(), this);
                }
            }

            List<Missel> misseis1 = naveUm.getMisseis();
            List<Missel> misseis2 = naveDois.getMisseis();

            for (int i = 0; i < misseis1.size(); i++) {

                Missel m = (Missel) misseis1.get(i);
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

            }
            for (int i = 0; i < misseis2.size(); i++) {

                Missel m = (Missel) misseis2.get(i);
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

            }

            for (int i = 0; i < inimigos.size(); i++) {

                Inimigo in = inimigos.get(i);
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);

            }

            graficos.setColor(Color.WHITE);
            graficos.drawString("INIMIGOS: " + inimigos.size(), 5, 15);

        } else if (ganhoJogo) {

            ImageIcon ganhojogo = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/jogo_vencido.png"));

            graficos.drawImage(ganhojogo.getImage(), 0, 0, null);

        } else if (inicio) {

            ImageIcon bg_ = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/Tela_Inicio.png"));
            Inicio = bg_.getImage();
            graficos.drawImage(Inicio, 0, 0, null);

        } else {
            ImageIcon fimJogo = new ImageIcon(getClass().getResource("/com/spacegreating/sprites/game_over.png"));

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

        List<Missel> misseis1 = naveUm.getMisseis();
        List<Missel> misseis2 = naveDois.getMisseis();

        for (int i = 0; i < misseis1.size(); i++) {

            Missel m = (Missel) misseis1.get(i);

            if (m.isVisivel()) {
                m.mexer();
            } else {
                misseis1.remove(i);
            }

        }
        for (int i = 0; i < misseis2.size(); i++) {

            Missel m = (Missel) misseis2.get(i);

            if (m.isVisivel()) {
                m.mexer();
            } else {
                misseis2.remove(i);
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

        naveUm.mexer();
        naveDois.mexer();
        checarColisoes();
        if (p2 == true) {
            if (naveUm.isMorto() && naveDois.isMorto()) {

                emJogo = false;

            }
        }
        repaint();
    }

    public void checarColisoes() {

        Rectangle formaNave1 = naveUm.getBounds();
        Rectangle formaNave2 = naveDois.getBounds();
        Rectangle formaInimigo;
        Rectangle formaMissel;

        for (int i = 0; i < inimigos.size(); i++) {

            Inimigo tempInimigo = inimigos.get(i);
            formaInimigo = tempInimigo.getBounds();

            if (formaNave1.intersects(formaInimigo)) {
                naveUm.setVisivel(false);
                naveUm.setMorto(true);
                if (p2 == false) {
                    emJogo = false;
                }
            }
            if (formaNave2.intersects(formaInimigo)) {
                naveDois.setVisivel(false);
                naveDois.setMorto(true);
            }
            if(naveUm.isMorto() == false && naveDois.isMorto() == false){
                if (formaNave1.intersects(formaNave2)){
                    naveUm.setDx(0);
                    naveUm.setDy(0);
                }
                if (formaNave2.intersects(formaNave1)){
                    naveDois.setDx(0);
                    naveDois.setDy(0);
                }
            }

        }

        List<Missel> misseis1 = naveUm.getMisseis();
        List<Missel> misseis2 = naveDois.getMisseis();

        for (int i = 0; i < misseis1.size(); i++) {

            Missel tempMissel = misseis1.get(i);
            formaMissel = tempMissel.getBounds();

            for (int j = 0; j < inimigos.size(); j++) {

                Inimigo tempInimigo = inimigos.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {

                    tempInimigo.setVisivel(false);
                    tempMissel.setVisivel(false);

                }
                if(formaMissel.intersects(formaNave2)){
                    
                    tempMissel.setVisivel(false);
                }

            }

        }
        for (int i = 0; i < misseis2.size(); i++) {

            Missel tempMissel = misseis2.get(i);
            formaMissel = tempMissel.getBounds();

            for (int j = 0; j < inimigos.size(); j++) {

                Inimigo tempInimigo = inimigos.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {

                    tempInimigo.setVisivel(false);
                    tempMissel.setVisivel(false);

                }
                  if(formaMissel.intersects(formaNave1)){
                    
                    tempMissel.setVisivel(false);
                }

            }

        }
    }
    
    public boolean getP2(){
        return this.p2;
    }

    private class TecladoAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (emJogo == false) {
                    emJogo = true;
                    naveUm.setMorto(false);
                    naveDois.setMorto(false);
                    ganhoJogo = false;
                    if (inicio == true) {
                        inicio = false;
                    }
                    
                    naveUm.setX(100);
                    naveUm.setY(100);
                    
                    naveDois.setX(100);
                    naveDois.setY(200);
                    
                    inicializaInimigos();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                emJogo = false;
            }

            naveUm.getControle().controle(naveUm, e);
            if(p2)
                naveDois.getControle().controle(naveDois, e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            naveUm.getControle().controle(naveUm, e);
            if(p2)
                naveDois.getControle().controle(naveDois, e);
        }

    }
}
