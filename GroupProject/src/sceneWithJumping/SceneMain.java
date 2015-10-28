package sceneWithJumping;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneMain extends Application
{
	 public double SCENE_WIDTH = 500;
	 public double SCENE_HEIGHT = 500;
	 Pane backgroundLayer;
	 Background b = new Background();
	 
	 
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		 try 
		 {
		   Group root = new Group();
		   backgroundLayer = new Pane();
		 
		   root.getChildren().add( backgroundLayer);

		   Scene scene = new Scene( root, SCENE_WIDTH,SCENE_HEIGHT);
		   
		   primaryStage.setScene(scene);
		   primaryStage.show();
		   
		   b.loadBackGround();
		   b.startBackGroundLoop();
		   
		   backgroundLayer.getChildren().add( b.backgroundImageView);
		   backgroundLayer.getChildren().add( b.backgroundImageView2);
		   
		   PlayerTest player = new PlayerTest(new Image("textures/runner.png"));
		   root.getChildren().add(player.getGraphics());
		  
		   player.getGraphics().setTranslateX(100);
		   player.getGraphics().setTranslateY(370);	
		   
		   TranslateTransition jump  = new TranslateTransition(Duration.millis(450), player.getGraphics());
		   TranslateTransition fall  = new TranslateTransition(Duration.millis(450), player.getGraphics());
		   jump.setInterpolator(Interpolator.LINEAR);
		   scene.setOnKeyPressed(event ->{
			   if (!player.isJumping())
			   {
				   player.setJumping(true);
				  // fall.stop();
				   //jump.stop();
				   jump.setByY(-150);
				   jump.setCycleCount(1);
				   jump.play();
				   jump.setOnFinished(finishedEvent ->{
					   jump.stop();
					   fall.setByY(150);
					   fall.play();
					  fall.setOnFinished(finishedFalling -> {
						  player.setJumping(false);
					  });
					  
					   
				   });
			   }
			   
		   });
		   
		   
	
		   
		  } 
		 catch(Exception e) 
		 {
		   e.printStackTrace();
		 }
		 
	 }

		
	public static void main(String[] args)
	{
		launch(args);
		
	}

}
