package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;

import cs1302.fxgame.Actions;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CollisionSystem { // STATIC CLASS. JUST A BUNCH OF METHODS THAT TEST AND DO CERTAIN THINGS.



																	//Alien	bullet
	public static  <T extends Node & Actions> boolean collisionAction(T obj1, T obj2){ // Use for Alien March
		//obj12
		
//		System.out.println("Obj1 :" + obj1.getBoundsInParent().getMaxX() + " " + "Obj1" + obj2.getBoundsInParent().getMaxX() );
//		System.exit(0);
		
		if (  obj1.getBoundsInParent().intersects(obj2.getBoundsInParent()) ){
//			System.exit(0);
			obj1.hit(); //alien to die
			obj2.hit(); //bullet to dissapear
			return true;
			
		}
		else{
			return false;
		}
  }


	
}
