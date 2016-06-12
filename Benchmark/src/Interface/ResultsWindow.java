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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ResultsWindow extends JFrame{


	private static int x, y;
	public static JLabel Score;
	public static float res1, res2;
	
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
		Upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interface.Upload frame = new Upload();
				frame.setVisible(true); 
				Upload.setEnabled(false);
			}
		});
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
		
		Score = new JLabel("");
		Score.setFont(new Font("SansSerif", Font.BOLD, 70));
		Score.setHorizontalAlignment(SwingConstants.CENTER);
		Score.setForeground(Color.WHITE);
		Score.setBounds(21, 128, 306, 208);
		getContentPane().add(Score);
		Score.setText(res1+res2+"");
		
		JLabel lblLessIsBetter = new JLabel("Less is better.");
		lblLessIsBetter.setHorizontalAlignment(SwingConstants.CENTER);
		lblLessIsBetter.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblLessIsBetter.setForeground(Color.WHITE);
		lblLessIsBetter.setBounds(0, 347, 350, 66);
		getContentPane().add(lblLessIsBetter);
		
		JLabel lblYourScore = new JLabel("Your score:");
		lblYourScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourScore.setForeground(Color.WHITE);
		lblYourScore.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblYourScore.setBounds(0, 62, 350, 66);
		getContentPane().add(lblYourScore);
		
	}
}
