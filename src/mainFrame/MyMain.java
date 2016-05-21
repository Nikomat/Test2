package mainFrame;
import java.awt.EventQueue;

public class MyMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				MyFrame frame=new MyFrame();
				
			}
			
		});
	}

}
