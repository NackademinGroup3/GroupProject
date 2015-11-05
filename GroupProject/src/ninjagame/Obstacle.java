package ninjagame;

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
	private int randomizedObject = rand.nextInt(12) + 1;

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
		case 5:
			this.image = new Image("textures/block1.jpg");
			this.setTranslateY(345);
			break;
		case 6:
			this.image = new Image("textures/block4L.jpg");
			this.setTranslateY(245);
			break;
		case 7:
			this.image = new Image("textures/block2L.jpg");
			this.setTranslateY(290);
			break;
		case 8:
			this.image = new Image("textures/block3L.jpg");
			this.setTranslateY(165);
			break;
		case 9:
			this.image = new Image("textures/block1.jpg");
			this.setTranslateY(340);
			break;
		case 10:
			this.image = new Image("textures/block4L.jpg");
			this.setTranslateY(240);
			break;
		case 11:
			this.image = new Image("textures/block2L.jpg");
			this.setTranslateY(285);
			break;
		case 12:
			this.image = new Image("textures/block3L.jpg");
			this.setTranslateY(160);
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

	public Rectangle getHitbox() {
		return hitbox;
	}


	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}
}
