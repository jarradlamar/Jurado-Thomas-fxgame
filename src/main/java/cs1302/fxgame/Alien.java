package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Alien extends Sprite implements Actions {

protected Image img1;
protected EnemyLaser l1;
protected Group root;

	public Alien( GameLab g, double xPlacement, double yPlacement, Group root){
		/*The ImageView node appears at the location given by the doubles given in the constructor.*/
		
		super();
		this.root = root;
		img1 = new Image("file:src/main/java/alienSmall.png");
		changeTo(img1);
		
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
	
	
	
	
	public void hit(){
	root.getChildren().remove(this);
	}


	
}
