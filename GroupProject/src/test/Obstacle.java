package test;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Group{
	private ImageView graphics = new ImageView();
	private Rectangle hitbox;
	private Image image;
	
	
	Obstacle(){
		this.image = new Image("textures/obstacles.jpg");
		this.graphics.setImage(image);
		this.hitbox = new Rectangle(image.getWidth(), image.getHeight());	
		this.getChildren().addAll(graphics);
		this.setTranslateX(1000);
		this.setTranslateY(370);
	}

	public ImageView getGraphics() {
		return graphics;
	}


	public void setGraphics(ImageView graphics) {
		this.graphics = graphics;
	}


	public Rectangle getHitbox() {
		return hitbox;
	}


	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}
	

}
