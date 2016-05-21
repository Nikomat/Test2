package vehicles;
import java.awt.geom.Point2D;

import world.Camera;
import world.Ocean;

public class Player extends Vehicle{

	private static final long serialVersionUID = 1L;

	public Player(String file_name, Point2D.Double cords, Camera camera, Ocean ocean, VehicleProperties properties) {
	
		super(file_name, cords, camera, ocean, properties);	

	}
	
	@Override
	public void work() {
		speed.work();
		cords.setLocation(cords.getX()+speed.getX(),cords.getY()+speed.getY());
		block.work();
	}
}
