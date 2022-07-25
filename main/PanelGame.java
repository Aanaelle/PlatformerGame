package main;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.Graphics;



public class PanelGame extends JPanel
{
    private MouseInputs mouseInputs;
    private int xDelta = 100;
    private int yDelta = 100;
    private int xDir = 1;
    private int yDir = 1;

    private int frames = 0;
    private long lastCheck =0;

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
    }

    public void changeYDelta(int value)
    {
        this.yDelta += value;
    }

    public void setRectPos(int x, int y)
    {
        this.xDelta = x;
        this.yDelta = y;
    }


    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        updateRectangle();
        
        g.fillRect( xDelta, yDelta, 200, 50);

        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000)
        {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS : " + frames);
            frames=0;
        }

        repaint();
    }

    private void updateRectangle() 
    {
        this.xDelta += xDir;
        if(this.xDelta > 400)
            xDir = -1;

        this.yDelta++;
    }
}
