package entities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import utilz.LoadSave;
import static utilz.HelpMethods.CanMoveHere;

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
    private int[][] lvlData;
    
    public Player(float x, float y, int width, int height) 
    {
        super(x, y, width, height);
        loadAnimations();
    }
    public void update()
    {
        updatePos();
        updateHitBox();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, width, height, null);
        drawHitBox(g);
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
        if(!left && !right && !up && !down)
        	return;
        
        float xSpeed = 0, ySpeed = 0;
        
        
        
        //verifie si on appuie pas sur deux touches en même temps
        //left and right
        if(left && !right)
            xSpeed = -playerSpeed;
        else if (right && !left)
        	xSpeed = playerSpeed;
   
        //up and down
        if(up && !down)
        	ySpeed = -playerSpeed;
        else if (down && !up)
        	ySpeed = playerSpeed;
 
        if(CanMoveHere(x+xSpeed, y+ySpeed, width, height, lvlData))
        {
        	this.x += xSpeed;
        	this.y += ySpeed;
        	moving = true;
        }
            
    }

    private void loadAnimations() 
    {
		BufferedImage img = LoadSave.getSpriteAtlas(LoadSave.PLAYER_ATLAS);
		
		this.animations = new BufferedImage[9][6];
		
		for (int j = 0; j < this.animations.length; j++ )
		    for (int i =0; i < this.animations[j].length; i++)
		        this.animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);

    }
    
    public void loadLvlData(int[][] lvlData)
    {
    	this.lvlData = lvlData;
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

