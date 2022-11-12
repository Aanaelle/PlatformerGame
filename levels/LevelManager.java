package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager {

	private Game game;
	private BufferedImage[] levelSprite;
	private Level levelOne;
	
	public LevelManager(Game game)
	{
		this.game = game;
		importOutsideSprites();
		this.levelOne = new Level(LoadSave.getLevelData());
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
		for(int j = 0; j < Game.TILES_IN_HEIGHT; j++) 
			for(int i = 0; i < Game.TILES_IN_WIDHT; i++)
			{
				int index = levelOne.getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], Game.TILES_SIZE*i,Game.TILES_SIZE*j , Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
		
	}
	
	public void update()
	{
		
	}
	
	public Level getCurrentLevel()
	{
		return this.levelOne;
	}
}
