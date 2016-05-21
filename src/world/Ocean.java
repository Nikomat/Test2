package world;
import interfaces.Workable;

public class Ocean implements Workable{

	//	private int depth;
	private int A;
	private double q=0;
	private double anqle;
	
	
	public Ocean(int seed){
		
		A=seed;
		anqle=1.0/(10*A);
	}
	
	public double OceanCalc(double Xcord){
		return (Math.sin(Xcord*anqle+q)*(A+1));
	}
	
	@Override
	public void work() {
		q=(q+3.0/(30*A))%(2*Math.PI);
		
	}
	
}
