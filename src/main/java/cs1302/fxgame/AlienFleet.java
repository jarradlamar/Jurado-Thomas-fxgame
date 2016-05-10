package cs1302.fxgame;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AlienFleet {

private AlienSprite alienSprite;
private String direction = "moveRight";
protected int xlocation;
protected int ylocation;
protected Group fleetNode;
public double SCREENWIDTH;
private final int rows = 5;
private final int cols = 11;
private final int jumps = 10;
private final double rateOfFiring = 1;

//here are some useful variablea
protected double rowLength;
protected double jumpLength;
protected double alienWidth;
protected double alienHeight;
protected double alienSpacing;
protected ArrayList<Alien> army = new ArrayList<>();

public AlienFleet(double SCREENWIDTH, double SCREENHEIGHT){
	this.SCREENWIDTH = SCREENWIDTH;
	rowLength = SCREENWIDTH * (1-.3);

	this.alienHeight = SCREENHEIGHT/4;

	this.jumpLength = (SCREENWIDTH - rowLength)/jumps;

	this.alienWidth = rowLength/10;

	this.alienSpacing = ( rowLength-alienWidth*(cols) )/(cols-1);

	
	xlocation = 0;
	ylocation = 0;
	fleetNode = new Group();
	this.jumpLength = (600 - rowLength)/jumps;
}

public void make( int number, GameLab gl){
	
	for(int r = 0; r <= number; r++){
		
		if(r == 11){
		ylocation += 30;
		xlocation =0;
			}
		
		if(r == 22){
			ylocation += 30;
			xlocation =0;
			}
		
		if(r == 33){
			ylocation += 30;
			xlocation=0;
			}
		
		if(r == 44){
			ylocation += 30;
			xlocation =0;
			}
		
		if(r == 55){
			ylocation += 30;
			xlocation =0;
			}
		
		alienSprite = new AlienSprite(gl, xlocation, ylocation,fleetNode);
		army.add(alienSprite.alien);
		fleetNode.getChildren().add(alienSprite.alien);
		xlocation += 60;
		
	}
	
	fleetNode.setLayoutY(0);
	fleetNode.setLayoutX(0);
	gl.getSceneNodes().getChildren().add(fleetNode); // adds the node to the board.
	
}// end of made()

public void fire( int first,int last, GameLab gl){
	
	for(int y=0;y<army.size();y++)
	this.fleetNode.getChildren().get(y);
	
}


//if (desiredJump +  this.getWidth() > SCREENWIDTH){
//this.setTranslateX(SCREENWIDTH-this.getPrefWrapLength());

private String moveRight(){
		double desiredJump = (fleetNode.getTranslateX() + jumpLength);
		if (desiredJump +  fleetNode.maxWidth(SCREENWIDTH) > SCREENWIDTH){
			fleetNode.setTranslateX(SCREENWIDTH - fleetNode.maxWidth(SCREENWIDTH));
			fleetNode.setTranslateY(fleetNode.getTranslateY() + alienHeight);
			return "moveLeft";

		}
		else{
			fleetNode.setTranslateX(desiredJump);
			return "moveRight";
		}
}


private String moveLeft(){
	 double desiredJump = (fleetNode.getTranslateX() - jumpLength);
	 if (desiredJump <= 0){
		 fleetNode.setTranslateX(0);
		 fleetNode.setTranslateY(fleetNode.getTranslateY() + alienHeight);
		 return "moveRight";

	 }
	 else{
		 fleetNode.setTranslateX(desiredJump);
		 return "moveLeft";
	 }
}



public void shiftArmy(){
	 			System.out.println("direction: " + direction);
				if (direction == "moveRight"){
					direction = this.moveRight( );
				} //if
				else if (direction == "moveLeft"){
						direction = this.moveLeft( ) ;
				}


}

public ArrayList<Alien> getArmy(){
	return army;
}

}


