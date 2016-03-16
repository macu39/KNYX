import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{

	private static int x, y;
	static TestWindow wind;
	
	public MainWindow(){
		
		setLocationRelativeTo(null);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(new Color(40, 40, 40));
		getContentPane().setLayout(null); 
		setTitle("KNYX");
		setResizable(false);
		setBounds(100, 100, 350, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		
	    //Movimiento del JFrame
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
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(MainWindow.class.getResource("/img/knix-logo-small.png")));
		Logo.setBounds(0, 0, 139, 66);
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
		
		JButton Beguin = new JButton("Beguin Test");
		Beguin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				wind = new TestWindow();
				wind.setVisible(true);
				
				Benchmarks bench = new Benchmarks();
				bench.start();
			}
		});
		Beguin.setBounds(23, 475, 304, 51);
		getContentPane().add(Beguin);
		
	}

	
}
