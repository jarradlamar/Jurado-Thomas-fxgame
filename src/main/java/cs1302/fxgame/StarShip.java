package cs1302.fxgame;

import com.michaelcotterell.game.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class StarShip extends Sprite {

private Image img1;

	public StarShip( double xPlacement, double yPlacement){
		/*The ImageView node appears at the location given by the doubles given in the constructor.*/
	
		super();
		img1 = new Image("/starShip.png");
		changeTo(img1);
		/* For some reason the LeftHorizontalBound copies the value of xPlacement. 
		 * This results in a situation where wherever the ship is placed originally on the scene, that's it's leftMostBound.
		 * IDK why this is happening so the ship will always pop-up at (0,800)*/
		this.setX(xPlacement);
		this.setY(yPlacement); /* Since a square image is being loaded the image will be placed using it's top left-hand pixel. */
	}
	
	public void changeTo( Image i){
		super.viewerShow(i);
	}
	
	public void movement(Game g, double LeftHorizontalBound, double RightHorizontalBound, double speed){
		
		if(this.getTranslateX() >= LeftHorizontalBound){
			
			if (g.getKeyManager().isKeyPressed(KeyCode.LEFT)) {this.setTranslateX(this.getTranslateX() - speed);
			
		}
		}
		
		if(this.getTranslateX() <= ( RightHorizontalBound - this.widthOfImage() ) ){
				if (g.getKeyManager().isKeyPressed(KeyCode.RIGHT)) this.setTranslateX(this.getTranslateX() + speed);
		}
		/* When space is pressed a laser object is made at the ship's location and then goes forward. */

		
		
	}
	
	public ImageView getViewerNode(){
		return this;
	}
}
