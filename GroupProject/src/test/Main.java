 
package test;
 
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
 
 private double SCENE_WIDTH = 500;
 private double SCENE_HEIGHT = 500;
 
 /**
  * Main game loop
  */
 private AnimationTimer gameLoop;

 /**
  * Container for the background image
  */
 ImageView backgroundImageView;
 
 /**
  * Scrolling speed of the background
  */
 double backgroundScrollSpeed = 0.5;
 
 /**
  * Layer for the background
  */
 Pane backgroundLayer;
 
 @Override
 public void start(Stage primaryStage) {
  try {

   // create root node
   Group root = new Group();

   // create layers
   backgroundLayer = new Pane();
   
   // add layers to scene root
   root.getChildren().add( backgroundLayer);
   
   // create scene
   Scene scene = new Scene( root, SCENE_WIDTH,SCENE_HEIGHT);
   
   // show stage
   primaryStage.setScene(scene);
   primaryStage.show();

   // load game assets
   loadGame();

   // start the game
   startGameLoop();
   
  } catch(Exception e) {
   e.printStackTrace();
  }
 }

 private void loadGame() {
  
  // background
  // --------------------------------
  backgroundImageView = new ImageView( getClass().getResource("/textures/space2.jpg").toExternalForm());
  
  // reposition the map. it is scrolling from bottom of the background to top of the background
  //backgroundImageView.relocate( 0, -backgroundImageView.getImage().getHeight() + SCENE_HEIGHT);
  backgroundImageView.relocate(backgroundImageView.getImage().getWidth(), 0);
  //backgroundImageView.relocate(500,0);
  
  // add background to layer
  backgroundLayer.getChildren().add( backgroundImageView);
  
 }
 
 private void startGameLoop() {

  // game loop
        gameLoop = new AnimationTimer() {
         
            @Override
            public void handle(long l) {
            
             // scroll background
             // ---------------------------
             // calculate new position
            
             double x = backgroundImageView.getLayoutX() + backgroundScrollSpeed;
             //double x1 = backgroundImageView.getLayoutX() + backgroundScrollSpeed;
             
            

           
             
             if(backgroundImageView.getLayoutX() > 0)
             {
            	 x = -500;
             }
             
             
             

             // move background
             //
             backgroundImageView.setLayoutX(x);

             
            }
 
        };
        
        gameLoop.start();
        
 }
 
 public static void main(String[] args) {
  launch(args);
 }
}