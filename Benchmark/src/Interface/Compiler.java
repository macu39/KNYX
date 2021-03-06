package Interface;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Compiler extends Thread {

    public void run(){

    	String[] OS = System.getProperty("os.name").split(" ");
    	
    	if(!OS[0].equals("Windows")){
    	
		    try {
		    	
		    	Runtime.getRuntime().exec("cc "+System.getProperty("user.dir")+"/Benchmarks/primes.c -o "+System.getProperty("user.dir")+"/Benchmarks/primes");
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload2.png")));
				LoadWindow.Progress.setText("Compiling 1 / 5");
				 
				Runtime.getRuntime().exec("cc "+System.getProperty("user.dir")+"/Benchmarks/pi.c -o "+System.getProperty("user.dir")+"/Benchmarks/pi");
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload3.png")));
				LoadWindow.Progress.setText("Compiling 2 / 5");
				
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload4.png")));
				LoadWindow.Progress.setText("Compiling 3 / 5");
				 
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload5.png")));
				LoadWindow.Progress.setText("Compiling 4 / 5");
				
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload6.png")));
				LoadWindow.Progress.setText("Compiling 5 / 5");
				
				Thread.sleep(300); 
    	
				LoadWindow.wind.setVisible(false);
				JFrame frame = new MainWindow();
				frame.setVisible(true); 
			    
			} catch (IOException | InterruptedException e) { e.printStackTrace(); }
		    
    	}else{
    		
    		try { Thread.sleep(1000); } catch (InterruptedException e) { }    		
	    	
    		LoadWindow.wind.setVisible(false);
			JFrame frame = new MainWindow();
			frame.setVisible(true); 
    		
    	}
    	
    }
    
}