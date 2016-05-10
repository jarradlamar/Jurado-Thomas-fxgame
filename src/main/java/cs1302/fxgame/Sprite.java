package cs1302.fxgame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*Basically a tailored ImageView object*/
public class Sprite extends ImageView{
 /* [Side Note]: ImageView is recognized as a subclass of the superclass Node*/
	
/* Each Sprite object contains on Image Viewer, and that viewer will load up an Image.*/
/* The Sprite constructor contains a image viewer. with one method that allows the viewer to show a different image.
 * Subclasses of the Sprite class can contain Image objects. These Image objects call to a local directory in the project 
 * and pull out images for the Sprite. For example, If one desires to create a alien. A subclass of Sprite called Alien is created.
 * However many Image objects for the class will be created and will pull all the images for those Image objects from a directory containing nothing but
 * alien images. For right now all of the Sprite classes are using images fro mthe src folder. I'm having problems getting Image objects to load
 * images from file paths.*/
	
private ImageView viewer;
	
public Sprite(){
	viewer = new ImageView();
	}

public void viewerShow(Image img){
	this.setImage(img);
}

public void hit(){
// checks if there are other Sprite objects on the screen that are located at coordinates that are n pixels away from the top left pixel.
// if there is a near by Sprite object the ImageView object viewer goes blank for right now.
}

public double widthOfImage(){ // Method gets the width of the image that the ImageViewer is holding.
	return this.getImage().getWidth();
}

public double heightOfImage(){ // Method gets the height of the image that the ImageViewer is holding.
	return this.getImage().getHeight();
}


}
