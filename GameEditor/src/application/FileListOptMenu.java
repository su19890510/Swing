package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FileListOptMenu extends TreeCell<String> {
	   private TextField textField = null ;
	   private FileOptMenu addMenu = null;
	   public FileListOptMenu() 
	   {
		   addMenu = new FileOptMenu(this);
//		   try {
//			addMenu = new FileOptMenu(this);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	       MenuItem addMenuItem = new MenuItem("Add Employee");
//	            addMenu.getItems().add(addMenuItem);
//	            addMenuItem.setOnAction(new EventHandler<ActionEvent>() {
//					@Override
//					public void handle(ActionEvent event) {
//						// TODO Auto-generated method stub
//						 FileCell newEmployee = 
//			                        new FileCell("创建新文件");
//			                            getTreeItem().getChildren().add(newEmployee);
//			                            getTreeItem().setExpanded(true);
////			                            getTreeItem().getParent().getChildren().remove(0);
//					}
//	            });

	   }
	    public void startEdit()
	    {
	        super.startEdit();
//	        if(textField == null)
//	        {
//	            createTextField();
//	        }
//	        setText(null);
//	        setGraphic(textField);
//	        textField.selectAll();
	    }
	     public void cancelEdit() {
	            super.cancelEdit();
//	            setText((String) getItem());
//	            setGraphic(getTreeItem().getGraphic());
	        }
	    @Override
	        public void updateItem(String item, boolean empty) {
	            super.updateItem(item, empty);
	            System.out.println("sdfsfsdf");
	            if (empty) {
	                setText(null);
	                setGraphic(null);
	            } else {
	            	
	                if (isEditing()) {
//	                    if (textField != null) {
//	                        textField.setText(getString());
//	                    }
//	                    setText(null);
//	                    setGraphic(textField);
	                } else {
	                    setText(getString());
	                    setGraphic(getTreeItem().getGraphic());
//	                    if (
//	                        !getTreeItem().isLeaf()
//	                    ){
	                    FileCell c = (FileCell) getTreeItem();
	                    File file = new File(c.getPath());
//	                   
//	                    if(this.addMenu == null)
//	    	            {
//	                    	 if(file.isDirectory())
//	   	                      System.out.println("~~~~~~~~~~~~~~~~~~"+c.getPath());
//	    	            	addMenu = new FileOptMenu(this);
////	    	            	System.out.println(getTreeItem().getValue());
//	    	            }  
	                        addMenu.createContextMenu(file.isDirectory());
	                        setContextMenu(addMenu.getMenu());
//	                    }

	                }
	            }
	        }
	    private void createTextField()
	    {
	         textField = new TextField(getString());
	            textField.setOnKeyReleased((KeyEvent t)->
	            {
	                if (t.getCode() == KeyCode.ENTER) {
	                            commitEdit(textField.getText());
	                            ((FileCell)getTreeItem()).updateFileName(getString());
	                        } else if (t.getCode() == KeyCode.ESCAPE) {
	                            cancelEdit();
	                        }
	            });

	    }
	    private String getString() {
	            return getItem() == null ? "" : getItem().toString();
	    }

	}
