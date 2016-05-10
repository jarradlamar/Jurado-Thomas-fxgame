package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Alien extends Sprite {

protected Image img1;
protected EnemyLaser l1;

	public Alien( GameLab g, double xPlacement, double yPlacement){
		/*The ImageView node appears at the location given by the doubles given in the constructor.*/
	
		super();
		img1 = new Image("file:src/main/java/alienSmall.png");
		changeTo(img1);
		/* For some reason the LeftHorizontalBound copies the value of xPlacement. 
		 * This results in a situation where wherever the ship is placed originally on the scene, that's it's leftMostBound.
		 * IDK why this is happening so the ship will always pop-up at (0,800)*/
		this.setX(xPlacement);
		this.setY(yPlacement); /* Since a square image is being loaded the image will be placed using it's top left-hand pixel. */
		l1 = new EnemyLaser(g, this);
	}
	
	public void changeTo( Image i){
		super.viewerShow(i);
	}
	
	public void movement(double speed){
		
				this.setTranslateX(this.getTranslateY() + speed);
				
	}
	
	public void attack(GameLab g){
	l1.shoot(this);	

	}
	
	
	
			
	
	
	public ImageView getViewerNode(){
		return this;
	}
}
