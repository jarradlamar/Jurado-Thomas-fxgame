package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;

import cs1302.fxgame.Actions;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/*This class basically controls what happens when two objects enter the same coordinate space*/
public class CollisionSystem { // STATIC CLASS. JUST A BUNCH OF METHODS THAT TEST AND DO CERTAIN THINGS.



	/*If two objects that have Action implemented and are nodes are in the same space
		then the hit methods will be activated and the method will return true 
		to indicate that a hit occured*/																//Alien	bullet
	public static  <T extends Node & Actions> boolean collisionAction(T obj1, T obj2){ // Use for Alien March
		//obj12
		
//		System.out.println("Obj1 :" + obj1.getBoundsInParent().getMaxX() + " " + "Obj1" + obj2.getBoundsInParent().getMaxX() );
//		System.exit(0);
		Bounds bound = obj1.getBoundsInLocal();
		Bounds screenBounds = obj1.localToScreen(bound);
		
		Bounds bound2 = obj2.getBoundsInLocal();
		Bounds screenBounds2 = obj2.localToScreen(bound2);
		
		if (  screenBounds.intersects(screenBounds2) ){
			
			System.out.println("Obj1 :" + obj1.getBoundsInParent().getMaxX() + 
					" " + "Obj1" + obj2.getBoundsInParent().getMaxX() );
					
			obj1.hit(); //alien to die
			obj2.hit(); //bullet to dissapear
			return true;
			
		}
		else{
			return false;
		}
  }


	
}
