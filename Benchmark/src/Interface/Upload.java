package Interface;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import javax.swing.JLabel;
import java.awt.Font;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.File;

@SuppressWarnings("serial")
public class Upload extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField PCID;
	private static JLabel url;

	public Upload() {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setType(Type.POPUP);
		setTitle("Upload Results");
		setResizable(false);
		setBounds(100, 100, 450, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblYourResultIs = new JLabel("Your result is uploaded");
			lblYourResultIs.setForeground(Color.WHITE);
			lblYourResultIs.setHorizontalAlignment(SwingConstants.CENTER);
			lblYourResultIs.setFont(new Font("SansSerif", Font.BOLD, 30));
			lblYourResultIs.setBounds(10, 11, 424, 86);
			contentPanel.add(lblYourResultIs);
		}
		{
			JLabel lblUseYouPcid = new JLabel("Use you PCID to link your computer and its results to your acount.");
			lblUseYouPcid.setFont(new Font("SansSerif", Font.PLAIN, 12));
			lblUseYouPcid.setHorizontalAlignment(SwingConstants.CENTER);
			lblUseYouPcid.setForeground(Color.WHITE);
			lblUseYouPcid.setBounds(10, 159, 424, 35);
			contentPanel.add(lblUseYouPcid);
		}
		{
			JLabel lblPcid = new JLabel("PCID: ");
			lblPcid.setForeground(Color.WHITE);
			lblPcid.setFont(new Font("SansSerif", Font.BOLD, 14));
			lblPcid.setBounds(114, 141, 46, 14);
			contentPanel.add(lblPcid);
		}
		
		PCID = new JTextField();
		PCID.setBounds(158, 140, 166, 20);
		contentPanel.add(PCID);
		PCID.setColumns(10);
		{
			JLabel lblSeeItOn = new JLabel("See it on:");
			lblSeeItOn.setFont(new Font("SansSerif", Font.BOLD, 16));
			lblSeeItOn.setForeground(Color.WHITE);
			lblSeeItOn.setBounds(53, 97, 72, 31);
			contentPanel.add(lblSeeItOn);
		}		
		
		getMAC();
		
		{
			url = new JLabel("www.hackshine.com/fdsadfsdfsdf/sdfdsfsdfs/dfsdfdsfsdf");
			url.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					try {
				        Desktop.getDesktop().browse(new URL("http://proyectos.hackshine.com/knyx/result.php?id="+PCID.getText()).toURI());
				    } catch (Exception e) {
				        e.printStackTrace();
				    }
					
				}
			});
			
			url.setFont(new Font("SansSerif", Font.BOLD, 14));
			url.setForeground(new Color(0, 102, 255));
			url.setBounds(136, 99, 264, 31);
			contentPanel.add(url);
		}
		
		uploadResult();
	}
	
	public static void getMAC(){

	    InetAddress ip;
	    try {

	        ip = InetAddress.getLocalHost();
	        System.out.println("Current IP address : " + ip.getHostAddress());

	        NetworkInterface network = NetworkInterface.getByInetAddress(ip);

	        byte[] mac = network.getHardwareAddress();

	        System.out.print("Current MAC address : ");

	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < mac.length; i++) {
	            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
	        }
	        System.out.println(sb.toString());    
	        PCID.setText(sb.toString());

	    } catch (UnknownHostException e) {

	        e.printStackTrace();

	    } catch (SocketException e){

	        e.printStackTrace();
	    }
	}
	
	public static void uploadResult(){

		Sigar sigar = new Sigar();
		
		org.hyperic.sigar.CpuInfo[] infos;
		org.hyperic.sigar.CpuInfo info = null;
		try {
			infos = sigar.getCpuInfoList();
			info = infos[0];
		} catch (SigarException e1) { e1.printStackTrace(); }
		
		Mem mem = null;
		try {
			mem = sigar.getMem();
		} catch (SigarException e2) { e2.printStackTrace(); }
		
		float diskSize = new File("/").getTotalSpace();
		diskSize = diskSize/1000000000;
		diskSize = (float) Math.round(diskSize * 100) / 100;		
		
		String cpu_vendor = info.getVendor();
		String cpu_model = info.getVendor()+" "+info.getModel();
		String cpu_frequency = info.getMhz()+"";
		String cpu_cores = Runtime.getRuntime().availableProcessors()+"";
		String ram = mem.getTotal()/ 1024 / 1024+"";
		String hdd = diskSize+"";		
		String os = System.getProperty("os.name");
		String os_version = System.getProperty("os.name")+" "+System.getProperty("os.version");
		String mac = PCID.getText();		
		String score = ResultsWindow.Score.getText();

		try {
			sendPost("http://proyectos.hackshine.com/knyx/api/up.php", "k=12345678&v="+cpu_vendor+";"+cpu_model+";"+cpu_frequency+";"+cpu_cores+";"+ram+";"+hdd+";"+os+";"+os_version+";"+mac+";"+score);
			url.setText("http://proyectos.hackshine.com/knyx/result.php?id="+mac);
			
		} catch (Exception e) {
			e.printStackTrace();
			url.setText("Error uploading score.");
		}
		
	}
	
	private static void sendPost(String request, String urlParameters) throws Exception {
		
		byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		URL    url            = new URL( request );
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
		conn.setDoOutput( true );
		conn.setConnectTimeout(3000);
		conn.setInstanceFollowRedirects( false );
		conn.setRequestMethod( "POST" );
		conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
		conn.setRequestProperty( "charset", "utf-8");
		conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
		conn.setUseCaches( false );
		try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
		   wr.write( postData );
		}
		
		System.out.println(conn.getResponseCode());
		System.out.println(conn.getResponseMessage());

	}
}
