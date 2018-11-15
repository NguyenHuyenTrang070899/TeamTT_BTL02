package Application;

import Sprites.GameEngine;
import Sprites.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
    private Player player = new Player(Player.Control.DEFAULT, 24, 24, 2);

    @Override
    public void start(Stage theStage) throws Exception {
        theStage.setTitle("BoomberMan");
        //set scene
        Group root = new Group();
        Scene theScene = new Scene(root,672,672);
        theStage.setResizable(false);
        theStage.setScene(theScene);
        //set canvas
        Canvas canvas = new Canvas(672, 672);
        root.getChildren().add(canvas);
        //set context
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //handle event
        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        switch(code){
                            case "LEFT": player.setControl(Player.Control.LEFT);break;
                            case "RIGHT": player.setControl(Player.Control.RIGHT);break;
                            case "DOWN": player.setControl(Player.Control.DOWN);break;
                            case "UP": player.setControl(Player.Control.UP);break;
                            case "SPACE": player.setControl(player.getControl());
                            default: player.setControl(player.getControl());
                        }
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e){
                        String code = e.getCode().toString();
                        if(code.equals("LEFT") || code.equals("RIGHT") || code.equals("DOWN") || code.equals("UP"))
                        player.setControl(Player.Control.DEFAULT);
                    }
                });

        GameEngine gameEngine = new GameEngine();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.update();
                gameEngine.getPlayer(player);
                gameEngine.render(gc);
            }
        }.start();
        theStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
