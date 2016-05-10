package cs1302.fxgame;

import java.util.ArrayList;
import javafx.geometry.Bounds;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Laser extends Rectangle implements Actions {
	
	
	
	protected int xPlacement;
	protected int yPlacement;
	protected int id;
	protected GameLab g;

	private boolean upwards;

	public Laser(GameLab g, Sprite s, boolean upwards){
		super(2, 5,Color.YELLOW);
		this.upwards = upwards;
		
		this.g = g;
		 
		Bounds bound = s.getBoundsInLocal();
		Bounds screenBounds = s.localToScreen(bound);

		xPlacement = (int) ( (screenBounds.getMinX() + screenBounds.getMaxX())/2 );
		 

		if(upwards){
				xPlacement = (int) ( s.getTranslateX() + s.getImage().getWidth()/2 );
				yPlacement = (int) s.getY() + 22;
		} //upwards
		else{
			yPlacement = (int) (screenBounds.getMinY());
		} //else

		 this.setX(xPlacement);
		 this.setY(yPlacement);

		 g.getSceneNodes().getChildren().add(this); // adds the rectangle from the list index to the scene of GameLab.
	} //Laser

	public Laser(GameLab g, Sprite s){
		this(g, s, true);
	} //Laser



	public void run(){

		if (upwards){
				//yPlacement = yPlacement -4;
				//this.setY(yPlacement ); // moves the rectangle down the screen by con.getY().
			this.setTranslateY(this.getTranslateY() -4);
		}
		else{
			yPlacement =yPlacement +4;
			this.setY(yPlacement);
		}

	} //run



	public void hit(){
		
		g.getSceneNodes().getChildren().remove(this);
	} //hit


}
