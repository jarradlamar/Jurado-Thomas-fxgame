package cs1302.fxgame;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Laser implements Actions {
	
	
	protected Rectangle con;
	protected int xPlacement;
	protected int yPlacement;
	protected int yPlacementInt;
	protected int xPlacementInt;
	protected boolean follow;
	static int index =0;
	protected int id;
	
public Laser(GameLab g, Sprite s){
	 id = index;
	 con = new Rectangle(2,5,Color.YELLOW);
	 follow = true;
	 
	 if(s.getTranslateX() == 0){
		 xPlacement = (int) s.getX() + 12;
	 }else{
		 
	 xPlacement = (int) s.getTranslateX() + 11;
	 }
	 
	 System.out.println("Alien x placement:" + xPlacement);
	 yPlacement = (int) s.getY() + 22;
	 // these two are returned using get statements.
	 yPlacementInt = yPlacement;
	 xPlacementInt = xPlacement;
	 //-----------------
	 con.setX(xPlacement);
	 con.setY(yPlacement);

	 g.getSceneNodes().getChildren().add(con); // adds the rectangle from the list index to the scene of GameLab.
	 this.increaseIndex();
		}


public void switchBoolValue( boolean fol){
	System.out.println("Follow Switched to false");
	this.follow = fol ;
}

public void increaseIndex(){
	index++;
}

public void run(Sprite s){


if(follow ==  true ){
	System.out.println(yPlacementInt);
	yPlacementInt -= 4; // a tag on to be used for the CollisionSystem
	
	con.setTranslateY( con.getTranslateY()- 4); // moves the rectangle down the screen by con.getY().
	
	
}



if(yPlacementInt <= 0){ // use this is CollisionSystem.
	con.setTranslateX(s.getTranslateX());
	con.setTranslateY(s.getY());
//	con.setVisible(false);
	con.setFill(Color.DARKRED);
//	yPlacementInt = (int) s.getY(); // sets back to original value and stops there from being a loop of this same command in the GameLab update method
	this.follow = true;
	
	System.out.println(   con + " is now invisible. Follow Switched Back to true and using next ammo index");

	

	
	
	}
}


public void runAlien(Sprite s){


if(follow ==  true ){
	System.out.println(yPlacementInt);
	yPlacementInt += 4; // a tag on to be used for the CollisionSystem
	
	con.setTranslateY( con.getTranslateY() - 4); // moves the rectangle down the screen by con.getY().
	
	
}



if(yPlacementInt >= 600){ // use this is CollisionSystem.
	con.setTranslateX(s.getTranslateX());
	con.setTranslateY(s.getY());
//	con.setVisible(false);
	con.setFill(Color.DARKRED);
//	yPlacementInt = (int) s.getY(); // sets back to original value and stops there from being a loop of this same command in the GameLab update method

	
	
}

}//run Alien version

public int getXPlacementInt(){
 return this.xPlacementInt;
}

public int getYPlacementInt(){
	 return this.yPlacementInt;
	}

public void hit(GameLab gl){
	System.out.println("Removed");
	gl.getSceneNodes().getChildren().remove(this.con);
}


public int getID(){
	return id;
}
}
