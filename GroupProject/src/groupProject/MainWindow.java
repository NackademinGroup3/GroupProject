package groupProject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainWindow extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		
		// Princip för startfönster som tar en vidare till spelet
		Button n = new Button("New GAme");
		Group root = new Group();
		Scene scene = new Scene(root);
		root.getChildren().add(n);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Group g = new Group();
		Label label = new Label("hej");
		g.getChildren().add(label);
		Scene scene2 = new Scene(g);
		
		n.setOnAction(event ->{
			primaryStage.setScene(scene2);
			
		});
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
