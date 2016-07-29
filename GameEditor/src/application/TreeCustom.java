package application;


import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class TreeCustom {
	private TreeView tree ;
	private static String state = "";
	public double preSize = 0;
	private TreeCustom _treeCustom ;
	public TreeCustom getInstance(TreeView t)
	{
		
		return _treeCustom;
	}
	public TreeCustom(TreeView t)
	{
		this.tree = t;
		this.handlerTree();
	}
	public void handlerTree()
	{
//		testimage.setUserData(p);
//    	tree.setTranslateX(tree.getPrefWidth() * -1);
		preSize = tree.getPrefWidth();
//		System.out.println("suzhaohui grans late  positino is "+tree.getTranslateX()+" "+tree.getTranslateY());
//		tree.setTranslateX(tree.getPrefWidth() * -0.5);
		tree.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("mouse click detected! " + mouseEvent.getSource() + " "+mouseEvent.getX());
//        mouseState = "pressed";
        if(mouseEvent.getX() < tree.getPrefWidth() + 5 && mouseEvent.getX() >tree.getPrefWidth() -5 )
        {  
        	Main.su_scene.setCursor(Cursor.W_RESIZE);
        	state = "resize";
        }
        
    }
});

		tree.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
    	
        state = "end";
        Main.su_scene.setCursor(Cursor.DEFAULT);
    }
});

		tree.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
//    	if(mouseState == "pressed")
//    	{
//    		 System.out.println("mouse click MOUSE_MOVED! " + mouseEvent.getSource() + " "+mouseEvent.getSceneX()+" "+mouseEvent.getX());
////    	}
//       NodeBaseProperty  property =(NodeBaseProperty) testimage.getUserData();
//       double offsetx = testimage.getLayoutBounds().getWidth() * property.getAncPoint().x;
//       double offsety = testimage.getLayoutBounds().getHeight() *  property.getAncPoint().y;
//       System.out.print("getWidth " +  testimage.getLayoutBounds().getWidth() + "testimage.getLayoutBounds().getHeight()  " + testimage.getLayoutBounds().getHeight());
//       testimage.setX(mouseEvent.getSceneX() - offsetx);
//       testimage.setY(mouseEvent.getSceneY() - offsety);
//    	tree.resize(tree.getPrefWidth() + Math.abs(mouseEvent.getX()), tree.getPrefHeight());
    	if(state != "resize")
    	{
    		return;
    	}
    	double width = tree.getPrefWidth() + Math.abs(mouseEvent.getX()) - preSize;
    	preSize = width;
    	tree.setPrefSize( Math.abs(mouseEvent.getX()), tree.getPrefHeight());
    	 
    }
});
	}
	
	public void updateSize()
	{
		
	}

}

