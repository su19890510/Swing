package application;

import java.io.File;

import javafx.scene.control.TreeItem;

public class FileCell extends TreeItem {
	private String path = "";
	private String fileName = "";
	public FileCell (final String value)
    {
        super(value);
    }
    public int updateFileName(String name)
    {  
        FileManager.getInstance().renameFile(path, name);
        return 0;
    }
    public void setPath(String param)
    {
        this.path = param;
    }
    public String getPath()
    {
        return this.path;
    }
    public String getName()
    {
    	return this.fileName;
    }
    public void setName(String name)
    {
    	this.fileName = name;
    }
}
