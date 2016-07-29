package application;

import java.io.File;
import java.io.IOException;

public class FileManager {
	private static  FileManager _fileManager;
	public FileManager()
	{
		
	}
	public static FileManager getInstance()
	{
		if(_fileManager == null)
		{
			_fileManager = new FileManager();
		}
		return _fileManager;
	}
	public String renameFile(String path, String newName)
	{
		File file = new File(path);
		if(file == null)
		{
			return path;
		}
		String newPath = file.getParent() + "\\" + newName;
		File newFile = new File(newPath);
		if(file.renameTo(newFile))
		{
			return newPath;
		}
		return path;
	}
	public String newFile(String path ,String name) throws IOException
	{  
		File parentFile = new File(path);
		String pathStart = parentFile.getParent();
		if(parentFile.isDirectory())
		{
			pathStart = parentFile.getAbsolutePath();
		}
		String newPath = pathStart + "\\" + name;
		File file = new File(newPath);
		if(file.exists())
		{
			return "exits";
		}
		else
		{
			file.createNewFile();
		}
		return path;
	}
	public String remvoeFile(String path)
	{
		File file = new File(path);
		if(file.exists())
		{
		 if(file.isDirectory())
		 {
			 return removeFolder(path);
		 }
		 Boolean b=	file.delete();
		 if(!b)
		 {
			 return "fail";
		 }
		}
		else
		{
			return "fail";
		}
		return "success";
	}
	public String removeFolder(String path)
	{
		File file = new File(path);
		if(file.isDirectory())
		{
			File[] fileList = file.listFiles();
			for(File f:fileList)
			{
				removeFolder(f.getAbsolutePath());
			}
			
		}
		
		Boolean b = file.delete();
		if(!b)
		{
			return "fail";
		}
		
		return "success";
	}
	public String newFolder(String path ,String name) 
	{  
		File parentFile = new File(path);
		String pathStart = null;
		if(parentFile.isDirectory())
		{
			pathStart = parentFile.getAbsolutePath();
		}
		else
		{
			return "fail";
		}
		String newPath = pathStart + "\\" + name;
		File file = new File(newPath);
		if(file.exists())
		{
			return "exits";
		}
		else
		{  
			try{
			  Boolean b =	file.mkdir();
			  if(!b)
			  {
				  return "fail";
			  }
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return "success";
	}
}
