package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity 
{
    protected float x;
    protected float y;
    
    protected int width;
    protected int height;
    protected Rectangle hitBox;
    

    public Entity(float x, float y, int width, int height) 
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        initHitBox();
    }
    
    protected void drawHitBox(Graphics g)
    {
    	//Pour déboguer hitBox
    	g.setColor(Color.PINK);
    	g.drawRect(this.hitBox.x, this.hitBox.y, this.hitBox.width, this.hitBox.height);
    }


	private void initHitBox() 
	{
		this.hitBox = new Rectangle((int) this.x, (int) this.y, this.width, this.height);		
	}
	
	protected void updateHitBox()
	{
		this.hitBox.x = (int) this.x;
		this.hitBox.y = (int) this.y;
	}
	
	public Rectangle getHitBox()
	{
		return this.hitBox;
	}
 
    

}
