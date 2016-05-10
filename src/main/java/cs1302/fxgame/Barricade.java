package cs1302.fxgame;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Barricade {
	

private ImageView viewer;
private Rectangle leg1;
private Rectangle leg2;
private Rectangle top;
private Group root;
private double damageNumber;

public Barricade( int x, int y){
	
		root = new Group();
		damageNumber = 1;
		top = new Rectangle(70,15);
		top.setFill(Color.rgb(0,128,0));
		top.setLayoutX(x);
		top.setLayoutY(y);
		
		leg1 = new Rectangle(15,30);
		leg1.setFill(Color.rgb(0,128,0));
		leg1.setLayoutX(x);
		leg1.setLayoutY(y);
		
		leg2 = new Rectangle(15,30);
		leg2.setFill(Color.rgb(0,128,0));
		leg2.setLayoutX(top.getWidth()+15);
		leg2.setLayoutY(y);

		root.getChildren().addAll(leg1,top,leg2);
	}


public Group getBarricadeNode(){
	return root;
}

public void damage(){ // must be between 0 and 1.
	damageNumber = damageNumber - (1/8);
	top.setFill(Color.rgb(0,128,0, damageNumber));
	leg1.setFill(Color.rgb(0,128,0, damageNumber));
	leg2.setFill(Color.rgb(0,128,0, damageNumber)); 

}

public void correctDamage(){
	
}

}
