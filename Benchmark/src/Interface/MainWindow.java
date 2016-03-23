package Interface;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

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
	private Sigar sigar = new Sigar();
	
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
		Logo.setIcon(new ImageIcon(MainWindow.class.getResource("/Img/knix-logo-small.png")));
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
		
		JLabel lblCores = new JLabel("Cores: "+Runtime.getRuntime().availableProcessors());
		lblCores.setBackground(Color.WHITE);
		lblCores.setForeground(Color.WHITE);
		lblCores.setBounds(34, 339, 279, 21);
		getContentPane().add(lblCores);
		
		JLabel lblOs = new JLabel("OS: "+System.getProperty("os.name")+" "+System.getProperty("os.version")+" "+System.getProperty("os.arch"));
		lblOs.setForeground(Color.WHITE);
		lblOs.setBackground(Color.WHITE);
		lblOs.setBounds(34, 428, 279, 16);
		getContentPane().add(lblOs);
		
		
		Mem mem = null;
		try {
			mem = sigar.getMem();
		} catch (SigarException e2) { e2.printStackTrace(); }
		
		JLabel lblNewLabel = new JLabel("RAM: "+mem.getTotal()/ 1024 / 1024+ " MB");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(34, 372, 279, 16);
		getContentPane().add(lblNewLabel);
		
		float diskSize = new File("/").getTotalSpace();
		diskSize = diskSize/1000000000;
		diskSize = (float) Math.round(diskSize * 100) / 100;
		
		JLabel lblHdd = new JLabel("HDD: "+diskSize+" GB");
		lblHdd.setForeground(Color.WHITE);
		lblHdd.setBounds(34, 400, 279, 16);
		getContentPane().add(lblHdd);
		
		org.hyperic.sigar.CpuInfo[] infos;
		org.hyperic.sigar.CpuInfo info = null;
		try {
			infos = this.sigar.getCpuInfoList();
			info = infos[0];
		} catch (SigarException e1) { e1.printStackTrace(); }
		
		JLabel lblCpu = new JLabel("CPU: "+info.getVendor()+" "+info.getModel());
		lblCpu.setForeground(Color.WHITE);
		lblCpu.setBounds(34, 278, 279, 16);
		getContentPane().add(lblCpu);
		
		JLabel label = new JLabel("Frequency: "+(float)info.getMhz()/1000+" Ghz");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.WHITE);
		label.setBounds(34, 306, 279, 21);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		if(info.getVendor().equals("Intel")){
			label_1.setIcon(new ImageIcon(MainWindow.class.getResource("/Img/intel.png")));
		}else{
			label_1.setIcon(new ImageIcon(MainWindow.class.getResource("/Img/amd.png")));
		}
		label_1.setBounds(34, 62, 279, 193);
		getContentPane().add(label_1);
		
	}
}
