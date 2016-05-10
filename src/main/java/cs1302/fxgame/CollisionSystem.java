package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;

import cs1302.fxgame.Actions;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CollisionSystem { // STATIC CLASS. JUST A BUNCH OF METHODS THAT TEST AND DO CERTAIN THINGS.



																	//Alien	bullet
	public static  <T extends Node & Actions> void collisionAction(T obj1, T obj2, GameLab gl){ // Use for Alien March
		//obj12
		if (  obj1.getBoundsInLocal().intersects(obj2.getBoundsInLocal() ) ){
			obj1.hit(gl); //alien to die
			obj2.hit(gl); //bullet to dissapear
		}
  }
	
}
