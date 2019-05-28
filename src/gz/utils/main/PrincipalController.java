package gz.utils.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
	
	private HashMap<String,Rotation> lesRotations = new HashMap<String,Rotation>();
	private HashMap<String,Translation> lesTranslations = new HashMap<String,Translation>();
	private HashMap<String,Homothetie> lesHomothetie = new HashMap<String,Homothetie>();
	private ArrayList<Transformation> lesTransformations = new ArrayList<Transformation>();

	private List<Node> allNodes;
	ArrayList<Boolean> display = new ArrayList<>(Arrays.asList(true));
	
	
    @FXML
    private Button btnReculer;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnAvancer;
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
    void btnAvancerListener(MouseEvent event) {

    }

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
            ).play();    // Animation entre les étapes firstStep et lastStep
        } catch (LibraryException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnReculerListener(MouseEvent event) {

    }

    @FXML
    void btnValiderHomothetieListener(MouseEvent event) throws LibraryException {
    	double rapport = Double.parseDouble(txtFieldRapportHomothetie.getText());
    	double x = Double.parseDouble(txtFieldXHomothetie.getText());
    	double y = Double.parseDouble(txtFieldYHomothetie.getText());
    	lesHomothetie.put(txtFieldNomHomothetie.getText(), new Homothetie(rapport, x, y));
    	lesTransformations.add(new Homothetie(rapport, x, y));
    	composition.add(new Homothetie(rapport, x, y));
    	setHomotetieDefaut();
    	ajoutAfficher();
    }

    @FXML
    void btnValiderRotationListener(MouseEvent event) throws LibraryException {
    	double degre = Double.parseDouble(txtFieldDegresRotation.getText());
    	double x = Double.parseDouble(txtFieldXRotation.getText());
    	double y = Double.parseDouble(txtFieldYRotation.getText());
    	lesRotations.put(txtFieldNomRptation.getText(), new Rotation(degre, x, y));
    	lesTransformations.add(new Rotation(degre, x, y));
    	composition.add(new Rotation(degre, x, y));;
    	setRotationDefaut();
    	ajoutAfficher();
    }

    @FXML
    void btnValiderTranslationListener(MouseEvent event) throws LibraryException {
    	double x = Double.parseDouble(txtFieldXTranslation.getText());
    	double y = Double.parseDouble(txtFieldYTranslation.getText());
    	lesTranslations.put(txtFieldNomTranslation.getText(), new Translation(x, y));
    	lesTransformations.add(new Translation(x, y));
    	composition.add(new Translation(x, y));
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
    
    

}
