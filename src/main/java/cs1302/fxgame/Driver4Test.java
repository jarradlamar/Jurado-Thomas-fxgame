package cs1302.fxgame;

import com.michaelcotterell.game.Game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Driver4Test extends Application {


    public void start(Stage primaryStage) throws Exception { 
    	/* place Game game, game.run(), and primaryStage.Scene(game.getScene())
    	 *  in setOnActionMethod for a button when you design the menu.
    	 */
        GameLab game = new GameLab(primaryStage);
        primaryStage.setTitle("GameLab");
        primaryStage.setScene(game.getScene());
        primaryStage.show();
        game.run();// put this in a setOnAction for a button.
        }// start
	

public static void main(String[] args){
launch(args);	
}

}//end of Driver4Test