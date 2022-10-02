package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager {

	private Game game;
	private BufferedImage levelSprite;
	
	public LevelManager(Game game)
	{
		this.game = game;
		this.levelSprite = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
		importOutsideSprites();
	}
	
	private void importOutsideSprites() {
		//levelSprite = new BufferedImage[];
		
	}

	public void draw(Graphics g)
	{
		g.drawImage(levelSprite, 0, 0, null);
	}
	
	public void update()
	{
		
	}
}
