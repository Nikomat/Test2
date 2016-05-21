package vehicles;

import java.awt.Polygon;
import java.awt.geom.Point2D;

import interfaces.Workable;
import world.Ocean;

public class VehicleBlock implements Workable{

	private Ocean ocean;	
	private VehicleProperties vehicle_prop;
	private Vehicle vehicle;
	private Point2D.Double cords; 
	
	private boolean is_in_water=true;
	
	public VehicleBlock(Ocean ocean, Vehicle vehicle, Point2D.Double cords){
		this.ocean=ocean;
		this.vehicle_prop=vehicle.getProperties();
		this.cords=cords;
		this.vehicle=vehicle;
	}
	
	@Override
	public void work() {
		
		
		
		if(ocean.OceanCalc(vehicle.getCords().getX()+cords.getX())<vehicle.getCords().getY()+cords.getY()){
			if(!is_in_water){
				vehicle_prop.setVehicleDisplacement(vehicle_prop.getVehicleDisplacement()+50);
				is_in_water=true;
			}
		}else{
			if(is_in_water){
				vehicle_prop.setVehicleDisplacement(vehicle_prop.getVehicleDisplacement()-50);
				is_in_water=false;
			}
		}
		
	}	

}
