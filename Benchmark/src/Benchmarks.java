import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Benchmarks extends Thread {

    public void run(){
       
    	Process theProcess = null;
    	BufferedReader inStream = null;
    	
	    try {
	    	
			theProcess = Runtime.getRuntime().exec("./primes");
			inStream = new BufferedReader(new InputStreamReader( theProcess.getInputStream() ));
		    System.out.println("CPU test (primes): "+inStream.readLine());
		    TestWindow.Progress.setText("1 / 5");
		    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload2.png")));

			theProcess = null;
		    inStream = null;
		    theProcess = Runtime.getRuntime().exec("./pi");
		    inStream = new BufferedReader(new InputStreamReader( theProcess.getInputStream() ));
		    System.out.println("CPU test (pi): "+inStream.readLine());
		    TestWindow.Progress.setText("2 / 5");
		    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload3.png")));
		    
		    Thread.sleep(1000);
		    TestWindow.Progress.setText("3 / 5");
		    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload4.png")));
		    
		    Thread.sleep(1000);
		    TestWindow.Progress.setText("4 / 5");
		    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload5.png")));
		    
		    Thread.sleep(1000);
		    TestWindow.Progress.setText("5 / 5");
		    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload6.png")));
		    
		    Thread.sleep(1000);
		    
		    MainWindow.wind.setVisible(false);
			JFrame frame = new ResultsWindow();
			frame.setVisible(true);
		    
		} catch (IOException | InterruptedException e) { e.printStackTrace(); }
    	
    }
    
}