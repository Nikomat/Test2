package world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;

import mainFrame.GameObject;

public class OceanPainter extends GameObject{

	private static final long serialVersionUID = 1L;

	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private int half_of_scr_height;
	private int half_of_src_width;
	private double scale;
	private Ocean ocean;
	private Polygon ocean_shape;
	
	public OceanPainter(Camera camera,Ocean ocean_cal,double scale){
		super(camera);
		this.setSize(toolkit.getScreenSize());
		
		ocean=ocean_cal;
		this.scale=scale;
		half_of_scr_height=(int)toolkit.getScreenSize().getHeight()/2;
		half_of_src_width=(int)toolkit.getScreenSize().getWidth()/2;
	}
	
	
	@Override 
	public void paint(Graphics g){
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(new Color(0,100,255,100));
		
		int[] xPoints = new int[323];
		int[] yPoints = new int[323];
		
		for(int i=0;i<=320;i++){
		xPoints[i]=(int)(i*scale*2);
		yPoints[i]=(int)(ocean.OceanCalc(i*scale*2+camera.getCords().getX()-half_of_src_width)+cords.getY()-camera.getCords().getY())+half_of_scr_height;
		
		}
		
		xPoints[321]=(int) toolkit.getScreenSize().getWidth();
		yPoints[321]=(int) toolkit.getScreenSize().getHeight();
		
		xPoints[322]=0;
		yPoints[322]=(int) toolkit.getScreenSize().getHeight();
		
		ocean_shape=new Polygon(xPoints, yPoints, 323);
		
		//nieefektywne, zuzywa >20% CPU
		g2.fillPolygon(ocean_shape);
	}
	
}
