package vehicles;
import interfaces.Workable;

/*
 * Klasa odpowiedzialna za obs³uge poruszania siê
 * 
 */
public class Speed implements Workable{
	
	private double dX=0;
	private double dY=0;
	
	private int engine_power;
	private int resistance;
	private int displacement;
	private int mass;
	
	private VehicleProperties properties;
	
	public boolean isAccelerating=false;
	public boolean isEmerging=false;
	public boolean isImmersed=false;
	
	public int isFacingRight=1;
	
	public Speed(VehicleProperties properties){
		
		
		this.properties=properties;
	}
	
	@Override
	public void work() {
		
		engine_power=properties.getEnginePower();
		resistance=properties.getWaterResistance();
		displacement=properties.getVehicleDisplacement();
		mass=properties.getVehicleMass();
		
		if(isAccelerating){
			dX+=isFacingRight*((double)engine_power/mass)/20;
		}
		
		if(isEmerging){
			dY-=((double)displacement/mass)/50;
		}
		if(isImmersed){
			dY+=((double)displacement/mass)/50;
		}
		
		dX-=dX*(((double)resistance/mass)/10);
		dY-=dY*(((double)resistance/mass)/10);
		if(mass>displacement){
			
		if(dY<-1.5)	
		{
			dY+=((double)mass/displacement);
		}else{			
			if(dY<-0.6)	
			{
				dY+=((double)mass/displacement)/10;
			}else{
				dY+=((double)mass/displacement)/50;
			}
		}
		
		}
		
	}
		
	public double getX(){
		return dX;
	}
	public double getY(){
		return dY;
	}
	
}
