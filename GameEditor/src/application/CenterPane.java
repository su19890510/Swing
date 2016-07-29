package application;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CenterPane {
	private static CenterPane CenterPane;
	private  Pane _center ;
	public  String mouseType = "default";
	public ImageCursor  mouseIcon = null;
	public CenterPane(Pane center)
	{
		this._center = center;
		this.init();
		
	}
	public static CenterPane getInstance(Pane center)
	{
		if(CenterPane == null)
		{
			CenterPane = new CenterPane(center);
		}
		return CenterPane;
	}
	private void init()
	{
		this._center.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			    @Override
			    public void handle(MouseEvent mouseEvent) {
			    	if(mouseType != "default")
			    	{
			    		Main.su_scene.setCursor(mouseIcon);
			    	}
			        System.out.println("mouse is enter center panel");
			    }
			});
		
		
		this._center.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {		
//		    	System.out.println("mouse is out center panel");
		    	Main.su_scene.setCursor(Cursor.DEFAULT);
		    }
		});
	 }
	 
}
