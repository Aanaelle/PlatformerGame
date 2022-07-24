package main;

public class Game 
{
    private FrameGame frameGame;
    private PanelGame panelGame;
    public Game() 
    {
        this.panelGame = new PanelGame();
        this.frameGame = new FrameGame(this.panelGame);
        this.panelGame.requestFocus();
    }
}
