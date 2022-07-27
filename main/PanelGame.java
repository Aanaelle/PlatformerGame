package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;





public class PanelGame extends JPanel
{
    private MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;

    private BufferedImage img;
    private BufferedImage[] idleAnim;
 

    public PanelGame() 
    {        
        importImg();
        loadAnimations();

        //taille de la frame
        setPanelSize();

        //Inputs
        this.mouseInputs = new MouseInputs(this);
        
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(this.mouseInputs);
        addMouseMotionListener(this.mouseInputs);

        
    }


    private void loadAnimations() 
    {
        this.idleAnim = new BufferedImage[5];

        for (int )
    }


    private void importImg() 
    {
        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        
    }


    //gérer la taille de la frame par rapport à l'image
    private void setPanelSize() 
    {
        Dimension size = new Dimension(1280,800);

        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
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

        //this.subImg = this.img.getSubimage(1*64, 8*40, 64, 40);
        g.drawImage(this.subImg, (int) xDelta, (int) yDelta, 128, 80, this);     

    }
}
