package inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.PanelGame;

import static utilz.Constants.Directions.*;


public class KeyboardInputs implements KeyListener
{
    private PanelGame panelGame;
    
    public KeyboardInputs(PanelGame panelGame)
    {
        this.panelGame = panelGame;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       //
        
    }

    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_Z:
                panelGame.getGame().getPlayer().setUp(false);
                break;
            case KeyEvent.VK_S:
                panelGame.getGame().getPlayer().setDown(false);
                break;
            case KeyEvent.VK_D:
                panelGame.getGame().getPlayer().setRight(false);
                break;
            case KeyEvent.VK_Q:
                panelGame.getGame().getPlayer().setLeft(false);
                break;
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_Z:
                panelGame.getGame().getPlayer().setUp(true);
                break;
            case KeyEvent.VK_S:
                panelGame.getGame().getPlayer().setDown(true);
                break;
            case KeyEvent.VK_D:
                panelGame.getGame().getPlayer().setRight(true);
                break;
            case KeyEvent.VK_Q:
                panelGame.getGame().getPlayer().setLeft(true);
                break;
        }

      
    }

}
