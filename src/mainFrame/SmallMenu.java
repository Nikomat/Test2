package mainFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class SmallMenu extends JComponent{

	private Image menu_img;
	
	public SmallMenu(MyActionListener input_key){
		
		try {
			menu_img=ImageIO.read(new File("data//img//fast_menu.png"));
		} catch (IOException e) {
			System.out.println("nie wczytano menu");;
			e.printStackTrace();
		}
		
		JButton main_menu_but= new JButton("Main Menu");
		main_menu_but.setBounds(100, 50, 200, 40);
		main_menu_but.addActionListener(input_key);
		this.add(main_menu_but);
		
		JButton creator_but= new JButton("Vehicle Creator");
		creator_but.setBounds(100, 100, 200, 40);
		creator_but.addActionListener(input_key);
		this.add(creator_but);
		
		JButton world_but= new JButton("World");
		world_but.setBounds(100, 150, 200, 40);
		world_but.addActionListener(input_key);
		this.add(world_but);
		
		JButton options_but= new JButton("Options");
		options_but.setBounds(100, 200, 200, 40);
		options_but.addActionListener(input_key);
		this.add(options_but);
		
		JButton resume_but= new JButton("Resume");
		resume_but.setBounds(100, 250, 200, 40);
		resume_but.addActionListener(input_key);
		this.add(resume_but);
		
		JButton exit_but= new JButton("Exit");
		exit_but.setBounds(100, 510, 200, 40);
		exit_but.addActionListener(input_key);
		this.add(exit_but);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(menu_img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
}
