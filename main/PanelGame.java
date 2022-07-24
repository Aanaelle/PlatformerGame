package main;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.Graphics;


public class PanelGame extends JPanel
{
    private MouseInputs mouseInputs;
    private int xDelta = 0;
    private int yDelta = 0;

    public PanelGame() 
    {
        this.mouseInputs = new MouseInputs();
        
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(this.mouseInputs);
        addMouseMotionListener(this.mouseInputs);
    }

    public void changeXDelta(int value)
    {
        this.xDelta = value;
        this.repaint();
    }

    public void changeYDelta(int value)
    {
        this.yDelta = value;
        this.repaint();
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        g.fillRect(100 + xDelta, 100 + yDelta, 200, 50);
    }
}
