package test;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SceneMeny extends Application {

	Background b = new Background();
	Scene meny;
	Scene game;
	Scene gameOver;
	Scene howToPlay;
	
	Stage mainStage;
	Group gameRoot; 
	
	Image[] images = { new Image("textures/run1.png"), new Image("textures/run2.png"), new Image("textures/jump.png")};
	Player player;
	private double counter = 1;
	Timeline playerLoop;
	
	ArrayList<Obstacle> obsList = new ArrayList<>();
	Obstacle obs;

	public void start(Stage theStage) {

		mainStage = theStage;
		meny = createMenyScene();
		game = createGameScene();
		gameOver = createGameOverScreen();
		howToPlay = createHowToPlayScene();

		mainStage.setScene(meny);
		mainStage.show();
	}

	private Scene createHowToPlayScene(){
		
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		/*FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
		pane.setAlignment(Pos.TOP_CENTER);*/
		
		BorderPane pane = new BorderPane();
		
		b.loadBackGround();
		   b.startBackGroundLoop();
		
		
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Label rules = new Label("     How to play");
		
		Label text = new Label("          Welcome to The Running Game, you will\n\n "
				             + "          be encountering obstacles that you will\n\n"
				             + "          need to evade. By evading the obstacles \n\n"
				             + "   		  you will use the SPACE key to jump \n\n"
				             + "          over them and try to survive for as \n\n"
				             + "			     long as you can");
	text.setMaxWidth(450);
		text.setWrapText(true);
		
		
		Font font = new Font("Arial Black", 40);
		Font font2 = new Font("Arial Black", 17);
		VBox vbox = new VBox(20);
		
		
		
		text.setFont(font2);
		text.setTextFill(Color.WHITE);
		
		vbox.getChildren().addAll(rules, text);
		
		vbox.setAlignment(Pos.CENTER);
		
		rules.setFont(font);
		rules.setTextFill(Color.WHITE);
		
		root.getChildren().addAll(b.backgroundImageView,b.backgroundImageView2,pane);
		
		pane.setRight(vbox);
		
		return scene;
	}
	
	private Scene createMenyScene() {
		Group root = new Group();
		Scene theScene = new Scene(root, 500, 500);

		FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
		pane.setAlignment(Pos.TOP_CENTER);

		b.loadBackGround();
		b.startBackGroundLoop();
		//playSoundEffect(3);

		Font font = new Font("Arial Black", 40);

		Text title = new Text("Jump and stuff");

		title.setFont(Font.font("Arial Black", 60));
		title.setFill(Color.GREEN);
		title.setStroke(Color.BLACK);
		title.setEffect(new Glow(10));

		Label newGame = new Label("New game");
		Label rules = new Label("How to play");
		Label scores = new Label("High score");
		Label exit = new Label("Exit Game");
		newGame.setFont(font);
		newGame.setTextFill(Color.WHITE);
		rules.setFont(font);
		rules.setTextFill(Color.WHITE);
		scores.setFont(font);
		scores.setTextFill(Color.WHITE);
		exit.setFont(font);
		exit.setTextFill(Color.WHITE);

		hoverOver(newGame);
		hoverOver(rules);
		hoverOver(scores);
		hoverOver(exit);

		menyChoice(newGame);
		menyChoice(rules);
		menyChoice(scores);
		menyChoice(exit);

		VBox meny = new VBox(20);

		meny.setAlignment(Pos.CENTER);
		meny.getChildren().addAll(newGame, rules, scores, exit);
		pane.getChildren().addAll(title, meny);
		
		root.getChildren().addAll(b.backgroundImageView, b.backgroundImageView2, pane);
		
		return theScene;

	}

	private Scene createGameScene() {
		double SCENE_WIDTH = 1000;
		double SCENE_HEIGHT = 500;
		Pane backgroundLayer;
		
		gameRoot = new Group();
		Scene scene;
		 try
		 {
		   gameRoot = new Group();
		   backgroundLayer = new Pane();
		 
		   gameRoot.getChildren().add( backgroundLayer);

		   scene = new Scene( gameRoot, SCENE_WIDTH,SCENE_HEIGHT);
		   
		   
		   
		   b.loadBackGround();
		   b.startBackGroundLoop();
		   
		   backgroundLayer.getChildren().add( b.backgroundImageView);
		   backgroundLayer.getChildren().add( b.backgroundImageView2);
		   
		   player = new Player(images);
			gameRoot.getChildren().add(player.getGraphics());
			
			player.getGraphics().setTranslateX(100);
			player.getGraphics().setTranslateY(370);
			
			
			startPlayerMovement();
			playerLoop.play();
			TranslateTransition jump = new TranslateTransition(Duration.millis(450), player.getGraphics());
			TranslateTransition fall = new TranslateTransition(Duration.millis(450), player.getGraphics());
			jump.setInterpolator(Interpolator.LINEAR);
			scene.setOnKeyPressed(event -> {
				if (!player.isJumping()) {
					player.setJumping(true);
					// fall.stop();
					// jump.stop();
					
					jump.setByY(-250);
					jump.setCycleCount(1);
					jump.play();
					jump.setOnFinished(finishedEvent -> {
						jump.stop();
						fall.setByY(250);
						fall.play();
						fall.setOnFinished(finishedFalling -> {
							player.setJumping(false);
						
						});

					});
				}

			});
			
			obs = new Obstacle();
			obs.getGraphics().setTranslateX(1000);
			obs.getGraphics().setTranslateY(370);
			gameRoot.getChildren().add(obs.getGraphics());
			
			
		   
	return scene;
		   
		  } 
		 catch(Exception e)
		 {
		   e.printStackTrace();
		 }
		 
		return null;
    
	}

	private Scene createGameOverScreen(){
		
		Group root = new Group();
		Scene gameOverScene = new Scene(root, 1000, 500);

		FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
		pane.setAlignment(Pos.CENTER);

		b.loadBackGround();
		b.startBackGroundLoop();
		
		Text gameOver = new Text("     GAME OVER");
		gameOver.setFont(Font.font("Arial Black",100));
		gameOver.setFill(Color.GREEN);
		gameOver.setEffect(new Glow(500));
		
		Label meny = new Label("                     Back to main meny");
		meny.setFont(new Font("Arial Black", 40));
		meny.setTextFill(Color.WHITE);
		meny.setAlignment(Pos.CENTER_RIGHT);
		hoverOver(meny);
		menyChoice(meny);
		pane.getChildren().add(gameOver);
		pane.getChildren().add(meny);
		root.getChildren().add(b.backgroundImageView);
		root.getChildren().add(b.backgroundImageView2);
		root.getChildren().add(pane);
		
		return gameOverScene;
		
		
	}
	
	
	private void hoverOver(Label label) {

		label.setOnMouseEntered(e -> {
			playSoundEffect(1);
			label.setEffect(new Glow(50));
			label.setTextFill(Color.DARKRED);

		});
		label.setOnMouseExited(e -> {
			label.setEffect(null);
			label.setTextFill(Color.WHITE);
		});

	}

	private void menyChoice(Label label) {

		label.setOnMouseClicked(e -> {
			switch (label.getText()) {
			case "New game":
				playSoundEffect(2);
				mainStage.setScene(game);
				System.out.println("new game");
				break;
			case "How to play":
				mainStage.setScene(howToPlay);
				playSoundEffect(2);
				System.out.println("how to play");
				break;
			case "High score":
				playSoundEffect(2);
				System.out.println("high score");
				break;
			case "Exit Game":
				playSoundEffect(2);
				System.exit(0);
				break;
				
			case "                     Back to main meny":
				playSoundEffect(2);
				mainStage.setScene(meny);
				System.out.println("new game");
				break;

			default:
				break;
			}

		});

	}

	private void playMedia(Media m) {
		if (m != null) {
			MediaPlayer mp = new MediaPlayer(m);
			mp.play();
		}
	}

	public void playSoundEffect(int i) {
		try {

			if (i == 1) {
				Media someSound = new Media(getClass().getResource("/sounds/Click.mp3").toString());
				playMedia(someSound);
			} else if (i == 2) {
				Media someSound = new Media(getClass().getResource("/sounds/Punch.mp3").toString());
				playMedia(someSound);
			}
			else if (i == 3) {
				Media someSound = new Media(getClass().getResource("/sounds/crazy.mp3").toString());
				playMedia(someSound);
			}

		} catch (Exception ex) {

		}

	}
	
	public void startPlayerMovement() {
		playerLoop = new Timeline(new KeyFrame(Duration.millis(1000 /15), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				updatePlayer();
				
				obs.getGraphics().setTranslateX(obs.getGraphics().getTranslateX()-10);
				
				
				
			}
		}));
		playerLoop.setCycleCount(-1);
	}
	private void updatePlayer(){
		if (counter %4 == 0){
			player.refreshImg();
			counter = 1;
		}
		counter++;
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}

