package test;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
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

	Scene meny;
	Scene game;
	Scene gameOver;
	Scene howToPlay;
	Stage mainStage;
	Group gameRoot;
	Image[] images = { new Image("textures/run1.png"), new Image("textures/run2.png"), new Image("textures/jump.png") };
	Player player;
	private double counter = 1;
	Timeline playerLoop;
	ArrayList<Obstacle> obsList = new ArrayList<>();
	Obstacle obs;
	Timeline timeline;
	Duration time = Duration.ZERO;
	Label timerLabel = new Label();
	IntegerProperty timeSeconds = new SimpleIntegerProperty();

	public void start(Stage theStage) {

		mainStage = theStage;
		meny = createMenyScene();
		

		mainStage.setScene(meny);
		mainStage.show();
	}

	private Scene createHowToPlayScene() {

		Background b = new Background();
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		/*
		 * FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
		 * pane.setAlignment(Pos.TOP_CENTER);
		 */

		BorderPane pane = new BorderPane();

		b.loadBackGround();
		b.startBackGroundLoop();

		// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		Label rules = new Label("     How to play");

		Label text = new Label("          Welcome to The Running Game, you will\n\n "
				+ "          be encountering obstacles that you will\n\n"
				+ "          need to evade. By evading the obstacles \n\n"
				+ "   		  you will use the SPACE key to jump \n\n"
				+ "          over them and try to survive for as \n\n"
				+ "			     long as you can");
		text.setMaxWidth(450);
		text.setWrapText(true);

		Label goBack = new Label(" Return to menu");

		Font font = new Font("Arial Black", 40);
		Font font2 = new Font("Arial Black", 17);
		Font font3 = new Font("Arial Black", 35);
		VBox vbox = new VBox(20);

		hoverOver(goBack);
		menyChoice(goBack);

		text.setFont(font2);
		text.setTextFill(Color.WHITE);

		vbox.getChildren().addAll(rules, text, goBack);

		vbox.setAlignment(Pos.CENTER);

		rules.setFont(font);
		rules.setTextFill(Color.WHITE);

		goBack.setFont(font3);
		goBack.setTextFill(Color.WHITE);

		root.getChildren().addAll(b.backgroundImageView, b.backgroundImageView2, pane);

		pane.setRight(vbox);

		return scene;
	}

	private Scene createMenyScene() {

		Background b = new Background();
		Group root = new Group();
		Scene theScene = new Scene(root, 500, 500);

		FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
		pane.setAlignment(Pos.TOP_CENTER);

		b.loadBackGround();
		b.startBackGroundLoop();
		// playSoundEffect(3);

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

		Background b = new Background();
		double SCENE_WIDTH = 1000;
		double SCENE_HEIGHT = 500;
		Pane backgroundLayer;
		
		timerLabel.textProperty().bind(timeSeconds.asString());
		timerLabel.setFont(Font.font("Arial Black", 40));
		timerLabel.setTextFill(Color.WHITE);
		
		
		HBox hbox = new HBox(5);
		Label score = new Label("Score: ");
		score.setFont(Font.font("Arial Black", 40));
		score.setTextFill(Color.WHITE);
		score.setAlignment(Pos.TOP_RIGHT);

		hbox.getChildren().addAll(score, timerLabel);

		gameRoot = new Group();
		Scene scene;
		try {
			gameRoot = new Group();
			backgroundLayer = new Pane();

			gameRoot.getChildren().add(backgroundLayer);

			scene = new Scene(gameRoot, SCENE_WIDTH, SCENE_HEIGHT);

			b.loadBackGround();
			b.startBackGroundLoop();

			backgroundLayer.getChildren().add(b.backgroundImageView);
			backgroundLayer.getChildren().add(b.backgroundImageView2);

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

					switch (event.getCode()) {
					case SPACE:

						player.setJumping(true);
						// fall.stop();
						// jump.stop();
						playSoundEffect(3);
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
					default:
						break;
					}
				}
			});

			obs = new Obstacle();
			obs.getGraphics().setTranslateX(1000);
			obs.getGraphics().setTranslateY(370);
			gameRoot.getChildren().add(obs.getGraphics());
			gameRoot.getChildren().add(hbox);

			return scene;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Scene createGameOverScreen() {

		Background b = new Background();
		Group root = new Group();
		Scene gameOverScene = new Scene(root, 1000, 500);

		FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
		pane.setAlignment(Pos.CENTER);

		b.loadBackGround();
		b.startBackGroundLoop();

		Text gameOver = new Text("     GAME OVER");
		gameOver.setFont(Font.font("Arial Black", 100));
		gameOver.setFill(Color.GREEN);
		gameOver.setEffect(new Glow(500));
		
		Label score = new Label("                       Your score is: " + timerLabel.getText());
		score.setFont(new Font("Arial Black", 40));
		score.setTextFill(Color.RED);
		Label meny = new Label("                     Back to main meny");
		meny.setFont(new Font("Arial Black", 40));
		meny.setTextFill(Color.WHITE);
		meny.setAlignment(Pos.CENTER_RIGHT);
		hoverOver(meny);
		menyChoice(meny);

		pane.getChildren().add(gameOver);
		pane.getChildren().add(score);
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
				game = createGameScene();
				mainStage.setScene(game);
				
				startScoreCounter();
				System.out.println("new game");
				break;
			case "How to play":
				
				playSoundEffect(2);
				howToPlay = createHowToPlayScene();
				mainStage.setScene(howToPlay);
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

			case " Return to menu":
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
			} else if (i == 3) {
				Media someSound = new Media(getClass().getResource("/sounds/jump.wav").toString());
				playMedia(someSound);
			}

		} catch (Exception ex) {

		}

	}

	int i = 0;
	
	public void startPlayerMovement() {
		obsList.add(new Obstacle());
		System.out.println(obsList.isEmpty());
		playerLoop = new Timeline(new KeyFrame(Duration.millis(1000 / 15), new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//if (obsList.isEmpty())
					
				updatePlayer();
				if (hit == false)
					checkCollision();
				if (obsList.get(0).getTranslateX() <= -200){
					//obsList.remove(0);
					obsList.removeAll(obsList);
					
					Obstacle obst = new Obstacle();	
						
						obsList.add(obst);
						obst.setTranslateX(obsList.get(obsList.size()-1).getTranslateX()-1);
						gameRoot.getChildren().remove(obst);
						gameRoot.getChildren().add(obst);
				}
				for (int i = 0; i < obsList.size(); i++) {
					obsList.get(i).setTranslateX(obsList.get(i).getTranslateX()-50);
				}
				hit = false;
					
			}
		}));
		playerLoop.setCycleCount(-1);
	}
	
	public void startScoreCounter(){
		timeline = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				Duration duration = ((KeyFrame) t.getSource()).getTime();
				time = time.add(duration);

				timeSeconds.set((int)time.toSeconds());

			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.play();
		
		
	}

	private void updatePlayer() {
		if (counter % 4 == 0) {
			player.refreshImg();
			counter = 1;
		}
		counter++;
	}
	
	//flytta instansvariabler
	boolean hit = false;
	int hitTimer = 0;
	private void checkCollision(){   	

	     player.getGraphics().boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
	        @Override
	        public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
	            if(obsList.get(0).getBoundsInParent().intersects(newValue)){
	            	hit = true;
	            	if (hit && hitTimer == 0){
	            	System.out.println("Collide ============= Collide");
	            	playSoundEffect(2);
	            	hitTimer=1;
	            	player.setHitPoints(player.getHitPoints()-1);
	            	}
	               //createGameOverScreen();
	            }
	        }
	    }
	 ); hitTimer = 0;
	if (player.getHitPoints() == 0){
		gameOver = createGameOverScreen();
		mainStage.setScene(gameOver);
		playerLoop.stop();
		timeline.stop();
		time = Duration.ZERO;
		//obsList.removeAll(obsList);
		//obsList.add(obs);
		//gameRoot.getChildren().removeAll(obsList);
		System.out.println("game Over");
		
	}
		
	 hit = false;
	     }

	public static void main(String[] args) {
		launch(args);
	}
}
