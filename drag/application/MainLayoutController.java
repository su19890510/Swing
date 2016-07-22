package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainLayoutController implements Initializable {
	@FXML
    private TreeView fileList;
    @FXML
    private MenuItem openFile;
    
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
            return;
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
