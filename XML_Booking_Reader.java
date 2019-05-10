// imported functions
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML_Booking_Reader extends XML_Reader implements ActionListener
{
	// Instance fields
	private static JFrame my_apts_viewing_frame;
	private static JPanel BookingPanel;
	private static JTextArea Booking_Viewing_Area;
	private static JScrollPane Booking_Area_Scroller;
	private static JButton Do_Booking_bt;
	
	public XML_Booking_Reader() 
	{
		// call the XML_Reader function
		Document inputFile = Reader("H:\\eclipse\\workspace\\Java Files\\src\\Apartments.xml");
		
		my_apts_viewing_frame = new JFrame();
		BookingPanel = new JPanel(null);
		
		//Creating the TextArea
		Booking_Viewing_Area = new JTextArea(800,100);
		Booking_Area_Scroller = new JScrollPane(Booking_Viewing_Area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Do_Booking_bt = new JButton("Book the apartment");
		
		Booking_Viewing_Area.setBounds(20,20,800,10);
		Booking_Viewing_Area.setLineWrap(true);
		Booking_Viewing_Area.setWrapStyleWord(true);
		Booking_Area_Scroller.setBounds(40,15,550,500);
		// Set All the controllers
		BookingPanel.add(Booking_Area_Scroller);
		
		Do_Booking_bt.setBounds(20, 600, 200, 50);
		BookingPanel.add(Do_Booking_bt);
		Do_Booking_bt.addActionListener(this);
		
		my_apts_viewing_frame.add(BookingPanel);
		my_apts_viewing_frame.setVisible(true);
		
		for (int temp = 0; temp < 10; temp++) {
			NodeList nList = inputFile.getElementsByTagName("apartment");
			Node nNode = nList.item(temp);
			Element eElement = (Element) nNode;
			// Display all the elements
			Booking_Viewing_Area.append("Root: \t\t"
					+ inputFile.getDocumentElement().getNodeName()
					+ "\nCurrent Element: \t" + nNode.getNodeName()
					+ "\nApartment ID: \t\t" + eElement.getAttribute("id")
					+ "\nThe name of the apartment: \t" + eElement.getElementsByTagName("apartmentname").item(0).getTextContent()
					+ "\nThe price: \t\t" + eElement.getElementsByTagName("price").item(0).getTextContent()
					+ "\nThe start date: \t\t" + eElement.getElementsByTagName("startdate").item(0).getTextContent()
					+ "\nThe end date: \t\t" + eElement.getElementsByTagName("enddate").item(0).getTextContent()
					+ "\nMaximum number of guests: \t" + eElement.getElementsByTagName("maxguests").item(0).getTextContent()
					+ "\nNumber of bedrooms: \t" + eElement.getElementsByTagName("bedroom").item(0).getTextContent()
					+ "\nSeparate living room or not: \t" + eElement.getElementsByTagName("livingroom").item(0).getTextContent()
					+ "\nNumber of bathrooms: \t" + eElement.getElementsByTagName("bathroom").item(0).getTextContent()
					+ "\n-----------------------------------------------------------------------------------------\n");
			Booking_Viewing_Area.setForeground(Color.blue);
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		// if the booking button has been clicked
		if(event.getSource() == Do_Booking_bt) {
			// DO the booking
			Booking LayoutFrame = new Booking();
			LayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			LayoutFrame.setSize(500, 500);
			LayoutFrame.setVisible(true);
		}
	}
}// end class XML_Booking_Reader