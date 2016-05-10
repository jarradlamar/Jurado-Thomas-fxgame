package cs1302.fxgame;
import cs1302.fxgame.Laser;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/*This class basically represents and alienFleet. This class helps to syncronize motion 
by using the shift method. It also provides a mechanism by which the 
aliens can take turn shooting*/
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
protected ArrayList<Laser> laserList;

public AlienFleet(double SCREENWIDTH, double SCREENHEIGHT, ArrayList<Laser> laserList){
	this.laserList  = laserList;
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


public void fire(GameLab g){
	Random ran = new Random();
	if(army.size()>0){
			System.out.println("It was able to fire One shot!!!");
			army.get( ran.nextInt( army.size() ) ).attack(g, laserList);
	}
	
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


