package test;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		Group root = new Group();
		Scene theScene = new Scene(root);
		
		primaryStage.setScene(theScene);
		
		Canvas canvas = new Canvas(500,500);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image sun = new Image("textures/sun.png");
		Image space = new Image("textures/space.jpg");




		final long startNanoTime = System.nanoTime();
		 
	    new AnimationTimer()
	    {
	        public void handle(long currentNanoTime)
	        {
	            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
	 
	            double x1 =  -500 * Math.cos(t);
	            double y1 = 1; // Math.sin(t);
	    
	            // background image clears canvas
	            gc.drawImage( space,x1,y1);
	            System.out.println(t);
	            gc.drawImage( sun, 100, 70 );
	            
	        }
	    }.start();
	 

		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
