package cs1302.fxgame;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EnemyLaser {
	
	
	protected Rectangle con;
	protected int xPlacement;
	protected int yPlacement;
	protected int yPlacementInt;
	protected int xPlacementInt;
	protected boolean trigger;
	protected int index;
	 
public EnemyLaser(GameLab g, Sprite s){
	
	 con = new Rectangle(2,9,Color.ORANGE);
	 trigger = true;
	 
	 if(s.getTranslateX() == 0){
		 xPlacement = (int) s.getX() + 100; // the additional 100 keeps the lasers right under the alien ship they are fired from.
	 }else{
		 
	 xPlacement = (int) s.getTranslateX() + 11;
	 }
	 
	 System.out.println("Alien x placement:" + xPlacement);
	 yPlacement = (int) s.getY() + 22;
	 
	 yPlacementInt = (int) s.getY();
	 xPlacementInt = xPlacement;
	 
	 con.setX(xPlacement);
	 con.setY(yPlacement);
	 con.setVisible(false);
	 g.getSceneNodes().getChildren().add(con); // adds the rectangle from the list index to the scene of GameLab.
		}


public void switchBoolValue( boolean c){
	System.out.println("Follow Switched to false");
	this.trigger = c ;
}



public void shoot(Sprite s){


if(trigger ==  true ){
	System.out.println(yPlacementInt);
	con.setVisible(true);
	yPlacementInt += 4; // a tag on to be used for the CollisionSystem
	
	con.setTranslateY( con.getTranslateY() + 4); // moves the rectangle down the screen by con.getY().
	
		}



if(yPlacementInt >= 600){ // use this is CollisionSystem.
	con.setVisible(false);
	con.setTranslateY(s.getY()-0); // the number being subtracted has to be the same as ylocation in the constructor of AlienFleet.
	yPlacementInt = (int) s.getY(); // sets back to original value and stops there from being a loop of this same command in the GameLab update method
		}

}

public int getXPlacementInt(){
	 return this.xPlacementInt;
	}

public int getYPlacementInt(){
	return this.yPlacementInt;
	}

}
