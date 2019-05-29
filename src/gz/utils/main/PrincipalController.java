package gz.utils.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import transforms.Composition;
import transforms.LibraryException;
import transforms.elementaires.Homothetie;
import transforms.elementaires.Rotation;
import transforms.elementaires.Transformation;
import transforms.elementaires.Translation;
import transforms.mobile.Motif;

public class PrincipalController {
	//ATTRIBUTS
	private Composition composition;
	
	private static HashMap<String,Rotation> lesRotations = new HashMap<String,Rotation>();
	private static HashMap<String,Translation> lesTranslations = new HashMap<String,Translation>();
	private static HashMap<String,Homothetie> lesHomothetie = new HashMap<String,Homothetie>();
	private static ArrayList<Transformation> lesTransformations = new ArrayList<Transformation>();

	private List<Node> allNodes;
	private static ArrayList<Boolean> display = new ArrayList<>(Arrays.asList(true));
	
	private static Label leLblInspector;
	private static VBox laVBoxHistorique;
	
    @FXML
    private Button btnPlay;
    @FXML
    private VBox vBoxHistorique;
    @FXML
    private Pane panePrincipal;
    @FXML
    private TextField txtFieldNomTranslation;
    @FXML
    private TextField txtFieldXTranslation;
    @FXML
    private TextField txtFieldYTranslation;
    @FXML
    private Label lblErreurTranslation;
    @FXML
    private Button btnValiderTranslation;
    @FXML
    private TextField txtFieldNomRptation;
    @FXML
    private TextField txtFieldXRotation;
    @FXML
    private TextField txtFieldYRotation;
    @FXML
    private TextField txtFieldDegresRotation;
    @FXML
    private Label lblErreurRotation;
    @FXML
    private Button btnValiderRotation;
    @FXML
    private TextField txtFieldNomHomothetie;
    @FXML
    private TextField txtFieldXHomothetie;
    @FXML
    private TextField txtFieldYHomothetie;
    @FXML
    private TextField txtFieldRapportHomothetie;
    @FXML
    private Label lblErreurHomothetie;
    @FXML
    private Button btnValiderHomothetie;
    @FXML
    private Label lblInspector;

    @FXML
    void btnPlayListener(MouseEvent event) {
        final int firstStep = 0;
        final int lastStep = lesTransformations.size();
        try {
            final Motif mobile = composition.getStep(firstStep);
            mobile.setStroke(Color.BLUE);
            panePrincipal.getChildren().add(mobile.toGroup());
            composition.animate(
                    mobile.toGroup(),
                    firstStep,
                    lastStep,
                    e -> panePrincipal.getChildren().remove(mobile.toGroup())
            ).play();    // Animation entre les �tapes firstStep et lastStep
        } catch (LibraryException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("static-access")
	@FXML
    void btnValiderHomothetieListener(MouseEvent event) throws LibraryException {
    	double rapport = Double.parseDouble(txtFieldRapportHomothetie.getText());
    	double x = Double.parseDouble(txtFieldXHomothetie.getText());
    	double y = Double.parseDouble(txtFieldYHomothetie.getText());
    	Homothetie h = new Homothetie(rapport, x, y);
    	lesHomothetie.put(txtFieldNomHomothetie.getText(), h);
    	lesTransformations.add(h);
    	composition.add(h);
    	
    	VBox vboxItem = new VBox();
		HBox hboxNom = new HBox();
		HBox hboxCheck = new HBox();
		Label lbl1 = new Label("");
		Label lblNom = new Label(txtFieldNomHomothetie.getText());
		Label lbl2 = new Label("");
		Label lbl3 = new Label("");
		CheckBox cbItem = new CheckBox("Visible");
		Label lbl4 = new Label("");

		HBox.setHgrow(lbl1, Priority.ALWAYS);
		HBox.setHgrow(lbl2, Priority.ALWAYS);
		HBox.setHgrow(lbl3, Priority.ALWAYS);
		HBox.setHgrow(lbl4, Priority.ALWAYS);

		lbl1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		cbItem.setSelected(true);

		hboxNom.getChildren().addAll(lbl1, lblNom, lbl2);
		hboxCheck.getChildren().addAll(lbl3, cbItem, lbl4);
		vboxItem.getChildren().addAll(hboxNom, hboxCheck);
		
		vboxItem.setMargin(vboxItem, new Insets(5.0));
		vboxItem.setPadding(new Insets(2, 0, 5, 0));
		vboxItem.getStyleClass().add("vbox");
		
		vBoxHistorique.getChildren().add(vboxItem);
		
    	setHomotetieDefaut();
    	ajoutAfficher();
    }

    @SuppressWarnings("static-access")
	@FXML
    void btnValiderRotationListener(MouseEvent event) throws LibraryException {
    	double degre = Double.parseDouble(txtFieldDegresRotation.getText());
    	double x = Double.parseDouble(txtFieldXRotation.getText());
    	double y = Double.parseDouble(txtFieldYRotation.getText());
    	Rotation r = new Rotation(degre, x, y);
    	lesRotations.put(txtFieldNomRptation.getText(), r);
    	lesTransformations.add(r);
    	composition.add(r);
    	
    	VBox vboxItem = new VBox();
		HBox hboxNom = new HBox();
		HBox hboxCheck = new HBox();
		Label lbl1 = new Label("");
		Label lblNom = new Label(txtFieldNomRptation.getText());
		Label lbl2 = new Label("");
		Label lbl3 = new Label("");
		CheckBox cbItem = new CheckBox("Visible");
		Label lbl4 = new Label("");

		HBox.setHgrow(lbl1, Priority.ALWAYS);
		HBox.setHgrow(lbl2, Priority.ALWAYS);
		HBox.setHgrow(lbl3, Priority.ALWAYS);
		HBox.setHgrow(lbl4, Priority.ALWAYS);

		lbl1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		cbItem.setSelected(true);

		hboxNom.getChildren().addAll(lbl1, lblNom, lbl2);
		hboxCheck.getChildren().addAll(lbl3, cbItem, lbl4);
		vboxItem.getChildren().addAll(hboxNom, hboxCheck);
		
		vboxItem.setMargin(vboxItem, new Insets(5.0));
		vboxItem.setPadding(new Insets(2, 0, 5, 0));
		vboxItem.getStyleClass().add("vbox");
		
		vBoxHistorique.getChildren().add(vboxItem);
		
    	setRotationDefaut();
    	ajoutAfficher();
    }

    @SuppressWarnings("static-access")
	@FXML
    void btnValiderTranslationListener(MouseEvent event) throws LibraryException {
    	double x = Double.parseDouble(txtFieldXTranslation.getText());
    	double y = Double.parseDouble(txtFieldYTranslation.getText());
    	Translation t = new Translation(x, y);
    	lesTranslations.put(txtFieldNomTranslation.getText(), t);
    	lesTransformations.add(t);
    	composition.add(t);
    	
    	VBox vboxItem = new VBox();
		HBox hboxNom = new HBox();
		HBox hboxCheck = new HBox();
		Label lbl1 = new Label("");
		Label lblNom = new Label(txtFieldNomTranslation.getText());
		Label lbl2 = new Label("");
		Label lbl3 = new Label("");
		CheckBox cbItem = new CheckBox("Visible");
		Label lbl4 = new Label("");

		HBox.setHgrow(lbl1, Priority.ALWAYS);
		HBox.setHgrow(lbl2, Priority.ALWAYS);
		HBox.setHgrow(lbl3, Priority.ALWAYS);
		HBox.setHgrow(lbl4, Priority.ALWAYS);

		lbl1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lbl4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		cbItem.setSelected(true);

		hboxNom.getChildren().addAll(lbl1, lblNom, lbl2);
		hboxCheck.getChildren().addAll(lbl3, cbItem, lbl4);
		vboxItem.getChildren().addAll(hboxNom, hboxCheck);
		
		vboxItem.setMargin(vboxItem, new Insets(5.0));
		vboxItem.setPadding(new Insets(2, 0, 5, 0));
		vboxItem.getStyleClass().add("vbox");
		
		vBoxHistorique.getChildren().add(vboxItem);
		
    	setTranslationDefaut();
    	ajoutAfficher();
    }
    
    //ANIMATION
    public void animer() {
    	int min = 0;
    	int max = lesTranslations.size();
    	try {
    		final Motif mobile = composition.getStep(min);
    		mobile.setStroke(Color.BLUE);
    		panePrincipal.getChildren().add(mobile.toGroup());
			composition.animate(
					mobile.toGroup(),
					min,
					max,
					e -> panePrincipal.getChildren().remove(mobile.toGroup())
					).play();    
		} catch (LibraryException e) {
			e.printStackTrace();
		}
    }
        
    //METHODES
    public void initialize() {
    	leLblInspector = lblInspector;
    	composition = new Composition();
    	panePrincipal.getChildren().add(composition.getGrille(panePrincipal));
    	setRotationDefaut();
    	setTranslationDefaut();
    	setHomotetieDefaut();
    	afficher();
    }
        
    //DEFAUT
    public void setRotationDefaut() {
		txtFieldNomRptation.setText("Rotation " + (lesRotations.size()+1));
		txtFieldXRotation.setText("1");
		txtFieldYRotation.setText("1");
		txtFieldDegresRotation.setText("90");
	}
    
    public void setTranslationDefaut() {
    	txtFieldNomTranslation.setText("Translation " + (lesTranslations.size()+1));
    	txtFieldXTranslation.setText("1");
    	txtFieldYTranslation.setText("1");
    }
    
    public void setHomotetieDefaut() {
    	txtFieldNomHomothetie.setText("Homotetie " + (lesHomothetie.size()+1));
    	txtFieldXHomothetie.setText("1");
    	txtFieldYHomothetie.setText("2");
    	txtFieldRapportHomothetie.setText("2");
    }
    
    //AFFICHAGES
    public void afficher() {
    	if (allNodes == null) {
    		try {
    			allNodes = composition.draw(display);
    		} catch (LibraryException e) {
    			e.printStackTrace();
    		}
    	}
    	panePrincipal.getChildren().addAll(allNodes);
    }
    
    public void ajoutAfficher() throws LibraryException {
    	display.add(true);
    	allNodes = composition.draw(display);
    	panePrincipal.getChildren().addAll(allNodes);
    }
    
    public static Label getLabelInspector() {
    	return leLblInspector;
    }
    
    public static VBox getLaVBoxHistorique() {
    	return laVBoxHistorique;
    }
    
    public static HashMap<String, Translation> getLesTranslations() {
		return lesTranslations;
	}
    
    public static HashMap<String, Rotation> getLesRotations() {
		return lesRotations;
	}
    
    public static HashMap<String, Homothetie> getLesHomothetie() {
		return lesHomothetie;
	}
    
    public static ArrayList<Transformation> getLesTransformations() {
		return lesTransformations;
	}
    
    public static ArrayList<Boolean> getDisplay() {
		return display;
	}

}
