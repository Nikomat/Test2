package mainFrame;

import java.awt.geom.Point2D;

import javax.swing.JComponent;

import world.Camera;

public abstract class GameObject extends JComponent{

	private static final long serialVersionUID = 1L;
	
	protected Point2D.Double cords=new Point2D.Double(0,0);
	protected Camera camera;
	
	
	public GameObject(){
		camera=null;
	}
	public GameObject(Camera camera){
		this.camera=camera;
	}
	
	public void setCords(Point2D.Double cords){
		this.cords = cords;
	}
	public Point2D.Double getCords(){
		return cords;
	}
	
}
