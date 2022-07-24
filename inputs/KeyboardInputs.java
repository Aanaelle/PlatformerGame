package inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.PanelGame;



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
    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Z:
                this.panelGame.changeYDelta(-5);
                break;
            case KeyEvent.VK_S:
                this.panelGame.changeYDelta(5);
                break;
            case KeyEvent.VK_D:
                this.panelGame.changeXDelta(5);
                break;
            case KeyEvent.VK_Q:
                this.panelGame.changeXDelta(-5);
                break;
        }
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        
    }
}
