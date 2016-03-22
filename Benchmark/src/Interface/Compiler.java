package Interface;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Compiler extends Thread {

    public void run(){
           	
    	String[] OS = System.getProperty("os.name").split(" ");
    	
    	if(!OS[0].equals("Windows")){
    	
		    try {
		    	
		    	Runtime.getRuntime().exec("cc "+System.getProperty("user.dir")+"/src/benchmark/primes.c -o primes");
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload2.png")));
				LoadWindow.Progress.setText("Compiling 1 / 5");
				 
				Runtime.getRuntime().exec("cc "+System.getProperty("user.dir")+"/src/benchmark/pi.c -o pi");
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload3.png")));
				LoadWindow.Progress.setText("Compiling 2 / 5");
				
				Runtime.getRuntime().exec("cc "+System.getProperty("user.dir")+"/src/benchmark/primes.c -o primes");
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload4.png")));
				LoadWindow.Progress.setText("Compiling 3 / 5");
				 
				Runtime.getRuntime().exec("cc "+System.getProperty("user.dir")+"/src/benchmark/primes.c -o primes");
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload5.png")));
				LoadWindow.Progress.setText("Compiling 4 / 5");
				 
				Runtime.getRuntime().exec("cc "+System.getProperty("user.dir")+"/src/benchmark/primes.c -o primes");
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload6.png")));
				LoadWindow.Progress.setText("Compiling 5 / 5");
				
				Thread.sleep(300); 
    	
				LoadWindow.wind.setVisible(false);
				JFrame frame = new MainWindow();
				frame.setVisible(true); 
			    
			} catch (IOException | InterruptedException e) { e.printStackTrace(); }
		    
    	}else{
    		
    		try {
    		
    			Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload2.png")));
				LoadWindow.Progress.setText("Compiling 1 / 5");
				 
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload3.png")));
				LoadWindow.Progress.setText("Compiling 2 / 5");
				
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload4.png")));
				LoadWindow.Progress.setText("Compiling 3 / 5");
				 
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload5.png")));
				LoadWindow.Progress.setText("Compiling 4 / 5");
				 
				Thread.sleep(300);
				LoadWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload6.png")));
				LoadWindow.Progress.setText("Compiling 5 / 5");
				
				Thread.sleep(300); 
	    	
	    		LoadWindow.wind.setVisible(false);
				JFrame frame = new MainWindow();
				frame.setVisible(true); 
				
    		} catch (InterruptedException e) { e.printStackTrace(); }
    		
    	}
    	
    }
    
}