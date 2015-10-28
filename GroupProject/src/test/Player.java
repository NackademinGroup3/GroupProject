package test;

import java.awt.Color;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Player {

	private ImageView graphics = new ImageView();
	private Rectangle hitbox;
	private Image image;
	private boolean isDead;
	

	Player(Image image) {
		this.image = image;
		this.graphics.setImage(image);
		this.hitbox = new Rectangle(image.getWidth(), image.getHeight());
		this.isDead = false;

	}

	public ImageView getGraphics() {
		return graphics;
	}

	public void setGraphics(ImageView graphics) {
		this.graphics = graphics;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}


	
}
