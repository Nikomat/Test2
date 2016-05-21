package world;


import interfaces.Workable;
import mainFrame.GameObject;

public class Camera extends GameObject implements Workable{

	private static final long serialVersionUID = 1L;
	
	private GameObject focus;
	
	public Camera(GameObject obj){
		focus=obj;
	}
	
	public Camera() {
		focus=null;
	}
	
	public void setFocusOn(GameObject obj){
		focus=obj;
	}
	
	@Override
	public void work() {
		cords=focus.getCords();
	}
}
