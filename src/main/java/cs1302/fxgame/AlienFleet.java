package cs1302.fxgame;

import java.util.ArrayList;

import javafx.scene.Group;

public class AlienFleet {

protected ArrayList<AlienSprite> fleet;
protected int xlocation;
protected int ylocation;
protected Group fleetNode;

public AlienFleet(){
	fleet = new ArrayList();
	xlocation = 0;
	ylocation = 0;
	fleetNode = new Group();
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
		
		fleet.add(r, new AlienSprite(gl,xlocation,ylocation));
		System.out.println(r);
		fleetNode.getChildren().add(fleet.get(r).alien.getViewerNode());
		xlocation += 60;
		
	}
	
	fleetNode.setLayoutY(30);
	fleetNode.setLayoutX(90);
	gl.getSceneNodes().getChildren().add(fleetNode); // adds the node to the board.
	
}// end of made()

public void fire( int first,int last, GameLab gl){
	
	for(int y=first;y<last;y++)
	fleet.get(y).alien.attack(gl);
	
}


public void fleetMove(){
	this.fleetNode.setTranslateX(value);
}

}
