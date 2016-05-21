package vehicles;

public class VehicleProperties {

	private int engine_power;
	private int resistance;
	private int displacement;
	private int mass;
	
	public VehicleProperties(int engine_power, int water_resistance, int vehicle_displacement, int vehicle_mass){
		this.engine_power=engine_power;
		resistance=water_resistance;
		displacement=vehicle_displacement;
		mass=vehicle_mass;
	}
	
	
	public int getEnginePower(){
		return engine_power;
	}
	public void setEnginePower(int power){
		engine_power=power;
	}
	
	public int getWaterResistance(){
		return resistance;
	}
	public void setWaterResistance(int resistance){
		this.resistance=resistance;
	}
	
	public int getVehicleDisplacement(){
		return displacement;
	}
	public void setVehicleDisplacement(int vehicle_displacement){
		displacement=vehicle_displacement;
	}
	
	public int getVehicleMass(){
		return mass;
	}
	public void setVehicleMass(int vehicle_mass){
		mass=vehicle_mass;
	}
	
}
