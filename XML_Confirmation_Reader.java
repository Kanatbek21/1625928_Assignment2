//imported functions
import java.awt.Color;
import javax.swing.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML_Confirmation_Reader extends XML_Reader
{
	// Instance fields
	private static JFrame my_apts_viewing_frame;
	private static JPanel BookingPanel;
	private static JTextArea Booking_Viewing_Area;
	private static JScrollPane Booking_Area_Scroller;
	
	public XML_Confirmation_Reader() 
	{
		// Read the following xml file
		Document inputFile = Reader("H:\\eclipse\\workspace\\HOTEL_SYSTEM\\src\\Client_Confirmation.xml");
		
		my_apts_viewing_frame = new JFrame();
		BookingPanel = new JPanel(null);
		
		//Creating the TextArea
		Booking_Viewing_Area = new JTextArea(800,100);
		Booking_Area_Scroller = new JScrollPane(Booking_Viewing_Area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		Booking_Viewing_Area.setBounds(20,120,800,10);
		Booking_Viewing_Area.setLineWrap(true);
		Booking_Viewing_Area.setWrapStyleWord(true);
		Booking_Area_Scroller.setBounds(40,120,550,500);
		// Set All the controllers
		BookingPanel.add(Booking_Area_Scroller);
		
		my_apts_viewing_frame.add(BookingPanel);
		my_apts_viewing_frame.setVisible(true);
		
		for (int temp = 0; temp < 10; temp++) {
			NodeList nList = inputFile.getElementsByTagName("Booking");
			Node nNode = nList.item(temp);
			Element eElement = (Element) nNode;
			
			// Display the following elements
			Booking_Viewing_Area.append("\nRoot: \t\t"
					+ inputFile.getDocumentElement().getNodeName()
					+ "\nCurrent Element: \t" + nNode.getNodeName()
					+ "\nUser ID: \t\t" + eElement.getAttribute("id")
					+ "\nUser name: \t\t" + eElement.getElementsByTagName("name").item(0).getTextContent()
					+ "\nUser surname: \t\t" + eElement.getElementsByTagName("surname").item(0).getTextContent()
					+ "\nNumber of guests: \t" + eElement.getElementsByTagName("guests").item(0).getTextContent()
					+ "\nThe start date: \t\t" + eElement.getElementsByTagName("start-date").item(0).getTextContent()
					+ "\nThe end date: \t\t" + eElement.getElementsByTagName("end-date").item(0).getTextContent()
					+ "\nApartment name: \t" + eElement.getElementsByTagName("aprt-name").item(0).getTextContent()
					+ "\nApartment ID: \t\t" + eElement.getElementsByTagName("aprt-id").item(0).getTextContent()
					+ "\nCatering: \t\t" + eElement.getElementsByTagName("catering").item(0).getTextContent()
					+ "\n-----------------------------------------------------------------------------------------\n");
			Booking_Viewing_Area.setForeground(Color.blue);
		}
	}
}//end the class XML_Confirmation_Reader