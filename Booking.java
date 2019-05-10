//imported functions
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
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
import javax.swing.*;

public class Booking extends JFrame implements ActionListener {
	// Instance fields for labels
	private static JLabel name_lb;
	private static JLabel surname_lb;
	private static JLabel aprt_name_lb;
	private static JLabel aprt_id_lb;
	private static JLabel num_guests_lb;
	private static JLabel start_date_lb;
	private static JLabel end_date_lb;
	private static JLabel box_lb;
	
	// Instance fields for text fields
	private static JTextField name_text;
	private static JTextField surname_text;
	private static JTextField aprt_name_text;
	private static JTextField aprt_id_text;
	private static JTextField num_guests_text;
	private static JTextField start_date_text;
	private static JTextField end_date_text;
	
	private static JComboBox box = new JComboBox (new String[] {"Yes", "No"});
	private boolean toggle = true;
	private static Container container;
	private static JButton confirm_bt;
	
	//no-argument constructor
	public Booking() {
		// Get the Client Booking details
		container = getContentPane();
		container.setLayout(null);
		
		name_lb = new JLabel("Name: ");
			container.add(name_lb);
			name_lb.setBounds(50, 10, 120, 30);
		name_text = new JTextField();
			container.add(name_text);
			name_text.setBounds(170, 10, 80, 30);
			name_text.addActionListener(this);
		
		surname_lb = new JLabel("Surname: ");
			container.add(surname_lb);
			surname_lb.setBounds(50, 40, 120, 30);
		surname_text = new JTextField(20);
			container.add(surname_text);
			surname_text.setBounds(170, 40, 80, 30);
			surname_text.addActionListener(this);		
		
		aprt_name_lb = new JLabel("Apartment Name: ");
			container.add(aprt_name_lb);
			aprt_name_lb.setBounds(50, 70, 120, 30);
		aprt_name_text = new JTextField();
			container.add(aprt_name_text);
			aprt_name_text.setBounds(170, 70, 80, 30);
			aprt_name_text.addActionListener(this);
			
		aprt_id_lb = new JLabel("Apartment ID: ");
			container.add(aprt_id_lb);
			aprt_id_lb.setBounds(50, 100, 120, 30);
		aprt_id_text = new JTextField();
			container.add(aprt_id_text);
			aprt_id_text.setBounds(170, 100, 80, 30);
			aprt_id_text.addActionListener(this);
			
		num_guests_lb = new JLabel("Number of guests: ");
			container.add(num_guests_lb);
			num_guests_lb.setBounds(50, 130, 120, 30);
		num_guests_text = new JTextField(20);
			container.add(num_guests_text);
			num_guests_text.setBounds(170, 130, 80, 30);
			num_guests_text.addActionListener(this);
		
		start_date_lb = new JLabel("Start date: ");
			container.add(start_date_lb);
			start_date_lb.setBounds(50, 160, 120, 30);
		start_date_text = new JTextField(20);
			container.add(start_date_text);
			start_date_text.setBounds(170, 160, 80, 30);
			start_date_text.addActionListener(this);
		
		end_date_lb = new JLabel("End date: ");
			container.add(end_date_lb);
			end_date_lb.setBounds(50, 190, 120, 30);
		end_date_text = new JTextField(20);
			container.add(end_date_text);
			end_date_text.setBounds(170, 190, 80, 30);
			end_date_text.addActionListener(this);
		
		box_lb = new JLabel("Catering: ");
			container.add(box_lb);
			box_lb.setBounds(50, 220, 120, 30);
		container.add(box);
			box.setBounds(170,220,80,30);
			box.addActionListener(this);
			
		confirm_bt = new JButton("Confirm");
			container.add(confirm_bt);
			confirm_bt.setBounds(100, 260, 100, 30);
			confirm_bt.addActionListener(this);
	}
	
	// handle button events by toggling between layouts @Override
	public void actionPerformed(ActionEvent event) {
		// check if the confirm button has been clicked
		if(event.getSource() == confirm_bt) {
			File file = new File("H:\\eclipse\\workspace\\HOTEL_SYSTEM\\src\\Client_Confirmation.xml");
			
			// check if the file exists
			if(file.exists()) {
				// if the file exists, then append it
				try {
					String filepath = "H:\\eclipse\\workspace\\HOTEL_SYSTEM\\src\\Client_Confirmation.xml";
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
					Document doc = docBuilder.parse(filepath);

					// Get the root element
					Node Clients = doc.getFirstChild();
					
					// user element
					Element user = doc.createElement("Booking");
					Clients.appendChild(user);
					
					// setting attribute to element
					Attr attr = doc.createAttribute("id");
					attr.setValue("02");
					user.setAttributeNode(attr);
					
					Element user_name = doc.createElement("name");
					user_name.appendChild(doc.createTextNode(name_text.getText()));
					user.appendChild(user_name);
					
					Element user_surname = doc.createElement("surname");
					user_surname.appendChild(doc.createTextNode(surname_text.getText()));
					user.appendChild(user_surname);
					
					Element num_guests = doc.createElement("guests");
					num_guests.appendChild(doc.createTextNode(num_guests_text.getText()));
					user.appendChild(num_guests);
					
					Element start_date = doc.createElement("start-date");
					start_date.appendChild(doc.createTextNode(start_date_text.getText()));
					user.appendChild(start_date);
					
					Element end_date = doc.createElement("end-date");
					end_date.appendChild(doc.createTextNode(end_date_text.getText()));
					user.appendChild(end_date);
					
					Element aprt_name = doc.createElement("aprt-name");
					aprt_name.appendChild(doc.createTextNode(aprt_name_text.getText()));
					user.appendChild(aprt_name);
					
					Element aprt_id = doc.createElement("aprt-id");
					aprt_id.appendChild(doc.createTextNode(aprt_id_text.getText()));
					user.appendChild(aprt_id);
					
					Element catering = doc.createElement("catering");
					catering.appendChild(doc.createTextNode((String) box.getSelectedItem()));
					user.appendChild(catering);
					
					
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
				// create a new xml file
				try {
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.newDocument();
					
					// root element
					Element rootElement = doc.createElement("Clients");
					doc.appendChild(rootElement);
					
					// user element
					Element user = doc.createElement("Booking");
					rootElement.appendChild(user);
					
					// setting attribute to element
					Attr attr = doc.createAttribute("id");
					attr.setValue("01");
					user.setAttributeNode(attr);
					
					// user_detail element
					Element user_name = doc.createElement("name");
					user_name.appendChild(doc.createTextNode(name_text.getText()));
					user.appendChild(user_name);
					
					Element user_surname = doc.createElement("surname");
					user_surname.appendChild(doc.createTextNode(surname_text.getText()));
					user.appendChild(user_surname);
					
					Element num_guests = doc.createElement("guests");
					num_guests.appendChild(doc.createTextNode(num_guests_text.getText()));
					user.appendChild(num_guests);
					
					Element start_date = doc.createElement("start-date");
					start_date.appendChild(doc.createTextNode(start_date_text.getText()));
					user.appendChild(start_date);
					
					Element end_date = doc.createElement("end-date");
					end_date.appendChild(doc.createTextNode(end_date_text.getText()));
					user.appendChild(end_date);
					
					Element aprt_name = doc.createElement("aprt-name");
					aprt_name.appendChild(doc.createTextNode(aprt_name_text.getText()));
					user.appendChild(aprt_name);
					
					Element aprt_id = doc.createElement("aprt-id");
					aprt_id.appendChild(doc.createTextNode(aprt_id_text.getText()));
					user.appendChild(aprt_id);
					
					Element catering = doc.createElement("catering");
					catering.appendChild(doc.createTextNode((String) box.getSelectedItem()));
					user.appendChild(catering);
					
					// write the content into xml file
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new File(".\\src\\Client_Confirmation.xml"));
					transformer.transform(source, result);
					
					// Output to console for testing
					StreamResult consoleResult = new StreamResult(System.out);
					transformer.transform(source, consoleResult);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	// main function to DO the booking
	public static void main(String[] args) {
		Booking gridLayoutFrame = new Booking();
		gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridLayoutFrame.setSize(500, 500);
		gridLayoutFrame.setVisible(true);
	}
}//end class Booking