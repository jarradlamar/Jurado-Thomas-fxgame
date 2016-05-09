package cs1302.fxgame;



import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InvertedRecThread extends Thread{
/* Create Thread
 * have update run the threads run command over and over? WORKS!
 * 
 * This is the prototype for all Sprite objects
 * 
*/
	

protected String nameOfRec;
protected Rectangle con;
protected Boolean go;
protected int subtractMe;
protected int xPlacement;
protected int yPlacement;

public InvertedRecThread(String name, int y, int x){ // Create the object in the constructor
nameOfRec = name;
go = true;
con = new Rectangle(40,40,Color.RED);
xPlacement = x;
yPlacement = y;
con.setX(xPlacement);
con.setY(yPlacement);
//con.setTranslateX(xPlacement);
//con.setTranslateY(yPlacement);
//con.setTranslateY(con.getY());

}

public void run(){ // Moving any sort of Node, manually , or by algorthim is now possible whether it be alien, bullet, or ship
	
	/* In the try block, have the mothod for movement, and the method to shoot. 
	 * Both method's headers take in a boolean variable, that sets the value of the boolean controlling the while-loop.
	 * CollisionSystem class controls changing those variables to certain values if a collision is detected.*/
	
	
	try {
		
	sleep(10);
	
	if( go == true){
			// subtracting 4 from get Y
	yPlacement -= 4; // a tag on to be used for the CollisionSystem
	this.con.setTranslateY( con.getTranslateY()- 4); // moves the rectangle down the screen by con.getY().
	
	}
	
	
	
	if( con.getTranslateY() <= -800){
		con.setTranslateY(yPlacement);
		}
	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

}

public Rectangle returnRec(){ // Used to add the Shape or Image node instance variable in the sceneNode of GameLab
return this.con;
}

public void changeColor(Color c){
	this.con.setFill(c);
}

public void setGo( boolean input){
	this.go = input;
}


public double getYPlacementInt(){
	return this.yPlacement;
}

public double getXPlacementInt(){
	return this.xPlacement;
}

}
