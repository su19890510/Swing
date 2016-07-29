package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainLayoutController implements Initializable {
	@FXML
    private TreeView fileList;
    @FXML
    private MenuItem openFile;
    
    @FXML
    private Pane centerPane;
    
    @FXML
    private GridPane topPane;
    
    @FXML
    private MenuBar menuBar;
    
    @FXML
    private Pane zoomInBg;
    
    @FXML
    private Pane zoomOutBg;
    
    private String path;
    
    private Stage stage;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		fileList.setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
//            public TreeCell<String> call(TreeView<String> p) {
//                return new FileListOptMenu();
//            }
//        });
	}
	public void afterLoad(BorderPane _bp)
	{
//        Image image = new Image(getClass().getResourceAsStream( "/res/bag_empty.png"));
//	    
//        // simple displays ImageView the image as is
//        ImageView iv1 = new ImageView();
//        iv1.setImage(image);
//        //.getChildrenUnmodifiable().add(iv1);
//        centerPane.getChildren().add(iv1);
////        iv1.setX(100);
////        iv1.setY(100);
//        
//        iv1.setLayoutX(300);
//        iv1.setLayoutY(300);
//        
//        
//        
//        
//        Image image1 = new Image(getClass().getResourceAsStream( "/res/pp1.png"));
//	    
//        // simple displays ImageView the image as is
//        ImageView iv11 = new ImageView();
//        iv11.setImage(image1);
//        //.getChildrenUnmodifiable().add(iv1);
//        centerPane.getChildren().add(iv11);
//        iv1.setX(image1.getWidth() * 1);
//        iv1.setY(image1.getHeight() * 1);
//        
//        iv11.setLayoutX(300);
//        iv11.setLayoutY(300);
		TreeCustom tc = new TreeCustom(fileList);
		CenterPane.getInstance(centerPane);
		
	}
    @FXML 
    void openFileClicked(ActionEvent event) {
        System.out.println("openFileClicked(ActionEvent event)");
        DirectoryChooser   fileChooser = new DirectoryChooser ();
        File file = fileChooser.showDialog(stage);
        path = file.getAbsolutePath();
        if (file != null) {
           fileList.setRoot(null);
            File[] filelist = file.listFiles();
            for(File fi:filelist)
            {
                System.out.println(fi.getName());
            }
            this.updateTreeView(file,null);
        }
        
    }
    @FXML 
     void zoomInClicked(MouseEvent mouseEvent) {
        System.out.println("scaleClicked(ActionEvent event)");
        Image image = new Image(getClass().getResourceAsStream( "/res/suoxiao.png"));
    	ImageCursor cursor = new ImageCursor(image,0,0);
    	Main.su_scene.setCursor(cursor);
        zoomInBg.setStyle("-fx-background-color: #8f8d8d;");
        zoomOutBg.setStyle("-fx-background-color: #333333;");
        CenterPane.getInstance(null).mouseType = "custom-zoomIn";
        CenterPane.getInstance(null).mouseIcon = cursor;
    }
    
    @FXML 
    void zoomOutClicked(MouseEvent mouseEvent) {
       System.out.println("scaleClicked(ActionEvent event)");
        Image image = new Image(getClass().getResourceAsStream( "/res/fangda.png"));
	   	ImageCursor cursor = new ImageCursor(image,0,0);
	   	Main.su_scene.setCursor(cursor);
       zoomOutBg.setStyle("-fx-background-color: #8f8d8d;");
       zoomInBg.setStyle("-fx-background-color: #333333;");
       CenterPane.getInstance(null).mouseType = "custom-zoomOut";
       CenterPane.getInstance(null).mouseIcon = cursor;
   }
    private void updateTreeView(File file ,TreeItem<String> _item)
    {
        if(_item != null)
        {
            _item.setExpanded(false);
        }
        if(fileList.getRoot() == null)
        {
            System.out.println("fileList is null");
            FileCell item = new FileCell (file.getName());
            item.setPath(file.getAbsolutePath());
            fileList.setRoot(item);
            item.setExpanded(true);
            _item = item;
        }
        if(!file.isDirectory())
        {
        	 Image image1 = new Image(getClass().getResourceAsStream( "/res/document.png"));
     	    
             // simple displays ImageView the image as is
             ImageView iv11 = new ImageView();
             iv11.setImage(image1);
         	_item.setGraphic(iv11);
            return;
        }
        if(file.isDirectory())
        {
            Image image1 = new Image(getClass().getResourceAsStream( "/res/folderIcon.png"));
    	    
            // simple displays ImageView the image as is
            ImageView iv11 = new ImageView();
            iv11.setImage(image1);
        	_item.setGraphic(iv11);
        }
        System.out.println(file.getName());
        File[] fileList = file.listFiles();
        for(File f :fileList)
        {
        	FileCell item = new FileCell (f.getName());
            item.setPath(f.getAbsolutePath());
            _item.getChildren().add(item);
            
            this.updateTreeView(f, item);
        }

    }
    public TreeView getFileList()
    {
    	return this.fileList;
    }
    public void setStage(Stage param_stage)
    {
    	this.stage = param_stage;
    }
}
