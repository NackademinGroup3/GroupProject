package sceneWithJumping;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneMeny extends Application {
	
	Background b=new Background();
	

	public void start(Stage theStage) {

		theStage.setTitle("Running game");

		Group root = new Group();
		Scene theScene = new Scene(root, 500, 500);
		theStage.setScene(theScene);

		FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
		pane.setAlignment(Pos.TOP_CENTER);
		
		b.loadBackGround();
		   b.startBackGroundLoop();
		
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

		root.getChildren().addAll(b.backgroundImageView,b.backgroundImageView2,pane);

		theStage.show();
	}

	private void hoverOver(Label label) {
		
		
		label.setOnMouseEntered(e -> {
			label.setEffect(new Glow(50));
			label.setTextFill(Color.DARKRED);

		});
		label.setOnMouseExited(e -> {
			label.setEffect(null);
			label.setTextFill(Color.WHITE);
		});

		

	}
	
	private void menyChoice(Label label){
		
		
		
		label.setOnMouseClicked(e -> {
			switch (label.getText()) {
			case "New game":
				
				System.out.println("new game");
				break;
			case "How to play":
				System.out.println("how to play");
				break;
			case "High score":
				System.out.println("high score");
				break;
			case "Exit Game":
				System.exit(0);
				break;

			default:
				break;
			}

		});
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
