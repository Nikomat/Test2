package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{

	private MyFrame f;
	
	public MyActionListener(MyFrame frame){
		f=frame;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		f.getLast().getClass().toString();
		
		System.out.println("listener:: "+f.getLast().getClass().toString());
		
		switch(e.getActionCommand()){
		case "Exit":
			System.exit(0);
			System.out.println("hej");
			break;
		case "Resume":
			switch (f.getLast().getClass().toString()){
			case "class world.World":
				
					f.getWorld().resumeWorld();
					f.removeMenu();	
				
				break;
			case "class vehicleCreator.Creator":
				
					f.getCreator().setWorking(true);
					f.removeMenu();	
				
				break;	
			}
			break;
		case "World":	
			f.getCreator().setWorking(false);
			f.getWorld().resumeWorld();
			f.setLast(f.getWorld());
			f.removeMenu();
			break;
		case "Vehicle Creator":
			f.getWorld().pauseWorld();
			f.startCreator();
			f.setLast(f.getCreator());
			f.removeMenu();
			break;
		}
	}

}
