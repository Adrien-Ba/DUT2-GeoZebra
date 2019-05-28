package gz.utils.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("rendu.fxml"));

		Scene s = new Scene(root, 300, 600);
		primaryStage.setTitle("test");
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

