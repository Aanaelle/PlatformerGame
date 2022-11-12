package levels;

public class Level {
	
	private int[][] lvlData;
	
	public Level(int[][] lvlData)
	{
		this.lvlData = lvlData;
	}
	
	public int getSpriteIndex(int x, int y)
	{
		return this.lvlData[y][x];
	}
	
	public int[][] getLevelData()
	{
		return this.lvlData;
	}
}
