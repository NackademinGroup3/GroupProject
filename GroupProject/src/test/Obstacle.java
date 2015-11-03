package test;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Group{
	private ImageView graphics = new ImageView();
	private Rectangle hitbox;
	private Image image;
	private Random rand = new Random();
	private int randomizedObject = rand.nextInt(4) + 1;

	Obstacle() {
		this.randomObstacles();
		this.graphics.setImage(image);
		this.hitbox = new Rectangle(image.getWidth(), image.getHeight());
		this.getChildren().addAll(graphics);
		this.setTranslateX(1000);
	}

	private void randomObstacles() {
		switch (randomizedObject) {
		case 1:
			this.image = new Image("textures/t3_obstacle_fire.gif");
			this.setTranslateY(400);
			break;
		case 2:
			this.image = new Image("textures/obstacle_fire.gif");
			this.setTranslateY(385);
			break;
		case 3:
			this.image = new Image("textures/obstacle_fire.gif");
			this.setTranslateY(370);
			break;
		default:
			this.image = new Image("textures/t2_obstacle_fire.gif");
			this.setTranslateY(270);
			break;
		}
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
