package cs1302.fxgame;

import java.util.ArrayList;

public class AlienFleet {

protected ArrayList<AlienSprite> fleet;
protected int xlocation;
protected int ylocation;

public AlienFleet(){
	fleet = new ArrayList();
	xlocation = 90;
	ylocation = 100;
}

public void make( int number, GameLab gl){
	
	for(int r = 0; r <= number; r++){
		
		if(r == 11){
		ylocation += 30;
		xlocation =90;
			}
		
		if(r == 22){
			ylocation += 30;
			xlocation =90;
			}
		
		if(r == 33){
			ylocation += 30;
			xlocation=90;
			}
		
		if(r == 44){
			ylocation += 30;
			xlocation =90;
			}
		
		if(r == 55){
			ylocation += 30;
			xlocation =90;
			}
		
		fleet.add(r, new AlienSprite(gl,xlocation,ylocation));
		System.out.println(r);
		gl.getSceneNodes().getChildren().add(fleet.get(r).alien.getViewerNode());
		xlocation += 60;
		
	}
	
	
}

public void fire( int first,int last, GameLab gl){
	
	for(int y=first;y<last;y++)
	fleet.get(y).alien.attack(gl);
	
}

}
