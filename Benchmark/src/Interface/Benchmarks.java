package Interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Benchmarks extends Thread {
	
    public void run(){

    	String[] OS = System.getProperty("os.name").split(" ");
    	
    	if(!OS[0].equals("Windows")){
    		
    		Process theProcess = null;
        	BufferedReader inStream = null;
    	
		    try {		    	
		    	
				theProcess = Runtime.getRuntime().exec("./Benchmarks/primes");
				inStream = new BufferedReader(new InputStreamReader( theProcess.getInputStream() ));
				float result1= Float.valueOf(inStream.readLine())/1000;
			    System.out.println("CPU test (primes): "+result1);
			    ResultsWindow.res1=result1;
			    TestWindow.Progress.setText("1 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload2.png")));
	
				theProcess = null;
			    inStream = null;
			    theProcess = Runtime.getRuntime().exec("./Benchmarks/pi");
			    inStream = new BufferedReader(new InputStreamReader( theProcess.getInputStream() ));
			    result1= Float.valueOf(inStream.readLine())/1000;
			    System.out.println("CPU test (pi): "+result1);
			    ResultsWindow.res2=result1;
			    TestWindow.Progress.setText("2 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload3.png")));
			    
			    Thread.sleep(1000);
			    TestWindow.Progress.setText("3 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload4.png")));
			    
			    Thread.sleep(1000);
			    TestWindow.Progress.setText("4 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload5.png")));
			    
			    Thread.sleep(1000);
			    TestWindow.Progress.setText("5 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload6.png")));
			    
			    Thread.sleep(1000);
			    
			    MainWindow.wind.setVisible(false);
			    JFrame frame = new ResultsWindow();
				frame.setVisible(true);
			    
			} catch (IOException | InterruptedException e) { e.printStackTrace(); }
		
	    }else{
	    	
	    	Process theProcess = null;
        	BufferedReader inStream = null;
	    	
	    	try {	
	    	
				theProcess = Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Benchmarks\\primes.exe");
				inStream = new BufferedReader(new InputStreamReader( theProcess.getInputStream() ));
				float result1= Float.valueOf(inStream.readLine());
			    System.out.println("CPU test (primes): "+result1);
			    ResultsWindow.res1=result1;
			    TestWindow.Progress.setText("1 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload2.png")));
	
				theProcess = null;
			    inStream = null;
			    theProcess = Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Benchmarks\\pi.exe");
			   	inStream = new BufferedReader(new InputStreamReader( theProcess.getInputStream() ));
				result1= Float.valueOf(inStream.readLine());
			    System.out.println("CPU test (pi): "+result1);
			    ResultsWindow.res2=result1;
			    
			    TestWindow.Progress.setText("2 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload3.png")));
			    
			    Thread.sleep(1000);
			    TestWindow.Progress.setText("3 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload4.png")));
			    
			    Thread.sleep(1000);
			    TestWindow.Progress.setText("4 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload5.png")));
			    
			    Thread.sleep(1000);
			    TestWindow.Progress.setText("5 / 5");
			    TestWindow.LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/Img/cload6.png")));
			    
			    Thread.sleep(1000);
			    
			    MainWindow.wind.setVisible(false);
			    JFrame frame = new ResultsWindow();
				frame.setVisible(true);
			
	    	} catch (InterruptedException | IOException e) { e.printStackTrace(); }
	    	
	    }
    	
    }
    
}