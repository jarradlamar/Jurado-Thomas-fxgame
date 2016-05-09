package cs1302.fxgame;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameLab extends Game {
	
protected RecThread rT;
protected AlienFleet a;
protected InvertedRecThread rT2;
protected StarShipSprite p;
protected ArrayList<Laser> l1;
protected int x;
protected CollisionSystem sys;

public GameLab(Stage stage){ // a = 60. b and c = 800.
	super(stage, "GameLab", 60, 800, 650); //40 is perfect for right now.
	Rectangle r = new Rectangle(800,650,Color.BLACK);
	r.setX(0);
	r.setY(0);
	getSceneNodes().getChildren().add(r);
	x=0;
	
	a = new AlienFleet();
	a.make(54, this);
	
	p = new StarShipSprite("player", this,0.0,800.0,0,600,7);
	p.setPriority(8);
	
	l1 = new ArrayList();
	sys = new CollisionSystem();
	
	
	
//	rT2 = new InvertedRecThread("Hey", 650, 300);
//	rT2.setPriority(5);
	getSceneNodes().getChildren().addAll( p.getViewerNodeOfSprite());

}

public void build(){
	for(int t=0; t < 1; t++){ // if error: missing = in < l1.size()?
	System.out.println("added :" + t);
	l1.add( new Laser(this,p.getShip()) ); // y, x	
	}
}

public void runList(){
if(l1.isEmpty() == true){
	System.out.println("Size of l1: " + l1.size());
} else{
	for(int y =0; y< l1.size(); y++){
		l1.get(y).run(p.getShip()); //checking and making it go forward.
		if(l1.get(y).yPlacementInt <= 0){
			l1.remove(y);// deleting. These to things will continue until nothing is left. 
						// Hoping this removes the rectangle from the scene after it comes back dark red and under the ship.
			}
		}
	}
}	
	




public void update(Game ga, GameTime t){
	

sys.collisionAction2(a, l1);
p.run(ga);
this.a.fire(0,11, this);
runList();



/* Ideally I want a rectangle to go forward to a certain length and then another rectangle pop up behind it.*/
if (ga.getKeyManager().isKeyPressed(KeyCode.SPACE)){ // follow is being set equal ot false but cant go back to being true fix this.
this.build();
}



//else{
//l1.switchBoolValue(true); // returns it back under the ship.
//}

//	l1 = new Laser("No.1", this, p.getShip());
//	while(x < 10 ){
//		x++;
//		System.out.println("go :" +x);
//	l1.run(a,p.getShip());}
//}

//for(int d = 0; d<10; d++){
//System.out.println(d);
//}

}

//CollisionSystem.collisionLaser1(p.getLaser(), 0);
//this.rT2.run();
//CollisionSystem.collisionAction1(rT, rT2);

public ArrayList<Laser> getLaser(){
	return this.l1;
}

}

