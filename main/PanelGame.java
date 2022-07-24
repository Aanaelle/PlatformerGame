package main;

import javax.swing.JPanel;

import java.awt.Graphics;

public class PanelGame extends JPanel
{
    public PanelGame() 
    {

    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.fillRect(100, 100, 200, 50);
    }
}
