//imported functions
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Registration extends JFrame {
	// Instance fields for label
	private static JLabel namelb;
	private static JLabel surnamelb;
	private static JLabel usernamelb;
	private static JLabel user_pwd_lb;
	
	// Instance fields for text fields
	private static JTextField nametext;
	private static JTextField surnametext;
	private static JTextField usernametext;
	private static JTextField user_pwd;
	
	// button instance field
	private static JButton reg;
	private boolean toggle = true;
	private static Container container;
	//private static JComboBox <String> box = new JComboBox <String> (new String[] {"Client", "Manager"});
	
	//no-argument constructor
	public Registration() {
		container = getContentPane();
		container.setLayout(null);
		
		namelb = new JLabel("Name: ");				// new name label
			container.add(namelb);
			namelb.setBounds(50, 50, 100, 30);
		nametext = new JTextField();				// new name text field 
			container.add(nametext);
			nametext.setBounds(150, 50, 100, 30);
		
		surnamelb = new JLabel("Surname: ");		// new surname label
			container.add(surnamelb);
			surnamelb.setBounds(50, 80, 100, 30);
		surnametext = new JTextField();				// new surname text field
			container.add(surnametext);
			surnametext.setBounds(150, 80, 100, 30);
		
		usernamelb = new JLabel("User Name: ");		// new username label
			container.add(usernamelb);
			usernamelb.setBounds(50, 110, 100, 30);
		usernametext = new JTextField();
			container.add(usernametext);
			usernametext.setBounds(150, 110, 100, 30);
			
		user_pwd_lb = new JLabel("User Password: ");	// new user password label
			container.add(user_pwd_lb);
			user_pwd_lb.setBounds(50, 150, 100, 30);
		user_pwd = new JTextField();
			container.add(user_pwd);
			user_pwd.setBounds(150, 150, 100, 30);
			
		reg = new JButton("Register");
		container.add(reg);
		reg.setBounds(100, 200, 100, 30);
		reg.addActionListener(new ActionListener() {
			@Override
			// if the registor button has been clicked
			public  void actionPerformed(ActionEvent event) {
				File file = new File("H:\\eclipse\\workspace\\HOTEL_SYSTEM\\src\\Login_Details.xml");
				
				// check if the file exists
				if(file.exists()) {
					// Append the existing xml file
					try {
						String filepath = "H:\\eclipse\\workspace\\HOTEL_SYSTEM\\src\\Login_Details.xml";
						DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
						Document doc = docBuilder.parse(filepath);

						// Get the root element
						Node Clients = doc.getFirstChild();
						
						// user element
						Element user = doc.createElement("User");
						Clients.appendChild(user);
						
						// setting attribute to element
						Attr attr = doc.createAttribute("ID");
						attr.setValue("02");
						user.setAttributeNode(attr);
						
						// user_detail element
						Element user_detail_1 = doc.createElement("fname");
						user_detail_1.appendChild(doc.createTextNode(nametext.getText()));
						user.appendChild(user_detail_1);
						
						Element user_detail_2 = doc.createElement("sname");
						user_detail_2.appendChild(doc.createTextNode(surnametext.getText()));
						user.appendChild(user_detail_2);
						
						Element user_detail_3 = doc.createElement("login");
						user_detail_3.appendChild(doc.createTextNode(usernametext.getText()));
						user.appendChild(user_detail_3);
						
						Element user_detail_4 = doc.createElement("password");
						user_detail_4.appendChild(doc.createTextNode(user_pwd.getText()));
						user.appendChild(user_detail_4);
						
						// write the content into xml file
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(filepath));
						transformer.transform(source, result);

						System.out.println("Done");
						
					} catch (ParserConfigurationException pce) {
						pce.printStackTrace();
					} catch (TransformerException tfe) {
						tfe.printStackTrace();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					} catch (SAXException sae) {
						sae.printStackTrace();
					}
				// if the file does not exist
				} else {
					// Create a new xml file
					try {
						DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
						Document doc = dBuilder.newDocument();
						
						// root element
						Element rootElement = doc.createElement("Clients");
						doc.appendChild(rootElement);
						
						// user element
						Element user = doc.createElement("User");
						rootElement.appendChild(user);
						
						// setting attribute to element
						Attr attr = doc.createAttribute("ID");
						attr.setValue("01");
						user.setAttributeNode(attr);
						
						// user_detail element
						Element user_detail1 = doc.createElement("fname");
						user_detail1.appendChild(doc.createTextNode(nametext.getText()));
						user.appendChild(user_detail1);
						
						Element user_detail2 = doc.createElement("sname");
						user_detail2.appendChild(doc.createTextNode(surnametext.getText()));
						user.appendChild(user_detail2);
						
						Element user_detai3 = doc.createElement("login");
						user_detai3.appendChild(doc.createTextNode(usernametext.getText()));
						user.appendChild(user_detai3);
						
						Element user_detail4 = doc.createElement("password");
						user_detail4.appendChild(doc.createTextNode(user_pwd.getText()));
						user.appendChild(user_detail4);
						
						// write the content into xml file
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(".\\src\\Login_Details.xml"));
						transformer.transform(source, result);
						
						// Output to console for testing
						StreamResult consoleResult = new StreamResult(System.out);
						transformer.transform(source, consoleResult);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}//end class Registration