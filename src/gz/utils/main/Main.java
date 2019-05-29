package gz.utils.main;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import transforms.elementaires.Homothetie;
import transforms.elementaires.Rotation;
import transforms.elementaires.Transformation;
import transforms.elementaires.Translation;

public class Main extends Application {

	private static HashMap<String,Rotation> lesRotations;
	private static HashMap<String,Translation> lesTranslations;
	private static HashMap<String,Homothetie> lesHomothetie;

	private static ArrayList<Transformation> lesTransformations;
	private static ArrayList<Boolean> display;

	private static Label lblInspector;
	private static VBox vboxHistorique;

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/gz/ressources/principal.fxml"));

		lesTranslations = PrincipalController.getLesTranslations();
		lesRotations = PrincipalController.getLesRotations();
		lesHomothetie = PrincipalController.getLesHomothetie();

		lesTransformations = PrincipalController.getLesTransformations();
		display = PrincipalController.getDisplay();

		lblInspector = PrincipalController.getLabelInspector();
		vboxHistorique = PrincipalController.getLaVBoxHistorique();

		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("GeoZebra");
		stage.setHeight(720);
		stage.setWidth(1280);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public static void addHistorique(String nom, Transformation tr) {
		VBox vboxItem = new VBox();
		HBox hboxNom = new HBox();
		HBox hboxCheck = new HBox();
		Label lbl1 = new Label("");
		Label lblNom = new Label(nom);
		Label lbl2 = new Label("");
		Label lbl3 = new Label("");
		CheckBox cbItem = new CheckBox("Visible");
		Label lbl4 = new Label("");

		VBox.setVgrow(lbl1, Priority.ALWAYS);
		VBox.setVgrow(lbl2, Priority.ALWAYS);
		VBox.setVgrow(lbl3, Priority.ALWAYS);
		VBox.setVgrow(lbl4, Priority.ALWAYS);

		lbl1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		cbItem.setSelected(true);

		hboxNom.getChildren().addAll(lbl1, lblNom, lbl2);
		hboxCheck.getChildren().addAll(lbl3, cbItem, lbl4);
		vboxItem.getChildren().addAll(hboxNom, hboxCheck);
		
		vboxHistorique.getChildren().add(vboxItem);
	}

}
