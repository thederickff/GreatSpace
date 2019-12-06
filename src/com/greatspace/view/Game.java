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
 * Date: 13/02/2016
 */
public class Game extends JPanel implements ActionListener {

    private int recp;
    private final Image background;
    private Image Inicio;
    private final Player nave;
    private final Timer timer;
    private final Player playeOne;
    private final Player playerTwo;

    private boolean p2 = false;
    private boolean playing;
    private boolean begin;
    private boolean isWon;

    private List<Enemy> enemies;

    public Game()
    {

        this.nave = new Player();

        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());

        ImageIcon referencia = new ImageIcon(getClass().getResource("/com/greatspace/sprites/background.png"));
        background = referencia.getImage();

        playeOne = (Player) nave.clone();
        playeOne.setX(100);
        playeOne.setY(100);
        playeOne.setControle(Controller.PLAYER_1);

        playerTwo = (Player) nave.clone();
        playerTwo.setX(100);
        playerTwo.setY(200);
        playerTwo.setControle(Controller.PLAYER_2);

        playing = false;
        isWon = false;
        begin = true;

        initEnemy();

        timer = new Timer(5, this);
        timer.start();
    }

    public void checkPlayer()
    {
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

    public JMenuBar criarMenu()
    {
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
        about.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "<html><strong>Great Space</strong><br> "
                    + "Developed by <strong>Derick Felix</strong>!<br><br>"
                    + "<strong>What's new:</strong><br><br>"
                    + "- Bug Fixes <br>"
                    + "- Changes in game controler <br>"
                    + "<br></html>", "About", 1);
        });
        JMenuItem htp = new JMenuItem("How to Play");
        htp.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "<html>"
                    + "<strong>Player 1</strong><br>"
                    + "Fire - <strong>Space</strong><br>"
                    + "Up - <strong>W</strong><br>"
                    + "Down - <strong>S</strong><br>"
                    + "Left - <strong>A</strong><br>"
                    + "Right - <strong>D</strong><br><br>"
                    + "<strong>Player 2</strong><br>"
                    + "Fire - <strong>Insert</strong><br>"
                    + "Up - <strong>UP ARROW</strong><br>"
                    + "Down - <strong>DOWN ARROW</strong><br>"
                    + "Left - <strong>LEFT ARROW</strong><br>"
                    + "Right - <strong>RIGHT ARROW</strong><br>"
                    + "</html>", "How to play", JOptionPane.QUESTION_MESSAGE);
        });

        help.add(htp);
        help.add(about);

        menub.add(game);
        menub.add(help);

        return menub;
    }

    private void initEnemy()
    {
        enemies = new ArrayList<>();
        Enemy enemy = new Enemy();

        ProxyImage enemyOneImage = new ProxyImage("/com/greatspace/sprites/enemy_1.gif");
        ProxyImage enemyTwoImage = new ProxyImage("/com/greatspace/sprites/enemy_2.gif");

        for (int i = 0; i < 100; i++) {
            Enemy ini = (Enemy) enemy.clone();
            ini.setX(Enemy.GeneratePosX());
            ini.setY(Enemy.GeneratePosY());

            if (i % 3 == 0) {
                ini.setImage(enemyTwoImage.loadImage().getImage());
            } else {
                ini.setImage(enemyOneImage.loadImage().getImage());
            }

            ini.setHeight(ini.getImage().getHeight(null));
            ini.setWidth(ini.getImage().getWidth(null));

            ini.setVisibility(true);
            enemies.add(ini);
        }
    }

    @Override
    public void paint(Graphics g)
    {

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(background, 0, 0, null);

        if (playing) {

            if (playeOne.isDead() == false) {
                graficos.drawImage(playeOne.getImage(), playeOne.getX(), playeOne.getY(), this);
            }
            if (p2 == true) {
                if (playerTwo.isDead() == false) {
                    ImageIcon naveDois_ = new ImageIcon(getClass().getResource("/com/greatspace/sprites/ship2.gif"));
                    playerTwo.setImage(naveDois_.getImage());
                    graficos.drawImage(playerTwo.getImage(), playerTwo.getX(), playerTwo.getY(), this);
                }
            }

            List<Bullet> bullets1 = playeOne.getBullet();
            List<Bullet> bullets2 = playerTwo.getBullet();

            for (int i = 0; i < bullets1.size(); i++) {

                Bullet m = (Bullet) bullets1.get(i);
                graficos.drawImage(m.getImage(), m.getX(), m.getY(), this);

            }
            for (int i = 0; i < bullets2.size(); i++) {

                Bullet m = (Bullet) bullets2.get(i);
                graficos.drawImage(m.getImage(), m.getX(), m.getY(), this);

            }

            for (int i = 0; i < enemies.size(); i++) {

                Enemy in = enemies.get(i);
                graficos.drawImage(in.getImage(), in.getX(), in.getY(), this);

            }

            graficos.setColor(Color.WHITE);
            graficos.drawString("Enemies: " + enemies.size(), 5, 15);

        } else if (isWon) {

            ImageIcon wonImage = new ImageIcon(getClass().getResource("/com/greatspace/sprites/game_won.png"));

            graficos.drawImage(wonImage.getImage(), 0, 0, null);

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
    public void actionPerformed(ActionEvent arg0)
    {

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (enemies.isEmpty()) {
            playing = false;
            isWon = true;
        }

        List<Bullet> bullets1 = playeOne.getBullet();
        List<Bullet> bullets2 = playerTwo.getBullet();

        for (int i = 0; i < bullets1.size(); i++) {

            Bullet m = (Bullet) bullets1.get(i);

            if (m.isVisible()) {
                m.mexer();
            } else {
                bullets1.remove(i);
            }

        }
        for (int i = 0; i < bullets2.size(); i++) {

            Bullet m = (Bullet) bullets2.get(i);

            if (m.isVisible()) {
                m.mexer();
            } else {
                bullets2.remove(i);
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
                playing = false;
            }
        }
        repaint();
    }

    public void findCollision()
    {

        Rectangle p1Bounds = playeOne.getBounds();
        Rectangle p2Bounds = playerTwo.getBounds();
        Rectangle formaInimigo;
        Rectangle formaMissel;

        for (int i = 0; i < enemies.size(); i++) {

            Enemy tempInimigo = enemies.get(i);
            formaInimigo = tempInimigo.getBounds();

            if (p1Bounds.intersects(formaInimigo)) {
                playeOne.setVisibility(false);
                playeOne.setMorto(true);
                if (p2 == false) {
                    playing = false;
                }
            }
            if (p2Bounds.intersects(formaInimigo)) {
                playerTwo.setVisibility(false);
                playerTwo.setMorto(true);
            }
            if (playeOne.isDead() == false && playerTwo.isDead() == false) {
                if (p1Bounds.intersects(p2Bounds)) {
                    playeOne.setDx(0);
                    playeOne.setDy(0);
                }
                if (p2Bounds.intersects(p1Bounds)) {
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
                if (formaMissel.intersects(p2Bounds)) {

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
                if (formaMissel.intersects(p1Bounds)) {

                    tempMissel.setVisibility(false);
                }

            }

        }
    }

    public boolean getP2()
    {
        return this.p2;
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (playing == false) {
                    playing = true;
                    playeOne.setMorto(false);
                    playerTwo.setMorto(false);
                    isWon = false;
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
                playing = false;
            }

            playeOne.getControle().keyPressed(playeOne, e);
            if (p2) {
                playerTwo.getControle().keyPressed(playerTwo, e);
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            playeOne.getControle().keyReleased(playeOne, e);
            if (p2) {
                playerTwo.getControle().keyReleased(playerTwo, e);
            }
        }

    }
}
