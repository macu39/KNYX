package Interface;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;

@SuppressWarnings("serial")
public class LoadWindow extends JFrame{

	private static int x, y;
	public static JLabel LoadingBar = new JLabel("");
	public static JLabel Progress = new JLabel("Compiling 0 / 5");
	public static LoadWindow wind;

	public static void main(String[] args) throws InterruptedException, IOException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wind = new LoadWindow();
					wind.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	    
		Compiler comp = new Compiler();
		comp.start();
		 
	}	
	
	public LoadWindow(){
		
		setBackground(new Color(40, 40, 40));
		setLocationRelativeTo(null);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(new Color(40, 40, 40));
		getContentPane().setLayout(null); 
		setTitle("KNYX");
		setResizable(false);
		setBounds(100, 100, 350, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/knyx-logo-big.png")));
		Logo.setBounds(0, 75, 350, 128);
		getContentPane().add(Logo);
		
		final JLabel Close = new JLabel("x");
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		Close.setForeground(Color.WHITE);
		Close.setBounds(310, 10, 30, 30);
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Close.setForeground(new Color(201, 201, 201));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Close.setForeground(Color.WHITE);
			}
		});
		getContentPane().add(Close);
		
		Progress.setHorizontalAlignment(SwingConstants.RIGHT);
		Progress.setForeground(Color.WHITE);
		Progress.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Progress.setBounds(0, 495, 324, 45);
		getContentPane().add(Progress);
		
		LoadingBar.setIcon(new ImageIcon(LoadWindow.class.getResource("/img/cload1.png")));
		LoadingBar.setBounds(0, 484, 350, 66);
		getContentPane().add(LoadingBar);
		
		MouseInputAdapter mia = new MouseInputAdapter() {			
		    @Override
			public void mouseDragged(MouseEvent e) {
		        Point point = MouseInfo.getPointerInfo().getLocation();
		        setLocation(point.x-x, point.y-y);		
			}		    
		    @Override
			public void mousePressed(MouseEvent e) {
		    	x=e.getX(); 
		    	y=e.getY();
		    }		    
        }; 
        addMouseListener(mia);
        addMouseMotionListener(mia);
		
	}
}
