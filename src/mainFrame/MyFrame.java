package mainFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import vehicleCreator.Creator;
import world.World;

public class MyFrame extends JFrame{

	private static final long serialVersionUID = -3932277580631175959L;
	
	private boolean isFullScreen=true;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private ActionMap actionMap;
	
	private World world;
	private Creator creator;
	private FastMenu menu;
	private GameObject last;
	
	public MyFrame()
	{	
		this.setTitle("Underwater");
		this.setSize(toolkit.getScreenSize());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLayout(null);
		
		JPanel input_key=new JPanel();
		input_key.setPreferredSize(new Dimension(0,0));
		add(input_key,BorderLayout.SOUTH);
		
		//utworzenie nowego swiata za pomoca wylosowanego ziarna
		world=new World((int) Math.round(Math.random()*9)+1, input_key);
		Thread thread=new Thread(world);
		add(world);
		
		thread.start();
		last=world;
		
		MyActionListener gui_listener=new MyActionListener(this);
		menu=new FastMenu(gui_listener);
		
		this.setVisible(true);
		
		keyBindings(input_key,this);
		
	}
	
	public World getWorld(){
		return world;
	}
	public Creator getCreator(){
		return creator;
	}
	public GameObject getLast(){
		return last;
	}
	public void setLast(GameObject obj){
		last=obj;
	}
	
	public boolean isFullScreen(){
		return isFullScreen;
	}
	public void setFullScreen(boolean full){
		isFullScreen=full;
	}
	
	public void startCreator(){
		creator = new Creator();
		removeMenu();
		this.add(creator);
		this.setComponentZOrder(creator, 0);
		Thread thread= new Thread(creator);
		thread.start();
		
		if(world.isWorking()){
			world.pauseWorld();
		}
		creator.setWorking(true);
		last=creator;
	}
	
	
	
	public void removeMenu(){
		for(int i=0;i<this.getComponentCount();i++){
			if(this.getComponent(i)==menu){
				this.remove(i);
			}
		}
	}
	
	private void keyBindings(JPanel p, MyFrame f)
	{
		actionMap = p.getActionMap();
		InputMap inputMap = p.getInputMap();
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0), "F1");
		actionMap.put("F1", new AbstractAction(){
		
			private static final long serialVersionUID = 2443816092886603744L;

			public void actionPerformed(ActionEvent e) {
				Toolkit toolkit=Toolkit.getDefaultToolkit();
				if(!isFullScreen){	
					
					f.dispose();
					f.setUndecorated(true);
					f.setVisible(true);
					f.setBounds(0, 0,(int) toolkit.getScreenSize().getWidth(),(int) toolkit.getScreenSize().getHeight());
					isFullScreen=true;
					
				}else{
					f.dispose();
					f.setUndecorated(false);
					f.setSize(toolkit.getScreenSize());
					f.setVisible(true);
					isFullScreen=false;
				}
			}});
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), "Esc");
		actionMap.put("Esc", new AbstractAction(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("frame:: "+f.getLast().getClass().toString());
				
				switch (last.getClass().toString()){
				case "class world.World":
					if(world.isWorking()){
						world.pauseWorld();
						f.add(menu);
						f.setComponentZOrder(menu, 0);
						repaint();
					}else{
						world.resumeWorld();
						f.removeMenu();	
					}	
				break;
				case "class vehicleCreator.Creator":
					if(creator.isWorking()){
						creator.setWorking(false);
						f.add(menu);
						f.setComponentZOrder(menu, 0);
						repaint();
					}else{
						creator.setWorking(true);
						f.removeMenu();	
					}
				break;	
				}
				
			}
		});	
	}
}

