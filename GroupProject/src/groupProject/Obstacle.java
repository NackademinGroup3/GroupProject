package groupProject;

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
			this.image = new Image("textures/block1.jpg");
			this.setTranslateY(350);
			break;
		case 2:
			this.image = new Image("textures/block4L.jpg");
			this.setTranslateY(250);
			break;
		case 3:
			this.image = new Image("textures/block2L.jpg");
			this.setTranslateY(295);
			break;
		case 4:
			this.image = new Image("textures/block3L.jpg");
			this.setTranslateY(170);
			break;
		default:
			this.image = new Image("textures/block1.jpg");
			this.setTranslateY(315);
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
