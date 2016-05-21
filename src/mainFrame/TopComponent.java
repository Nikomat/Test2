package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TopComponent extends GameObject implements Runnable{

	protected boolean is_working=false;
	
	
	
	
	public void pause(){
		is_working=false;
	}
	public void resume(){
		is_working=true;
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
