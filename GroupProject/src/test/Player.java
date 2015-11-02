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
	private boolean jumping;
	private Image[] images;
	private int imageCounter = 0;
	private int hitPoints = 3;

	Player(Image image) {
		this.image = image;
		this.graphics.setImage(image);
		this.hitbox = new Rectangle(image.getWidth(), image.getHeight());
		this.jumping = false;
		this.isDead = false;
		this.hitPoints = 3;

	}

	Player(Image[] images) {
		this.images = images;
		this.graphics.setImage(images[imageCounter]);
		this.hitbox = new Rectangle(images[imageCounter].getWidth(), images[imageCounter].getHeight());
		this.jumping = false;
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

	public boolean isJumping() {
		// TODO Auto-generated method stub
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public int getImageCounter() {
		return imageCounter;
	}

	public void setImageCounter(int imageCounter) {
		this.imageCounter = imageCounter;
	}
	

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public void refreshImg() {
		if (!jumping) {
			graphics.setImage(images[imageCounter++]);
			if (imageCounter == 2)
				imageCounter = 0;
			
			//bort?
			hitbox.setHeight(graphics.getFitHeight());
			hitbox.setWidth(graphics.getFitWidth());
			hitbox.xProperty().bind(graphics.translateXProperty().add(images[0].getWidth()));
			hitbox.yProperty().bind(graphics.translateYProperty().add(images[0].getHeight()));
			
		} else
			graphics.setImage(images[2]);

	}

}
