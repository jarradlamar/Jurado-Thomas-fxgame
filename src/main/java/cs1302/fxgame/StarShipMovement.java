package cs1302.fxgame;

import com.michaelcotterell.game.Game;

import javafx.scene.input.KeyCode;

public class StarShipMovement{

	
	
public StarShipMovement(Sprite subject, Game g, double LeftHorizontalBound, double RightHorizontalBound){
	if(subject.getTranslateX() >= LeftHorizontalBound)
		if (g.getKeyManager().isKeyPressed(KeyCode.LEFT)) subject.setTranslateX(subject.getTranslateX() - 4);
	
	if(subject.getTranslateX() < ( RightHorizontalBound - subject.widthOfImage() ) ){
//		System.out.println(subject.widthOfImage());
		if (g.getKeyManager().isKeyPressed(KeyCode.RIGHT)) subject.setTranslateX(subject.getTranslateX() + 4);
	}
}

}
