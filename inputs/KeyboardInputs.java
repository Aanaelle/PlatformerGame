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
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
            case KeyEvent.VK_Q:
                panelGame.setMoving(false);
                break;
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_Z:
                this.panelGame.setDirection(UP);
                break;
            case KeyEvent.VK_S:
                this.panelGame.setDirection(DOWN);
                break;
            case KeyEvent.VK_D:
                this.panelGame.setDirection(RIGHT);
                break;
            case KeyEvent.VK_Q:
                this.panelGame.setDirection(LEFT);
                break;
        }

      
    }

}
