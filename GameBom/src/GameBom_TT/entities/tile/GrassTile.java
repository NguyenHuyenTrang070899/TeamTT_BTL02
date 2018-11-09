package GameBom_TT.entities.tile;


import GameBom_TT.entities.Entity;
import GameBom_TT.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public boolean collide(Entity e) {
		return true;
	}
}
