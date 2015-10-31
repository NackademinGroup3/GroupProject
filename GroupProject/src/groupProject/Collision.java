package groupProject;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Collision extends Application {

	public void start(Stage primaryStage) throws Exception {
	    StackPane pane = new StackPane();
	    Scene scene = new Scene(pane,300,300,Color.GREEN);
	    primaryStage.setScene(scene);       
	    primaryStage.show();

	    Rectangle  rect1 = new Rectangle(50, 50);
	    rect1.setFill(Color.BLUE);
	    Rectangle rect2 = new Rectangle(50, 50);         

	    pane.getChildren().add(rect1);
	    pane.getChildren().add(rect2);

	    TranslateTransition translateTransition = new TranslateTransition();
	    translateTransition.setDuration(Duration.millis(2000));
	    translateTransition.setNode(rect2);
	    translateTransition.setFromY(-150);
	    translateTransition.setToY(150);
	    translateTransition.setAutoReverse(true);
	    translateTransition.setCycleCount(Timeline.INDEFINITE);
	    translateTransition.play();             
	    checkCollision(pane,rect1,rect2);       
	}

	//Collision Detection
	 void checkCollision(StackPane pane, Rectangle rect1, Rectangle rect2){   

	     rect2.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
	        @Override
	        public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
	            if(rect1.getBoundsInParent().intersects(newValue)){
	                System.out.println("Collide ============= Collide");
	              
	               // createGameOverScreen();
	            }
	        }
	    }
	 );}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
