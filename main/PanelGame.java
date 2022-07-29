package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.InputStream;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;




public class PanelGame extends JPanel
{
    private MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;

    private BufferedImage img;
    private BufferedImage[][] animations;
   
    private int aniTick;
    private int aniIndex;
    private int aniSpeed = 15;

    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;

 

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
        this.animations = new BufferedImage[9][6];

        for (int j = 0; j < this.animations.length; j++ )
            for (int i =0; i < this.animations[j].length; i++)
                this.animations[j][i] = this.img.getSubimage(i*64, j*40, 64, 40);
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

    public void setDirection(int direction)
    {
        this.playerDir = direction;
        this.moving = true;
    }

    public void setMoving(boolean moving)
    {
        this.moving = moving;
    }

    private void updateAnimationTick() 
    {
        aniTick++;
        if(aniTick >= aniSpeed )
        {
            aniTick = 0;
            aniIndex++;

            if (aniIndex >= GetSpritAmount(playerAction))
            {
                aniIndex = 0;
            }
        }
    }

    private void setAnimation() 
    {
        if(moving)
            this.playerAction = RUNNING;
        else 
            this.playerAction = IDLE;
    }

    
    private void updatePos() 
    {
        if(moving)
        {
            switch(this.playerDir)
            {
                case LEFT:
                    xDelta -= 5;
                    break;
                case UP:
                    yDelta -= 5;
                    break;
                case RIGHT:
                    xDelta += 5;
                    break;
                case DOWN:
                    yDelta +=5;
                    break;
            }
        }
    }

    public void updateGame()
    {
        updateAnimationTick();
        setAnimation();
        updatePos();
    }



    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(this.animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 256, 160, this);     

    }


}
