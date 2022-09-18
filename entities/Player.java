package entities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

import java.awt.Graphics;

public class Player extends Entity
{
    private BufferedImage[][] animations;

    private int aniTick;
    private int aniIndex;
    private int aniSpeed = 25;

    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attacking = false;
    private boolean left;
    private boolean up;
    private boolean right;
    private boolean down;
    private float   playerSpeed = 2.0f;
    
    public Player(float x, float y)
    {
        super(x, y);
        loadAnimations();
    }

    public void update()
    {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 160, null);     
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
                aniIndex  = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() 
    {
    	
    	int startAni = playerAction;
    	
        if(moving)
            this.playerAction = RUNNING;
        else 
            this.playerAction = IDLE;
        
        if(attacking)
        	this.playerAction = ATTACK_1;
        
        if (startAni != playerAction)
        	resetAniTick();
    }

    
    private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0;
		
	}

	private void updatePos() 
    {
        moving = false;
        
        //verifie si on appuie pas sur deux touches en même temps
        //left and right
        if(left && !right)
        {
            x-= playerSpeed;
            moving = true;
        }
        else if (right && !left)
        {
            x+= playerSpeed;
            moving = true;
        }

        //up and down
        if(up && !down)
        {
            y-= playerSpeed;
            moving = true;
        }
        else if (down && !up)
        {
            y+= playerSpeed;
            moving = true;
        }

            
    }

    private void loadAnimations() 
    {
        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");

        try {
            BufferedImage img = ImageIO.read(is);

            this.animations = new BufferedImage[9][6];

            for (int j = 0; j < this.animations.length; j++ )
                for (int i =0; i < this.animations[j].length; i++)
                    this.animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);

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
    
    public void resetDirBooleans()
    {
    	this.left  = false;
    	this.right = false;
    	this.up    = false;
    	this.down  = false;
    	
    }

    //getteurs
    public boolean getLeft()      { return this.left;  }
    public boolean getUp()        { return this.up;    }
    public boolean getRight()     { return this.right; }
    public boolean getDown()      { return this.down;  }
    public boolean getAttacking() {return attacking;   }


    //setteurs
    public void setLeft(boolean left)           { this.left = left;   }
    public void setUp(boolean up)               { this.up = up;       }
    public void setRight(boolean right)         { this.right = right; }
    public void setDown(boolean down)           { this.down = down;   }
	public void setAttacking(boolean attacking) { this.attacking = attacking; }

    

}

