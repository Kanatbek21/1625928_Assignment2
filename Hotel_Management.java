//imported functions
import java.awt.*;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class Hotel_Management extends JFrame implements ActionListener {
	private boolean toggle = true;
	private final Container my_container;
	// instance filed for the grid layout
	private final GridLayout gridLayout1;
	private final GridLayout gridLayout2;
	// instance field for border
	private final Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	// INstance fields for labels
	private static JLabel my_client_label;
	private static JLabel my_client_opt_label;
	private static JLabel my_mng_label;
	private static JLabel my_mng_opt_label;
	
	// Text fields instance fields
	private static JTextField my_client_opt_field;
	private static JTextField my_mng_opt_field;

	// Font instance fields
	private static Font aFont;
	private static Font aTextFieldFont;
	
	private static boolean clientLogged = false;
	private static int counterLogin = 0;
	
	//no-argument constructor
	public Hotel_Management() {
		super("GridLayout Demo");
		// set the grid layout with 2 rows and 1 column
		gridLayout1 = new GridLayout(2, 1);
		gridLayout2 = new GridLayout(2, 1);
		my_container = new Container();
		my_container.setLayout(gridLayout1);
		
		// new JPanel with flow layout
		JPanel client_panel = new JPanel(new FlowLayout());
		my_container.add(client_panel);
		add(my_container);
		client_panel.setBorder(loweredetched);
		
		//Format the label Client using DOM
		StringBuilder buff = new StringBuilder();
		buff.append("<html><table>");
		buff.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", "CLIENT"));
		buff.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", ""));
		buff.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", "1. Do Your Booking"));
		buff.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", "2. Manage Your Booking"));
		buff.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", "3. EXIT"));
		buff.append("</table></html>");
		
		// font details for the labels
		aFont = new Font("Arial", Font.ITALIC, 24);
		my_client_label = new JLabel(buff.toString());		// new label for client
		my_client_label.setForeground(Color.black);
		my_client_label.setFont(aFont);
		client_panel.add(my_client_label);
		
		// font details for the text
		aTextFieldFont = new Font("Arial", Font.BOLD, 18);
		my_client_opt_label = new JLabel("Option: ");		// client options 
		my_client_opt_label.setBounds(20, 50, 80, 20);
		my_client_opt_label.setFont(aTextFieldFont);
		my_client_label.add(my_client_opt_label);
		
		my_client_opt_field = new JTextField();
		my_client_opt_field.setBounds(100, 50, 80, 20);
		my_client_opt_field.setFont(aTextFieldFont);
		my_client_label.add(my_client_opt_field);
		my_client_opt_field.addActionListener(this);
		
		
		// JPanel for the manager
		JPanel mng_panel = new JPanel(new FlowLayout());
		my_container.add(mng_panel);
		add(my_container);
		mng_panel.setBorder(loweredetched);
		
		//Format the label Client using DOM
		StringBuilder buff2 = new StringBuilder();
		buff2.append("<html><table>");
		buff2.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", "MANAGER"));
		buff2.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", ""));
		buff2.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", "1. View all the Bookings"));
		buff2.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", "2. Manage a Booking"));
		buff2.append(String.format("<tr><td align='left'>%s</td>"+"</tr>", "3. EXIT"));
		buff2.append("</table></html>");
		
		aFont = new Font("Arial", Font.ITALIC, 24);
		my_mng_label = new JLabel(buff2.toString());
		my_mng_label.setForeground(Color.black);
		my_mng_label.setFont(aFont);
		mng_panel.add(my_mng_label);
		
		aTextFieldFont = new Font("Arial", Font.BOLD, 18);
		my_mng_opt_label = new JLabel("Option: ");
		my_mng_opt_label.setBounds(20, 50, 80, 20);
		my_mng_opt_label.setFont(aTextFieldFont);
		my_mng_label.add(my_mng_opt_label);
		
		my_mng_opt_field = new JTextField();
		my_mng_opt_field.setBounds(100, 50, 80, 20);
		my_mng_opt_field.setFont(aTextFieldFont);
		my_mng_label.add(my_mng_opt_field);
		my_mng_opt_field.addActionListener(this);
	}
	
	// handle button events by toggling between layouts @Override
	public void actionPerformed(ActionEvent event) {
		String Client_Option = my_client_opt_field.getText();
		String Mng_Option = my_mng_opt_field.getText();
		
		// if the client option is 1, then DO the booking
		if(Client_Option.equals("1")) {
			XML_Booking_Reader Do_Booking = new XML_Booking_Reader();
		}
		// if the client option is 2, then view the bookings
		if(Client_Option.equals("2")) {
			XML_Confirmation_Reader Manage_Booking = new XML_Confirmation_Reader();
		}
		// if the client option is 3, then exit
		if(Client_Option.equals("3")) {
			LoginFrame Exit = new LoginFrame();
			Exit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Exit.setSize(400, 300);
			Exit.setVisible(true);
		}
		
		// if the manager options is 1, view the bookings
		if(Mng_Option.equals("1")) {
			XML_Confirmation_Reader Manage_Booking = new XML_Confirmation_Reader();
		}
		// if the manager options is 2, manage the bookings
		if(Mng_Option.equals("2")) {
			XML_Confirmation_Reader Manage_Booking = new XML_Confirmation_Reader();
		}
		// if the manager options is 3, return to the GUI menu
		if(Mng_Option.equals("3")) {
			LoginFrame Exit2 = new LoginFrame();
			Exit2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Exit2.setSize(400, 300);
			Exit2.setVisible(true);
		}
	}
}//end class Hotel_Management