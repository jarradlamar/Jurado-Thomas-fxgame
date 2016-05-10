package cs1302.fxgame;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EnemyLaser extends Rectangle implements Actions {
	
	
	
	protected int xPlacement;
	protected int yPlacement;
	protected int yPlacementInt;
	protected int xPlacementInt;
	protected boolean follow;
	static int index =0;
	protected int id;
	protected GameLab g;
	
public EnemyLaser(GameLab g, Sprite s){
	super(2, 5,Color.ORANGE);
	
	this.g = g;
	 id = index;
	 
	 follow = true;
	 
	 if(s.getTranslateX() == 0){
		 xPlacement = (int) s.getX() + 12;
	 }else{
		 
	 xPlacement = (int) s.getTranslateX() + 11;
	 }
	 
	 
	 yPlacement = (int) s.getY() + 22;
	 // these two are returned using get statements.
	 yPlacementInt = yPlacement;
	 xPlacementInt = xPlacement;
	 //-----------------
	 this.setX(xPlacement);
	 this.setY(yPlacement);

	 g.getSceneNodes().getChildren().add(this); // adds the rectangle from the list index to the scene of GameLab.
	 this.increaseIndex();
		}


public void switchBoolValue( boolean fol){
	
	this.follow = fol ;
}

public void increaseIndex(){
	index++;
}


public void runAlien(Sprite s){


if(follow ==  true ){

	yPlacementInt += 4; // a tag on to be used for the CollisionSystem
	
	this.setTranslateY( this.getTranslateY() + 4); // moves the rectangle down the screen by con.getY().
	
	
}



if(yPlacementInt >= 600){ // use this is CollisionSystem.
	this.setTranslateX(s.getTranslateX());
	this.setTranslateY(s.getY());
//	con.setVisible(false);
	yPlacementInt = (int) s.getY(); // sets back to original value and stops there from being a loop of this same command in the GameLab update method

	
	
}

}//run Alien version

public int getXPlacementInt(){
 return this.xPlacementInt;
}

public int getYPlacementInt(){
	 return this.yPlacementInt;
	}

public void hit(){
	
	g.getSceneNodes().getChildren().remove(this);
}


public int getID(){
	return id;
}

public Rectangle giveRectangle(){
	return this;
}
}
