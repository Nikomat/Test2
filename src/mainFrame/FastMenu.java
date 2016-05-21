package mainFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class FastMenu extends JComponent{

	Toolkit toolkit=Toolkit.getDefaultToolkit();
	
	private Image background;
	
	public FastMenu(MyActionListener input_key){
		this.setSize(toolkit.getScreenSize());
		
		try {
			background=ImageIO.read(new File("data//img//background.png"));
			ImageIO.read(new File("data//img//fast_menu.png"));
		} catch (IOException e) {
			System.out.println("nie wczytano t³a menu");;
			e.printStackTrace();
		}
		
		SmallMenu menu= new SmallMenu(input_key);
		menu.setBounds((int)toolkit.getScreenSize().getWidth()/2-400/2, (int)toolkit.getScreenSize().getHeight()/2-600/2, 400, 600);
		
		this.add(menu);
		
		repaint();	
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.drawImage(background, 0, 0, (int)toolkit.getScreenSize().getWidth(), (int)toolkit.getScreenSize().getHeight(), null);
	}
}
