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
import transforms.Composition;
import transforms.LibraryException;
import transforms.elementaires.Homothetie;
import transforms.elementaires.Rotation;
import transforms.elementaires.Translation;

public class PrincipalController {
	//ATTRIBUTS
	private Composition composition;
	
	private HashMap<String,Rotation> lesRotations = new HashMap<String,Rotation>();
	private HashMap<String,Translation> lesTranslations = new HashMap<String,Translation>();
	private HashMap<String,Homothetie> lesHomothetie = new HashMap<String,Homothetie>();

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

    }

    @FXML
    void btnReculerListener(MouseEvent event) {

    }

    @FXML
    void btnValiderHomothetieListener(MouseEvent event) {

    }

    @FXML
    void btnValiderRotationListener(MouseEvent event) {

    }

    @FXML
    void btnValiderTranslationListener(MouseEvent event) throws LibraryException {
    	double x = Double.parseDouble(txtFieldXTranslation.getText());
    	double y = Double.parseDouble(txtFieldYTranslation.getText());
    	lesTranslations.put(txtFieldNomTranslation.getText(), new Translation(x, y));
    	//
    	composition.add(new Translation(x, y));
    	ajoutAfficher();
    }
    
    //METHODES
    public void initialize() {
    	composition = new Composition();
    	panePrincipal.getChildren().add(composition.getGrille(panePrincipal));
    	afficher();
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
