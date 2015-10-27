package groupProject;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Entity {
	protected Rectangle hitbox;
	protected Image image;
	
	Entity(int height, int width, Image image)
	{
		this.hitbox = new Rectangle(height, width);
		this.image = image;
		this.hitbox.setFill(Color.TRANSPARENT);
		this.hitbox.setStroke(Color.TRANSPARENT);
	}
	
	

}
