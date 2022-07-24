package main;

import javax.swing.JFrame;

public class FrameGame extends JFrame
{
    public FrameGame(PanelGame panelGame) 
    {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelGame);
        this.setLocationRelativeTo(null);


        this.setVisible(true);
    }
}
