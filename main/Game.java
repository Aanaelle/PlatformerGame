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

    public void update()
    {
        panelGame.updateGame();
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
}
