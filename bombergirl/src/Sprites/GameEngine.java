package Sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameEngine {
    private Image background1 = new Image("pic/tile_grass.png");
    private Image background2 = new Image("pic/tile_wall.png");
    private Player player;

    public void getPlayer(Player player) {
        this.player = player;
    }

    public void render(GraphicsContext pen){
        this.refresh(pen);
        this.drawBackground(pen);
        pen.drawImage(player.getCurrenImage(),player.getX(),player.getY(),48,48);
    }

    public void refresh(GraphicsContext pen){
        pen.clearRect(0,0,640,640);
    }

    public void drawBackground(GraphicsContext pen){
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
                if(i == 0 || i == 20 || j == 0 || j == 20 || (i%2 == 0 && j%2 == 0)){
                    pen.drawImage(background2,i*32,j*32,32,32);
                }
                else pen.drawImage(background1,i*32,j*32,32,32);
            }
        }
    }
}
