package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import model.*;
import control.*;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BookingWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Flight flight;
	private String seatNum;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingWindow frame = new BookingWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public BookingWindow(Flight f) {
		this.flight = f;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{175, 216, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		panel.add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Kennitala:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSeatNumber = new JLabel("Select seatnumber to book:");
		GridBagConstraints gbc_lblSeatNumber = new GridBagConstraints();
		gbc_lblSeatNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSeatNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeatNumber.gridx = 0;
		gbc_lblSeatNumber.gridy = 5;
		panel.add(lblSeatNumber, gbc_lblSeatNumber);
		
		BookingManager manager = new BookingManager();
		ArrayList<Integer> bokud = manager.getBookedSeats(f.getFlightNum());
		int bokudsaeti = 0;
		String[] seatarray = null;
		if (!manager.getBookedSeats(f.getFlightNum()).isEmpty()){
			bokudsaeti = manager.getBookedSeats(f.getFlightNum()).size();
			int seatquantity = f.getAirplane().getNumOfSeats() - bokudsaeti;
			seatarray = new String[seatquantity];
			int j=0;
			for (Integer i=1; i<=seatquantity+1; i++){
				if (!bokud.contains(i)){
					seatarray[j] = i+"";
					j++;
				}
			}
		}
		
		
		else{
			int seatquantity = f.getAirplane().getNumOfSeats();
			seatarray = new String[seatquantity];
			for (int i=0; i<seatquantity; i++){
					seatarray[i] = i+1+"";		
			}
		}
		
		seatNum = seatarray[0];
		JComboBox comboBox = new JComboBox(seatarray);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox kassi = (JComboBox)e.getSource();
				seatNum = (String) kassi.getSelectedItem();
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		panel.add(comboBox, gbc_comboBox);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.SOUTH;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 8;
		panel.add(panel_2, gbc_panel_2);
		
		JButton btnNewButton = new JButton("Book flight!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveBooking();
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				dispose(); //Destroy the JFrame object
			}
		});
		panel_2.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblBookYourFlight = new JLabel("Book your flight:");
		panel_1.add(lblBookYourFlight);
	
		JLabel lblNewLabel = new JLabel(f.getFlightNum() + "");
		panel_1.add(lblNewLabel);
	}
	
	
	private void saveBooking() {
		boolean error = false;
		
		String name = textField.getText();
		String kt = textField_1.getText();
		int kennitala ;
		//name not empty
		if(name.equals("")){
			//name empty
			NoNameWarning nnw = new NoNameWarning();
			nnw.setVisible(true);
			error=true;	
		}
		
		else if(!name.equals("")){
			//check if there is a number in kennitala field
			try {
			    kennitala = Integer.parseInt(textField_1.getText());
			} catch (NumberFormatException e) {
			    KennitalaError ke = new KennitalaError();
			    ke.setVisible(true);
			    error=true;
			}
			
		}
		
		/*if(seatNum.equals("") && error == false){
			SeatWarning sw = new SeatWarning();
			sw.setVisible(true);
			error=true;
		}*/
		
		
		if(error ==false){
			Passenger p = new Passenger(name,kt);
			Seat s = new Seat(seatNum,false,true);
			BookingManager manager = new BookingManager();
			int flightNum = flight.getFlightNum();
			manager.book(s,p,flightNum);
			
			BookingSuccess bs = new BookingSuccess();
			bs.setVisible(true);
			this.setVisible(false);
			dispose();
		}
	}

}
