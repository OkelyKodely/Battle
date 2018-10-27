import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioFormat;
public class Battle{
    private JFrame frame = new JFrame();
    private RainPanel panel = new RainPanel();
    private Rambo rambo = new Rambo();
    private Boss1 bs_1 = new Boss1(this);
    private Boss2 bs_2 = new Boss2(this);
    private Boss3 bs_3 = new Boss3(this);
    private Boss4 bs_4 = new Boss4(this);
    private Boss5 bs_5 = new Boss5(this);
    private Boss6 bs_6 = new Boss6(this);
    public int life = 100;
    public int bullet = 100;
    public int bomb = 0;
    public int deadCount = 0;
    public int bx = 0;
    public int bx2 = 1200;
    public int shakeGround = 0;
    public int level = 1;
    public int step = 0;
    private boolean setLevel6 = false;
    private JLabel howToPlayLbl = new JLabel("BATTLE: How to Play?");
    private JLabel txtLbl = new JLabel("To shoot, space; To bomb, enter; To move, arrow Keys");
    public List bs1 = new ArrayList();
    public List<EnemySoldier.Shoot> shoots = new ArrayList<EnemySoldier.Shoot>();
    private List<EnemySoldier> es = new ArrayList<EnemySoldier>();
    private List<Prisoner> p = new ArrayList<Prisoner>();
    private List<Coin> coins = new ArrayList<Coin>();
    public boolean levelBossStart = false;
    public boolean advancedLvl = false;
    private boolean playAgain = false;
    private boolean playPressed = false;
    private String level1Str = "Level 1";
    private String level2Str = "Level 2";
    private String level3Str = "Level 3";
    private String level4Str = "Level 4";
    private String level5Str = "Level 5";
    private String level6Str = "Level 6";
    private String level7Str = "The End";
    private int level1DoneLoading = 0;
    private int level2DoneLoading = 0;
    private int level3DoneLoading = 0;
    private int level4DoneLoading = 0;
    private int level5DoneLoading = 0;
    private int level6DoneLoading = 0;
    private Graphics g;
    private int ft = 0;

    private Battle() {

    }

    public static void main(String[] args) {
        Battle war = new Battle();
        war.setGUI(). addKeyListener();
    }

    private Battle setGUI(){
        Battle.this.frame.setTitle("BATTLE");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.blue);
        frame.setSize(new Dimension(1200, 700));
        frame.setLocation(0, 0);

        JPanel panel3 = new JPanel();
        panel3.setSize(new Dimension(1200, 500));
        panel3.setLocation(0, 0);
        panel3.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.howToPlayLbl.setFont(new java.awt.Font("tahoma", java.awt.Font.PLAIN, 44));
        howToPlayLbl.setForeground(java.awt.Color.yellow);
        howToPlayLbl.setLocation(0, 0);

        txtLbl.setFont(new java.awt.Font("tahoma", java.awt.Font.PLAIN, 22));
        txtLbl.setForeground(java.awt.Color.white);
        txtLbl.setLocation(0, 40);

        JPanel panel2 = new JPanel();
        panel2.setBackground(java.awt.Color.blue);
        panel2.setSize(new Dimension(600, 660 - 200));
        panel2.setLocation(10, 720 - 200);
        panel2.add(howToPlayLbl);
        panel2.add(txtLbl);

        frame.add(panel2);

        frame.setTitle("BATTLE " + "life: " + life + " bullet: " + this.bullet + " bombs: " + bomb);

        bs_1.pb.setSize(new Dimension(400, 20));
        bs_1.pb.setLocation(700, 720 - 200);

        JLabel bossStr1 = new JLabel("Boss 1 / 7: ");
        bossStr1.setSize(new Dimension(100, 20));
        bossStr1.setLocation(620, 720 - 200);
        bossStr1.setForeground(Color.green);

        frame.add(bs_1.pb);

        frame.add(bossStr1);

        bs_2.pb.setSize(new Dimension(400, 20));
        bs_2.pb.setLocation(700, 750 - 200);

        JLabel bossStr2 = new JLabel("Boss 2 / 7: ");
        bossStr2.setSize(new Dimension(100, 20));
        bossStr2.setLocation(620, 750 - 200);
        bossStr2.setForeground(Color.green);

        frame.add(bs_2.pb);

        frame.add(bossStr2);

        bs_3.pb.setSize(new Dimension(400, 20));
        bs_3.pb.setLocation(700, 780 - 200);

        JLabel bossStr3 = new JLabel("Boss 3 / 7: ");
        bossStr3.setSize(new Dimension(100, 20));
        bossStr3.setLocation(620, 780 - 200);
        bossStr3.setForeground(Color.green);

        frame.add(bs_3.pb);

        frame.add(bossStr3);

        bs_4.pb.setSize(new Dimension(400, 20));
        bs_4.pb.setLocation(700, 810 - 200);

        JLabel bossStr4 = new JLabel("Boss 4 / 7: ");
        bossStr4.setSize(new Dimension(100, 20));
        bossStr4.setLocation(620, 810 - 200);
        bossStr4.setForeground(Color.green);

        frame.add(bs_4.pb);

        frame.add(bossStr4);

        bs_5.pb.setSize(new Dimension(400, 20));
        bs_5.pb.setLocation(700, 840 - 200);

        JLabel bossStr5 = new JLabel("Boss 5 / 7: ");
        bossStr5.setSize(new Dimension(100, 20));
        bossStr5.setLocation(620, 840 - 200);
        bossStr5.setForeground(Color.green);

        frame.add(bs_5.pb);

        frame.add(bossStr5);

        bs_6.pb.setSize(new Dimension(400, 20));
        bs_6.pb.setLocation(700, 870 - 200);

        JLabel bossStr6 = new JLabel("Boss 6 / 7: ");
        bossStr6.setSize(new Dimension(100, 20));
        bossStr6.setLocation(620, 870 - 200);
        bossStr6.setForeground(Color.green);

        frame.add(bs_6.pb);

        frame.add(bossStr6);

        Battle.this.g = panel3.getGraphics();
        
        JButton a = new JButton("Play");
        a.setSize(new Dimension(150,30));
        a.setLocation(500, 300);
        panel2.add(a);
        frame.add(panel3);
        panel3.setLayout(null);
        a.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(ft > 0)
                            frame.remove(panel3);
                        ft++;
                        playPressed = true;
                        panel3.removeAll();
                        frame.add(panel3);
                        JLabel l = new JLabel("Loading...");
                        l.setSize(new Dimension(560, 30));
                        l.setFont(new Font("arial", Font.BOLD, 20));
                        l.setLocation(350, 400);
                        l.setForeground(Color.gray);
                        JProgressBar pb = new JProgressBar();
                        pb.setSize(new Dimension(500, 40));
                        pb.setLocation(540, 380);
                        pb.setValue(0);
                        pb.setMinimum(0);
                        pb.setMaximum(100);
                        a.setText("Loading...");
                        panel3.add(l);
                        panel3.add(pb);
                        panel3.repaint();
                        int c = 0;
                        do {
                            try {
                                Thread.sleep(10);
                            } catch(Exception ee) {}
                            pb.setValue(pb.getValue()+1);
                            l.setText("Loading... " + pb.getValue()+"%");
                            c++;
                        } while(c <= 100);
                        playPressed = false;
                        a.setText("Play");
                        frame.requestFocus();
                        frame.remove(panel3);
                        panel.setSize(new Dimension(1200, 700 - 200));
                        panel.setLocation(0, 0);
                        panel.setBackground(Color.blue);
                        frame.add(panel);
                        Battle.this.start();
                    }
                });
                t.start();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        makeIntro(panel3);
        return this;
    }
    private void makeIntro(final JPanel panel3) {
        Thread th = new Thread(new Runnable() {
            public void run() {
                int c = 0;
                do {
                    ImageIcon i = new ImageIcon(this.getClass().getResource("intro1.png"));
                    if(c == 1)
                        i = new ImageIcon(this.getClass().getResource("intro2.png"));
                    else if(c == 2)
                        i = new ImageIcon(this.getClass().getResource("intro3.png"));
                    else if(c == 3)
                        i = new ImageIcon(this.getClass().getResource("intro4.png"));
                    c+=1;
                    if(c == 4)
                        c = 0;
                    Image im = i.getImage();
                    panel3.getGraphics().drawImage(im, 0, 0, panel3.getWidth(), panel3.getHeight(), null);
                    try {
                        Thread.sleep(3000);
                    } catch(InterruptedException ie) {}
                } while(true);
            }
        });
        th.start();
    }
    private void addKeyListener() {
        KeyListener keyL = new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                     if(bomb > 0) {
                         rambo.throwBomb();
                         --bomb;
                     }
                 }

                 if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                     if(bullet > 2) {
                         rambo.shoot();
                         bullet-=3;
                     }
                 }

                 if(e.getKeyCode() == KeyEvent.VK_UP) {
                     Battle.this.rambo.moveTop();
                 }

                 if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                     Battle.this.rambo.moveLeft();
                 }

                 if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                     rambo.moveBottom();
                 }

                 if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                     rambo.moveRight();
                 }

                 drawSoldier(panel.getGraphics());
            }
        };
        frame.addKeyListener(keyL);
    }
    private void __l123() throws InterruptedException {
        if(this.level!=7){
            frame.setTitle("BATTLE " + "life: " + life + " bullet: " + bullet + " bombs: " + bomb);
        }
        Thread.sleep(17);
        if(level != 7) {
            drawBattleField(g);
            drawSoldier(g);
            drawEnemies(g);
            drawRamboAssets();
            drawCoins();
            drawPrisoners();
        }
    }
    private void start(){
        g = panel.getGraphics();
        randomizeNewEnemySoldiers();
        randomizeNewPrisoners();
        try{
            while(true) {
                if(Battle.this.playPressed) {
                    g.setColor(Color.black);
                    g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
                    level = 1;
                    step = 0;
                    levelBossStart = false;
                    bs1.clear();
                    frame.remove(bs_1.pb);
                    frame.remove(bs_2.pb);
                    frame.remove(bs_3.pb);
                    frame.remove(bs_4.pb);
                    frame.remove(bs_5.pb);
                    frame.remove(bs_6.pb);
                    bs_1 = new Boss1(this);
                    bs_2 = new Boss2(this);
                    bs_3 = new Boss3(this);
                    bs_4 = new Boss4(this);
                    bs_5 = new Boss5(this);
                    bs_6 = new Boss6(this);
                    rambo = new Rambo();
                    bs_1.pb.setSize(new Dimension(400, 20));
                    bs_1.pb.setLocation(700, 720 - 200);
                    frame.add(bs_1.pb);
                    bs_2.pb.setSize(new Dimension(400, 20));
                    bs_2.pb.setLocation(700, 750 - 200);
                    frame.add(bs_2.pb);
                    bs_3.pb.setSize(new Dimension(400, 20));
                    bs_3.pb.setLocation(700, 780 - 200);
                    frame.add(bs_3.pb);
                    bs_4.pb.setSize(new Dimension(400, 20));
                    bs_4.pb.setLocation(700, 810 - 200);
                    frame.add(bs_4.pb);
                    bs_5.pb.setSize(new Dimension(400, 20));
                    bs_5.pb.setLocation(700, 840 - 200);
                    frame.add(bs_5.pb);
                    bs_6.pb.setSize(new Dimension(400, 20));
                    bs_6.pb.setLocation(700, 870 - 200);
                    frame.add(bs_6.pb);
                    life = 100;
                    bullet = 100;
                    bomb = 0;
                    deadCount = 0;
                    p.clear();
                    es.clear();
                    coins.clear();
                    shoots.clear();
                    frame.requestFocus();
                    level1DoneLoading = 0;
                    level2DoneLoading = 0;
                    level3DoneLoading = 0;
                    level4DoneLoading = 0;
                    level5DoneLoading = 0;
                    level6DoneLoading = 0;
                    break;
                }
                
                try {
                    __l123();
                    Battle.this.panel.paintComponent(g);
                    if(es.size() > 0) {

                        for(int i=0; i<rambo.theShoot.size(); i++) {
                            Rambo.Shoot shoot = rambo.theShoot.get(i);
                            shoot.moveRight();

                            drawShoots(shoot);

                            for(int j=0; j<es.size(); j++) {
                                EnemySoldier enemySoldier = es.get(j);
                                if(enemySoldier.didYouDie(shoot.x, shoot.y)) {
                                    makeDyingSound();
                                    es.remove(enemySoldier);
                                    Coin coin = new Coin(shoot.x, shoot.y);
                                    coins.add(coin);
                                    life+=2;
                                }
                            }
                            if(shoot.x > 1200) {
                                rambo.theShoot.remove(shoot);
                            }
                        }

                        for(int i=0; i<rambo.bombs.size(); i++) {
                            Rambo.Bomb bomb = rambo.bombs.get(i);
                            bomb.move();

                            drawBombs(bomb);

                            for(int j=0; j<es.size(); j++) {
                                EnemySoldier enemySoldier = es.get(j);
                                if(bomb != null)
                                if(bomb.stage == 13) {
                                    shakeGround = 5;

                                    drawExplosion(bomb.x, bomb.y);

                                    rambo.bombs.remove(bomb);
                                    if(enemySoldier.didYouExplode(bomb.x, bomb.y)) {
                                        makeDyingSound();

                                        drawExplosion(bomb.x, bomb.y);

                                        es.remove(enemySoldier);
                                        Coin coin = new Coin(bomb.x, bomb.y);
                                        coins.add(coin);
                                        life+=3;
                                    }
                                }
                            }
                        }
                    }

                    if(this.level != 7) {
                        for(int j=0; j<es.size(); j++) {
                            EnemySoldier enemySoldier = es.get(j);
                            enemySoldier.shoot(rambo);
                            enemySoldier.throwBomb();
                            if(enemySoldier.bomb != null) {
                                enemySoldier.bomb.move();

                                drawEnemyBomb(enemySoldier.bomb.x, enemySoldier.bomb.y);

                                if(enemySoldier.bomb.stage == 13) {
                                    shakeGround = 5;

                                    drawExplosion(enemySoldier.bomb.x, enemySoldier.bomb.y);

                                    if(enemySoldier.bomb.x >= rambo.x - 140 && 
                                            enemySoldier.bomb.y >= rambo.y - 140 &&
                                            enemySoldier.bomb.x <= rambo.x + 140 &&
                                            enemySoldier.bomb.y <= rambo.y + 140) {
                                        life -= 5;
                                    }
                                    enemySoldier.bomb = null;
                                }
                            }
                        }
                    }
                    
                    if(Battle.this.rambo.dazed>0) {
                        rambo.dazed = rambo.dazed - 1;
                    }

                    for(int i=0; i<shoots.size(); i++) {
                        EnemySoldier.Shoot shoot = shoots.get(i);
                        shoot.x += shoot.movx;
                        shoot.y += shoot.movy;
                        if(shoot.movx == 0 && shoot.movy == 0)
                            shoot.moveLeft();

                        drawEnemyShoots(shoot);

                        if(shoot.x >= rambo.x && shoot.y >= rambo.y &&
                                shoot.x <= rambo.x + 40 && shoot.y <= rambo.y + 40) {
                            life-=5;
                            rambo.dazed = 52;
                            shoots.remove(shoot);
                        }
                        if(shoot.x < 0) {
                            shoots.remove(shoot);
                        }
                    }

                    if(this.life <= 0) {
                        level = 1;
                        step = 0;
                        levelBossStart = false;
                        bs1.clear();
                        frame.remove(bs_1.pb);
                        frame.remove(bs_2.pb);
                        frame.remove(bs_3.pb);
                        frame.remove(bs_4.pb);
                        frame.remove(bs_5.pb);
                        frame.remove(bs_6.pb);
                        bs_1 = new Boss1(this);
                        bs_2 = new Boss2(this);
                        bs_3 = new Boss3(this);
                        bs_4 = new Boss4(this);
                        bs_5 = new Boss5(this);
                        bs_6 = new Boss6(this);
                        rambo = new Rambo();
                        bs_1.pb.setSize(new Dimension(400, 20));
                        bs_1.pb.setLocation(700, 720 - 200);
                        frame.add(bs_1.pb);
                        bs_2.pb.setSize(new Dimension(400, 20));
                        bs_2.pb.setLocation(700, 750 - 200);
                        frame.add(bs_2.pb);
                        bs_3.pb.setSize(new Dimension(400, 20));
                        bs_3.pb.setLocation(700, 780 - 200);
                        frame.add(bs_3.pb);
                        bs_4.pb.setSize(new Dimension(400, 20));
                        bs_4.pb.setLocation(700, 810 - 200);
                        frame.add(bs_4.pb);
                        bs_5.pb.setSize(new Dimension(400, 20));
                        bs_5.pb.setLocation(700, 840 - 200);
                        frame.add(bs_5.pb);
                        bs_6.pb.setSize(new Dimension(400, 20));
                        bs_6.pb.setLocation(700, 870 - 200);
                        frame.add(bs_6.pb);
                        life = 100;
                        bullet = 100;
                        bomb = 0;
                        deadCount = 0;
                        p.clear();
                        es.clear();
                        coins.clear();
                        shoots.clear();
                        frame.requestFocus();
                        level1DoneLoading = 0;
                        level2DoneLoading = 0;
                        level3DoneLoading = 0;
                        level4DoneLoading = 0;
                        level5DoneLoading = 0;
                        level6DoneLoading = 0;
                    }

                    if(Battle.this.p.size() == 0 && level != 7) {
                        randomizeNewPrisoners();
                    }

                    if(Battle.this.step != 4 && es.size() == 0) {
                        ++step;
                        randomizeNewEnemySoldiers();
                        if(level == 7) {
                            step = 4;
                            es.clear();
                        }
                    }

                    if(Battle.this.step == 4) {
                        if(level == 1) {
                            if(!levelBossStart) {
                                bs_1.x = 800;
                                bs_1.y = 230;
                                levelBossStart = true;
                            }
                            bs_1.shoot(rambo);
                            for(int i=0; i<bs1.size(); i++) {
                                ((Boss1.Shoot)bs1.get(i)).x += ((Boss1.Shoot)bs1.get(i)).movx;
                                ((Boss1.Shoot)bs1.get(i)).y += ((Boss1.Shoot)bs1.get(i)).movy;
                                if(((Boss1.Shoot)bs1.get(i)).x >= rambo.x && ((Boss1.Shoot)bs1.get(i)).y >= rambo.y &&
                                        ((Boss1.Shoot)bs1.get(i)).x <= rambo.x + 40 &&
                                        ((Boss1.Shoot)bs1.get(i)).y <= rambo.y + 40) {
                                    life = life - 5;
                                    rambo.dazed = 170;
                                    bs1.remove(bs1.get(i));
                                }
                            }
                            bs_1.nextMove();

                            drawBossLvlShoots();

                            drawBossLvl(bs_1.x, bs_1.y);

                            for(int i=0; i<rambo.theShoot.size(); i++) {
                                Rambo.Shoot shoot = rambo.theShoot.get(i);
                                shoot.moveRight();

                                drawShoots(shoot);

                                if(shoot.x >= bs_1.x && shoot.y >= bs_1.y &&
                                        shoot.x <= bs_1.x + 300 &&
                                        shoot.y <= bs_1.y + 300) {
                                    bs_1.life = bs_1.life - 1;
                                    bs_1.pb.setValue(bs_1.life);
                                    if(bs_1.life <= 0) {
                                        advancedLvl = true;
                                    }
                                }
                            }
                            for(int i=0; i<rambo.bombs.size(); i++) {
                                Rambo.Bomb bomb = rambo.bombs.get(i);
                                bomb.move();

                                drawBombs(bomb);

                                if(bomb != null)
                                if(bomb.stage == 13) {
                                    shakeGround = 5;
                                    drawExplosion(bomb.x, bomb.y);
                                    rambo.bombs.remove(bomb);
                                    if(bomb.x >= bs_1.x && bomb.y >= bs_1.y &&
                                            bomb.x <= bs_1.x + 300 &&
                                            bomb.y <= bs_1.y + 300) {
                                        bs_1.life = bs_1.life - 55;
                                        bs_1.pb.setValue(bs_1.life);
                                        if(bs_1.life <= 0) {
                                            advancedLvl = true;
                                        }
                                    }
                                }
                            }
                        }
                        else if(level == 2) {
                            if(!levelBossStart) {
                                bs_2.x = 800;
                                bs_2.y = 230;
                                levelBossStart = true;
                            }
                            bs_2.shoot(rambo);
                            for(int i=0; i<bs1.size(); i++) {
                                ((Boss2.Shoot)bs1.get(i)).x += ((Boss2.Shoot)bs1.get(i)).movx;
                                ((Boss2.Shoot)bs1.get(i)).y += ((Boss2.Shoot)bs1.get(i)).movy;
                                if(((Boss2.Shoot)bs1.get(i)).x >= rambo.x && ((Boss2.Shoot)bs1.get(i)).y >= rambo.y &&
                                        ((Boss2.Shoot)bs1.get(i)).x <= rambo.x + 40 &&
                                        ((Boss2.Shoot)bs1.get(i)).y <= rambo.y + 40) {
                                    life = life - 5;
                                    rambo.dazed = 170;
                                    bs1.remove(bs1.get(i));
                                }
                            }
                            bs_2.nextMove();

                            drawBossLvlShoots();

                            drawBossLvl(bs_2.x, bs_2.y);

                            for(int i=0; i<rambo.theShoot.size(); i++) {
                                Rambo.Shoot shoot = rambo.theShoot.get(i);
                                shoot.moveRight();

                                drawShoots(shoot);

                                if(shoot.x >= bs_2.x && shoot.y >= bs_2.y &&
                                        shoot.x <= bs_2.x + 300 &&
                                        shoot.y <= bs_2.y + 300) {
                                    bs_2.life = bs_2.life - 2;
                                    bs_2.pb.setValue(bs_2.life);
                                    if(bs_2.life <= 0) {
                                        advancedLvl = true;
                                    }
                                }
                            }
                            for(int i=0; i<rambo.bombs.size(); i++) {
                                Rambo.Bomb bomb = rambo.bombs.get(i);
                                bomb.move();

                                drawBombs(bomb);

                                if(bomb != null)
                                if(bomb.stage == 13) {
                                    shakeGround = 5;

                                    drawExplosion(bomb.x, bomb.y);

                                    rambo.bombs.remove(bomb);
                                    if(bomb.x >= bs_2.x && bomb.y >= bs_2.y &&
                                            bomb.x <= bs_2.x + 300 &&
                                            bomb.y <= bs_2.y + 300) {
                                        bs_2.life = bs_2.life - 55;
                                        bs_2.pb.setValue(bs_2.life);
                                        if(bs_2.life <= 0) {
                                            advancedLvl = true;
                                        }
                                    }
                                }
                            }
                        }
                        else if(level == 3) {
                            if(!levelBossStart) {
                                bs_3.x = 800;
                                bs_3.y = 230;
                                levelBossStart = true;
                            }
                            bs_3.shoot(rambo);
                            for(int i=0; i<bs1.size(); i++) {
                                ((Boss3.Shoot)bs1.get(i)).x += ((Boss3.Shoot)bs1.get(i)).movx;
                                ((Boss3.Shoot)bs1.get(i)).y += ((Boss3.Shoot)bs1.get(i)).movy;
                                if(((Boss3.Shoot)bs1.get(i)).x >= rambo.x && ((Boss3.Shoot)bs1.get(i)).y >= rambo.y &&
                                        ((Boss3.Shoot)bs1.get(i)).x <= rambo.x + 40 &&
                                        ((Boss3.Shoot)bs1.get(i)).y <= rambo.y + 40) {
                                    rambo.dazed = 170;
                                    life = life - 5;
                                    bs1.remove(bs1.get(i));
                                }
                            }
                            bs_3.nextMove();

                            drawBossLvlShoots();

                            drawBossLvl(bs_3.x, bs_3.y);

                            for(int i=0; i<rambo.theShoot.size(); i++) {
                                Rambo.Shoot shoot = rambo.theShoot.get(i);
                                shoot.moveRight();

                                drawShoots(shoot);

                                if(shoot.x >= bs_3.x && shoot.y >= bs_3.y &&
                                        shoot.x <= bs_3.x + 300 &&
                                        shoot.y <= bs_3.y + 300) {
                                    bs_3.life = bs_3.life - 2;
                                    bs_3.pb.setValue(bs_3.life);
                                    if(bs_3.life <= 0) {
                                        advancedLvl = true;
                                    }
                                }
                            }
                            for(int i=0; i<rambo.bombs.size(); i++) {
                                Rambo.Bomb bomb = rambo.bombs.get(i);
                                bomb.move();

                                drawBombs(bomb);

                                if(bomb != null)
                                if(bomb.stage == 13) {
                                    shakeGround = 5;

                                    drawExplosion(bomb.x, bomb.y);

                                    rambo.bombs.remove(bomb);
                                    if(bomb.x >= bs_3.x && bomb.y >= bs_3.y &&
                                            bomb.x <= bs_3.x + 300 &&
                                            bomb.y <= bs_3.y + 300) {
                                        bs_3.life = bs_3.life - 55;
                                        bs_3.pb.setValue(bs_3.life);
                                        if(bs_3.life <= 0) {
                                            advancedLvl = true;
                                        }
                                    }
                                }
                            }
                        }
                        else if(level == 4) {
                            if(!levelBossStart) {
                                bs_4.x = 800;
                                bs_4.y = 230;
                                levelBossStart = true;
                            }
                            bs_4.shoot(rambo);
                            for(int i=0; i<bs1.size(); i++) {
                                ((Boss4.Shoot)bs1.get(i)).x += ((Boss4.Shoot)bs1.get(i)).movx;
                                ((Boss4.Shoot)bs1.get(i)).y += ((Boss4.Shoot)bs1.get(i)).movy;
                                if(((Boss4.Shoot)bs1.get(i)).x >= rambo.x && ((Boss4.Shoot)bs1.get(i)).y >= rambo.y &&
                                        ((Boss4.Shoot)bs1.get(i)).x <= rambo.x + 40 &&
                                        ((Boss4.Shoot)bs1.get(i)).y <= rambo.y + 40) {
                                    rambo.dazed = 170;
                                    life = life - 6;
                                    bs1.remove(bs1.get(i));
                                }
                            }
                            bs_4.nextMove();

                            drawBossLvlShoots();

                            drawBossLvl(bs_4.x, bs_4.y);

                            for(int i=0; i<rambo.theShoot.size(); i++) {
                                Rambo.Shoot shoot = rambo.theShoot.get(i);
                                shoot.moveRight();

                                drawShoots(shoot);

                                if(shoot.x >= bs_4.x && shoot.y >= bs_4.y &&
                                        shoot.x <= bs_4.x + 300 &&
                                        shoot.y <= bs_4.y + 300) {
                                    bs_4.life = bs_4.life - 2;
                                    bs_4.pb.setValue(bs_4.life);
                                    if(bs_4.life <= 0) {
                                        advancedLvl = true;
                                    }
                                }
                            }
                            for(int i=0; i<rambo.bombs.size(); i++) {
                                Rambo.Bomb bomb = rambo.bombs.get(i);
                                bomb.move();

                                drawBombs(bomb);

                                if(bomb != null)
                                if(bomb.stage == 13) {
                                    shakeGround = 5;

                                    drawExplosion(bomb.x, bomb.y);

                                    rambo.bombs.remove(bomb);
                                    if(bomb.x >= bs_4.x && bomb.y >= bs_4.y &&
                                            bomb.x <= bs_4.x + 300 &&
                                            bomb.y <= bs_4.y + 300) {
                                        bs_4.life = bs_4.life - 55;
                                        bs_4.pb.setValue(bs_4.life);
                                        if(bs_4.life <= 0) {
                                            advancedLvl = true;
                                        }
                                    }
                                }
                            }
                        }
                        else if(level == 5) {
                            if(!levelBossStart) {
                                bs_5.x = 800;
                                bs_5.y = 230;
                                levelBossStart = true;
                            }
                            bs_5.shoot(rambo);
                            for(int i=0; i<bs1.size(); i++) {
                                ((Boss5.Shoot)bs1.get(i)).x += ((Boss5.Shoot)bs1.get(i)).movx;
                                ((Boss5.Shoot)bs1.get(i)).y += ((Boss5.Shoot)bs1.get(i)).movy;
                                if(((Boss5.Shoot)bs1.get(i)).x >= rambo.x && ((Boss5.Shoot)bs1.get(i)).y >= rambo.y &&
                                        ((Boss5.Shoot)bs1.get(i)).x <= rambo.x + 40 &&
                                        ((Boss5.Shoot)bs1.get(i)).y <= rambo.y + 40) {
                                    rambo.dazed = 170;
                                    life = life - 6;
                                    bs1.remove(bs1.get(i));
                                }
                            }
                            bs_5.nextMove();

                            drawBossLvlShoots();

                            drawBossLvl(bs_5.x, bs_5.y);

                            for(int i=0; i<rambo.theShoot.size(); i++) {
                                Rambo.Shoot shoot = rambo.theShoot.get(i);
                                shoot.moveRight();

                                drawShoots(shoot);

                                if(shoot.x >= bs_5.x && shoot.y >= bs_5.y &&
                                        shoot.x <= bs_5.x + 300 &&
                                        shoot.y <= bs_5.y + 300) {
                                    bs_5.life = bs_5.life - 2;
                                    bs_5.pb.setValue(bs_5.life);
                                    if(bs_5.life <= 0) {
                                        advancedLvl = true;
                                    }
                                }
                            }
                            for(int i=0; i<rambo.bombs.size(); i++) {
                                Rambo.Bomb bomb = rambo.bombs.get(i);
                                bomb.move();

                                drawBombs(bomb);

                                if(bomb != null)
                                if(bomb.stage == 13) {
                                    shakeGround = 5;

                                    drawExplosion(bomb.x, bomb.y);

                                    rambo.bombs.remove(bomb);
                                    if(bomb.x >= bs_5.x && bomb.y >= bs_5.y &&
                                            bomb.x <= bs_5.x + 300 &&
                                            bomb.y <= bs_5.y + 300) {
                                        bs_5.life = bs_5.life - 55;
                                        bs_5.pb.setValue(bs_5.life);
                                        if(bs_5.life <= 0) {
                                            advancedLvl = true;
                                        }
                                    }
                                }
                            }
                        }
                        else if(level == 6) {
                            if(!levelBossStart) {
                                bs_6.x = 800;
                                bs_6.y = 230;
                                levelBossStart = true;
                            }
                            bs_6.shoot(rambo);
                            for(int i=0; i<bs1.size(); i++) {
                                ((Boss6.Shoot)bs1.get(i)).x += ((Boss6.Shoot)bs1.get(i)).movx;
                                ((Boss6.Shoot)bs1.get(i)).y += ((Boss6.Shoot)bs1.get(i)).movy;
                                if(((Boss6.Shoot)bs1.get(i)).x >= rambo.x && ((Boss6.Shoot)bs1.get(i)).y >= rambo.y &&
                                        ((Boss6.Shoot)bs1.get(i)).x <= rambo.x + 40 &&
                                        ((Boss6.Shoot)bs1.get(i)).y <= rambo.y + 40) {
                                    rambo.dazed = 170;
                                    life = life - 4;
                                    bs1.remove(bs1.get(i));
                                }
                            }
                            bs_6.nextMove();

                            drawBossLvlShoots();

                            drawBossLvl(bs_6.x, bs_6.y);

                            for(int i=0; i<rambo.theShoot.size(); i++) {
                                Rambo.Shoot shoot = rambo.theShoot.get(i);
                                shoot.moveRight();

                                drawShoots(shoot);

                                if(shoot.x >= bs_6.x && shoot.y >= bs_6.y &&
                                        shoot.x <= bs_6.x + 300 &&
                                        shoot.y <= bs_6.y + 300) {
                                    bs_6.life = bs_6.life - 2;
                                    bs_6.pb.setValue(bs_6.life);
                                    if(bs_6.life <= 0) {
                                        advancedLvl = true;
                                    }
                                }
                            }
                            for(int i=0; i<rambo.bombs.size(); i++) {
                                Rambo.Bomb bomb = rambo.bombs.get(i);
                                bomb.move();

                                drawBombs(bomb);

                                if(bomb != null)
                                if(bomb.stage == 13) {
                                    shakeGround = 5;
                                    drawExplosion(bomb.x, bomb.y);
                                    rambo.bombs.remove(bomb);
                                    if(bomb.x >= bs_6.x && bomb.y >= bs_6.y &&
                                            bomb.x <= bs_6.x + 300 &&
                                            bomb.y <= bs_6.y + 300) {
                                        bs_6.life = bs_6.life - 55;
                                        bs_6.pb.setValue(bs_6.life);
                                        if(bs_6.life <= 0) {
                                            advancedLvl = true;
                                        }
                                    }
                                }
                            }
                        }
                        else if(level == 7) {
                            drawHeaven(panel.getGraphics());
                            if(!setLevel6) {
                                frame.setTitle("You have killed Hitler~");
                                setLevel6 = true;
                            }
                        }
                    }

                    for(int i=0; i<coins.size(); i++) {
                        Coin coin = coins.get(i);
                        if(coin.didYouEatMe(rambo.x, rambo.y)) {
                            makeCoinSound();
                            coins.remove(coin);
                            bullet+=10;
                            bomb+=1;
                        }
                        --coin.ttl;
                        if(coin.ttl <= 0) {
                            coins.remove(coin);
                        }
                    }

                    for(int i=0; i<p.size(); i++) {
                        Prisoner prisoner = p.get(i);
                        if(prisoner.didYouEatMe(rambo.x, rambo.y)) {
                            makeDohSound();
                            p.get(i).image = "prisoner_running.gif";
                        }
                    }
                    
                    if(advancedLvl) {
                        if(level == 1) {
                            bs_1.x = -1000;
                            bs_1.y = -1000;
                            bs_1.life = 1000;
                        }
                        else if(level == 2) {
                            bs_2.x = -1000;
                            bs_2.y = -1000;
                            bs_2.life = 2000;
                        }
                        else if(level == 3) {
                            bs_3.x = -1000;
                            bs_3.y = -1000;
                            bs_3.life = 2500;
                        }
                        else if(level == 4) {
                            bs_4.x = -1000;
                            bs_4.y = -1000;
                            bs_4.life = 3000;
                        }
                        else if(level == 5) {
                            bs_5.x = -1000;
                            bs_5.y = -1000;
                            bs_5.life = 5000;
                        }
                        else if(level == 6) {
                            bs_6.x = -1000;
                            bs_6.y = -1000;
                            bs_6.life = 15000;
                        }
                        step = 0;
                        levelBossStart = false;
                        advancedLvl = false;
                        bs1.clear();
                        ++level;
                    }
                    
                    g.setFont(new Font("tahoma", Font.BOLD, 135));
                    
                    g.setColor(Color.YELLOW);

                    if(level1DoneLoading!=100 && level == 1) {
                        g.drawString(level1Str, 100, 100);
                        level1DoneLoading++;
                    }

                    if(level2DoneLoading!=100 && level == 2) {
                        g.drawString(level2Str, 100, 100);
                        level2DoneLoading++;
                    }

                    if(level3DoneLoading!=100 && level == 3) {
                        g.drawString(level3Str, 100, 100);
                        level3DoneLoading++;
                    }

                    if(level4DoneLoading!=100 && level == 4) {
                        g.drawString(level4Str, 100, 100);
                        level4DoneLoading++;
                    }

                    if(level5DoneLoading!=100 && level == 5) {
                        g.drawString(level5Str, 100, 100);
                        level5DoneLoading++;
                    }

                    if(level6DoneLoading!=100 && level == 6) {
                        g.drawString(level6Str, 100, 100);
                        level6DoneLoading++;
                    }

                    if(level == 7) {
                        g.drawString(level7Str, 100, 100);
                    }
                } catch(Exception e) {}
            }
        } catch(Exception e) {}
    }

    private void drawBossLvlShoots() {
        java.awt.Image img = null;

        String image = "bomb.gif";

        if(level == 1)
            image = "bomb.gif";
        if(level == 2)
            image = "bomb.gif";
        if(level == 3)
            image = "missile.png";
        if(level == 4)
            image = "missile.png";
        if(level == 5)
            image = "bomb.gif";
        if(level == 6)
            image = "missile.png";

        javax.swing.ImageIcon j = new javax.swing.ImageIcon(this.getClass().getResource(image));
        img = j.getImage();

        for(int i=0; i<bs1.size(); i++) {
            try {
                g.drawImage(img, ((Boss1.Shoot)bs1.get(i)).x, ((Boss1.Shoot)bs1.get(i)).y, 22, 22, null);
            } catch(Exception e1) {
                try {
                    g.drawImage(img, ((Boss2.Shoot)bs1.get(i)).x, ((Boss2.Shoot)bs1.get(i)).y, 22, 22, null);
                } catch(Exception e2) {
                    try {
                        g.drawImage(img, ((Boss3.Shoot)bs1.get(i)).x, ((Boss3.Shoot)bs1.get(i)).y, 22, 22, null);
                    } catch(Exception e3) {
                        try {
                            g.drawImage(img, ((Boss4.Shoot)bs1.get(i)).x, ((Boss4.Shoot)bs1.get(i)).y, 22, 22, null);
                        } catch(Exception e4) {
                            try {
                                g.drawImage(img, ((Boss5.Shoot)bs1.get(i)).x, ((Boss5.Shoot)bs1.get(i)).y, 22, 22, null);
                            } catch(Exception e5) {
                                g.drawImage(img, ((Boss6.Shoot)bs1.get(i)).x, ((Boss6.Shoot)bs1.get(i)).y, 22, 22, null);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void drawBossLvl(int x, int y) {
        java.awt.Image img = null;

        String image = null;

        if(level == 1)
            image = "bosslvl1.gif";
        if(level == 2)
            image = "bosslvl2.gif";
        if(level == 3)
            image = "bosslvl3.gif";
        if(level == 4)
            image = "bosslvl4.gif";
        if(level == 5)
            image = "bosslvl5.gif";
        if(level == 6)
            image = "bosslvl6.gif";

        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
        img = i.getImage();

        g.drawImage(img, x, y, 300, 300, null);
    }
    
    private void makeCoinSound() {
        try {
            makeSound("coin.wav");
        } catch(Exception e1) {
            try {
                makeSound("src/coin.wav");
            } catch(Exception e2) {}
        }
    }

    private void makeDohSound() {
        try {
            makeSound("doh.wav");
        } catch(Exception e1) {
            try {
                makeSound("src/doh.wav");
            } catch(Exception e2) {}
        }
    }
        
    private void makeDyingSound() {
        try {
            makeSound("woohoo.wav");
        } catch(Exception e1) {
            try {
                makeSound("src/woohoo.wav");
            } catch(Exception e2) {}
        }
    }

    private void makeSound(String file) throws Exception {

        File audioFile = new File(file);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        AudioFormat format = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.start();
        audioStream.close();
    }

    private void drawCoins() {
        for(int i=0; i<coins.size(); i++) {
            Coin coin = coins.get(i);
            drawCoins(coin);
        }
    }
    
    private void drawCoins(Coin coin) {
        java.awt.Image img = null;

        String image = "coin.png";

        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
        img = i.getImage();

        Battle.this.g.drawImage(img, coin.x, coin.y, 80, 80, null);
    }

    private void drawRamboAssets() {
        for(int i=0; i<rambo.theShoot.size(); i++) {
            Rambo.Shoot shoot = rambo.theShoot.get(i);

            shoot.moveRight();

            drawShoots(shoot);
        }

        for(int i=0; i<rambo.bombs.size(); i++) {
            Rambo.Bomb bomb = rambo.bombs.get(i);

            bomb.moveRight();

            drawBombs(bomb);
        }
    }
    
    private void drawHeaven(Graphics g) {
        if(level != 5)
            return;

        java.awt.Image img = null;

        String image = "heaven.gif";

        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
        img = i.getImage();

        Battle.this.g.drawImage(img, 0, 0, panel.getWidth(), panel.getHeight(), null);
    }
    
    private void drawBattleField(Graphics g) {
        BufferedImage bi = null;

        String image = null;

        if(level == 1) {
            image = "b1.png";
        } else if(level == 2) {
            image = "b2.png";
        } else if(level == 3) {
            image = "b3.png";
        } else if(level == 4) {
            image = "b4.png";
        } else if(level == 5) {
            image = "b5.png";
        } else if(level == 6) {
            image = "b2.png";
        }

        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));

        bi = new BufferedImage(
            i.getIconWidth(),
            i.getIconHeight(),
            BufferedImage.TYPE_INT_RGB);
        Graphics gg = bi.createGraphics();

        i.paintIcon(null, gg, 0,0);

        int width = bi.getWidth();
        int height = bi.getHeight();

        BufferedImage mimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for(int y = 0; y < height; y++){
          for(int lx = 0, rx = width - 1; lx < width; lx++, rx--){
            int p = bi.getRGB(lx, y);

            mimg.setRGB(rx, y, p);
          }
        }

        g.drawImage(bi, bx, 0, panel.getWidth(), panel.getHeight(), null);
        g.drawImage(mimg, bx2, 0, panel.getWidth(), panel.getHeight(), null);

        if(Battle.this.shakeGround == 0) {
            bx-=5;
            bx2-=5;
        }
        if(shakeGround == 5) {
            bx+=5;
            bx2+=5;
        }
        if(shakeGround == 4) {
            bx-=5;
            bx2-=5;
        }
        if(shakeGround == 3) {
            bx+=5;
            bx2+=5;
        }
        if(shakeGround == 2) {
            bx-=5;
            bx2-=5;
        }
        if(shakeGround == 1) {
            bx+=5;
            bx2+=5;
        }
        if(bx == -1200)
            bx = 1200;
        else if(bx2 == -1200)
            bx2 = 1200;
        if(shakeGround > 0)
            shakeGround--;
    }

    private void drawExplosion(int x, int y) {
        java.awt.Image imgFb = null;

        String imageFb = "explosion.gif";

        javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
        imgFb = iFb.getImage();

        g.drawImage(imgFb, x-500, y-500, 1000, 1000, null);
    }
    
    private void drawEnemyBomb(int x, int y) {
        java.awt.Image imgFb = null;

        String imageFb = "bomb.gif";

        javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
        imgFb = iFb.getImage();

        g.drawImage(imgFb, x, y, 50, 50, null);
    }

    private void drawBombs(Rambo.Bomb bomb) {
        if(bomb == null)
            return;

        java.awt.Image imgFb = null;

        String imageFb = "bomb.gif";

        javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
        imgFb = iFb.getImage();

        g.drawImage(imgFb, bomb.x, bomb.y, 50, 50, null);
    }

    private void drawShoots(Rambo.Shoot shoot) {
        if(shoot == null)
            return;

        java.awt.Image imgFb = null;

        String imageFb = "shoot.gif";

        javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
        imgFb = iFb.getImage();

        g.drawImage(imgFb, shoot.x, shoot.y, 50, 50, null);
    }
    
    private void drawEnemyShoots(EnemySoldier.Shoot shoot) {
        if(shoot == null)
            return;
        
        Graphics2D g2d = (Graphics2D) this.g;
        
        java.awt.Image imgFb = null;

        String imageFb = "shoot.gif";

        javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
        imgFb = iFb.getImage();

        AffineTransform at = AffineTransform.getTranslateInstance(shoot.x, shoot.y);
        at.scale(0.3, 0.3);
        at.rotate(Math.toRadians(-180 + (int) Math.toDegrees(Math.atan2(shoot.awayHeight, shoot.awayWidth))));
        g2d.drawImage(imgFb, at, null);
    }

    private void drawPrisoners() {
        for(int i=0; i<p.size(); i++) {
            java.awt.Image imgFb = null;
            
            String imageFb = p.get(i).image;
            
            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();
            
            if(p.get(i).image.equals("prisoner_running.gif")) {
                p.get(i).x-=10;
            }
            g.drawImage(imgFb, p.get(i).x, p.get(i).y, 120, 120, null);
            if(p.get(i).x < 0) {
                p.remove(p.get(i));
                bullet+=5;
            }
        }
    }

    private void drawEnemies(Graphics g) {
        for(int i=0; i<es.size(); i++) {
            EnemySoldier sold = es.get(i);
            
            java.awt.Image imgSold = null;
            
            String imageSold = "enemysoldier.gif";
            
            if(level == 1)
                imageSold = "enemysoldier.gif";
            if(level == 2)
                imageSold = "enemysoldier2.gif";
            if(level == 3)
                imageSold = "enemysoldier3.gif";
            if(level == 4)
                imageSold = "enemysoldier4.gif";
            if(level == 5)
                imageSold = "enemysoldier5.gif";
            if(level == 6)
                imageSold = "enemysoldier3.gif";
            
            javax.swing.ImageIcon iSold = new javax.swing.ImageIcon(this.getClass().getResource(imageSold));
            imgSold = iSold.getImage();
            g.drawImage(imgSold, sold.x, sold.y, sold.width, sold.height, null);
            
            sold.nextMove();
            
            if(sold.x < 700 && sold.PLACE.equals("normal")) {
                sold.PLACE = "700";
                sold.width += 10;
                sold.height += 10;
            }
            if(sold.x < 600 && sold.PLACE.equals("700")) {
                sold.PLACE = "600";
                sold.width += 10;
                sold.height += 10;
            }
            if(sold.x < 500 && sold.PLACE.equals("600")) {
                sold.PLACE = "500";
                sold.width += 10;
                sold.height += 10;
            }
            if(sold.x < 400 && sold.PLACE.equals("500")) {
                sold.PLACE = "400";
                sold.width += 10;
                sold.height += 10;
            }
            if(sold.x < 0) {
                es.remove(sold);
            }
        }
    }
    
    private void drawSoldier(Graphics g) {
        java.awt.Image img = null;
        
        String image = "soldier.gif";
        
        if(rambo.dazed > 0)
            image = "dazed.gif";
        
        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
        img = i.getImage();
        
        g.drawImage(img, rambo.x, rambo.y, 60, 60, null);
    }

    private void randomizeNewEnemySoldiers() {
        for(int i = 0; i < 10; i++) {
            Battle.this.es.add( new EnemySoldier(this));
        }

    }
    private void randomizeNewPrisoners() {
        for(int i = 0; i < 5; i++) {
            Battle.this.p.add( new Prisoner());
        }

    }
    public void randomizeMiniNewEnemySoldiers() {
        for(int i = 0; i < 6; i++) {
            Battle.this.es.add( new EnemySoldier(this));
        }

    }
}