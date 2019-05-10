//imported functions
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.swing.*;

// class for logging in
public class LoginFrame extends JFrame implements ActionListener {
	// Instance fields for label
	private static JLabel loginlb;
	private static JLabel password;
	
	// Instance fields for text fields
	private static JTextField logintext;
	private static JTextField pwd;
	
	private boolean toggle = true;
	private final Container container;		// an execution environment that is responsible for adding the technical concerns to the COMPONENTS
	// instance field for drop down menu
	private static JComboBox box = new JComboBox (new String[] {"Client", "Manager"});
	
	// Instance fields fro buttons
	private static JButton loginbt;
	private static JButton registerbt;
	
	//no-argument constructor
	public LoginFrame() {
		container = getContentPane();	// add the component to the container
		container.setLayout(null);		// Set the container's layout manager to null by calling
		
		container.add(box);				// adds the drop down menu to the container
		box.setBounds(150,50,80,30);	// set the location
		box.addActionListener(this);	// adds the action
		
		loginlb = new JLabel("Login: ");			// new login label
			container.add(loginlb);					// adds the label to the container
			loginlb.setBounds(50, 100, 80, 30);		// set the location
		logintext = new JTextField();				// new login text field
			container.add(logintext);				// adds the text field to the container
			logintext.setBounds(150, 100, 80, 30);	// set the location
			logintext.addActionListener(this);		// adds the action event
		
		password = new JLabel("Password: ");		// new password label
			container.add(password);
			password.setBounds(50, 130, 80, 30);
		pwd = new JTextField(20);					// new password text field
			container.add(pwd);
			pwd.setBounds(150, 130, 80, 30);
			pwd.addActionListener(this);			// adds the action
		
		registerbt = new JButton("Register");		// new button to register
			container.add(registerbt);
			registerbt.setBounds(50, 200, 100, 30);
			registerbt.addActionListener(this);		// add the action
		loginbt = new JButton("Login");				// new button to login
			container.add(loginbt);
			loginbt.setBounds(200, 200, 100, 30);
			loginbt.addActionListener(this);		// add the action
	}
	
	// handle button events by toggling between layouts @Override
	public void actionPerformed(ActionEvent event) {
		// if the registor button has been clicked, do the following
		if(event.getSource() == registerbt) {
			// new JFrame to register
			Registration LayoutFrame = new Registration();
			LayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// Exit the application on close
			LayoutFrame.setSize(400, 300);									// Sets the size
			LayoutFrame.setVisible(true);									// Sets the visibility
		}
		// if the login button has been clicked
		if(event.getSource() == loginbt) {
			String box_opt = (String) box.getSelectedItem();	// get the drop down menu value
			String opt_login = logintext.getText();				// get the login value
			String opt_pwd = pwd.getText();						// get the password value
			Document docs;
			
			// if the drop down menu value equals 'Client'
			if(box_opt.equals("Client")) {
				try {
					File inputFile = new File("H:\\eclipse\\workspace\\HOTEL_SYSTEM\\src\\Login_Details.xml");	// new filepath
					// Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					// Protected constructor to prevent instantiation
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					docs = dBuilder.parse(inputFile);
					
					// Normalisation is Reduction of Redundancies
					docs.getDocumentElement().normalize();
					
					// for every client
					for (int temp = 0; temp < 10; temp++) {
						NodeList nList = docs.getElementsByTagName("User");	// get the tag element
						Node nNode = nList.item(temp);
						Element eElement = (Element) nNode;
						String login_details = eElement.getElementsByTagName("login").item(0).getTextContent();		// assign the login value
						String pwd_details = eElement.getElementsByTagName("password").item(0).getTextContent();	// assign the password value
						
						// check if the login and password are correct
						if(opt_login.equals(login_details) && opt_pwd.equals(pwd_details)) {
							// Opens Hotel_Management frame
							Hotel_Management Book = new Hotel_Management();
							Book.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							Book.setSize(500, 500);
							Book.setVisible(true);
						}
					}
				// catches any errors
				} catch (Exception e) {
					e.printStackTrace();
				}
			// else if the drop down menu is Manager
			} else {
				// Check if the login is 'Hulk' and password is 'a1'
				if(opt_login.equals("Hulk") && opt_pwd.equals("a1")) {
					// Opens Hotel_Management frame
					Hotel_Management Book = new Hotel_Management();
					Book.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Book.setSize(500, 500);
					Book.setVisible(true);
				}
				// Check if the login is 'Ironman' and password is 'a2'
				if(opt_login.equals("Ironman") && opt_pwd.equals("a2")) {
					// Opens Hotel_Management frame
					Hotel_Management Book = new Hotel_Management();
					Book.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Book.setSize(500, 500);
					Book.setVisible(true);
				}
			}
		}
	}
	// main function to run the LoginFrame class
	public static void main(String[] args) {
		LoginFrame gridLayoutFrame = new LoginFrame();
		gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridLayoutFrame.setSize(400, 300);
		gridLayoutFrame.setVisible(true);
	}
}//end class LoginFrame