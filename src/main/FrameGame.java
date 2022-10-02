package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class FrameGame extends JFrame
{
    public FrameGame(PanelGame panelGame) 
    {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelGame);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();

        this.setVisible(true);
        this.addWindowFocusListener(new WindowFocusListener(){

			@Override
			public void windowGainedFocus(WindowEvent e) {
				
				
			}

			@Override
			public void windowLostFocus(WindowEvent e) {
				panelGame.getGame().windowFocusLost();
				
			}

        });
    }
}
