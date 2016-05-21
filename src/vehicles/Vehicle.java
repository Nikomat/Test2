package vehicles;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import interfaces.Workable;
import mainFrame.GameObject;
import world.Camera;
import world.Ocean;

public class Vehicle extends GameObject implements Workable{
	
	private static final long serialVersionUID = 1L;

	public static final int n=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/320;
	
	protected Image img;
	protected boolean is_facing_right=true;
	protected double angle=0;
	protected Toolkit toolkit=Toolkit.getDefaultToolkit();
	
	private VehicleProperties properties;
	
	private int half_of_screen_width;
	private int half_of_screen_height;
	private int half_of_img_height_in_scale;
	private int half_of_img_width_in_scale;
	
	protected Speed speed=null;
	
	
	//test
	protected VehicleBlock block;
	
	
	public Vehicle(String file_name, Point2D.Double cords, Camera camera, Ocean ocean, VehicleProperties properties)
	{	
		super(camera);
		this.cords=cords;
		
		this.properties=properties;
		
		speed=new Speed(properties);
		
		half_of_screen_width=(int)toolkit.getScreenSize().getWidth()/2;
		half_of_screen_height=(int)toolkit.getScreenSize().getHeight()/2;
		
		try {
			img=ImageIO.read(new File("data//img//default.png"));
			img=ImageIO.read(new File("data//img//"+file_name));
		} catch (IOException e) {
			System.out.println("Vehicle: nie wczytano obrazka data//img//"+file_name);
			e.printStackTrace();
		}
		this.setSize(toolkit.getScreenSize());
		block=new VehicleBlock(ocean,this,new Point2D.Double(0, 0));
		
		half_of_img_height_in_scale=img.getHeight(null)*n/2;
		half_of_img_width_in_scale=img.getWidth(null)*n/2;
	}
	
	public Vehicle(String file_name, Camera camera, int vehicleMass, int enginePower, int waterResistance, int vehicleDisplacement)
	{
		super(camera);
		this.cords=null;
		speed=new Speed(properties);
		
		try {
			img=ImageIO.read(new File("data//img//"+file_name));
		} catch (IOException e) {
			System.out.println("Vehicle: nie wczytano obrazka data//img//"+file_name);
			e.printStackTrace();
		}
		
		this.setVisible(false);
	}
	
	public void setAngle(double angle){
		this.angle = angle;
	}
	public double getAngle(){
		return angle;
	}
	
	public void addAngle(double angle){
		this.angle += angle;
	}
	
	public void setSpeed(Speed s){
		speed=s;
	}
	public Speed getSpeed(){
		return speed;
	}
	
	public VehicleProperties getProperties(){
		return properties;
	}
	
	@Override
	public void paint(Graphics g){
		
		Graphics2D g2 = (Graphics2D)g;
		g2.rotate(angle);
		
		if(is_facing_right){
			g2.drawImage(img, (int)(cords.getX()-half_of_img_width_in_scale-camera.getCords().getX()+half_of_screen_width), 
					(int)(cords.getY()-half_of_img_height_in_scale-camera.getCords().getY()+half_of_screen_height), 
					(int)(cords.getX()+half_of_img_width_in_scale-camera.getCords().getX()+half_of_screen_width), 
					(int)(cords.getY()+half_of_img_height_in_scale-camera.getCords().getY()+half_of_screen_height), 
					0, 0, img.getWidth(null), img.getHeight(null), null);
		}else{
			g2.drawImage(img, (int)(cords.getX()+half_of_img_width_in_scale-camera.getCords().getX()+half_of_screen_width),
					(int)(cords.getY()-half_of_img_height_in_scale-camera.getCords().getY()+half_of_screen_height), 
					(int)(cords.getX()-half_of_img_width_in_scale-camera.getCords().getX()+half_of_screen_width), 
					(int)(cords.getY()+half_of_img_height_in_scale-camera.getCords().getY()+half_of_screen_height), 
					0, 0, img.getWidth(null), img.getHeight(null), null);
		}
	}

	@Override
	public void work(){
		speed.work();
	}
	
}
