package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("mainLayout.fxml"));
	        Parent root = (Parent)loader.load();
	        MainLayoutController controller = (MainLayoutController)loader.getController();
	        controller.getFileList().setEditable(true);
	        controller.setStage(stage);
	        controller.getFileList().setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
	            public TreeCell<String> call(TreeView<String> p) {
	                return new FileListOptMenu();
	            }
	        });


	        Scene scene = new Scene(root);
	        
	        stage.setScene(scene);
	        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
