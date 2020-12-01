package me.xtrm.EZInstaller.info.spicyClient.javaFx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import me.xtrm.EZInstaller.Installer;
import me.xtrm.EZInstaller.Referances;

public class Stage extends Application implements Initializable {
	
	public static javafx.stage.Stage stage;
	public static Scene scene;
	
	public void createGui(String... args) {
		launch(args);
	}
	
	@Override
	public void start(javafx.stage.Stage arg0) throws Exception {
		
		stage = new javafx.stage.Stage();
		stage.setTitle("SpicyClient Installer");
		
		// Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        
        //String fxmlDocPath = "src/me/xtrm/EZInstaller/info/spicyClient/javaFx/Window.fxml"; // Only use src if you are running in eclipse
        
        String fxmlDocPath = "Window.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        // Create the Pane and all Details
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
        
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Make the stage not resizeable
        stage.setResizable(false);
        // Display the Stage
        stage.show();
		
	}
	
    @FXML
    private Button installButton;
	
    @FXML
    public Text InfoBox;
    
    @FXML
    void startInstaller(MouseEvent event) {
    	
    	InfoBox.setY(InfoBox.getY() - 20);
    	InfoBox.setText("Installer will close when download is complete");
    	installButton.setText("Installing...");
		installButton.setDisable(true);
		new Thread().start();
		
    }
    
    public void closeStage() {
    	stage.close();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
