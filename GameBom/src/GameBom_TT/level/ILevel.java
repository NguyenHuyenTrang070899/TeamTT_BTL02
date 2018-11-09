package GameBom_TT.level;


import GameBom_TT.exceptions.LoadLevelException;

public interface ILevel {

	public void loadLevel(String path) throws LoadLevelException;
}
