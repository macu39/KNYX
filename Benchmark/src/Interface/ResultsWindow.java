package Interface;

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
public class ResultsWindow extends JFrame{

	private static int x, y;
	
	public ResultsWindow(){
		
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
		Logo.setIcon(new ImageIcon(ResultsWindow.class.getResource("/Img/knix-logo-small.png")));
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
		
		JButton Upload = new JButton("Upload Results");
		Upload.setBounds(130, 475, 197, 51);
		getContentPane().add(Upload);
		
		JButton Home = new JButton("Home");
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				MainWindow wind = new MainWindow();
				wind.setVisible(true);
			}
		});
		Home.setBounds(21, 475, 92, 51);
		getContentPane().add(Home);
		
	}
}
