package main;

import entities.Player;
import levels.LevelManager;

import java.awt.Graphics;

public class Game implements Runnable
{
    private FrameGame frameGame;
    private PanelGame panelGame;
    private Thread    gameThread;

    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    private Player player;
    private LevelManager levelManager;
    
    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDHT = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH  = TILES_SIZE * TILES_IN_WIDHT;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public Game() 
    {
        this.initClasses();
        this.panelGame = new PanelGame(this);
        this.frameGame = new FrameGame(this.panelGame);
        this.panelGame.requestFocus();
        this.startGameLoop();
    }

    private void initClasses() 
    {
        this.player = new Player(200, 200);
        this.levelManager = new LevelManager(this);
    }

    private void startGameLoop()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update()
    {
        this.player.update();
        this.levelManager.update();
    }

    public void render(Graphics g)
    {
        player.render(g);
        levelManager.draw(g);
    }

    @Override
    public void run() 
    {
        double timePerFrame  = 1_000_000_000.0 / FPS_SET;
        double timePerUpdate = 1_000_000_000.0 / UPS_SET;
        
        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;

        double deltaU = 0;
        double detlaF = 0;

        long lastCheck = System.currentTimeMillis();

        while(true)
        {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            detlaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1)
            {
                update();
                updates++;
                deltaU--;
            }

            if(detlaF >= 1)
            {
                panelGame.repaint();
                frames++;
                detlaF--;
            }


            if(System.currentTimeMillis() - lastCheck >= 1000)
            {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS : " + frames + "| UPS: " + updates );
                frames  = 0;
                updates = 0;
            }

        }        
    }
    
    public void windowFocusLost()
    {
    	player.resetDirBooleans();
    }

    public Player getPlayer()
    {
        return this.player;
    }

}
