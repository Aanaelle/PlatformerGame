package main;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class PanelGame extends JPanel
{
    private MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;
    private float xDir = 1f;
    private float yDir = 1f;


    private Color color = new Color(150,20,90);
    private Random random;

    public PanelGame() 
    {
        this.random = new Random();
        
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
        g.setColor(this.color);
        
        g.fillRect((int) xDelta,(int) yDelta, 200, 50);

        

    }

    private void updateRectangle() 
    {
        this.xDelta += xDir;
        if(this.xDelta > 400 || xDelta < 0)
        {
            xDir *= -1;
            this.color = this.getRndColor();
        }
            
        
        this.yDelta += yDir;
        if(yDelta > 400 || yDelta < 0)
        {
            yDir *= -1;
            this.color = this.getRndColor(); 
        }
           

       
    }

    private Color getRndColor() 
    {
        int r = this.random.nextInt(255);
        int g = this.random.nextInt(255);
        int b = this.random.nextInt(255);
        

        return new Color(r,g,b);
    }
}
