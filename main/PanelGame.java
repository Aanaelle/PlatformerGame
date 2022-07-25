package main;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PanelGame extends JPanel
{
    private MouseInputs mouseInputs;
    private int xDelta = 100;
    private int yDelta = 100;

    public PanelGame() 
    {
        this.mouseInputs = new MouseInputs(this);
        
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(this.mouseInputs);
        addMouseMotionListener(this.mouseInputs);
    }

    //méthode pour modifié les coordonnées du rectangle
    public void changeXDelta(int value)
    {
        this.xDelta += value;
        this.repaint();
    }

    public void changeYDelta(int value)
    {
        this.yDelta += value;
        this.repaint();
    }

    public void setRectPos(int x, int y)
    {
        this.xDelta = x;
        this.yDelta = y;
        this.repaint();
    }


    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        g.fillRect( xDelta, yDelta, 200, 50);
    }
}
