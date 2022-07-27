package main;

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
    }
}
