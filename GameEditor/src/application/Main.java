package application;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Scene su_scene;
	@Override
	public void start(Stage stage) throws IOException {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("mainLayout.fxml"));
	        Parent root = (Parent)loader.load();
	        Scene scene = new Scene(root);
	        su_scene = scene;
	        MainLayoutController controller = (MainLayoutController)loader.getController();
	        controller.getFileList().setEditable(true);
	        controller.setStage(stage);
	        controller.afterLoad((BorderPane)root);
	        controller.getFileList().setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
	            public TreeCell<String> call(TreeView<String> p) {
	                return new FileListOptMenu();
	            }
	        });
//	        final ContextMenu contextMenu = new ContextMenu();
//	        MenuItem item1 = new MenuItem("About");
//	        item1.setOnAction(new EventHandler<ActionEvent>()
//	        {
//	            @Override
//	            public void handle(ActionEvent e)
//	            {
//	                System.out.println("About");
//	            }
//	        });
//	        MenuItem item2 = new MenuItem("Remove");
//	        item2.setOnAction(new EventHandler<ActionEvent>() {
//	            @Override
//	            public void handle(ActionEvent e) {
//	                FileCell c = (FileCell)controller.getFileList().getSelectionModel().getSelectedItem();
//	                boolean remove = c.getParent().getChildren().remove(c);
//	                System.out.println("Remove");
//	            }
//	        });
//	    
//	        contextMenu.getItems().addAll(item1,item2);
//            controller.getFileList().setContextMenu(contextMenu);
//            
	       
	        stage.setScene(scene);
	        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
