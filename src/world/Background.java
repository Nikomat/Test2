package world;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel{

	private Camera camera;
	private Image bgimg;
	
	public Background(Camera camera){
		this.camera=camera;
		
		try {
			bgimg=ImageIO.read(new File("data//img//tlo1.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("B³¹d wczytywania obazu t³a");
		}
		
	}
	
	
	@Override
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		
		
	}
	
}
