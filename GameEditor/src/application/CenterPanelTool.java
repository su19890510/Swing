package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CenterPanelTool  implements Initializable {
	private Pane zoomInBg;
	private ImageView zoomIn;
	private Pane zoomOutBg;
	private ImageView zoomOut;
	
	
	public Pane getZoomInBg() {
		return zoomInBg;
	}
	public void setZoomInBg(Pane zoomInBg) {
		this.zoomInBg = zoomInBg;
	}
	public ImageView getZoomIn() {
		return zoomIn;
	}
	public void setZoomIn(ImageView zoomIn) {
		this.zoomIn = zoomIn;
	}
	public Pane getZoomOutBg() {
		return zoomOutBg;
	}
	public void setZoomOutBg(Pane zoomOutBg) {
		this.zoomOutBg = zoomOutBg;
	}
	public ImageView getZoomOut() {
		return zoomOut;
	}
	public void setZoomOut(ImageView zoomOut) {
		this.zoomOut = zoomOut;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
