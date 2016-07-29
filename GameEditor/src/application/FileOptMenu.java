package application;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FileOptMenu {
	private static FileOptMenu _fileOptMenu;
	private TreeCell _treeCell;
	private ContextMenu menu ;
	public FileOptMenu(TreeCell cell) 
	{
		this._treeCell = cell;
		if(cell.getTreeItem() == null)
		{
			System.out.println("空的啊");
		}
//		this.createContextMenu();
	}
	public void createContextMenu(Boolean isDirectory) 
	{
		if(menu != null)
		{   
			menu.getItems().clear();
		}
		 menu = new ContextMenu();
		
		MenuItem item1 = new MenuItem("创建新文件");
		item1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				// TODO Auto-generated method stub
				FileCell cell = (FileCell) _treeCell.getTreeItem();
				String path = cell.getPath();
				String ret = DialogManager.showCreateFileDialog(path, "创建文件", null, "名称:", "", "txt");
				if(ret == "false")
				{
					
				}
				else
				{
					 FileCell newEmployee = new FileCell(ret);
					 Image image1 = new Image(getClass().getResourceAsStream( "/res/document.png"));
			     	 newEmployee.setPath(path + "\\" + ret);
			     	 System.out.println("suzhaohui new path is "+newEmployee.getPath());
		             // simple displays ImageView the image as is
		             ImageView iv11 = new ImageView();
		             iv11.setImage(image1);
		             newEmployee.setGraphic(iv11);
                    _treeCell.getTreeItem().getChildren().add(newEmployee);
                    _treeCell.getTreeItem().setExpanded(true);
				}			
			}
        });
		
		
		MenuItem item2 = new MenuItem("删除文件");
		item2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					// TODO Auto-generated method stub
					FileCell cell = (FileCell) _treeCell.getTreeItem();
					String path = cell.getPath();
					String ret = FileManager.getInstance().remvoeFile(path);
					if(ret == "success")
					{
						  FileCell c = (FileCell) _treeCell.getTreeItem();
			                boolean remove = c.getParent().getChildren().remove(c);
			                System.out.println("Remove");
					}
					else
					{
						
					}
				}
          });
		
		
		MenuItem item3 = new MenuItem("创建文件夹");
		item3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					// TODO Auto-generated method stub
					FileCell cell = (FileCell) _treeCell.getTreeItem();
					String path = cell.getPath();
					String ret = DialogManager.showCreateFolderDialog(path, "创建文件", null, "名称:", "");
					if(ret == "false")
					{
						
					}
					else
					{
						 FileCell newEmployee = new FileCell(ret);
						 Image image1 = new Image(getClass().getResourceAsStream( "/res/folderIcon.png"));
						 newEmployee.setPath(path + "\\" + ret); 
			             // simple displays ImageView the image as is
			             ImageView iv11 = new ImageView();
			             iv11.setImage(image1);
			             newEmployee.setGraphic(iv11);
	                    _treeCell.getTreeItem().getChildren().add(newEmployee);
	                    _treeCell.getTreeItem().setExpanded(true);
					}		
				}
          });
		
		MenuItem item4 = new MenuItem("修改名字");
		item4.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					TextField textField = new TextField(_treeCell.getItem().toString());
					_treeCell.setText(null);
					_treeCell.setGraphic(textField);
				        textField.selectAll();
		            textField.setOnKeyReleased((KeyEvent t)->
		            {
		                if (t.getCode() == KeyCode.ENTER) {
		                	System.out.println("suzhaohui bbbbbbb");
		                	_treeCell.commitEdit(textField.getText());
		                            ((FileCell)_treeCell.getTreeItem()).updateFileName(_treeCell.getItem().toString());
		                            _treeCell.setText((String) _treeCell.getItem());
		                        	_treeCell.setGraphic(_treeCell.getTreeItem().getGraphic());
		                        } else if (t.getCode() == KeyCode.ESCAPE) {
		                        	_treeCell.setText((String) _treeCell.getItem());
		                        	_treeCell.setGraphic(_treeCell.getTreeItem().getGraphic());
		                        }
		            });
				}
          });
		menu.getItems().addAll(item1,item2,item4);
		item1.setId("fileMenuItem");
		item2.setId("fileMenuItem");
		item3.setId("fileMenuItem");
		item4.setId("fileMenuItem");
		FileCell c = (FileCell) _treeCell.getTreeItem();
		String path = c.getPath();
		File file = new File(path);
		if(isDirectory)
		{   
			System.out.println(path);
			menu.getItems().add(item3);
		}
		menu.setId("sdf");
	}
	public ContextMenu getMenu()
	{
		return this.menu;
	}
	
	
}
