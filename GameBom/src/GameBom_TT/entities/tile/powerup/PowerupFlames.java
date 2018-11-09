package GameBom_TT.entities.tile.powerup;

import GameBom_TT.Game;
import GameBom_TT.entities.Entity;
import GameBom_TT.entities.mob.Player;
import GameBom_TT.graphics.Sprite;

public class PowerupFlames extends Powerup {

	public PowerupFlames(int x, int y, int level, Sprite sprite) {
		super(x, y, level, sprite);
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player) {
			((Player) e).addPowerup(this);
			remove();
			return true;
		}
		
		return false;
	}
	
	@Override
	public void setValues() {
		_active = true;
		Game.addBombRadius(1);
	}
	


}
