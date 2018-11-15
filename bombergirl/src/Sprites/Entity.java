package Sprites;


import javafx.scene.image.WritableImage;

public abstract class Entity {
    protected int x;
    protected int y;
    protected WritableImage currentImage;
    public abstract void update();

    public WritableImage getCurrenImage() {
        return currentImage;
    }

    public int getX(){
        return this.x;
    };

    public int getY(){
        return this.y;
    };
}
