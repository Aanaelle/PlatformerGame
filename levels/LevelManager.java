package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager {

	private Game game;
	private BufferedImage[] levelSprite;
	
	public LevelManager(Game game)
	{
		this.game = game;
		//this.levelSprite = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
		importOutsideSprites();
	}
	
	private void importOutsideSprites() 
	{
		BufferedImage img = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
		
		levelSprite = new BufferedImage[48];
		for(int j = 0; j < 4; j++) //hauteur de l'image
			for(int i = 0; i < 12; i++) //largeur de l'image
			{
				int index = j*12 + i;
				this.levelSprite[index] = img.getSubimage(i*32, j*32, 32, 32);
			}
	}

	public void draw(Graphics g)
	{
		g.drawImage(levelSprite[2], 0, 0, null);
	}
	
	public void update()
	{
		
	}
}
