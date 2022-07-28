package main;



public class Game implements Runnable
{
    private FrameGame frameGame;
    private PanelGame panelGame;
    private Thread    gameThread;

    private final int FPS_SET = 120;
    private final int UPS_SET = 200;


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
        double timePerFrame  = 1_000_000_000.0 / FPS_SET;
        double timePerUpdate = 1_000_000_000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        
        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;

        double deltaU = 0;

        long lastCheck = System.currentTimeMillis();

        while(true)
        {
            now = System.nanoTime();
            long currentTime = System.nanoTime();

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
