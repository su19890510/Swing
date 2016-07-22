package application;

import java.io.File;

import javafx.scene.control.TreeItem;

public class FileCell extends TreeItem {
	private String path = "";
	public FileCell (final String value)
    {
        super(value);
    }
    public int updateFileName(String name)
    {  
        File file = new File(path);
        if(file == null)
        {
            return 0;
        }
        File file1 = new File(file.getParent()+"/"+name);
        if(file.renameTo(file1))
        {
            path = file1.getAbsolutePath();
            return 1;
        }
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
}
