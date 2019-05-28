package gz.utils.main;

import java.security.Principal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import transforms.Composition;

public class PrincipalController {
	//ATTRIBUTS
	private Composition composition;

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
    void btnValiderTranslationListener(MouseEvent event) {

    }
    
    public void initialize() {
    	composition = new Composition();
    	panePrincipal.getChildren().add(composition.getGrille(panePrincipal));
    }

}
