package world;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import interfaces.Workable;
import mainFrame.GameObject;
import vehicles.Player;
import vehicles.VehicleKeyListener;
import vehicles.VehicleProperties;

public class World extends GameObject implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int seed;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private ArrayList<Workable> list=new ArrayList<Workable>();
	private Player player;
	private boolean is_working=true;
	
	private static Camera camera=new Camera();
	
	
	private Timer time=new Timer(20,new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			for(int i=0;i<list.size();i++){
				list.get(i).work();
				
			}
			
		}
	});
	
	
	
	public World(int seed , JPanel key_panel){
		
		this.setSize(toolkit.getScreenSize());
		this.setLayout(null);
		this.seed=seed;
		double k =(double)toolkit.getScreenSize().getWidth()/640;
		
								
								//stworzenie i dodane nowego Oceanu
		Ocean ocean=new Ocean(seed);
		OceanPainter ocean_paint=new OceanPainter(camera, ocean, k);
		this.add(ocean_paint);
		list.add(ocean);
								//stworzenie nowego gracza i dodanie sluchacza klawiszy
		player = new Player("lodz1.png",new Point2D.Double(0,200.0), camera, ocean, new VehicleProperties(30,4,120,100));
		this.add(player);
		list.add(player);
		VehicleKeyListener key_listener = new VehicleKeyListener(player);
		key_panel.addKeyListener(key_listener);
								//stworzenie nowej Kamery
		camera.setFocusOn(player);
		list.add(camera);
								
								//stworzenie przyk³adowego obiektu(punkt odniesienia)
		Player player2 = new Player("lodz1.png", new Point2D.Double(100.0,100.0), camera, ocean, new VehicleProperties(30,4,120,100));
		this.add(player2);
		list.add(player2);
		
								//uruchomienie petli gry
		time.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		
		g2.drawString("Seed: "+seed, 10, 20);
	}
	
	public void pauseWorld(){
		time.stop();
		is_working=false;
	}
	public void resumeWorld(){
		time.start();
		is_working=true;
	}
	public boolean isWorking(){
		return is_working;
	}
	
								//petla malujaca
	@Override
	public void run() {
		
			Timer paint_timer=new Timer(20,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(is_working){
					
				repaint();
				}
			}
			
		});
			paint_timer.start();
	}

}
