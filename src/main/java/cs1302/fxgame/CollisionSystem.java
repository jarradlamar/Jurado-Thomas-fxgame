package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CollisionSystem { // STATIC CLASS. JUST A BUNCH OF METHODS THAT TEST AND DO CERTAIN THINGS.
/* one system with multiple methods that take in two sprite objects and tests if they are in a similar location. 
 * If so, then a certain thing happens.
 * */
	
/*
 *  For right now Rectangles ,but in the future, it will be Imageview objects. 
 *  Create a method that gets the x and y location of the imageView node on the scene. 
 *  
 *  
 *  if the location of obj2 is less than the right hand 
 */

	public static void collisionAction1( RecThread s1, InvertedRecThread s2){
		double topLeftCornerOfObj1 = 0;
		double topLeftCornerOfObj2 = 0;
		double bottomRightCornerOfObj1 = 0;
		
		
		
		
		topLeftCornerOfObj1 = s1.getXPlacementInt() + s1.getYPlacementInt();
		bottomRightCornerOfObj1 = s1.returnRec().getWidth() + s1.returnRec().getHeight() + topLeftCornerOfObj1; // gives the coordinate of the bottom right corner at every move.
		topLeftCornerOfObj2 = s2.getXPlacementInt() + s2.getYPlacementInt();
		
		System.out.println( "s1:" + topLeftCornerOfObj1 + " " + "bottom of s1:" +  bottomRightCornerOfObj1 + " " + "s2:" + topLeftCornerOfObj2);
		
		if( (topLeftCornerOfObj1 < topLeftCornerOfObj2) && (topLeftCornerOfObj2 < (bottomRightCornerOfObj1-40)) ){
			
		s1.changeColor(Color.BLUE);	
		s2.changeColor(Color.PINK);
		
		s1.setGo(false);	
		s2.setGo(false);
		}
	}
	
	public static void collisionAction2( AlienFleet s1, ArrayList<Laser> s2){ // Use for Alien March
	
		if(s2.size() > 0){
		for(int index =0; index <s1.fleet.size(); index++){
		int index2 = 0;
		double topLeftCornerOfObj1 = 0;
		double topLeftCornerOfObj2 = 0;
		double bottomRightCornerOfObj1 = 0;
		
		topLeftCornerOfObj1 = s1.fleet.get(index).getXPlacementInt() + s1.fleet.get(index).getYPlacementInt();
		bottomRightCornerOfObj1 = s1.fleet.get(index).alien.getImage().getWidth() + s1.fleet.get(index).alien.getImage().getHeight()  + topLeftCornerOfObj1; // gives the coordinate of the bottom right corner at every move.
		topLeftCornerOfObj2 = s2.get(index2).getXPlacementInt() + s2.get(index2).getYPlacementInt();
		
		System.out.println( "s1:" + topLeftCornerOfObj1 + " " + "bottom of s1:" +  bottomRightCornerOfObj1 + " " + "s2:" + topLeftCornerOfObj2);
		
		if( (topLeftCornerOfObj1 < topLeftCornerOfObj2) && (topLeftCornerOfObj2 < (bottomRightCornerOfObj1-20)) ){
			
		s1.fleet.get(index).alien.setVisible(false);	
		s2.get(index2).con.setVisible(false);;
		
		index2++;
		
		if(index2 == s2.size()){
		index2 = 0;	
				}
		
			}
		}
	}
}
	
}
