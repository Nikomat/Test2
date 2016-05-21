package vehicleCreator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

import mainFrame.GameObject;

public class Creator extends GameObject implements Runnable{

	private Toolkit toolkit= Toolkit.getDefaultToolkit();
	
	private boolean is_working = false;
	private Image background;
	
	
	public Creator(){
		this.setSize(toolkit.getScreenSize());
		this.setOpaque(true);
		repaint();
		
		try {
			background=ImageIO.read(new File("data//img//creator_bg.png"));
		} catch (IOException e) {
			System.out.println("Nie wczytano obrazu t³a w kreatorze");
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(background, 0, 0, (int)toolkit.getScreenSize().getWidth(), (int)toolkit.getScreenSize().getHeight(), 0, 0, background.getWidth(null), background.getHeight(null), null);
		g2.drawString("Creator", 10, 20);
	}
	
	public void setWorking(boolean is_working){
		this.is_working=is_working;
	}
	public boolean isWorking(){
		return is_working;
	}


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
