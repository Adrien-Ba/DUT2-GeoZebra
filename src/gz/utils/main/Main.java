package gz.utils.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/gz/ressources/principal.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("gz/ressources/style.css");
		stage.setScene(scene);
		stage.setTitle("GeoZebra");
		stage.setHeight(720);
		stage.setWidth(1280);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
