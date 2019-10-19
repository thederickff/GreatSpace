package com.greatspace.view;

import com.greatspace.controller.Controller;
import com.greatspace.model.Bullet;
import com.greatspace.model.Enemy;
import com.greatspace.model.Player;
import com.greatspace.proxy.ProxyImage;
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
 * @author: Derick Felix
 * @Data: 02/13/2016
 * @Release: 2.1
 * @Class: Game
 * @Objective: Control the game
 */
public class Game extends JPanel implements ActionListener {

    private int recp;
    private final Image fundo;
    private Image Inicio;
    private final Player nave;
    private final Timer timer;
    private final Player playeOne;
    private final Player playerTwo;

    private boolean p2 = false;
    private boolean emJogo;
    private boolean begin;
    private boolean ganhoJogo;

    private List<Enemy> enemies;

    public Game() {

        this.nave = new Player();

        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());

        ImageIcon referencia = new ImageIcon(getClass().getResource("/com/greatspace/sprites/background.png"));
        fundo = referencia.getImage();

        playeOne = (Player) nave.clone();
        playeOne.setX(100);
        playeOne.setY(100);
        playeOne.setControle(Controller.PLAYER_1);

        playerTwo = (Player) nave.clone();
        playerTwo.setX(100);
        playerTwo.setY(200);
        playerTwo.setControle(Controller.PLAYER_2);

        emJogo = false;
        ganhoJogo = false;
        begin = true;

        initEnemy();

        timer = new Timer(5, this);
        timer.start();
    }

    public void checkPlayer() {
        try {
            recp = Integer.parseInt(JOptionPane.showInputDialog(null, "<html>Type 1 to Singleplayer<br>"
                    + "Type 2 to Multiplayer</html>", "Game type", 1));

            if (recp == 2) {
                p2 = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }

    }

    public JMenuBar criarMenu() {
        // Create a new MenuBar
        JMenuBar menub = new JMenuBar();
        // Create a new Menu
        JMenu game = new JMenu("Game");
        // Create a new Menu Item of Jogo menu
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        // Add fechar menu item to the jogo menu
        game.add(close);

        JMenu help = new JMenu("Help");

        JMenuItem about = new JMenuItem("About");
        about.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "<html><strong>Great Space</strong><br> "
                    + "Developed by <strong>Derick Felix</strong>!<br><br>"
                    + "<strong>What's new:</strong><br><br>"
                    + "- Bug Fixes <br>"
                    + "- Changes in game controler <br>"
                    + "<br></html>", "About", 1);
        });
        JMenuItem htp = new JMenuItem("How to Play");
        htp.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "<html>"
                    + "<strong>Player 1</strong><br>"
                    + "Fire - <strong>Space</strong><br>"
                    + "Up - <strong>Z</strong><br>"
                    + "Down - <strong>S</strong><br>"
                    + "Left - <strong>Q</strong><br>"
                    + "Right - <strong>D</strong><br><br>"
                    + "<strong>Player 2</strong><br>"
                    + "Fire - <strong>Insert</strong><br>"
                    + "Up - <strong>UP ARROW</strong><br>"
                    + "Down - <strong>DOWN ARROW</strong><br>"
                    + "Left - <strong>LEFT ARROW</strong><br>"
                    + "Right - <strong>RIGHT ARROW</strong><br>"
                    + "</html>", "How to play", JOptionPane.QUESTION_MESSAGE);
        });
        // Add coj and sobre menu item to ajuda menu
        help.add(htp);
        help.add(about);
        // Add jogo and ajuda menu to the Menu Bar
        menub.add(game);
        menub.add(help);
        // Return the menu bar
        return menub;
    }

    private void initEnemy() {
        enemies = new ArrayList<>();
        Enemy enemy = new Enemy();
        ProxyImage imagemInimigoUm = new ProxyImage("/com/greatspace/sprites/enemy_1.gif");
        ProxyImage imagemInimigoDois = new ProxyImage("/com/greatspace/sprites/enemy_2.gif");

        for (int i = 0; i < 100; i++) {
            Enemy ini = (Enemy) enemy.clone();
            ini.setX(Enemy.GeneratePosX());
            ini.setY(Enemy.GeneratePosY());

            if (i % 3 == 0) {
                ini.setImagem(imagemInimigoDois.loadImage().getImage());
            } else {
                ini.setImagem(imagemInimigoUm.loadImage().getImage());
            }

            ini.setHeight(ini.getImagem().getHeight(null));
            ini.setWidth(ini.getImagem().getWidth(null));

            ini.setVisibility(true);
            enemies.add(ini);
        }
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);

        if (emJogo) {

            if (playeOne.isDead() == false) {
                graficos.drawImage(playeOne.getImagem(), playeOne.getX(), playeOne.getY(), this);
            }
            if (p2 == true) {
                if (playerTwo.isDead() == false) {
                    ImageIcon naveDois_ = new ImageIcon(getClass().getResource("/com/greatspace/sprites/ship2.gif"));
                    playerTwo.setImagem(naveDois_.getImage());
                    graficos.drawImage(playerTwo.getImagem(), playerTwo.getX(), playerTwo.getY(), this);
                }
            }

            List<Bullet> misseis1 = playeOne.getBullet();
            List<Bullet> misseis2 = playerTwo.getBullet();

            for (int i = 0; i < misseis1.size(); i++) {

                Bullet m = (Bullet) misseis1.get(i);
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

            }
            for (int i = 0; i < misseis2.size(); i++) {

                Bullet m = (Bullet) misseis2.get(i);
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

            }

            for (int i = 0; i < enemies.size(); i++) {

                Enemy in = enemies.get(i);
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);

            }

            graficos.setColor(Color.WHITE);
            graficos.drawString("Enemies: " + enemies.size(), 5, 15);

        } else if (ganhoJogo) {

            ImageIcon ganhojogo = new ImageIcon(getClass().getResource("/com/greatspace/sprites/game_won.png"));

            graficos.drawImage(ganhojogo.getImage(), 0, 0, null);

        } else if (begin) {

            ImageIcon bg_ = new ImageIcon(getClass().getResource("/com/greatspace/sprites/main_menu.png"));
            Inicio = bg_.getImage();
            graficos.drawImage(Inicio, 0, 0, null);

        } else {
            ImageIcon fimJogo = new ImageIcon(getClass().getResource("/com/greatspace/sprites/game_over.png"));

            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (enemies.isEmpty()) {
            emJogo = false;
            ganhoJogo = true;
        }

        List<Bullet> misseis1 = playeOne.getBullet();
        List<Bullet> misseis2 = playerTwo.getBullet();

        for (int i = 0; i < misseis1.size(); i++) {

            Bullet m = (Bullet) misseis1.get(i);

            if (m.isVisible()) {
                m.mexer();
            } else {
                misseis1.remove(i);
            }

        }
        for (int i = 0; i < misseis2.size(); i++) {

            Bullet m = (Bullet) misseis2.get(i);

            if (m.isVisible()) {
                m.mexer();
            } else {
                misseis2.remove(i);
            }

        }

        for (int i = 0; i < enemies.size(); i++) {

            Enemy in = enemies.get(i);

            if (in.isVisible()) {
                in.move(enemies.size());
            } else {
                enemies.remove(i);
            }

        }



        playeOne.mexer();
        playerTwo.mexer();
        findCollision();
        if (p2 == true) {
            if (playeOne.isDead() && playerTwo.isDead()) {

                emJogo = false;

            }
        }
        repaint();
    }

    public void findCollision() {

        Rectangle formaNave1 = playeOne.getBounds();
        Rectangle formaNave2 = playerTwo.getBounds();
        Rectangle formaInimigo;
        Rectangle formaMissel;

        for (int i = 0; i < enemies.size(); i++) {

            Enemy tempInimigo = enemies.get(i);
            formaInimigo = tempInimigo.getBounds();

            if (formaNave1.intersects(formaInimigo)) {
                playeOne.setVisibility(false);
                playeOne.setMorto(true);
                if (p2 == false) {
                    emJogo = false;
                }
            }
            if (formaNave2.intersects(formaInimigo)) {
                playerTwo.setVisibility(false);
                playerTwo.setMorto(true);
            }
            if (playeOne.isDead() == false && playerTwo.isDead() == false) {
                if (formaNave1.intersects(formaNave2)) {
                    playeOne.setDx(0);
                    playeOne.setDy(0);
                }
                if (formaNave2.intersects(formaNave1)) {
                    playerTwo.setDx(0);
                    playerTwo.setDy(0);
                }
            }

        }

        List<Bullet> bulletsOne = playeOne.getBullet();
        List<Bullet> bulletsTwo = playerTwo.getBullet();

        for (int i = 0; i < bulletsOne.size(); i++) {

            Bullet tempMissel = bulletsOne.get(i);
            formaMissel = tempMissel.getBounds();

            for (int j = 0; j < enemies.size(); j++) {

                Enemy tempInimigo = enemies.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {

                    tempInimigo.setVisibility(false);
                    tempMissel.setVisibility(false);

                }
                if (formaMissel.intersects(formaNave2)) {

                    tempMissel.setVisibility(false);
                }

            }

        }
        for (int i = 0; i < bulletsTwo.size(); i++) {

            Bullet tempMissel = bulletsTwo.get(i);
            formaMissel = tempMissel.getBounds();

            for (int j = 0; j < enemies.size(); j++) {

                Enemy tempInimigo = enemies.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {

                    tempInimigo.setVisibility(false);
                    tempMissel.setVisibility(false);

                }
                if (formaMissel.intersects(formaNave1)) {

                    tempMissel.setVisibility(false);
                }

            }

        }
    }

    public boolean getP2() {
        return this.p2;
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (emJogo == false) {
                    emJogo = true;
                    playeOne.setMorto(false);
                    playerTwo.setMorto(false);
                    ganhoJogo = false;
                    if (begin == true) {
                        begin = false;
                    }

                    playeOne.setX(100);
                    playeOne.setY(100);

                    playerTwo.setX(100);
                    playerTwo.setY(200);

                    initEnemy();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                emJogo = false;
            }

            playeOne.getControle().keyPressed(playeOne, e);
            if (p2) {
                playerTwo.getControle().keyPressed(playerTwo, e);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            playeOne.getControle().keyReleased(playeOne, e);
            if (p2) {
                playerTwo.getControle().keyReleased(playerTwo, e);
            }
        }

    }
}
