package Sprites;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    public enum Control {DEFAULT,UP,DOWN,LEFT,RIGHT,DIE};
    private Control control;
    private int velocity;
    private int frame;
    private int count;
    private int bombMax;
    private int bombStrength;
    private boolean alive;
    private Image betty = new Image("pic/betty.png");
    private PixelReader reader = betty.getPixelReader();
    private List<WritableImage> player_up = new ArrayList<>();
    private List<WritableImage> player_down = new ArrayList<>();
    private List<WritableImage> player_left = new ArrayList<>();
    private List<WritableImage> player_right = new ArrayList<>();
    private WritableImage player_die;

    {
        count = 0;
        frame = 0;
        for(int i = 0; i < 4; i++){
            player_down.add(new WritableImage(reader,i*48,0,48,48));
            player_left.add(new WritableImage(reader,i*48,48,48,48));
            player_up.add(new WritableImage(reader,i*48,48*2,48,48));
            player_right.add(new WritableImage(reader,i*48,48*3,48,48));
        }
        player_die = new WritableImage(reader,0,48*4,48,48);
        currentImage = null;
    }

    public Player(Control control, int x, int y, int velocity){
        this.control = control;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public void setControl(Control control){
        this.control = control;
    }

    public Control getControl(){
        return this.control;
    }

    public boolean isNotWallCollision(){
        return true;
    }

    @Override
    public void update() {
        switch(this.control){
            case DEFAULT: {
                this.currentImage = this.player_down.get(0); break;
            }
            case UP: {
                this.y -= isNotWallCollision()? this.velocity : 0;
                this.currentImage = this.player_up.get(this.frame);
                this.frame = this.frame + ((this.frame == 3 && count%10 == 0)?-3:((count%10 == 0)?1:0));
                count++;
                break;
            }
            case DOWN: {
                this.y += isNotWallCollision()? this.velocity : 0;
                this.currentImage = this.player_down.get(this.frame);
                this.frame = this.frame + ((this.frame == 3 && count%10 == 0)?-3:((count%10 == 0)?1:0));
                count ++;
                break;
            }
            case LEFT: {
                this.x -= isNotWallCollision()? this.velocity : 0;
                this.currentImage = this.player_left.get(this.frame);
                this.frame = this.frame + ((this.frame == 3 && count%10 == 0)?-3:((count%10 == 0)?1:0));
                count ++;
                break;
            }
            case RIGHT: {
                this.x += isNotWallCollision()? this.velocity : 0;
                this.currentImage = this.player_right.get(this.frame);
                this.frame = this.frame + ((this.frame == 3 && count%10 == 0)?-3:((count%10 == 0)?1:0));
                count ++;
                break;
            }
            case DIE: {
                this.currentImage = this.player_die;
                break;
            }
        }
    }

}
