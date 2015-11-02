package test;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;


public class Background
{
	 public AnimationTimer gameLoop;
	 ImageView backgroundImageView, backgroundImageView2;
	 double backgroundScrollSpeed = 1.5;
	
	public void loadBackGround()
	{

		  backgroundImageView = new ImageView( getClass().getResource("/textures/backg2.png").toExternalForm());
		  backgroundImageView2 = new ImageView( getClass().getResource("/textures/backg2.png").toExternalForm());

		  backgroundImageView.relocate(0, 0);
		  backgroundImageView2.relocate(backgroundImageView2.getImage().getWidth(), 0);

	}
	
	public void startBackGroundLoop()
	{
		gameLoop = new AnimationTimer() {
	         
            @Override
            public void handle(long l) {
            
             double x = backgroundImageView.getLayoutX() - backgroundScrollSpeed;
             double x2 = backgroundImageView2.getLayoutX() - backgroundScrollSpeed;
             
             if(backgroundImageView.getLayoutX() < -993)
             {
            	 x += backgroundImageView.getImage().getWidth() * 2;
             }
             
             if(backgroundImageView2.getLayoutX() < -993)
             {
                 x2 += backgroundImageView2.getImage().getWidth() * 2;
             }

             backgroundImageView.setLayoutX(x);  
             backgroundImageView2.setLayoutX(x2);
            }
 
        };
        
        gameLoop.start();
	}

	
}
