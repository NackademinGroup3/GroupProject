package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
