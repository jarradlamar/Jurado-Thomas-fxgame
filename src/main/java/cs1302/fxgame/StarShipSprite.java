package cs1302.fxgame;

import com.michaelcotterell.game.Game;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class StarShipSprite extends Thread{

protected StarShip player;
protected String threadID;
protected double LeftHorizontalBound;
protected double RightHorizontalBound;
protected double speed;

public StarShipSprite(String iD, Game g, double l, double r, int xLoc, int yLoc, double s){
player = new StarShip(xLoc,yLoc);
threadID = iD;
LeftHorizontalBound = l;
RightHorizontalBound = r;
speed = s;
//System.out.println(player.getTranslateX());

}

public void run(Game g){
player.movement(g, LeftHorizontalBound, RightHorizontalBound,speed);
}

public ImageView getViewerNodeOfSprite(){
	return this.player.getViewerNode();
}

public StarShip getShip(){
return this.player;
}


}
