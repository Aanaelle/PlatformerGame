package main;

import java.text.NumberFormat.Style;

public class Game implements Runnable
{
    private FrameGame frameGame;
    private PanelGame panelGame;
    private Thread    gameThread;

    private final int FPS_SET = 120;


    public Game() 
    {
        this.panelGame = new PanelGame();
        this.frameGame = new FrameGame(this.panelGame);
        this.panelGame.requestFocus();
        this.startGameLoop();
    }

    private void startGameLoop()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() 
    {
        double timePerFrame = 1_000_000_000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while(true)
        {
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame)
            {
                panelGame.repaint();
                lastFrame = now;
                frames++;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000)
            {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS : " + frames);
                frames=0;
            }

        }        
    }
}
