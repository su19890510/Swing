package application;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javafx.scene.control.TextInputDialog;

public class DialogManager {
	public static String showCreateFileDialog(String path,String title,String header,String context,String defaultName,String houzhui)
	{
		TextInputDialog dialog = new TextInputDialog(defaultName);
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(context);
		dialog.setGraphic(null);

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent())
		{
			try {
				String ret = FileManager.getInstance().newFile(path, result.get()+"."+houzhui);
				if(ret == "exits")
				{
					return DialogManager.showCreateFileDialog(path,title,"创建的文件已经存在，请重新输入名称","名称:",result.get(),houzhui);
				}
				else
				{
					return result.get()+"."+houzhui;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return "false";
	}
	public static String showCreateFolderDialog(String path,String title,String header,String context,String defaultName)
	{
		TextInputDialog dialog = new TextInputDialog(defaultName);
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(context);
		dialog.setGraphic(null);

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent())
		{
		
				String ret = FileManager.getInstance().newFolder(path, result.get());
				if(ret == "exits")
				{
					return DialogManager.showCreateFolderDialog(path,title,"创建的文件已经存在，请重新输入名称","名称:",result.get());
				}
				else if (ret == "fail")
				{
					return "false";
				}
				else
				{
					return result.get();
				}
			
			
		}
		
		return "false";
	}
}
