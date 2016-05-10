package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class AlienSprite extends Thread {

protected String alienID;
protected Alien alien;
protected boolean control = true;
protected int yPlacementInt;
protected int xPlacementInt;
protected Group root;

public AlienSprite( GameLab g, int x, int y, Group root) {
	this.root = root;
	alienID = "A";
	yPlacementInt = y;
	xPlacementInt = x;
	alien = new Alien(g, x, y,root);
	this.setPriority(8);
}

public void run(GameLab g){
	if(control == false)	{
		alien.movement(4);
}

// if(control == true){

// 	alien.attack(g);
// }

}

public ImageView getViewerNodeOfSprite(){
	return this.alien.getViewerNode();
}


public int getXPlacementInt(){
	 return this.xPlacementInt;
	}

public int getYPlacementInt(){
		 return this.yPlacementInt;
	}


}
