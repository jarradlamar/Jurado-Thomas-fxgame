package cs1302.fxgame;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Barricade extends Group implements Actions {
	

private ImageView viewer;
private Rectangle leg1;
private Rectangle leg2;
private Rectangle top;
private double damageNumber;

public Barricade( int x, int y) {
		super();

		damageNumber = 1;
		top = new Rectangle(35,4);
		top.setFill(Color.rgb(0,128,0));
		top.setLayoutX(x);
		top.setLayoutY(y);
		//this.setLayoutX(x);
		//this.setLayoutY(y);
		leg1 = new Rectangle(5,15);
		leg1.setFill(Color.rgb(0,128,0));
		leg1.setLayoutX(x);
		leg1.setLayoutY(y);
		
		leg2 = new Rectangle(5,15);
		leg2.setFill(Color.rgb(0,128,0));
		leg2.setLayoutX(top.getWidth()+30);
		leg2.setLayoutY(y);

		this.getChildren().addAll(leg1,top,leg2);
	}




public void damage(){ // must be between 0 and 1.
	damageNumber = damageNumber - (1/8);
	top.setFill(Color.rgb(0,128,0, damageNumber));
	leg1.setFill(Color.rgb(0,128,0, damageNumber));
	leg2.setFill(Color.rgb(0,128,0, damageNumber)); 

}

@Override
public void hit(){
	this.damage();
}

}
