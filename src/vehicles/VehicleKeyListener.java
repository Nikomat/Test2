package vehicles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VehicleKeyListener implements KeyListener{

	private Player player;
	
	public VehicleKeyListener(Player current_player){
		player = current_player;
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()=='w'){
			
			player.getSpeed().isEmerging=true;
		}
		if(e.getKeyChar()=='s'){
			player.getSpeed().isImmersed=true;
		}
		if(e.getKeyChar()=='a'){
			player.is_facing_right=false;
			player.getSpeed().isFacingRight=-1;
			player.getSpeed().isAccelerating=true;
		}
		if(e.getKeyChar()=='d'){
			player.is_facing_right=true;
			player.getSpeed().isFacingRight=1;
			player.getSpeed().isAccelerating=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar()=='w'||e.getKeyChar()=='s'){
			player.getSpeed().isEmerging=false;
			player.getSpeed().isImmersed=false;
		}
		
		if(e.getKeyChar()=='a'||e.getKeyChar()=='d'){
			player.getSpeed().isAccelerating=false;
		}
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
