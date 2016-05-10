package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import com.michaelcotterell.game.util.TimeSpan;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
public class GameLab extends Game {

private int livesLeft = 3;
private int score = 0;
private int difficultyTime = 1;

protected Label label = new Label("LivesLeft: " + livesLeft );
protected Label label2 = new Label("Score: " + score);
protected HBox hBox  = new HBox(100);
private boolean addedLoseButton = false;

protected AlienFleet a;


protected StarShipSprite p;

protected ArrayList<Laser> shipLaserList = new ArrayList<Laser>();
protected ArrayList<Laser> enemyLaserList  = new ArrayList<>();
protected ArrayList<Barricade> barricadeList = new ArrayList<>();

private Button loseButton;
protected int x;
protected CollisionSystem sys;
protected TimeSpan start;
protected int numBullets =0;
protected TimeSpan timeShotFired = TimeSpan.now();

public GameLab(Stage stage){ // a = 60. b and c = 800.
	super(stage, "GameLab", 60, 800, 650); //40 is perfect for right now.
	loseButton = new Button("YOU'VE LOST!!!!!!!");
	loseButton.setOnAction(event -> System.exit(0));
	loseButton.setPrefWidth(800);
	loseButton.setPrefHeight(650);

	label.setTextFill(Color.GREEN);
	label.setFont(new Font(30));

	label2.setTextFill(Color.GREEN);
	label2.setFont(new Font(30));
	hBox.getChildren().addAll(label, label2);

	Rectangle r = new Rectangle(800,650,Color.BLACK);
	r.setX(0);
	r.setY(0);
	getSceneNodes().getChildren().add(r);
	x=0;

	int xDistance = 30;
	for(int i = 0; i < 4; i ++){
		Barricade barricade = new Barricade(xDistance,520);
		barricadeList.add(barricade);
		xDistance += 200;
	}
	a = new AlienFleet(800,650, enemyLaserList);
	a.make(54, this);
	
	p = new StarShipSprite("player", this,0.0,800.0,0,600,7);
	p.setPriority(8);
	
	sys = new CollisionSystem();
	
	start = TimeSpan.now();

	
	
//	rT2 = new InvertedRecThread("Hey", 650, 300);
//	rT2.setPriority(5);
	getSceneNodes().getChildren().addAll( p.getViewerNodeOfSprite(), hBox);
	for(Barricade barricade: barricadeList){
		getSceneNodes().getChildren().add(barricade);
	} //for
}

public void build(){
	for(int t=0; t < 1; t++){ // if error: missing = in < shipLaserList.size()?
	shipLaserList.add( new Laser(this,p.getShip()) ); // y, x	

	}
}

	public void runList(){
		for(Laser laser: shipLaserList){
			laser.run(); //checking and making it go forward.
		} //for
		for(Laser laser: enemyLaserList){
				laser.run();
		} //for

}// runList
	
public boolean canShoot(){
	return Math.abs(TimeSpan.now().getMilliseconds()-timeShotFired.getMilliseconds() ) >200;
}

public boolean hasLost(){
	for(Alien alien: a.getArmy() ){
		if (sys.collisionAction(p.getShip(), alien) ){
			System.out.println("youve lost!");
			System.exit(0);
			return true;
		}
	}
	if (livesLeft < 0){
		return true;
	} //if
	else{
		return false;
	} //else
} //hasLost

public boolean hasWon(){

	if (a.getArmy().size() <= 0 ){
		return true;
	}
	else{
		return false;
	}
}

public void update(Game ga, GameTime t){
	
	if (this.hasWon() ){
		a = new AlienFleet(800,650, enemyLaserList);
		a.make(54, this);
		difficultyTime -= .2;
	} //if 
//System.out.println("move elapsed: " + Math.abs(TimeSpan.now().getMilliseconds() - start.getMilliseconds() ));
if(Math.abs(TimeSpan.now().getTotalSeconds() - start.getTotalSeconds() ) > 1 ){

//System.out.println("is firing here");
a.fire(this);
a.shiftArmy();
start = TimeSpan.now();
}

//  for(int i = 0; i < enemyLaserList.size(); i++){

// 	for(int r = 0; r < barricadeList.size(); r++){
// 		if ( sys.collisionAction(barricadeList.get(r), enemyLaserList.get(i) ) ){
// 			enemyLaserList.remove(i);
// 			i--; 
// 		}
// 	}
// }

// for(int i = 0; i < shipLaserList.size(); i++){

// 	for(int r = 0; r < barricadeList.size(); r++){
// 		if( sys.collisionAction(barricadeList.get(r), shipLaserList.get(i) ) ){
// 			shipLaserList.remove(i);
// 			i--; 
// 		}
// 	}
// }

for(int r = 0; r < a.getArmy().size(); r++){
	for(int i = 0; i < shipLaserList.size(); i++){

		if( sys.collisionAction((Alien) (a.getArmy().get(r)), shipLaserList.get(i))){
			a.getArmy().remove(r);
			shipLaserList.remove(i);
			score+= 10;
			label2.setText("Score: " + score);
			r--;
			i--;
		 	}
	}
	 for(int i = 0; i < enemyLaserList.size(); i++){

	 	if( sys.collisionAction(enemyLaserList.get(i), p.getShip() )){
	 		//System.out.println("hit");
	 		livesLeft--;
	 		enemyLaserList.remove(i);
	 		label.setText("LivesLeft: " + livesLeft );
	 		//System.exit(0);
			i--;
  		}
	 }	
	 		if (this.hasLost() && !(addedLoseButton)){
	 			this.getSceneNodes().getChildren().add(loseButton);
	 			addedLoseButton = true;
	 		}

}

p.run(ga);
runList();
	

if (ga.getKeyManager().isKeyPressed(KeyCode.SPACE) && ( ( this.canShoot() ) || ( numBullets == 0) ) ){ // follow is being set equal ot false but cant go back to being true fix this.
	// System.out.println("Army size: " + a.getArmy().size() );
	 numBullets += 1;
	 timeShotFired = TimeSpan.now();
	 this.build();
	}


/* Ideally I want a rectangle to go forward to a certain length and then another rectangle pop up behind it.*/

}



//else{
//shipLaserList.switchBoolValue(true); // returns it back under the ship.
//}

//	shipLaserList = new Laser("No.1", this, p.getShip());
//	while(x < 10 ){
//		x++;
//		System.out.println("go :" +x);
//	shipLaserList.run(a,p.getShip());}
//}

//for(int d = 0; d<10; d++){
//System.out.println(d);
//}



//CollisionSystem.collisionLaser1(p.getLaser(), 0);
//this.rT2.run();
//CollisionSystem.collisionAction1(rT, rT2);

public ArrayList<Laser> getLaser(){
	return this.shipLaserList;
}

}

